package usk.eng.komputer.gotravel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HalamanAkhirALSBAM extends AppCompatActivity {

    Button btnLogOutKeluar1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_akhir_alsbam);

        btnLogOutKeluar1 = (Button) findViewById(R.id.btnLogOutALSBAM) ;

        btnLogOutKeluar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);
            }
        });


    }
}
