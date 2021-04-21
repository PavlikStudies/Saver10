package com.example.saver10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PirmoKartoActivity extends AppCompatActivity {

   static double alga;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pirmo_karto);
        Button DuomenuIvedimas = findViewById(R.id.PirmoKartoivedimas);


     DuomenuIvedimas.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {

             EditText IvestaAlga = findViewById(R.id.PirmaKartaIvedamaAlga);
             alga = Double.parseDouble(IvestaAlga.getText().toString());

         }
     });
    }
}