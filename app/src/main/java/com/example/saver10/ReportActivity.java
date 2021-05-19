package com.example.saver10;

import androidx.annotation.ColorRes;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class ReportActivity extends AppCompatActivity {
    String lapatai="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        Spinner MySpinner = (Spinner) findViewById(R.id.pasirinkimai_Spinners_ataskaita);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(ReportActivity.this,
                android.R.layout.simple_expandable_list_item_1, getResources().getStringArray(R.array.options));
        myAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        MySpinner.setAdapter(myAdapter);
        Button buttonofpasirinkimai = findViewById(R.id.button_Pasirinkti_ataskaita);
        TextView Text_KeySpending = (TextView) findViewById(R.id.MounhtKeeSpending);
        TextView Text_Investing = (TextView) findViewById(R.id.MounhtInvesti);
        TextView Text_Savings = (TextView) findViewById(R.id.MounthSavings);

        TextView Person_Text_KeySpending=(TextView) findViewById(R.id.Spending_Person);
        TextView Person_Text_Investing=(TextView) findViewById(R.id.Investing_Person);
        TextView Person_Text_Savings=(TextView) findViewById(R.id.Lavish_PersonS);


        buttonofpasirinkimai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(MySpinner.getSelectedItem().toString().equals("January"))
                {


                    String filename = "JanuaryData.txt";
                    String filepath = "MyfileDirectory";
                    String filename1 = "InitialIncome.txt";
                    File myExternalFile = new File(getExternalFilesDir(filepath),filename);
                    File PirmoKartoData = new File(getExternalFilesDir(filepath), filename1);
                    double PradinesPajamos = GetIncomeData(PirmoKartoData);
                    ArrayList<MountData> SavingsL = new ArrayList<MountData>();
                    SavingsL = GetMounthData(myExternalFile);
                    double Savings = GetSUMofMounthByIndex(SavingsL,0,3);
                    double Keyspending = GetSUMofMounthByIndex(SavingsL,3,7);
                    double Investing = GetSUMofMounthByIndex(SavingsL,7,11);



                    Text_KeySpending.setText(String.valueOf(Math.round(Keyspending)));
                    Text_Investing.setText(String.valueOf(Math.round(Investing)));
                    Text_Savings.setText(String.valueOf(Math.round(Savings)));

                    ///
                    Person_Text_KeySpending.setText(String.valueOf(Math.round(PradinesPajamos*0.5)));
                    Person_Text_Investing.setText(String.valueOf(Math.round(PradinesPajamos*0.3)));
                    Person_Text_Savings.setText(String.valueOf(Math.round(PradinesPajamos*0.2)));
                    if (Keyspending <= Math.round(PradinesPajamos*0.5))
                    {
                        Text_KeySpending.setBackgroundColor(getColor(R.color.SavingsGreen));
                    }
                    else  Text_KeySpending.setBackgroundColor(getColor(R.color.SavingsRed));
                    if (Investing <= Math.round(PradinesPajamos*0.3))
                    {
                        Text_Investing.setBackgroundColor(getColor(R.color.SavingsGreen));
                    }
                    else  Text_Investing.setBackgroundColor(getColor(R.color.SavingsRed));
                    if (Savings <= Math.round(PradinesPajamos*0.2))
                    {
                       Text_Savings.setBackgroundColor(getColor(R.color.SavingsGreen));
                    }
                    else Text_Investing.setBackgroundColor(getColor(R.color.SavingsRed));
                }
                if(MySpinner.getSelectedItem().toString().equals("February"))
                {


                    String filename = "FeabuaryData.txt";
                    String filepath = "MyfileDirectory";
                    String filename1 = "InitialIncome.txt";
                    File myExternalFile = new File(getExternalFilesDir(filepath),filename);
                    File PirmoKartoData = new File(getExternalFilesDir(filepath), filename1);
                    double PradinesPajamos = GetIncomeData(PirmoKartoData);
                    ArrayList<MountData> SavingsL = new ArrayList<MountData>();
                    SavingsL = GetMounthData(myExternalFile);
                    double Savings = GetSUMofMounthByIndex(SavingsL,0,3);
                    double Keyspending = GetSUMofMounthByIndex(SavingsL,3,7);
                    double Investing = GetSUMofMounthByIndex(SavingsL,7,11);



                    Text_KeySpending.setText(String.valueOf(Math.round(Keyspending)));
                    Text_Investing.setText(String.valueOf(Math.round(Investing)));
                    Text_Savings.setText(String.valueOf(Math.round(Savings)));

                    ///
                    Person_Text_KeySpending.setText(String.valueOf(Math.round(PradinesPajamos*0.5)));
                    Person_Text_Investing.setText(String.valueOf(Math.round(PradinesPajamos*0.3)));
                    Person_Text_Savings.setText(String.valueOf(Math.round(PradinesPajamos*0.2)));
                    if (Keyspending <= Math.round(PradinesPajamos*0.5))
                    {
                        Text_KeySpending.setBackgroundColor(getColor(R.color.SavingsGreen));
                    }
                    else  Text_KeySpending.setBackgroundColor(getColor(R.color.SavingsRed));
                    if (Investing <= Math.round(PradinesPajamos*0.3))
                    {
                        Text_Investing.setBackgroundColor(getColor(R.color.SavingsGreen));
                    }
                    else  Text_Investing.setBackgroundColor(getColor(R.color.SavingsRed));
                    if (Savings <= Math.round(PradinesPajamos*0.2))
                    {
                        Text_Savings.setBackgroundColor(getColor(R.color.SavingsGreen));
                    }
                    else Text_Investing.setBackgroundColor(getColor(R.color.SavingsRed));
                }
                if(MySpinner.getSelectedItem().toString().equals("March"))
                {


                    String filename = "MarchData.txt";
                    String filepath = "MyfileDirectory";
                    String filename1 = "InitialIncome.txt";
                    File myExternalFile = new File(getExternalFilesDir(filepath),filename);
                    File PirmoKartoData = new File(getExternalFilesDir(filepath), filename1);
                    double PradinesPajamos = GetIncomeData(PirmoKartoData);
                    ArrayList<MountData> SavingsL = new ArrayList<MountData>();
                    SavingsL = GetMounthData(myExternalFile);
                    double Savings = GetSUMofMounthByIndex(SavingsL,0,3);
                    double Keyspending = GetSUMofMounthByIndex(SavingsL,3,7);
                    double Investing = GetSUMofMounthByIndex(SavingsL,7,11);



                    Text_KeySpending.setText(String.valueOf(Math.round(Keyspending)));
                    Text_Investing.setText(String.valueOf(Math.round(Investing)));
                    Text_Savings.setText(String.valueOf(Math.round(Savings)));

                    ///
                    Person_Text_KeySpending.setText(String.valueOf(Math.round(PradinesPajamos*0.5)));
                    Person_Text_Investing.setText(String.valueOf(Math.round(PradinesPajamos*0.3)));
                    Person_Text_Savings.setText(String.valueOf(Math.round(PradinesPajamos*0.2)));
                    if (Keyspending <= Math.round(PradinesPajamos*0.5))
                    {
                        Text_KeySpending.setBackgroundColor(getColor(R.color.SavingsGreen));
                    }
                    else  Text_KeySpending.setBackgroundColor(getColor(R.color.SavingsRed));
                    if (Investing <= Math.round(PradinesPajamos*0.3))
                    {
                        Text_Investing.setBackgroundColor(getColor(R.color.SavingsGreen));
                    }
                    else  Text_Investing.setBackgroundColor(getColor(R.color.SavingsRed));
                    if (Savings <= Math.round(PradinesPajamos*0.2))
                    {
                        Text_Savings.setBackgroundColor(getColor(R.color.SavingsGreen));
                    }
                    else Text_Investing.setBackgroundColor(getColor(R.color.SavingsRed));
                }
                if(MySpinner.getSelectedItem().toString().equals("April"))
                {


                    String filename = "AprilData.txt";
                    String filepath = "MyfileDirectory";
                    String filename1 = "InitialIncome.txt";
                    File myExternalFile = new File(getExternalFilesDir(filepath),filename);
                    File PirmoKartoData = new File(getExternalFilesDir(filepath), filename1);
                    double PradinesPajamos = GetIncomeData(PirmoKartoData);
                    ArrayList<MountData> SavingsL = new ArrayList<MountData>();
                    SavingsL = GetMounthData(myExternalFile);
                    double Savings = GetSUMofMounthByIndex(SavingsL,0,3);
                    double Keyspending = GetSUMofMounthByIndex(SavingsL,3,7);
                    double Investing = GetSUMofMounthByIndex(SavingsL,7,11);



                    Text_KeySpending.setText(String.valueOf(Math.round(Keyspending)));
                    Text_Investing.setText(String.valueOf(Math.round(Investing)));
                    Text_Savings.setText(String.valueOf(Math.round(Savings)));

                    ///
                    Person_Text_KeySpending.setText(String.valueOf(Math.round(PradinesPajamos*0.5)));
                    Person_Text_Investing.setText(String.valueOf(Math.round(PradinesPajamos*0.3)));
                    Person_Text_Savings.setText(String.valueOf(Math.round(PradinesPajamos*0.2)));
                    if (Keyspending <= Math.round(PradinesPajamos*0.5))
                    {
                        Text_KeySpending.setBackgroundColor(getColor(R.color.SavingsGreen));
                    }
                    else  Text_KeySpending.setBackgroundColor(getColor(R.color.SavingsRed));
                    if (Investing <= Math.round(PradinesPajamos*0.3))
                    {
                        Text_Investing.setBackgroundColor(getColor(R.color.SavingsGreen));
                    }
                    else  Text_Investing.setBackgroundColor(getColor(R.color.SavingsRed));
                    if (Savings <= Math.round(PradinesPajamos*0.2))
                    {
                        Text_Savings.setBackgroundColor(getColor(R.color.SavingsGreen));
                    }
                    else Text_Investing.setBackgroundColor(getColor(R.color.SavingsRed));
                }
                if(MySpinner.getSelectedItem().toString().equals("May"))
                {


                    String filename = "MayData.txt";
                    String filepath = "MyfileDirectory";
                    String filename1 = "InitialIncome.txt";
                    File myExternalFile = new File(getExternalFilesDir(filepath),filename);
                    File PirmoKartoData = new File(getExternalFilesDir(filepath), filename1);
                    double PradinesPajamos = GetIncomeData(PirmoKartoData);
                    ArrayList<MountData> SavingsL = new ArrayList<MountData>();
                    SavingsL = GetMounthData(myExternalFile);
                    double Savings = GetSUMofMounthByIndex(SavingsL,0,3);
                    double Keyspending = GetSUMofMounthByIndex(SavingsL,3,7);
                    double Investing = GetSUMofMounthByIndex(SavingsL,7,11);



                    Text_KeySpending.setText(String.valueOf(Math.round(Keyspending)));
                    Text_Investing.setText(String.valueOf(Math.round(Investing)));
                    Text_Savings.setText(String.valueOf(Math.round(Savings)));

                    ///
                    Person_Text_KeySpending.setText(String.valueOf(Math.round(PradinesPajamos*0.5)));
                    Person_Text_Investing.setText(String.valueOf(Math.round(PradinesPajamos*0.3)));
                    Person_Text_Savings.setText(String.valueOf(Math.round(PradinesPajamos*0.2)));
                    if (Keyspending <= Math.round(PradinesPajamos*0.5))
                    {
                        Text_KeySpending.setBackgroundColor(getColor(R.color.SavingsGreen));
                    }
                    else  Text_KeySpending.setBackgroundColor(getColor(R.color.SavingsRed));
                    if (Investing <= Math.round(PradinesPajamos*0.3))
                    {
                        Text_Investing.setBackgroundColor(getColor(R.color.SavingsGreen));
                    }
                    else  Text_Investing.setBackgroundColor(getColor(R.color.SavingsRed));
                    if (Savings <= Math.round(PradinesPajamos*0.2))
                    {
                        Text_Savings.setBackgroundColor(getColor(R.color.SavingsGreen));
                    }
                    else Text_Investing.setBackgroundColor(getColor(R.color.SavingsRed));
                }
                if(MySpinner.getSelectedItem().toString().equals("June"))
                {


                    String filename = "JuneData.txt";
                    String filepath = "MyfileDirectory";
                    String filename1 = "InitialIncome.txt";
                    File myExternalFile = new File(getExternalFilesDir(filepath),filename);
                    File PirmoKartoData = new File(getExternalFilesDir(filepath), filename1);
                    double PradinesPajamos = GetIncomeData(PirmoKartoData);
                    ArrayList<MountData> SavingsL = new ArrayList<MountData>();
                    SavingsL = GetMounthData(myExternalFile);
                    double Savings = GetSUMofMounthByIndex(SavingsL,0,3);
                    double Keyspending = GetSUMofMounthByIndex(SavingsL,3,7);
                    double Investing = GetSUMofMounthByIndex(SavingsL,7,11);



                    Text_KeySpending.setText(String.valueOf(Math.round(Keyspending)));
                    Text_Investing.setText(String.valueOf(Math.round(Investing)));
                    Text_Savings.setText(String.valueOf(Math.round(Savings)));

                    ///
                    Person_Text_KeySpending.setText(String.valueOf(Math.round(PradinesPajamos*0.5)));
                    Person_Text_Investing.setText(String.valueOf(Math.round(PradinesPajamos*0.3)));
                    Person_Text_Savings.setText(String.valueOf(Math.round(PradinesPajamos*0.2)));
                    if (Keyspending <= Math.round(PradinesPajamos*0.5))
                    {
                        Text_KeySpending.setBackgroundColor(getColor(R.color.SavingsGreen));
                    }
                    else  Text_KeySpending.setBackgroundColor(getColor(R.color.SavingsRed));
                    if (Investing <= Math.round(PradinesPajamos*0.3))
                    {
                        Text_Investing.setBackgroundColor(getColor(R.color.SavingsGreen));
                    }
                    else  Text_Investing.setBackgroundColor(getColor(R.color.SavingsRed));
                    if (Savings <= Math.round(PradinesPajamos*0.2))
                    {
                        Text_Savings.setBackgroundColor(getColor(R.color.SavingsGreen));
                    }
                    else Text_Investing.setBackgroundColor(getColor(R.color.SavingsRed));
                }
                if(MySpinner.getSelectedItem().toString().equals("July"))
                {

                    String filename = "JulyData.txt";
                    String filepath = "MyfileDirectory";
                    String filename1 = "InitialIncome.txt";
                    File myExternalFile = new File(getExternalFilesDir(filepath),filename);
                    File PirmoKartoData = new File(getExternalFilesDir(filepath), filename1);
                    double PradinesPajamos = GetIncomeData(PirmoKartoData);
                    ArrayList<MountData> SavingsL = new ArrayList<MountData>();
                    SavingsL = GetMounthData(myExternalFile);
                    double Savings = GetSUMofMounthByIndex(SavingsL,0,3);
                    double Keyspending = GetSUMofMounthByIndex(SavingsL,3,7);
                    double Investing = GetSUMofMounthByIndex(SavingsL,7,11);



                    Text_KeySpending.setText(String.valueOf(Math.round(Keyspending)));
                    Text_Investing.setText(String.valueOf(Math.round(Investing)));
                    Text_Savings.setText(String.valueOf(Math.round(Savings)));

                    ///
                    Person_Text_KeySpending.setText(String.valueOf(Math.round(PradinesPajamos*0.5)));
                    Person_Text_Investing.setText(String.valueOf(Math.round(PradinesPajamos*0.3)));
                    Person_Text_Savings.setText(String.valueOf(Math.round(PradinesPajamos*0.2)));
                    if (Keyspending <= Math.round(PradinesPajamos*0.5))
                    {
                        Text_KeySpending.setBackgroundColor(getColor(R.color.SavingsGreen));
                    }
                    else  Text_KeySpending.setBackgroundColor(getColor(R.color.SavingsRed));
                    if (Investing <= Math.round(PradinesPajamos*0.3))
                    {
                        Text_Investing.setBackgroundColor(getColor(R.color.SavingsGreen));
                    }
                    else  Text_Investing.setBackgroundColor(getColor(R.color.SavingsRed));
                    if (Savings <= Math.round(PradinesPajamos*0.2))
                    {
                        Text_Savings.setBackgroundColor(getColor(R.color.SavingsGreen));
                    }
                    else Text_Investing.setBackgroundColor(getColor(R.color.SavingsRed));
                }
                if(MySpinner.getSelectedItem().toString().equals("August"))
                {


                    String filename = "AugustData.txt";
                    String filepath = "MyfileDirectory";
                    String filename1 = "InitialIncome.txt";
                    File myExternalFile = new File(getExternalFilesDir(filepath),filename);
                    File PirmoKartoData = new File(getExternalFilesDir(filepath), filename1);
                    double PradinesPajamos = GetIncomeData(PirmoKartoData);
                    ArrayList<MountData> SavingsL = new ArrayList<MountData>();
                    SavingsL = GetMounthData(myExternalFile);
                    double Savings = GetSUMofMounthByIndex(SavingsL,0,3);
                    double Keyspending = GetSUMofMounthByIndex(SavingsL,3,7);
                    double Investing = GetSUMofMounthByIndex(SavingsL,7,11);



                    Text_KeySpending.setText(String.valueOf(Math.round(Keyspending)));
                    Text_Investing.setText(String.valueOf(Math.round(Investing)));
                    Text_Savings.setText(String.valueOf(Math.round(Savings)));

                    ///
                    Person_Text_KeySpending.setText(String.valueOf(Math.round(PradinesPajamos*0.5)));
                    Person_Text_Investing.setText(String.valueOf(Math.round(PradinesPajamos*0.3)));
                    Person_Text_Savings.setText(String.valueOf(Math.round(PradinesPajamos*0.2)));
                    if (Keyspending <= Math.round(PradinesPajamos*0.5))
                    {
                        Text_KeySpending.setBackgroundColor(getColor(R.color.SavingsGreen));
                    }
                    else  Text_KeySpending.setBackgroundColor(getColor(R.color.SavingsRed));
                    if (Investing <= Math.round(PradinesPajamos*0.3))
                    {
                        Text_Investing.setBackgroundColor(getColor(R.color.SavingsGreen));
                    }
                    else  Text_Investing.setBackgroundColor(getColor(R.color.SavingsRed));
                    if (Savings <= Math.round(PradinesPajamos*0.2))
                    {
                        Text_Savings.setBackgroundColor(getColor(R.color.SavingsGreen));
                    }
                    else Text_Investing.setBackgroundColor(getColor(R.color.SavingsRed));
                }
                if(MySpinner.getSelectedItem().toString().equals("September"))
                {


                    String filename = "SeptemberData.txt";
                    String filepath = "MyfileDirectory";
                    String filename1 = "InitialIncome.txt";
                    File myExternalFile = new File(getExternalFilesDir(filepath),filename);
                    File PirmoKartoData = new File(getExternalFilesDir(filepath), filename1);
                    double PradinesPajamos = GetIncomeData(PirmoKartoData);
                    ArrayList<MountData> SavingsL = new ArrayList<MountData>();
                    SavingsL = GetMounthData(myExternalFile);
                    double Savings = GetSUMofMounthByIndex(SavingsL,0,3);
                    double Keyspending = GetSUMofMounthByIndex(SavingsL,3,7);
                    double Investing = GetSUMofMounthByIndex(SavingsL,7,11);



                    Text_KeySpending.setText(String.valueOf(Math.round(Keyspending)));
                    Text_Investing.setText(String.valueOf(Math.round(Investing)));
                    Text_Savings.setText(String.valueOf(Math.round(Savings)));

                    ///
                    Person_Text_KeySpending.setText(String.valueOf(Math.round(PradinesPajamos*0.5)));
                    Person_Text_Investing.setText(String.valueOf(Math.round(PradinesPajamos*0.3)));
                    Person_Text_Savings.setText(String.valueOf(Math.round(PradinesPajamos*0.2)));
                    if (Keyspending <= Math.round(PradinesPajamos*0.5))
                    {
                        Text_KeySpending.setBackgroundColor(getColor(R.color.SavingsGreen));
                    }
                    else  Text_KeySpending.setBackgroundColor(getColor(R.color.SavingsRed));
                    if (Investing <= Math.round(PradinesPajamos*0.3))
                    {
                        Text_Investing.setBackgroundColor(getColor(R.color.SavingsGreen));
                    }
                    else  Text_Investing.setBackgroundColor(getColor(R.color.SavingsRed));
                    if (Savings <= Math.round(PradinesPajamos*0.2))
                    {
                        Text_Savings.setBackgroundColor(getColor(R.color.SavingsGreen));
                    }
                    else Text_Investing.setBackgroundColor(getColor(R.color.SavingsRed));
                }
                if(MySpinner.getSelectedItem().toString().equals("October"))
                {


                    String filename = "OctoberData.txt";
                    String filepath = "MyfileDirectory";
                    String filename1 = "InitialIncome.txt";
                    File myExternalFile = new File(getExternalFilesDir(filepath),filename);
                    File PirmoKartoData = new File(getExternalFilesDir(filepath), filename1);
                    double PradinesPajamos = GetIncomeData(PirmoKartoData);
                    ArrayList<MountData> SavingsL = new ArrayList<MountData>();
                    SavingsL = GetMounthData(myExternalFile);
                    double Savings = GetSUMofMounthByIndex(SavingsL,0,3);
                    double Keyspending = GetSUMofMounthByIndex(SavingsL,3,7);
                    double Investing = GetSUMofMounthByIndex(SavingsL,7,11);

                    Text_KeySpending.setText(String.valueOf(Math.round(Keyspending)));
                    Text_Investing.setText(String.valueOf(Math.round(Investing)));
                    Text_Savings.setText(String.valueOf(Math.round(Savings)));

                    ///
                    Person_Text_KeySpending.setText(String.valueOf(Math.round(PradinesPajamos*0.5)));
                    Person_Text_Investing.setText(String.valueOf(Math.round(PradinesPajamos*0.3)));
                    Person_Text_Savings.setText(String.valueOf(Math.round(PradinesPajamos*0.2)));
                    if (Keyspending <= Math.round(PradinesPajamos*0.5))
                    {
                        Text_KeySpending.setBackgroundColor(getColor(R.color.SavingsGreen));
                    }
                    else  Text_KeySpending.setBackgroundColor(getColor(R.color.SavingsRed));
                    if (Investing <= Math.round(PradinesPajamos*0.3))
                    {
                        Text_Investing.setBackgroundColor(getColor(R.color.SavingsGreen));
                    }
                    else  Text_Investing.setBackgroundColor(getColor(R.color.SavingsRed));
                    if (Savings <= Math.round(PradinesPajamos*0.2))
                    {
                        Text_Savings.setBackgroundColor(getColor(R.color.SavingsGreen));
                    }
                    else Text_Investing.setBackgroundColor(getColor(R.color.SavingsRed));
                }
                if(MySpinner.getSelectedItem().toString().equals("November"))
                {


                    String filename = "NovemberData.txt";
                    String filepath = "MyfileDirectory";
                    String filename1 = "InitialIncome.txt";
                    File myExternalFile = new File(getExternalFilesDir(filepath),filename);
                    File PirmoKartoData = new File(getExternalFilesDir(filepath), filename1);
                    double PradinesPajamos = GetIncomeData(PirmoKartoData);
                    ArrayList<MountData> SavingsL = new ArrayList<MountData>();
                    SavingsL = GetMounthData(myExternalFile);
                    double Savings = GetSUMofMounthByIndex(SavingsL,0,3);
                    double Keyspending = GetSUMofMounthByIndex(SavingsL,3,7);
                    double Investing = GetSUMofMounthByIndex(SavingsL,7,11);



                    Text_KeySpending.setText(String.valueOf(Math.round(Keyspending)));
                    Text_Investing.setText(String.valueOf(Math.round(Investing)));
                    Text_Savings.setText(String.valueOf(Math.round(Savings)));

                    ///
                    Person_Text_KeySpending.setText(String.valueOf(Math.round(PradinesPajamos*0.5)));
                    Person_Text_Investing.setText(String.valueOf(Math.round(PradinesPajamos*0.3)));
                    Person_Text_Savings.setText(String.valueOf(Math.round(PradinesPajamos*0.2)));
                    if (Keyspending <= Math.round(PradinesPajamos*0.5))
                    {
                        Text_KeySpending.setBackgroundColor(getColor(R.color.SavingsGreen));
                    }
                    else  Text_KeySpending.setBackgroundColor(getColor(R.color.SavingsRed));
                    if (Investing <= Math.round(PradinesPajamos*0.3))
                    {
                        Text_Investing.setBackgroundColor(getColor(R.color.SavingsGreen));
                    }
                    else  Text_Investing.setBackgroundColor(getColor(R.color.SavingsRed));
                    if (Savings <= Math.round(PradinesPajamos*0.2))
                    {
                        Text_Savings.setBackgroundColor(getColor(R.color.SavingsGreen));
                    }
                    else Text_Investing.setBackgroundColor(getColor(R.color.SavingsRed));
                }
                if(MySpinner.getSelectedItem().toString().equals("December"))
                {


                    String filename = "DecemberData.txt";
                    String filepath = "MyfileDirectory";
                    String filename1 = "InitialIncome.txt";
                    File myExternalFile = new File(getExternalFilesDir(filepath),filename);
                    File PirmoKartoData = new File(getExternalFilesDir(filepath), filename1);
                    double PradinesPajamos = GetIncomeData(PirmoKartoData);
                    ArrayList<MountData> SavingsL = new ArrayList<MountData>();
                    SavingsL = GetMounthData(myExternalFile);
                    double Savings = GetSUMofMounthByIndex(SavingsL,0,3);
                    double Keyspending = GetSUMofMounthByIndex(SavingsL,3,7);
                    double Investing = GetSUMofMounthByIndex(SavingsL,7,11);



                    Text_KeySpending.setText(String.valueOf(Math.round(Keyspending)));
                    Text_Investing.setText(String.valueOf(Math.round(Investing)));
                    Text_Savings.setText(String.valueOf(Math.round(Savings)));

                    ///
                    Person_Text_KeySpending.setText(String.valueOf(Math.round(PradinesPajamos*0.5)));
                    Person_Text_Investing.setText(String.valueOf(Math.round(PradinesPajamos*0.3)));
                    Person_Text_Savings.setText(String.valueOf(Math.round(PradinesPajamos*0.2)));
                    if (Keyspending <= Math.round(PradinesPajamos*0.5))
                    {
                        Text_KeySpending.setBackgroundColor(getColor(R.color.SavingsGreen));
                    }
                    else  Text_KeySpending.setBackgroundColor(getColor(R.color.SavingsRed));
                    if (Investing <= Math.round(PradinesPajamos*0.3))
                    {
                        Text_Investing.setBackgroundColor(getColor(R.color.SavingsGreen));
                    }
                    else  Text_Investing.setBackgroundColor(getColor(R.color.SavingsRed));
                    if (Savings <= Math.round(PradinesPajamos*0.2))
                    {
                        Text_Savings.setBackgroundColor(getColor(R.color.SavingsGreen));
                    }
                    else Text_Investing.setBackgroundColor(getColor(R.color.SavingsRed));
                }

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

    public  double GetSUMofMounthByIndex(ArrayList<MountData> Data, int i,int p)
    {
        double sum = 0;
        int k=0;
        for (k=i;i<p; i++)
        {
            sum = sum + Data.get(i).Value;
        }
        return sum;
    }

    public double GetIncomeData(File PaimtasFailas)
    {
        String Textedit = "";
        double Pajamos = 0;
        FileReader fr =null;
        try {
            fr = new FileReader(PaimtasFailas);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(fr);
        try {
            while ((Textedit = br.readLine()) != null)
            {
                String[] Lines = Textedit.split(";");
                for (int i = 0; i < Lines.length; i++)
                {
                    String[] parts = Lines[i].split(" ");
                    String Name = (parts[0]);
                    Pajamos = Double.parseDouble(parts[1]);

                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Pajamos;
    }
}