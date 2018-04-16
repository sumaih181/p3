package com.example.sumaih.p;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {
    private String appName;

    private EditText userName;
    private EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        userName=(EditText) findViewById(R.id.editText);
        pass=(EditText) findViewById(R.id.editText2);

        appName= getIntent().getStringExtra("AppName");
        Intent returnIntent = new Intent();
        returnIntent.putExtra("AppName",appName);
        setResult(RESULT_OK,returnIntent);
        finish();
    }

}
