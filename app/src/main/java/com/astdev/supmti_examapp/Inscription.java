package com.astdev.supmti_examapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class Inscription extends AppCompatActivity {

    private EditText editTxtName, editTxtPhone, editTxtEmail, editTxtPasswrd;

    private String strName, strPhone, strEmail, strPass;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        mAuth = FirebaseAuth.getInstance();

        this.editTxtName = findViewById(R.id.editTxtName);
        this.editTxtEmail = findViewById(R.id.editTxtEmail);
        this.editTxtPhone = findViewById(R.id.editTxtPhone);
        this.editTxtPasswrd = findViewById(R.id.editTxtPassword);

        Button btnSignIn = findViewById(R.id.SignIn);
        btnSignIn.setOnClickListener(view -> addUsers());
    }

    public  void addUsers(){
        /*try {
            strName = editTxtName.getText().toString().trim();
            strPhone = editTxtPhone.getText().toString().trim();
            strEmail = editTxtEmail.getText().toString().trim();
            strPass = editTxtPasswrd.getText().toString().trim();

            user = new Users(strName, strEmail, strPhone);
            mDatabase = FirebaseDatabase.getInstance().getReference("Users");
            mDatabase.setValue(user).addOnSuccessListener(unused ->
                            Toast.makeText(getApplicationContext(),"Succes",Toast.LENGTH_LONG).show()).
                    addOnFailureListener(e -> Toast.makeText(getApplicationContext(),"Fail",Toast.LENGTH_LONG).show()).
                    addOnCompleteListener(task -> Toast.makeText(getApplicationContext(),"ok",Toast.LENGTH_LONG).show());
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        strName = editTxtName.getText().toString().trim();
        strPhone = editTxtPhone.getText().toString().trim();
        strEmail = editTxtEmail.getText().toString().trim();
        strPass = editTxtPasswrd.getText().toString().trim();
        mAuth.createUserWithEmailAndPassword(strEmail, strPass).
                addOnCompleteListener(task -> {
                    if (task.isSuccessful()){
                        Users agent = new Users(strName, strEmail, strPhone, strPass);

                        FirebaseDatabase.getInstance().getReference("Users")
                                .child(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).
                                        getUid()).setValue(agent).addOnCompleteListener(task1 -> {
                                    if(task1.isSuccessful()){
                                        Toast.makeText(Inscription.this,"Vous êtes inscrit",
                                                Toast.LENGTH_LONG).show();
                                        startActivity(new Intent(getApplicationContext(), ShowAllUser.class));
                                    }
                                    else {
                                        Toast.makeText(Inscription.this,"Votre inscription n'a" +
                                                        " pas été fait !\n Essayez à nouveau",
                                                Toast.LENGTH_LONG).show();
                                    }
                                });
                    }else {
                        Toast.makeText(Inscription.this,"Votre inscription n'a" +
                                " pas été fait !\n Essayez à nouveau", Toast.LENGTH_LONG).show();
                    }
                });
    }

}