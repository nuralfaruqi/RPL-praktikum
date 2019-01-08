package usk.eng.komputer.gotravel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import usk.eng.komputer.gotravel.Model.MandaTBAcehSubulussalam;

public class MenuBAcehSubulussalam extends AppCompatActivity {


    int quantity3=0;

    FirebaseDatabase database3;
    DatabaseReference databaseMandatbacehsubulussalam;

    EditText teksNamapemesan3;
    TextView tvJumlahtiket3, tvHargatotal3;

    Button btnOkDone3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_baceh_subulussalam);

        database3 = FirebaseDatabase.getInstance();
        databaseMandatbacehsubulussalam = database3.getReference("MandaTBAcehSubulussalam");

        teksNamapemesan3 = (EditText) findViewById(R.id.namapemesanBASUMandaT);
        tvJumlahtiket3 = (TextView) findViewById(R.id.quantity_textview3);
        tvHargatotal3 = (TextView) findViewById(R.id.TotalBASuMANDAT);

        btnOkDone3 = (Button) findViewById(R.id.btnOkBASUMandaT) ;

        btnOkDone3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addMandaTBAcehSubulussalam();
            }
        });
    }

    private void addMandaTBAcehSubulussalam() {
        String NamaP3 = teksNamapemesan3.getText().toString().trim();
        String JumlahT3 = tvJumlahtiket3.getText().toString().trim();
        String HargaT3 = tvHargatotal3.getText().toString().trim();

        if(!TextUtils.isEmpty(JumlahT3)){

            String id = databaseMandatbacehsubulussalam.push().getKey();

            MandaTBAcehSubulussalam mandaTBAcehSubulussalam = new MandaTBAcehSubulussalam(id, NamaP3, JumlahT3, HargaT3);


            databaseMandatbacehsubulussalam.child(id).setValue(mandaTBAcehSubulussalam);

            Toast.makeText(this, "Berhasil", Toast.LENGTH_LONG).show();
            Intent i = new Intent(getApplicationContext(), HalamanAkhirMandaTBASU.class);
            startActivity(i);
        }
        else {
            Toast.makeText(this, "Gagal", Toast.LENGTH_LONG).show();
        }
    }


    public void TambahTiket3(View v){//perintah tombol tambah
        if(quantity3==50){
            Toast.makeText(this,"Pemesanan Tiket Maksimal 50",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity3 = quantity3+1 ;
        display3(quantity3);
    }
    public void KurangTiket3(View v){//perintah tombol kurang
        if (quantity3==1){
            Toast.makeText(this,"Pemesanan Tiket Minimal 1",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity3 = quantity3-1;
        display3(quantity3);

        btnOkDone3 = (Button) findViewById(R.id.btnOkBASUMandaT) ;

        btnOkDone3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), HalamanAkhirMandaTBASU.class);
                startActivity(i);
            }
        });
    }


    public void CekInfo3(View v) {



        int price3=calculateprice3();//memanggil method jumlah harga
        String pricemessage3=createOrderSummary3(price3);


        displayMessage3(pricemessage3);

    }
    private int calculateprice3(){//jumlah pesanan * harga
        int harga3=120000;

        return quantity3 * harga3;
    }
    private String createOrderSummary3(int price3) {//hasil pemesanan
        String pricemessage3=" Harga = Rp. " +price3;
        return  pricemessage3;
    }

    //method ini untuk mencetak hasil perintah yang di tampilkan dengan inisial quantity_textview di textview 0
    private void displayMessage3(String message3) {
        TextView priceTextView3 = (TextView) findViewById(R.id.TotalBASuMANDAT);
        priceTextView3.setText(message3);
    }
    private void display3(int number3) {
        TextView quantityTextView3 = (TextView) findViewById(R.id.quantity_textview3);
        quantityTextView3.setText("" + number3);
    }

}

