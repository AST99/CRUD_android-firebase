package com.astdev.supmti_examapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Authentification extends AppCompatActivity {

    private EditText editTxtAuthEmail, editTxtAuthPassword;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentification);

        mAuth = FirebaseAuth.getInstance();
        mAuth.signOut();

        Button btnConect = findViewById(R.id.Auth);
        this.editTxtAuthEmail = findViewById(R.id.EmailAuth);
        this.editTxtAuthPassword = findViewById(R.id.PasswordAuth);

        btnConect.setOnClickListener(view -> authentification());
    }


    private void authentification(){
        String email = editTxtAuthEmail.getText().toString().trim();
        String passWord = editTxtAuthPassword.getText().toString().trim();

        try {
            mAuth.signInWithEmailAndPassword(email, passWord).addOnCompleteListener(task -> {

                if (task.isSuccessful()){
                    startActivity(new Intent(getApplicationContext(), ShowAllUser.class));
                    Toast.makeText(Authentification.this,"Connexion réussie", Toast.LENGTH_LONG).show();
                }
                else {

                    Toast.makeText(Authentification.this,"La connexion a échouer !\n Vérifiez vos" +
                            " informations.", Toast.LENGTH_LONG).show();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //Pour la déconnexion : "mAuth.signOut();"
}