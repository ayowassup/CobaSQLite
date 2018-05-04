package com.example.afridha.cobasqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BuatBiodataActivity extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    Button button1, button2;
    EditText text1, text2, text3, text4, text5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buat_biodata);

        dbHelper = new DataHelper(this);
        text1 = (EditText) findViewById(R.id.EditText1);
        text2 = (EditText) findViewById(R.id.EditText2);
        text3 = (EditText) findViewById(R.id.EditText3);
        text4 = (EditText) findViewById(R.id.EditText4);
        text5 = (EditText) findViewById(R.id.EditText5);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);

        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("insert into biodata(no, nama, tgl, jk, alamat) values('" +
                        text1.getText().toString() + "','" +
                        text2.getText().toString() + "','" +
                        text3.getText().toString() + "','" +
                        text4.getText().toString() + "','" +
                        text5.getText().toString() + "')");
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                MainActivity.ma.RefreshList();
                finish();
            }

        });
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View arg0) {
                finish();
            }
        });
    }
}
