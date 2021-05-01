package com.example.saver10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class PirmoKartoActivity extends AppCompatActivity {

   static double alga;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pirmo_karto);
        String filename = "InitialIncome.txt";
        String filepath = "MyfileDirectory";
        File myExternalFile = new File(getExternalFilesDir(filepath),filename);
        Button IvestiPirmas = findViewById(R.id.PirmoKartoivedimas);
        IvestiPirmas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView FirstTimeInocme = findViewById(R.id.PirmaKartaIvedamaAlga);
                double Pajamos = Double.parseDouble(FirstTimeInocme.getText().toString());
                RewriteData(myExternalFile, Pajamos);
                BackTOMAIN();
            }
        });
    }

    public void RewriteData (File Paimtasfailas, double income)
    {
        FileOutputStream fos = null;
        try{
            String text = "Pajamos "+income+";";

            FileWriter Writer = new FileWriter(Paimtasfailas);
            Writer.write(text);
            Writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void BackTOMAIN()
    {
        Intent first = new Intent(this,MainActivity.class);
        startActivity(first);
    }
}