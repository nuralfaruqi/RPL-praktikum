package usk.eng.komputer.gotravel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MentariTravel extends AppCompatActivity {

    Button btnCheckBAcehSigli;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentari_travel);

        btnCheckBAcehSigli = (Button) findViewById(R.id.btnBAcehSigli) ;

        btnCheckBAcehSigli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MenuBAcehSigliMentaTra.class);
                startActivity(i);
            }
        });

    }
}
