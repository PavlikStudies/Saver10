package com.example.saver10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DuomenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duomenu);
        TextView labas = (TextView) findViewById(R.id.First_Atribute);
        labas.setText("Atejau");
    }
}