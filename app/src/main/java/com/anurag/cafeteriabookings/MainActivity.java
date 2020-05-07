package com.anurag.cafeteriabookings;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText email;
    EditText password;
    Button register;
    Button login;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.EmaileditText);
        password = findViewById(R.id.PasswordeditText);
        register = findViewById(R.id.Registerbutton);
        login = findViewById(R.id.Loginbutton);


    }
}
