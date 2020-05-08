package com.anurag.cafeteriabookings;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
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

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

public class RegisterActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    EditText loginId2;
    EditText epass;
    EditText uID2;
    EditText nom2;


    public void submitPressed(View view) throws IOException, JSONException {

        String email1 = loginId2.getText().toString();
        String password1 = epass.getText().toString();

        mAuth.createUserWithEmailAndPassword(email1, password1)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("submitPressed", "createUserWithEmail:success");
                            Toast.makeText(RegisterActivity.this, "createUserWithEmail:success.",
                                    Toast.LENGTH_SHORT).show();

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

    private void checkID() throws IOException, JSONException {
        JSONReader jsonReader = new JSONReader();
        JSONArray ids = jsonReader.readJsonFromUrl("https://sheetsu.com/apis/v1.0su/f1ca81c31d64#");
        ArrayList<String> availableIDs = new ArrayList<>();

        for (int i=0;i<ids.length();i++) {
            String temp = ids.getJSONObject(i).getString("id");
            availableIDs.add(temp);
       }
        Log.d("IDs", availableIDs.toString());
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

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
            Log.d("Permission","not granted");
        } else {
            Log.d("Permission","granted");
            try {
                checkID();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }
}
