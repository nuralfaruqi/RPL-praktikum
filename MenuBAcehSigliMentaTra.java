package usk.eng.komputer.gotravel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import usk.eng.komputer.gotravel.Model.MentaTBAcehSigli;

public class MenuBAcehSigliMentaTra extends AppCompatActivity {

    int quantity2=0;

    FirebaseDatabase database2;
    DatabaseReference databaseMentatbacehsigli;

    EditText teksNamapemesan2;
    TextView tvJumlahtiket2, tvHargatotal2;

    Button btnOkDone2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_baceh_sigli_menta_tra);


        database2 = FirebaseDatabase.getInstance();
        databaseMentatbacehsigli = database2.getReference("MentaTBAcehSigli");

        teksNamapemesan2 = (EditText) findViewById(R.id.namapemesanBASMentaT);
        tvJumlahtiket2 = (TextView) findViewById(R.id.quantity_textview2);
        tvHargatotal2 = (TextView) findViewById(R.id.TotalBASMentaT);

        btnOkDone2 = (Button) findViewById(R.id.btnOkBASMentaT) ;

        btnOkDone2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addMentaTBAcehSigli();
            }
        });
    }

    private void addMentaTBAcehSigli() {
        String NamaP2 = teksNamapemesan2.getText().toString().trim();
        String JumlahT2 = tvJumlahtiket2.getText().toString().trim();
        String HargaT2 = tvHargatotal2.getText().toString().trim();

        if(!TextUtils.isEmpty(JumlahT2)){

            String id = databaseMentatbacehsigli.push().getKey();

            MentaTBAcehSigli mentaTBAcehSigli = new MentaTBAcehSigli(id, NamaP2, JumlahT2, HargaT2);


            databaseMentatbacehsigli.child(id).setValue(mentaTBAcehSigli);

            Toast.makeText(this, "Berhasil", Toast.LENGTH_LONG).show();
            Intent i = new Intent(getApplicationContext(), HalamanAkhirMentaTBAS.class);
            startActivity(i);
        }
        else {
            Toast.makeText(this, "Gagal", Toast.LENGTH_LONG).show();
        }
    }


    public void TambahTiket2(View v){//perintah tombol tambah
        if(quantity2==50){
            Toast.makeText(this,"Pemesanan Tiket Maksimal 50",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity2 = quantity2+1 ;
        display2(quantity2);
    }
    public void KurangTiket2(View v){//perintah tombol kurang
        if (quantity2==1){
            Toast.makeText(this,"Pemesanan Tiket Minimal 1",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity2 = quantity2 -1;
        display2(quantity2);

        btnOkDone2 = (Button) findViewById(R.id.btnOkBASMentaT) ;

        btnOkDone2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), HalamanAkhirMentaTBAS.class);
                startActivity(i);
            }
        });
    }


    public void CekInfo2(View v) {



        int price2=calculateprice2();//memanggil method jumlah harga
        String pricemessage2=createOrderSummary2(price2);


        displayMessage2(pricemessage2);

    }
    private int calculateprice2(){//jumlah pesanan * harga
        int harga2=120000;

        return quantity2 * harga2;
    }
    private String createOrderSummary2(int price2) {//hasil pemesanan
        String pricemessage2=" Harga = Rp. " +price2;
        return  pricemessage2;
    }

    //method ini untuk mencetak hasil perintah yang di tampilkan dengan inisial quantity_textview di textview 0
    private void displayMessage2(String message2) {
        TextView priceTextView2 = (TextView) findViewById(R.id.TotalBASMentaT);
        priceTextView2.setText(message2);
    }
    private void display2(int number2) {
        TextView quantityTextView2 = (TextView) findViewById(R.id.quantity_textview2);
        quantityTextView2.setText("" + number2);
    }



}