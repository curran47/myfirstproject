package com.example.nanovacationke;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class RegisterActivity extends AppCompatActivity {
    private EditText edtemail, edtpassword;
    private FirebaseAuth mAuth;
    private Button btnsave;
    private ProgressBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edtemail = findViewById(R.id.edtEmail);
        edtpassword = findViewById(R.id.edtpword);
        btnsave = findViewById(R.id.btnsubmit);
        bar = findViewById(R.id.progressbar);

        mAuth = FirebaseAuth.getInstance();
    }

    public void reg(View view) {
        Intent intent2 = new Intent(this, RegisteradminsActivity.class);
        startActivity(intent2);
    }


    public void view(View view) {
        Intent intent1 = new Intent(this, LoginActivity.class);
        startActivity(intent1);


    }

    public void Save(final View view) {
        String email = edtemail.getText().toString().trim();
        String pass = edtpassword.getText().toString().trim();
        if (email.isEmpty()) {
            edtemail.setError("Email required");
            edtemail.requestFocus();
            return;
        }
        if (pass.isEmpty()) {
            edtpassword.setError("Password required");
            edtpassword.requestFocus();
            return;
        }
        if (pass.length() < 8) {
            edtpassword.setError("Invalid password");
            edtpassword.requestFocus();
            return;
        }
        bar.setVisibility(view.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                bar.setVisibility(view.GONE);
                if (task.isSuccessful()) {

                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent);
                    Toast.makeText(RegisterActivity.this, "Sign up successfull", Toast.LENGTH_SHORT).show();
                } else if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                    Toast.makeText(RegisterActivity.this, "You are already registered", Toast.LENGTH_SHORT).show();
                    Intent intent1 = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent1);
                } else {
                    Toast.makeText(RegisterActivity.this, "Error signing up", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
