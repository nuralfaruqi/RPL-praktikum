package usk.eng.komputer.gotravel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MenuMedanPadangALS extends AppCompatActivity {

    int quantity=0;
    Button btnOkDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_medan_padang_als);

        btnOkDone = (Button) findViewById(R.id.btnOkMPALS) ;

        btnOkDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), HalamanAkhirALSMP.class);
                startActivity(i);
            }
        });

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
        String pricemessage=" Jumlah Pemesanan =" +quantity;
        pricemessage="\n Rp. \n" +price;
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

