package usk.eng.komputer.gotravel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MandalaTravel extends AppCompatActivity {

    Button btnCheckBAcehSubulussalam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mandala_travel);

        btnCheckBAcehSubulussalam = (Button) findViewById(R.id.btnBAcehSubulussalam) ;

        btnCheckBAcehSubulussalam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MenuBAcehSubulussalam.class);
                startActivity(i);
            }
        });

    }
}
