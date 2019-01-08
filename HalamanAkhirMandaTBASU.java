package usk.eng.komputer.gotravel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HalamanAkhirMandaTBASU extends AppCompatActivity {

    Button btnLogOutKeluar3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_akhir_manda_tbasu);

        btnLogOutKeluar3 = (Button) findViewById(R.id.btnLogOutMandaTBASU) ;

        btnLogOutKeluar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);
            }
        });

    }
}
