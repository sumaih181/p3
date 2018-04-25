package com.example.sumaih.p;



import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void whatsapp(View view) {
        String service  = "whatsapp";
        Intent i = new Intent(this,Main2Activity.class);
        i.putExtra("ser", service);
        startActivity(i);


    }

    public void uber(View view) {

        String service  = "uber";
        Intent i = new Intent(this, Main2Activity.class);
        i.putExtra("ser", service);
        startActivity(i);
    }

    public void careem(View view) {
        String service  = "careem";
        Intent i = new Intent(this, Main2Activity.class);
        i.putExtra("ser", service);
        startActivity(i);
    }

    public void twitter(View view) {
        String service  = "twitter";
        Intent i = new Intent(this, Main2Activity.class);
        i.putExtra("ser", service);
        startActivity(i);
    }

    public void instagram(View view) {
        String service  = "instagram";
        Intent i = new Intent(this, Main2Activity.class);
        i.putExtra("ser", service);
        startActivity(i);
    }

    public void snapchat(View view) {
        String service  = "snapchat";
        Intent i = new Intent(this, Main2Activity.class);
        i.putExtra("ser", service);
        startActivity(i);
    }

    public void appStore(View view) {
        String service  = "appStore";
        Intent i = new Intent(this, Main2Activity.class);
        i.putExtra("ser", service);
        startActivity(i);
    }

    public void google(View view) {
        String service  = "google";
        Intent i = new Intent(this, Main2Activity.class);
        i.putExtra("ser", service);
        startActivity(i);
    }

    public void facebook(View view) {
        String service  = "facebook";
        Intent i = new Intent(this, Main2Activity.class);
        i.putExtra("ser", service);
        startActivity(i);
    }

    public void imdb(View view) {
        String service  = "imdb";
        Intent i = new Intent(this, Main2Activity.class);
        i.putExtra("ser", service);
        startActivity(i);
    }

    public void duolingo(View view) {
        String service  = "duolingo";
        Intent i = new Intent(this, Main2Activity.class);
        i.putExtra("ser", service);
        startActivity(i);
    }

    public void dropox(View view) {
        String service  = "dropox";
        Intent i = new Intent(this, Main2Activity.class);
        i.putExtra("ser", service);
        startActivity(i);
    }

    public void alinma(View view) {
        String service  = "alinma";
        Intent i = new Intent(this, Main2Activity.class);
        i.putExtra("ser", service);
        startActivity(i);
    }

    public void alrajhi(View view) {
        String service  = "alrajhi";
        Intent i = new Intent(this, Main2Activity.class);
        i.putExtra("ser", service);
        startActivity(i);
    }

    public void saib(View view) {
        String service  = "saib";
        Intent i = new Intent(this, Main2Activity.class);
        i.putExtra("ser", service);
        startActivity(i);
    }

    public void alahli(View view) {
        String service  = "alahli";
        Intent i = new Intent(this, Main2Activity.class);
        i.putExtra("ser", service);
        startActivity(i);
    }

    public void account4(View view) {
   Intent ii = new Intent(this, Main3Activity.class);
   startActivity(ii);

    }

    public void account3(View view) {
        Intent ii = new Intent(this, Main3Activity.class);
        startActivity(ii);

    }

    public void account2(View view) {
        Intent ii = new Intent(this, Main3Activity.class);
        startActivity(ii);

    }

    public void account1(View view) {
        Intent ii = new Intent(this, Main3Activity.class);
        startActivity(ii);


    }
}