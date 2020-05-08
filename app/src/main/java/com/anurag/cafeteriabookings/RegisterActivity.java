package com.anurag.cafeteriabookings;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    EditText loginId2;
    EditText epass;
    EditText uID2;
    EditText nom2;


    public void submitPressed(View view){


        String email1 = loginId2.getText().toString();
        String password1 = epass.getText().toString();
//        String uniqueId = uID.getText().toString();
//        String name = nom.getText().toString();
        mAuth.createUserWithEmailAndPassword(email1, password1)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("submitPressed", "createUserWithEmail:success");
                            Toast.makeText(RegisterActivity.this, "createUserWithEmail:success.",
                                    Toast.LENGTH_SHORT).show();
                            FirebaseUser user = mAuth.getCurrentUser();

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("submitPressed", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();
        loginId2 = findViewById(R.id.emailEditText2);
        epass = findViewById(R.id.passwordEditText2);
        uID2 = findViewById(R.id.uniqueIdEditText2);
        nom2 = findViewById(R.id.nameEditText2);


    }
}
