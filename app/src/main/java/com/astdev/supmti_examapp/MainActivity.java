package com.astdev.supmti_examapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    public static Users userId;
    public FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userId = new Users();

        mAuth = FirebaseAuth.getInstance();

        Button btnInscription = findViewById(R.id.btnIscription);
        btnInscription.setOnClickListener(view -> startActivity(
                new Intent(getApplicationContext(),Inscription.class)));
        Button btnAuth = findViewById(R.id.btnAuth);
        btnAuth.setOnClickListener(view -> startActivity(
                new Intent(getApplicationContext(), Authentification.class)));
    }

}