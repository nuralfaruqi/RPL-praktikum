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

import usk.eng.komputer.gotravel.Model.ALSMedanPadang;


public class MenuMedanPadangALS extends AppCompatActivity {

    int quantity=0;

    FirebaseDatabase database;
    DatabaseReference databaseAlsmedanpadang;

    EditText teksNamapemesan;
    TextView tvJumlahtiket, tvHargatotal;

    Button btnOkDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_medan_padang_als);


        database = FirebaseDatabase.getInstance();
        databaseAlsmedanpadang = database.getReference("ALSMedanPadang");

        teksNamapemesan = (EditText) findViewById(R.id.namapemesanMPALS);
        tvJumlahtiket = (TextView) findViewById(R.id.quantity_textview);
        tvHargatotal = (TextView) findViewById(R.id.TotalMPALS);

        btnOkDone = (Button) findViewById(R.id.btnOkMPALS) ;

        btnOkDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addALSMedanPadang();
            }
        });
    }

    private void addALSMedanPadang() {
        String NamaP = teksNamapemesan.getText().toString().trim();
        String JumlahT = tvJumlahtiket.getText().toString().trim();
        String HargaT = tvHargatotal.getText().toString().trim();

        if(!TextUtils.isEmpty(JumlahT)){

            String id = databaseAlsmedanpadang.push().getKey();

            ALSMedanPadang alsMedanPadang = new ALSMedanPadang(id, NamaP, JumlahT, HargaT);


            databaseAlsmedanpadang.child(id).setValue(alsMedanPadang);

            Toast.makeText(this, "Berhasil", Toast.LENGTH_LONG).show();
            Intent i = new Intent(getApplicationContext(), HalamanAkhirALSMP.class);
            startActivity(i);
        }
        else {
            Toast.makeText(this, "Gagal", Toast.LENGTH_LONG).show();
        }
    }


    public void TambahTiket(View v){//perintah tombol tambah
        if(quantity==50){
            Toast.makeText(this,"Pemesanan Tiket Maksimal 50",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity+1 ;
        display(quantity);
    }
    public void KurangTiket(View v){//perintah tombol kurang
        if (quantity==1){
            Toast.makeText(this,"Pemesanan Tiket Minimal 1",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity -1;
        display(quantity);

        btnOkDone = (Button) findViewById(R.id.btnOkMPALS) ;

        btnOkDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), HalamanAkhirALSMP.class);
                startActivity(i);
            }
        });
    }


    public void CekInfo(View v) {



        int price=calculateprice();//memanggil method jumlah harga
        String pricemessage=createOrderSummary(price);


        displayMessage(pricemessage);

    }
    private int calculateprice(){//jumlah pesanan * harga
        int harga=200000;

        return quantity * harga;
    }
    private String createOrderSummary(int price) {//hasil pemesanan
        String pricemessage=" Harga = Rp. " +price;
        return  pricemessage;
    }

    //method ini untuk mencetak hasil perintah yang di tampilkan dengan inisial quantity_textview di textview 0
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.TotalMPALS);
        priceTextView.setText(message);
    }
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_textview);
        quantityTextView.setText("" + number);
    }



}


