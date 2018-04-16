package com.example.sumaih.p;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ImageView whatsapp ;
    private ImageView uber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        whatsapp = (ImageView) findViewById(R.id.whatsapp);
        uber = (ImageView) findViewById(R.id.uber);
        whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String AppName = "Whatsapp";
                Intent i = new Intent(getApplicationContext(),Main2Activity.class) ;
                i.putExtra("appName",AppName);
                startActivityForResult(i,1);
            }
        });
        uber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String AppName = "Uber";
                Intent i = new Intent(getApplicationContext(),Main2Activity.class) ;
                i.putExtra("appName",AppName);
                startActivityForResult(i,2);
            }
        });
    }
    // ميثود لما يغير باسوورد معين ويرجع للصفحة الرئيسيه بيقول له انه تم تغيير الباسورد او الخ
    protected void onActivityResult(int requstCode, int resultCode, Intent data){
        if(resultCode == RESULT_OK && requstCode == 1){
            String done = "Your Passowrd for "+ data.getStringExtra("AppName")+" set succusess ";
            Toast.makeText(
                    getApplicationContext(), done, Toast.LENGTH_SHORT
            ).show();
        }
    }
}
