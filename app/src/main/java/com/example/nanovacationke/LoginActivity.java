package com.example.nanovacationke;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
    private EditText edtemail1 ,edtpassword1;
    private FirebaseAuth mAuthl;
    private ProgressBar bar1;
    ArrayList<AdminsConstructor> admins;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        edtemail1=findViewById(R.id.edtmail1);
        edtpassword1=findViewById(R.id.edtpassword1);
        bar1=findViewById(R.id.progressbar1);

        mAuthl = FirebaseAuth.getInstance();
        admins = new ArrayList<>();


    }
    public void signin(final View view) {
        final String email1=edtemail1.getText().toString().trim();
        String password1=edtpassword1.getText().toString().trim();
        if (email1.isEmpty()){
            edtemail1.setError("please enter email");
            return;
            //edtemail1.requestFocus();
        } if (password1.isEmpty()){
            edtpassword1.setError("please enter password");
            return;
            //edtemail1.requestFocus();
        }if (password1.length()<8) {
            edtpassword1.setError("Invalid password");
            return;
            //edtpassword1.requestFocus();
        }

        bar1.setVisibility(view.VISIBLE);

        mAuthl.signInWithEmailAndPassword(email1, password1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                bar1.setVisibility(View.INVISIBLE);
                if (task.isSuccessful()){
                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Admins");
                    reference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for (DataSnapshot snap : dataSnapshot.getChildren()){
                                AdminsConstructor admin = snap.getValue(AdminsConstructor.class);
                                admins.add(admin);
                                String arafa = admin.getEmail();

                                Toast.makeText(LoginActivity.this, "Log in up successfull", Toast.LENGTH_SHORT).show();
                                if (arafa.equals(email1)){
                                    Intent intent = new Intent(LoginActivity.this,AdminUploadActivity.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(intent);
                                }else {
                                    Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(intent);
                                }
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Toast.makeText(LoginActivity.this, "DB Locked", Toast.LENGTH_SHORT).show();
                        }
                    });

                }else {
                    Toast.makeText(LoginActivity.this, "Authentication Failed ", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
