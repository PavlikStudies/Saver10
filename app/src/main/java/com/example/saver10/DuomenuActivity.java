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

public class DuomenuActivity extends AppCompatActivity {
    String lapatai="";
    ArrayList<MountData> MASYVAS = new ArrayList<MountData>();
    String filenameofredingfile = "Modification.txt";
    int maxdigitvalue = 7;
    double max =9999999;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duomenu);
        /// Kiekvienai funcijai po 4 laukus;
        TextView islaid_taupemoji = (TextView) findViewById(R.id.textView_KeySpending);
        Button islaid_pridet1 = (Button) findViewById(R.id.button2_plius_isl);
        Button islaid_atimt1 = (Button) findViewById(R.id.button6_min_isl);
        TextView islaid_number1 = (TextView) findViewById(R.id.editTextNumberDecimal);
        ///
        TextView islaid_investavimo  = (TextView) findViewById(R.id.textView2_KeySpending2);
        Button islaid_pridet2 = (Button) findViewById(R.id.button3_plius_isl);
        Button islaid_atimt2 = (Button) findViewById(R.id.button7_min_isl);
        TextView islaid_number2 = (TextView) findViewById(R.id.editTextNumberDecimal2);
        ///
        TextView islaid_nenumatytu  = (TextView) findViewById(R.id.textView3_KeySpending3);
        Button islaid_pridet3 = (Button) findViewById(R.id.button4_plius_isl);
        Button islaid_atimt3 = (Button) findViewById(R.id.button8_min_isl);
        TextView islaid_number3 = (TextView) findViewById(R.id.editTextNumberDecimal3);

        Button issaugoti = (Button) findViewById(R.id.issaugoti_isl);



        String filepath = "MyfileDirectory";
        File PathFile = new File(getExternalFilesDir(filepath),filenameofredingfile);
        String filename = GetTextFileNameToRead(PathFile);
        File myExternalFile = new File(getExternalFilesDir(filepath),filename);
        MASYVAS = GetMounthData(myExternalFile);
        // Pradines reiksmes kokios yra faile
        islaid_taupemoji.setText(MASYVAS.get(0).Label+"\n"+String.format("%.2f",MASYVAS.get(0).Value));
        islaid_investavimo.setText(MASYVAS.get(1).Label +"\n" + String.format("%.2f",MASYVAS.get(1).Value));
        islaid_nenumatytu.setText(MASYVAS.get(2).Label +"\n" + String.format("%.2f",MASYVAS.get(2).Value));
        //Migtukai pirmo lauko
        islaid_pridet1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double number = Double.parseDouble(islaid_number1.getText().toString());
                    String textofnumber = Double.toString(Math.abs(number));
                    int integerPlaces = textofnumber.indexOf('.');
                    int decimalPlaces = textofnumber.length() - integerPlaces - 1;
                    if(decimalPlaces < 3) {
                        if (integerPlaces > maxdigitvalue) {
                            Context context = getApplicationContext();
                            CharSequence text = "Don't input more than 7 digit value!";
                            int duration = Toast.LENGTH_SHORT;
                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();
                        } else {
                            double tmp = MASYVAS.get(0).Value + number;
                            if (tmp > max) {
                                Context context = getApplicationContext();
                                CharSequence text = "If we add it will be more than 7 digit number" +"\n"+"You don't need to save money :)";
                                int duration = Toast.LENGTH_SHORT;
                                Toast toast = Toast.makeText(context, text, duration);
                                toast.show();
                            } else {
                                MASYVAS.get(0).SetValue(number);
                                islaid_taupemoji.setText(MASYVAS.get(0).Label + "\n" + String.format("%.2f",(MASYVAS.get(0).Value )));
                            }
                        }
                    }
                    else {
                        Context context = getApplicationContext();
                        CharSequence text = "There are to many decimal places!";
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }
                }
                catch (Exception e)
                {
                    MASYVAS.get(0).SetValue(0);
                }
            }
        });
        islaid_atimt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double number = Double.parseDouble(islaid_number1.getText().toString());
                    String textformthenumber = Double.toString(Math.abs(number));
                    int integerPlaces = textformthenumber.indexOf('.');
                    int decimalPlaces = textformthenumber.length() - integerPlaces - 1;
                    if(decimalPlaces < 3) {
                        if (integerPlaces > maxdigitvalue) {
                            Context context = getApplicationContext();
                            CharSequence text = "Don't input more than 7 digit value!";
                            int duration = Toast.LENGTH_SHORT;
                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();
                        } else {
                            double tmp = MASYVAS.get(0).Value - number;
                            if (tmp < 0) {
                                Context context = getApplicationContext();
                                CharSequence text = "It can't be negative value";
                                int duration = Toast.LENGTH_SHORT;
                                Toast toast = Toast.makeText(context, text, duration);
                                toast.show();
                            } else {
                                MASYVAS.get(0).MinusValue(number);
                                islaid_taupemoji.setText(MASYVAS.get(0).Label + "\n" + String.format("%.2f",MASYVAS.get(0).Value));
                            }

                        }
                    }
                    else {
                        Context context = getApplicationContext();
                        CharSequence text = "There are to many decimal places!";
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }

                }
                catch (Exception e)
                {
                    MASYVAS.get(0).SetValue(0);
                }
            }
        });
        //Migtukai antro lauko
        islaid_pridet2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double number = Double.parseDouble(islaid_number2.getText().toString());
                    String textofnumber = Double.toString(Math.abs(number));
                    int integerPlaces = textofnumber.indexOf('.');
                    int decimalPlaces = textofnumber.length() - integerPlaces - 1;
                    if(decimalPlaces < 3) {
                        if (integerPlaces > maxdigitvalue) {
                            Context context = getApplicationContext();
                            CharSequence text = "Don't input more than 7 digit value!";
                            int duration = Toast.LENGTH_SHORT;
                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();
                        } else {
                            double tmp = MASYVAS.get(1).Value + number;
                            if (tmp > max) {
                                Context context = getApplicationContext();
                                CharSequence text = "If we add it will be more than 7 digit number" +"\n"+"You don't need to save money :)";
                                int duration = Toast.LENGTH_SHORT;
                                Toast toast = Toast.makeText(context, text, duration);
                                toast.show();
                            } else {
                                MASYVAS.get(1).SetValue(number);
                                islaid_investavimo.setText(MASYVAS.get(1).Label + "\n" + String.format("%.2f",(MASYVAS.get(1).Value )));
                            }
                        }
                    }
                    else {
                        Context context = getApplicationContext();
                        CharSequence text = "There are to many decimal places!";
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }
                }
                catch (Exception e)
                {
                    MASYVAS.get(1).SetValue(0);
                }
            }
        });
        islaid_atimt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double number = Double.parseDouble(islaid_number2.getText().toString());
                    String textformthenumber = Double.toString(Math.abs(number));
                    int integerPlaces = textformthenumber.indexOf('.');
                    int decimalPlaces = textformthenumber.length() - integerPlaces - 1;
                    if(decimalPlaces < 3) {
                        if (integerPlaces > maxdigitvalue) {
                            Context context = getApplicationContext();
                            CharSequence text = "Don't input more than 7 digit value!";
                            int duration = Toast.LENGTH_SHORT;
                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();
                        } else {
                            double tmp = MASYVAS.get(1).Value - number;
                            if (tmp < 0) {
                                Context context = getApplicationContext();
                                CharSequence text = "It can't be negative value";
                                int duration = Toast.LENGTH_SHORT;
                                Toast toast = Toast.makeText(context, text, duration);
                                toast.show();
                            } else {
                                MASYVAS.get(1).MinusValue(number);
                                islaid_investavimo.setText(MASYVAS.get(1).Label + "\n" + String.format("%.2f", MASYVAS.get(1).Value));
                            }

                        }
                    }
                    else {
                        Context context = getApplicationContext();
                        CharSequence text = "There are to many decimal places!";
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }

                }
                catch (Exception e)
                {
                    MASYVAS.get(8).SetValue(0);
                }
            }
        });
        // Migutkai trecio lauko
        islaid_pridet3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double number = Double.parseDouble(islaid_number3.getText().toString());
                    String textofnumber = Double.toString(Math.abs(number));
                    int integerPlaces = textofnumber.indexOf('.');
                    int decimalPlaces = textofnumber.length() - integerPlaces - 1;
                    if(decimalPlaces < 3) {
                        if (integerPlaces > maxdigitvalue) {
                            Context context = getApplicationContext();
                            CharSequence text = "Don't input more than 7 digit value!";
                            int duration = Toast.LENGTH_SHORT;
                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();
                        } else {
                            double tmp = MASYVAS.get(2).Value + number;
                            if (tmp > max) {
                                Context context = getApplicationContext();
                                CharSequence text = "If we add it will be more than 7 digit number" + "\n" + "You don't need to save money :)";
                                int duration = Toast.LENGTH_SHORT;
                                Toast toast = Toast.makeText(context, text, duration);
                                toast.show();
                            } else {
                                MASYVAS.get(2).SetValue(number);
                                islaid_nenumatytu.setText(MASYVAS.get(2).Label + "\n" + String.format("%.2f", (MASYVAS.get(2).Value)));
                            }
                        }
                    }
                    else {
                        Context context = getApplicationContext();
                        CharSequence text = "There are to many decimal places!";
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }
                }
                catch (Exception e)
                {
                    MASYVAS.get(2).SetValue(0);
                }
            }
        });
        islaid_atimt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double number = Double.parseDouble(islaid_number3.getText().toString());
                    String textformthenumber = Double.toString(Math.abs(number));
                    int integerPlaces = textformthenumber.indexOf('.');
                    int decimalPlaces = textformthenumber.length() - integerPlaces - 1;
                    if(decimalPlaces < 3) {
                        if (integerPlaces > maxdigitvalue) {
                            Context context = getApplicationContext();
                            CharSequence text = "Don't input more than 7 digit value!";
                            int duration = Toast.LENGTH_SHORT;
                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();
                        } else {
                            double tmp = MASYVAS.get(2).Value - number;
                            if (tmp < 0) {
                                Context context = getApplicationContext();
                                CharSequence text = "It can't be negative value";
                                int duration = Toast.LENGTH_SHORT;
                                Toast toast = Toast.makeText(context, text, duration);
                                toast.show();
                            } else {
                                MASYVAS.get(2).MinusValue(number);
                                islaid_nenumatytu.setText(MASYVAS.get(2).Label + "\n" + String.format("%.2f", MASYVAS.get(2).Value));
                            }

                        }
                    }
                    else {
                        Context context = getApplicationContext();
                        CharSequence text = "There are to many decimal places!";
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }
                }
                catch (Exception e)
                {
                    MASYVAS.get(5).SetValue(0);
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
            String text1 ="EatingOut,"+data.get(0).Value+";";
            String text2= "Entertainment,"+data.get(1).Value+";";
            String text3="Addictions,"+data.get(2).Value+";";

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

