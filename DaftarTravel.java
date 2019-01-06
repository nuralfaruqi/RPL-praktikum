package usk.eng.komputer.gotravel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class DaftarTravel extends AppCompatActivity {

    Button btnBusALS, btnBusMentari, btnBusMandala;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_travel);

        btnBusALS = (Button) findViewById(R.id.btnALS) ;

        btnBusALS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), AntarLintasSumatra.class);
                startActivity(i);
            }
        });

        btnBusMentari = (Button) findViewById(R.id.btnMentariTravel) ;

        btnBusMentari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MentariTravel.class);
                startActivity(i);
            }
        });

        btnBusMandala = (Button) findViewById(R.id.btnMandalaTravel) ;

        btnBusMandala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MandalaTravel.class);
                startActivity(i);
            }
        });

    }
}

