package com.anurag.cafeteriabookings;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Main2Activity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    TextView loginId;
    TextView passcode;
    TextView uID;
    TextView nom;


    public void submitPressed(View view){
        String email = loginId.getText().toString();
        String password = passcode.getText().toString();
//        String uniqueId = uID.getText().toString();
//        String name = nom.getText().toString();
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("submitPressed", "createUserWithEmail:success");
                            Toast.makeText(Main2Activity.this, "createUserWithEmail:success.",
                                    Toast.LENGTH_SHORT).show();
                            FirebaseUser user = mAuth.getCurrentUser();

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("submitPressed", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(Main2Activity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mAuth = FirebaseAuth.getInstance();
        loginId = findViewById(R.id.emailTextView);
        passcode = findViewById(R.id.passwordTextView);
        uID = findViewById(R.id.uniqueIdTextView);
        nom = findViewById(R.id.nameTextView);


    }
}
