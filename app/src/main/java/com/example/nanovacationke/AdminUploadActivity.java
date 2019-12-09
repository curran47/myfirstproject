package com.example.nanovacationke;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;


public class AdminUploadActivity extends AppCompatActivity {
    private EditText edtadmin;
    private ImageView imgadmin;
    private Button btnupload;
    String storagepath="placesimages/";
    String mdatabasepath="CategoryPlace";
    Uri uri;
    String downloadUrl;
    private StorageReference mstorageReference;
    private DatabaseReference mdatabaseReference;
    private ProgressDialog loadingBar;
    int  IMAGE_REQUEST_CODE=1;
    private StorageTask mUploadTask;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_upload);
        imgadmin=findViewById(R.id.img_admin);
        edtadmin=findViewById(R.id.edt_admin);
        btnupload=findViewById(R.id.btn_admin);
        imgadmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,"select image"),IMAGE_REQUEST_CODE);


            }

    });
        btnupload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadDataToFirebase();
            }
        });
        mstorageReference= FirebaseStorage.getInstance().getReference();
        mdatabaseReference=FirebaseDatabase.getInstance().getReference(mdatabasepath);
        loadingBar=new ProgressDialog(AdminUploadActivity.this);

}

    private void uploadDataToFirebase(){
        if (uri!=null){
            loadingBar.setTitle("Image is loading...");
            loadingBar.show();
            final StorageReference storageReference2=mstorageReference.child(storagepath+System.currentTimeMillis()+".jpg");
            mUploadTask = storageReference2.putFile(uri);

            storageReference2.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {


                    Task<Uri> urlTask = mUploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                        @Override
                        public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                            if (!task.isSuccessful()) {
                                throw task.getException();
                            }

                            // Continue with the task to get the download URL
                            return storageReference2.getDownloadUrl();
                        }
                    }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                        @Override
                        public void onComplete(@NonNull Task<Uri> task) {
                            if (task.isSuccessful()) {
                                Uri downloadUri = task.getResult();
                                downloadUrl = downloadUri.toString();
                                String pplacename=edtadmin.getText().toString().trim();
                                loadingBar.dismiss();
                                Toast.makeText(AdminUploadActivity.this, "image uploaded succesfully", Toast.LENGTH_SHORT).show();
                                Imageuploadconstructor upload = new Imageuploadconstructor(downloadUrl, pplacename);
                                mdatabaseReference.push().getKey();
//                                mdatabaseReference.child("CategoryPlace").setValue(upload);
                                mdatabaseReference.child(System.currentTimeMillis()+"").setValue(upload);

                            } else {
                                // Handle failures
                                // ...
                            }
                        }
                    });

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    loadingBar.dismiss();
                    Toast.makeText(AdminUploadActivity.this, "Error uploading", Toast.LENGTH_SHORT).show();

                }
            });
        }

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==IMAGE_REQUEST_CODE  &&  resultCode==RESULT_OK  &&  data!=null && data.getData() !=null)
        {
            uri = data.getData();
            imgadmin.setImageURI(uri);
        }
    }

}