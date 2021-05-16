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
                    File april = new File(getExternalFilesDir(filepath),"AprilData.txt");
                    AllMounthsData(april);
                    File may = new File(getExternalFilesDir(filepath),"MayData.txt");
                    AllMounthsData(may);
                    File june = new File(getExternalFilesDir(filepath),"JuneData.txt");
                    AllMounthsData(june);
                    File july = new File(getExternalFilesDir(filepath),"JulyData.txt");
                    AllMounthsData(july);
                    File august = new File(getExternalFilesDir(filepath),"AugustData.txt");
                    AllMounthsData(august);
                    File september = new File(getExternalFilesDir(filepath),"SeptemberData.txt");
                    AllMounthsData(september);
                    File october = new File(getExternalFilesDir(filepath),"OctoberData.txt");
                    AllMounthsData(october);
                    File november = new File(getExternalFilesDir(filepath),"NovemberData.txt");
                    AllMounthsData(november);
                    File december = new File(getExternalFilesDir(filepath),"DecemberData.txt");
                    AllMounthsData(december);


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
            String text1 ="Namuose 0;";
            String text2="Internete 0;";
            String text3="Banke 0;";
            ///Keyspending
            String text4="Nuoma 0;";
            String text5="Kuras 0;";
            String text6="Maistas 0;";
            String text7="Mokesciai 0;";
            /// Investing
            String text8="AkcijuBirza 0;";
            String text9="Investiciniaifondai 0;";
            String text10="Pencijufondai 0;";
            String text11="Nekilnojamasturtas 0;";
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
            Writer.write(text1);
            Writer.write(text2);
            Writer.write(text3);
            Writer.write(text4);
            Writer.write(text5);
            Writer.write(text6);
            Writer.write(text7);
            Writer.write(text8);
            Writer.write(text9);
            Writer.write(text10);
            Writer.write(text11);
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