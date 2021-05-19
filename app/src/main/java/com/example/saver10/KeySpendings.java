package com.example.saver10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class KeySpendings extends AppCompatActivity {

    double maxdigitvalue = 9999;
    String lapatai="";
    ArrayList<MountData> MASYVAS = new ArrayList<MountData>();
    String filenameofredingfile = "Modification.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_key_spendings);

        /// Kiekvienai funcijai po 4 laukus;
        TextView islaid_taupemoji = (TextView) findViewById(R.id.textView_islaidos);
        Button islaid_pridet1 = (Button) findViewById(R.id.button2_islaidos);
        Button islaid_atimt1 = (Button) findViewById(R.id.button3_islaidos_min);
        TextView islaid_number1 = (TextView) findViewById(R.id.editTextNumberDecimal5_islaidos);
        ///
        TextView islaid_investavimo  = (TextView) findViewById(R.id.textView2_islaidos);
        Button islaid_pridet2 = (Button) findViewById(R.id.button2_islaidos2);
        Button islaid_atimt2 = (Button) findViewById(R.id.button3_islaidos_min2);
        TextView islaid_number2 = (TextView) findViewById(R.id.editTextNumberDecimal6_islaidos);
        ///
        TextView islaid_nenumatytu  = (TextView) findViewById(R.id.textView3_islaidos);
        Button islaid_pridet3 = (Button) findViewById(R.id.button2_islaidos3);
        Button islaid_atimt3 = (Button) findViewById(R.id.button3_islaidos_min3);
        TextView islaid_number3 = (TextView) findViewById(R.id.editTextNumberDecimal7_islaidos);
        ///
        TextView islaid_ButoSas  = (TextView) findViewById(R.id.textView4_islaidos);
        Button islaid_pridet4 = (Button) findViewById(R.id.button2_islaidos4);
        Button islaid_atimt4 = (Button) findViewById(R.id.button3_islaidos_min4);
        TextView islaid_number4 = (TextView) findViewById(R.id.editTextNumberDecimal8_islaidos);
        ///
        Button issaugoti = (Button) findViewById(R.id.button4_isaugoti_isl);
        String filepath = "MyfileDirectory";
        File PathFile = new File(getExternalFilesDir(filepath),filenameofredingfile);
        String filename = GetTextFileNameToRead(PathFile);
        File myExternalFile = new File(getExternalFilesDir(filepath),filename);
        MASYVAS = GetMounthData(myExternalFile);
        // Pradines reiksmes kokios yra faile
        islaid_taupemoji.setText(MASYVAS.get(3).Label + "\n"+ MASYVAS.get(3).Value);
        islaid_investavimo.setText(MASYVAS.get(4).Label + "\n"+ MASYVAS.get(4).Value);
        islaid_nenumatytu.setText(MASYVAS.get(5).Label + "\n"+ MASYVAS.get(5).Value);
        islaid_ButoSas.setText(MASYVAS.get(6).Label + "\n"+ MASYVAS.get(6).Value);
        //Migtukai pirmo lauko
        islaid_pridet1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double number = Double.parseDouble(islaid_number1.getText().toString());
                    if(number > maxdigitvalue) {
                        Context context = getApplicationContext();
                        CharSequence text = "Don't input more than 4 digit value!";
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context,text,duration);
                        toast.show();
                    }
                        else{
                            double tmp = MASYVAS.get(3).Value + number;
                        if (tmp > maxdigitvalue)
                        {
                            Context context = getApplicationContext();
                            CharSequence text = "It will be more than 4 digit number";
                            int duration = Toast.LENGTH_SHORT;
                            Toast toast = Toast.makeText(context,text,duration);
                            toast.show();
                        }
                        else {
                            MASYVAS.get(3).SetValue(number);
                            islaid_taupemoji.setText(MASYVAS.get(3).Label +"\n"+ MASYVAS.get(3).Value);
                        }
                        }
                }
                catch (Exception e)
                {
                    MASYVAS.get(3).SetValue(0);
                }
            }
        });
        islaid_atimt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double number = Double.parseDouble(islaid_number1.getText().toString());
                    if(number > maxdigitvalue) {
                        Context context = getApplicationContext();
                        CharSequence text = "Don't input more than 4 digit value!";
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context,text,duration);
                        toast.show();
                    }
                    else{
                        double tmp = MASYVAS.get(3).Value - number;
                        if(tmp < 0) {
                            Context context = getApplicationContext();
                            CharSequence text = "It can't be negative value";
                            int duration = Toast.LENGTH_SHORT;
                            Toast toast = Toast.makeText(context,text,duration);
                            toast.show();
                        }
                        else {
                            MASYVAS.get(3).MinusValue(number);
                            islaid_taupemoji.setText(MASYVAS.get(3).Label +"\n"+ MASYVAS.get(3).Value);
                        }

                    }

                }
                catch (Exception e)
                {
                    MASYVAS.get(3).SetValue(0);
                }
            }
        });
        //Migtukai antro lauko
        islaid_pridet2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double number = Double.parseDouble(islaid_number2.getText().toString());
                    if(number > maxdigitvalue) {
                        Context context = getApplicationContext();
                        CharSequence text = "Don't input more than 4 digit value!";
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context,text,duration);
                        toast.show();
                    }
                    else {
                        double tmp = MASYVAS.get(4).Value + number;
                        if (tmp > maxdigitvalue)
                        {
                            Context context = getApplicationContext();
                            CharSequence text = "It will be more than 4 digit number";
                            int duration = Toast.LENGTH_SHORT;
                            Toast toast = Toast.makeText(context,text,duration);
                            toast.show();
                        }
                        else {
                            MASYVAS.get(4).SetValue(number);
                            islaid_investavimo.setText(MASYVAS.get(4).Label +"\n"+ MASYVAS.get(4).Value);
                        }
                    }
                }
                catch (Exception e)
                {
                    MASYVAS.get(4).SetValue(0);
                }
            }
        });
        islaid_atimt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double number = Double.parseDouble(islaid_number2.getText().toString());
                    if(number > maxdigitvalue) {
                        Context context = getApplicationContext();
                        CharSequence text = "Don't input more than 4 digits value!";
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context,text,duration);
                        toast.show();
                    }
                    else {
                        double tmp = MASYVAS.get(4).Value - number;
                        if (tmp < 0) {
                            Context context = getApplicationContext();
                            CharSequence text = "It can't be negative value";
                            int duration = Toast.LENGTH_SHORT;
                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();
                        } else {
                            MASYVAS.get(4).MinusValue(number);
                            islaid_investavimo.setText(MASYVAS.get(4).Label +"\n"+ MASYVAS.get(4).Value);
                        }
                    }

                }
                catch (Exception e)
                {
                    MASYVAS.get(4).SetValue(0);
                }
            }
        });
        // Migutkai trecio lauko
        islaid_pridet3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double number = Double.parseDouble(islaid_number3.getText().toString());
                    if(number > maxdigitvalue) {
                        Context context = getApplicationContext();
                        CharSequence text = "Don't input more than 4 digit value!";
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context,text,duration);
                        toast.show();
                    }
                    else {
                        double tmp = MASYVAS.get(5).Value + number;
                        if (tmp > maxdigitvalue) {
                            Context context = getApplicationContext();
                            CharSequence text = "It will be more than 4 digit number";
                            int duration = Toast.LENGTH_SHORT;
                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();
                        } else {
                            MASYVAS.get(5).SetValue(number);
                            islaid_nenumatytu.setText(MASYVAS.get(5).Label +"\n"+ MASYVAS.get(5).Value);
                        }
                    }
                }
                catch (Exception e)
                {
                    MASYVAS.get(5).SetValue(0);
                }
            }
        });
        islaid_atimt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double number = Double.parseDouble(islaid_number3.getText().toString());
                    if(number > maxdigitvalue) {
                        Context context = getApplicationContext();
                        CharSequence text = "Don't input more than 4 digit value!";
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context,text,duration);
                        toast.show();
                    }
                    else {
                        double tmp = MASYVAS.get(5).Value - number;
                        if (tmp < 0) {
                            Context context = getApplicationContext();
                            CharSequence text = "It can't be negative value";
                            int duration = Toast.LENGTH_SHORT;
                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();
                        } else {
                            MASYVAS.get(5).MinusValue(number);
                            islaid_nenumatytu.setText(MASYVAS.get(5).Label +"\n"+ MASYVAS.get(5).Value);
                        }
                    }
                }
                catch (Exception e)
                {
                    MASYVAS.get(5).SetValue(0);
                }
            }
        });
        //Migtukai ketvirto lauko
        islaid_pridet4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double number = Double.parseDouble(islaid_number4.getText().toString());
                    if(number > maxdigitvalue) {
                        Context context = getApplicationContext();
                        CharSequence text = "Don't input more than 4 digit value!";
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context,text,duration);
                        toast.show();
                    }
                    else {
                        double tmp = MASYVAS.get(6).Value + number;
                        if (tmp > maxdigitvalue) {
                            Context context = getApplicationContext();
                            CharSequence text = "It will be more than 4 digit number";
                            int duration = Toast.LENGTH_SHORT;
                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();
                        } else {
                            MASYVAS.get(6).SetValue(number);
                            islaid_ButoSas.setText(MASYVAS.get(6).Label +"\n"+ MASYVAS.get(6).Value);
                        }
                    }
                }
                catch (Exception e)
                {
                    MASYVAS.get(6).SetValue(0);
                }
            }
        });
        islaid_atimt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double number = Double.parseDouble(islaid_number4.getText().toString());
                    if(number > maxdigitvalue) {
                        Context context = getApplicationContext();
                        CharSequence text = "Don't input more than 4 digit value!";
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context,text,duration);
                        toast.show();
                    }
                    else {
                        double tmp = MASYVAS.get(6).Value - number;
                        if (tmp < 0) {
                            Context context = getApplicationContext();
                            CharSequence text = "It can't be negative value";
                            int duration = Toast.LENGTH_SHORT;
                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();
                        } else {
                            MASYVAS.get(6).MinusValue(number);
                            islaid_ButoSas.setText(MASYVAS.get(6).Label + "\n" +MASYVAS.get(6).Value);
                        }
                    }
                }
                catch (Exception e)
                {
                    MASYVAS.get(7).SetValue(0);
                }
            }
        });
        // Isaugoti mygtukas
        issaugoti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RewriteData(MASYVAS,myExternalFile);
                TakeActiviti();

            }
        });

    }

    public ArrayList<MountData> GetMounthData(File PaimtasFailas)
    {
        FileReader fr =null;
        try {
            fr = new FileReader(PaimtasFailas);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(fr);
        ArrayList<MountData> data = new ArrayList<MountData>();
        try {
            while ((lapatai = br.readLine()) != null)
            {
                String[] Lines = lapatai.split(";");
                for (int i = 0; i < Lines.length; i++)
                {
                    String[] parts = Lines[i].split(",");
                    String Name = (parts[0]);
                    double NumberOfMarks = Double.parseDouble(parts[1]);
                    MountData S = new MountData(Name,NumberOfMarks);
                    data.add(S);
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public void RewriteData (ArrayList<MountData> data, File Paimtasfailas)
    {
        FileOutputStream fos = null;
        try{
            String text1 ="Home,"+data.get(0).Value+";";
            String text2="Internet,"+data.get(1).Value+";";
            String text3="Bank,"+data.get(2).Value+";";

            //////
            String text4="Rent,"+data.get(3).Value+";";
            String text5="Fuel,"+data.get(4).Value+";";
            String text6="Food,"+data.get(5).Value+";";
            String text7="Taxes,"+data.get(6).Value+";";

            ////
            String text8 ="Stock Market,"+data.get(7).Value+";";
            String text9="Investment funds,"+data.get(8).Value+";";
            String text10="Pension funds,"+data.get(9).Value+";";
            String text11="Real estate,"+data.get(10).Value+";";
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
    public void TakeActiviti()
    {
        Intent i = new Intent(this,MenesiuActivity.class);
        startActivity(i);
    }
    public void BackTOMAIN()
    {
        Intent first = new Intent(this,MainActivity.class);
        startActivity(first);
    }
    public String GetTextFileNameToRead(File PaimtasFailas)
    {
        String name = "";
        FileReader fr =null;
        try {
            fr = new FileReader(PaimtasFailas);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(fr);
        try {
            while ((lapatai = br.readLine()) != null)
            {
                String[] Lines = lapatai.split(";");
                for (int i = 0; i < Lines.length; i++)
                {
                    String[] parts = Lines[i].split(" ");
                    name = (parts[0]);
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return name;
    }
}