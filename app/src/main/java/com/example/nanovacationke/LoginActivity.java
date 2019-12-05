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

public class LoginActivity extends AppCompatActivity {
    private EditText edtemail1 ,edtpassword1;
    private FirebaseAuth mAuthl;
    private ProgressBar bar1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        edtemail1=findViewById(R.id.edtmail1);
        edtpassword1=findViewById(R.id.edtpassword1);
        bar1=findViewById(R.id.progressbar1);

        mAuthl = FirebaseAuth.getInstance();


    }
    public void signin(final View view) {
        String email1=edtemail1.getText().toString().trim();
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
                    Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    Toast.makeText(LoginActivity.this, "Log in up successfull", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(LoginActivity.this, "Authentication Failed ", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
