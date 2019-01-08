package usk.eng.komputer.gotravel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AntarLintasSumatra extends AppCompatActivity {

    Button btnCheckMedanPadang;
    Button btnCheckBAcehMedan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_antar_lintas_sumatra);


        btnCheckMedanPadang = (Button) findViewById(R.id.btnMedanPadang) ;

        btnCheckMedanPadang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MenuMedanPadangALS.class);
                startActivity(i);
            }
        });

        btnCheckBAcehMedan = (Button) findViewById(R.id.btnBAcehMedan) ;

        btnCheckBAcehMedan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MenuBAcehMedan.class);
                startActivity(i);

            }
        });
    }
}
