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
    ArrayList<String> availableIDs;

    public void submitPressed(View view) {

        String email1 = loginId2.getText().toString();
        String password1 = epass.getText().toString();


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
