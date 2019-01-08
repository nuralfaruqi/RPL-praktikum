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

import usk.eng.komputer.gotravel.Model.ALSBAcehMedan;


public class MenuBAcehMedan extends AppCompatActivity {

    int quantity1=0;

    FirebaseDatabase database1;
    DatabaseReference databaseAlsbacehmedan;

    EditText teksNamapemesan1;
    TextView tvJumlahtiket1, tvHargatotal1;

    Button btnOkDone1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_baceh_medan);


        database1 = FirebaseDatabase.getInstance();
        databaseAlsbacehmedan = database1.getReference("ALSBAcehMedan");

        teksNamapemesan1 = (EditText) findViewById(R.id.namapemesanBAMALS);
        tvJumlahtiket1 = (TextView) findViewById(R.id.quantity_textview1);
        tvHargatotal1 = (TextView) findViewById(R.id.TotalBAMALS);

        btnOkDone1 = (Button) findViewById(R.id.btnOkBAMALS) ;

        btnOkDone1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addALSBAcehMedan();
            }
        });
    }

    private void addALSBAcehMedan() {
        String NamaP1 = teksNamapemesan1.getText().toString().trim();
        String JumlahT1 = tvJumlahtiket1.getText().toString().trim();
        String HargaT1 = tvHargatotal1.getText().toString().trim();

        if(!TextUtils.isEmpty(JumlahT1)){

            String id = databaseAlsbacehmedan.push().getKey();

            ALSBAcehMedan alsBAcehMedan = new ALSBAcehMedan(id, NamaP1, JumlahT1, HargaT1);


            databaseAlsbacehmedan.child(id).setValue(alsBAcehMedan);

            Toast.makeText(this, "Berhasil", Toast.LENGTH_LONG).show();
            Intent i = new Intent(getApplicationContext(), HalamanAkhirALSBAM.class);
            startActivity(i);
        }
        else {
            Toast.makeText(this, "Gagal", Toast.LENGTH_LONG).show();
        }
    }


    public void TambahTiket1(View v){//perintah tombol tambah
        if(quantity1==50){
            Toast.makeText(this,"Pemesanan Tiket Maksimal 50",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity1 = quantity1+1 ;
        display1(quantity1);
    }
    public void KurangTiket1(View v){//perintah tombol kurang
        if (quantity1==1){
            Toast.makeText(this,"Pemesanan Tiket Minimal 1",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity1 = quantity1 -1;
        display1(quantity1);

        btnOkDone1 = (Button) findViewById(R.id.btnOkBAMALS) ;

        btnOkDone1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), HalamanAkhirALSBAM.class);
                startActivity(i);
            }
        });
    }


    public void CekInfo1(View v) {



        int price1=calculateprice1();//memanggil method jumlah harga
        String pricemessage1=createOrderSummary1(price1);


        displayMessage1(pricemessage1);

    }
    private int calculateprice1(){//jumlah pesanan * harga
        int harga1=190000;

        return quantity1 * harga1;
    }
    private String createOrderSummary1(int price1) {//hasil pemesanan
        String pricemessage1=" Harga = Rp. " +price1;
        return  pricemessage1;
    }

    //method ini untuk mencetak hasil perintah yang di tampilkan dengan inisial quantity_textview di textview 0
    private void displayMessage1(String message1) {
        TextView priceTextView1 = (TextView) findViewById(R.id.TotalBAMALS);
        priceTextView1.setText(message1);
    }
    private void display1(int number1) {
        TextView quantityTextView1 = (TextView) findViewById(R.id.quantity_textview1);
        quantityTextView1.setText("" + number1);
    }



}


