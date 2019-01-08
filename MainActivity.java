package usk.eng.komputer.gotravel;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import usk.eng.komputer.gotravel.Model.User;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference users;

    EditText teksUsername, teksAlamat, teksNohp, teksEmail, teksPassword;
    Button btnDaftar, btnMenujuLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        database = FirebaseDatabase.getInstance();
        users = database.getReference("Users");

        teksUsername = (EditText) findViewById(R.id.usernameD);
        teksAlamat = (EditText) findViewById(R.id.alamatD);
        teksNohp = (EditText) findViewById(R.id.noHpD);
        teksEmail = (EditText) findViewById(R.id.emailD);
        teksPassword = (EditText) findViewById(R.id.passwordD);

        btnDaftar = (Button) findViewById(R.id.btnRegister);
        btnMenujuLogin = (Button) findViewById(R.id.btnKeLogin);

        btnMenujuLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);
            }
        });


        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final User user;
                user = new User(teksUsername.getText().toString(),
                        teksAlamat.getText().toString(),
                        teksNohp.getText().toString(),
                        teksEmail.getText().toString(),
                        teksPassword.getText().toString());


                users.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.child(user.getUsername()).exists())
                            Toast.makeText(MainActivity.this, "Username Sudah Tersedia!", Toast.LENGTH_SHORT).show();
                        else {
                            users.child(user.getUsername()).setValue(user);
                            Toast.makeText(MainActivity.this, "Register Sukses!", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                            startActivity(i);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}

