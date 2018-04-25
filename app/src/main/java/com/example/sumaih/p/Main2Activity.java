package com.example.sumaih.p;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.sumaih.p.MyDBHandler.COLUMN_SERVICE;
import static com.example.sumaih.p.MyDBHandler.TABLE_NAME;
import static com.example.sumaih.p.MyDBHandler.COLUMN_USER;
import static com.example.sumaih.p.MyDBHandler.COLUMN_PASSWORD;

public class Main2Activity extends AppCompatActivity {
    private TextView textView4, textView;
    private EditText editText, editText2;




    private MyDBHandler dbHandler;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        textView4 = (TextView) findViewById(R.id.textView4);
        textView = (TextView) findViewById(R.id.textView);
        dbHandler = new MyDBHandler(getApplicationContext());




    }
    public boolean CheckIsDataAlreadyInDBorNot(String fieldValue) {

        db = dbHandler.getReadableDatabase();
        String Query = "Select * from " + TABLE_NAME + " where " + COLUMN_SERVICE
                + "='" + fieldValue + "'";
        Cursor cursor = db.rawQuery(Query, null);
        if (cursor.getCount() <= 0) {
            return false;
        }
        return true;
    }

    public void addButtonClicked(View view) {
        textView4.setVisibility(View.INVISIBLE);
        textView.setVisibility(View.INVISIBLE);
        editText.setVisibility(View.VISIBLE);
        editText2.setVisibility(View.VISIBLE);

        db = dbHandler.getWritableDatabase();
        String user = editText.getText().toString();
        String password = editText2.getText().toString();
        Intent intent = getIntent();
        String service = intent.getExtras().getString("ser");
        if (user.isEmpty() || password.isEmpty()) {
            Toast.makeText(getApplicationContext(),
                    "Please, fill-in missing data", Toast.LENGTH_LONG).show();
            return;
        }
        if (CheckIsDataAlreadyInDBorNot(service) == true) {
            Toast.makeText(getApplicationContext(), "Data already exists.. ", Toast.LENGTH_LONG).show();
            editText.setText("");
            editText2.setText("");
            return; }
            ContentValues rov = new ContentValues();
            rov.put(COLUMN_SERVICE, service);
            rov.put(COLUMN_USER, user);
            rov.put(COLUMN_PASSWORD, password);
            long rop = db.insert(TABLE_NAME, null, rov);
            db.close();
            String tstMsg;
            tstMsg = "UserName: " + user + ", Password: " + password + " is inserted";
            Toast.makeText(getApplicationContext(), tstMsg, Toast.LENGTH_LONG).show();
            editText.setText("");
            editText2.setText("");


            return;
        }




    public void Update(View view) {
        textView4.setVisibility(View.INVISIBLE);
        textView.setVisibility(View.INVISIBLE);
        editText.setVisibility(View.VISIBLE);
        editText2.setVisibility(View.VISIBLE);

        Intent intent = getIntent();
        String service = intent.getExtras().getString("ser");

        db = dbHandler.getWritableDatabase();

        String user = editText.getText().toString();
        String password = editText2.getText().toString();

        if(user.isEmpty() && password.isEmpty()){
            Toast.makeText(getApplicationContext(),"Please, fill-in missing data",Toast.LENGTH_LONG).show();
            return;

        }
                   if(user.isEmpty() && !password.isEmpty()) {
                       if (CheckIsDataAlreadyInDBorNot(service) == false) {
                           Toast.makeText(getApplicationContext(), "no data to  Update ", Toast.LENGTH_LONG).show();
                           return; }
            ContentValues cv = new ContentValues();
            cv.put(COLUMN_PASSWORD, password);
            String selection = COLUMN_SERVICE +" LIKE ?";
            String[] args={service};
            db.update(TABLE_NAME, cv, selection, args);
                       Toast.makeText(getApplicationContext(),"PASSWORD Update ",Toast.LENGTH_LONG).show();
                       editText2.setText("");
            return;



        }

      else  if(!user.isEmpty() && password.isEmpty()) {

                       if (CheckIsDataAlreadyInDBorNot(service) == false) {
                           Toast.makeText(getApplicationContext(), "no data to  Update ", Toast.LENGTH_LONG).show();
                           return; }
            ContentValues cv = new ContentValues();
            cv.put(COLUMN_USER, user);
            String selection = COLUMN_SERVICE +" LIKE ?";
            String[] args={service};
            db.update(TABLE_NAME, cv, selection, args);
                       Toast.makeText(getApplicationContext(),"USER Update ",Toast.LENGTH_LONG).show();
                       editText.setText("");
            return;
        }
        else  if(!user.isEmpty() && !password.isEmpty()) {
            Toast.makeText(getApplicationContext(),"you can not update both ,try to add new ",Toast.LENGTH_LONG).show();
                       return;
        }
        db.close();
        return;
    }



    public void Read(View V){
        Intent intent = getIntent();
        String service = intent.getExtras().getString("ser");

        db = dbHandler.getReadableDatabase();

        String sql = "Select * from " + TABLE_NAME  + " where " + COLUMN_SERVICE + " = ?";

        Cursor c = db.rawQuery(sql, new String[] {service});

        if(!c.moveToFirst()){
            Toast.makeText(getApplicationContext(),"No data ",Toast.LENGTH_LONG).show();

            return; }
        textView4.setVisibility(View.VISIBLE);
        textView.setVisibility(View.VISIBLE);
        editText.setVisibility(View.INVISIBLE);
        editText2.setVisibility(View.INVISIBLE);
        textView4.setText(c.getString(1));
        textView.setText(c.getString(2));
        c.close();
        db.close();
        return;
    }

    public void delete(View view) {
        db = dbHandler.getReadableDatabase();

        Intent intent = getIntent();
        String service = intent.getExtras().getString("ser");

        if (CheckIsDataAlreadyInDBorNot(service) == false) {
            Toast.makeText(getApplicationContext(), "no data to delete.. ", Toast.LENGTH_LONG).show();
            return; }
        String selection = COLUMN_SERVICE +" LIKE ?";
        String[] args={service};
        db.delete(TABLE_NAME, selection ,args);
        String tstMsg = "the "+service+" account is delete";
        Toast.makeText(getApplicationContext(), tstMsg, Toast.LENGTH_LONG).show();
        textView4.setText(" ");
        textView.setText(" ");
        editText2.setText("");
        editText.setText("");
        db.close();
    }
}