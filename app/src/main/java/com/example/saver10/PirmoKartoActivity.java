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
import java.util.ArrayList;

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
                File op = new File(getExternalFilesDir(filepath),"JanuaryData.txt");
                if(!op.exists())
                {
                    /// Menesiu sukurimo failai:
                File january = new File(getExternalFilesDir(filepath),"JanuaryData.txt");
                AllMounthsData(january);
                File febuary = new File(getExternalFilesDir(filepath),"FeabuaryData.txt");
                AllMounthsData(febuary);
                File march = new File(getExternalFilesDir(filepath),"MarchData.txt");
                AllMounthsData(march);

                    /// Sukuria kuri duomenu faila reikia modufikuoti
                    File modifications = new File(getExternalFilesDir(filepath),"Modification.txt");
                    Modification(modifications);
                }
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
    public void AllMounthsData (File Paimtasfailas)
    {
        FileOutputStream fos = null;
        try{
            /// Savings
            String text = "Banke 800;";
            String text1 = "Namuose 900;";
            ///Keyspending
            String text2="ButoNuoma 300;";
            String text3="Telefonosąs 600;";
            String text4="Maistas 800;";
            String text5="ButosąsSas 601;";
            /// Investing
            String text6="Taupomijisaskaita 157;";
            String text7="Investavimosąskaita 761;";
           /* String text = "TaupomojiSas "+data.get(0).Value+";";
            String text1 = "InvestavimoSas "+data.get(1).Value+";";
            String text2="NenumatytųatvejųSas "+data.get(2).Value+";";
            String text3="ButosąsSas "+data.get(3).Value+";";*/
            /// String fileContent = text.trim();
            /// RASYMAS SU FILE OUTPUTSTREAM
            /*fos = new FileOutputStream(Paimtasfailas,true);
            fos.write(fileContent.getBytes());
            fos.close();
             */
            FileWriter Writer = new FileWriter(Paimtasfailas);
            Writer.write(text);
            Writer.write(text1);
            Writer.write(text2);
            Writer.write(text3);
            Writer.write(text4);
            Writer.write(text5);
            Writer.write(text6);
            Writer.write(text7);
            Writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void Modification (File Paimtasfailas)
    {
        FileOutputStream fos = null;
        try{
            String text = "JanuaryData.txt;";

            FileWriter Writer = new FileWriter(Paimtasfailas);
            Writer.write(text);
            Writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}