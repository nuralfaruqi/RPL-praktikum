package usk.eng.komputer.gotravel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class HalamanAkhirALSMP extends AppCompatActivity {

    Button btnLogOutKeluar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_akhir_alsmp);


        btnLogOutKeluar = (Button) findViewById(R.id.btnLogOutALSMP) ;

        btnLogOutKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);
            }
        });




    }
}
