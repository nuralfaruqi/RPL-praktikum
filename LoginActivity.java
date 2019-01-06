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



public class LoginActivity extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference users;

    EditText teksUsername, teksPassword;
    Button btnMasuk, btnMenujuDftar, btnKeLupaPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        database = FirebaseDatabase.getInstance();
        users = database.getReference("Users");

        teksUsername = (EditText) findViewById(R.id.usernameD);
        teksPassword = (EditText) findViewById(R.id.passwordD);

        btnMasuk = (Button) findViewById(R.id.btnLogIn);
        btnMenujuDftar = (Button) findViewById(R.id.btnKeBuatAkun);

        btnMenujuDftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

        btnKeLupaPass = (Button) findViewById(R.id.btnLupaPass);

        btnKeLupaPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ResetPassword.class);
                startActivity(i);
            }
        });

        btnMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn(teksUsername.getText().toString(),
                        teksPassword.getText().toString());
            }
        });
    }

    private void signIn(final String username, final String password) {
        users.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.child(username).exists()){
                    if(!username.isEmpty()){
                        User login = dataSnapshot.child(username).getValue(User.class);
                        assert login != null;
                        if(login.getPassword().equals(password)){
                            Toast.makeText(LoginActivity.this, "Login Sukses", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(getApplicationContext(), HomePage.class);
                            startActivity(i);

                        }
                        else {
                            Toast.makeText(LoginActivity.this, "Password Salah", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                        Toast.makeText(LoginActivity.this, "Usename Belum Terdaftar", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}