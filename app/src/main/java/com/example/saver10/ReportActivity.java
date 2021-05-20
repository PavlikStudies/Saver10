package com.example.saver10;

import androidx.annotation.ColorRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class ReportActivity extends AppCompatActivity {
    String lapatai="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int[] labas;
        List <String> Patarimai = new ArrayList<String>(11);
        String pat1 = "You should try planning your shopping list that way you will buy less stuff that you do not need";
        String pat2 = "Try using more cash for payments that way it will be easier to visualise your spendings";
        String pat3 = "Try minimising your time using utilities such as electricity or water that way you can have more money for " +
                "your weekends";
        String pat4 = "Try controlling your bad habits such as smoking or drinking it could significantly change your budget size";
        String pat5 = "Carefully manage your subscriptions, if you do not utilize it once a month you should consider getting rid of it";
        String pat6 = "Check your belongings maybe you have something that you could sell to ease up your economic tensions";
        Patarimai.add(pat1);
        Patarimai.add(pat2);
        Patarimai.add(pat3);
        Patarimai.add(pat4);
        Patarimai.add(pat5);
        Patarimai.add(pat6);

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
        TextView Text_Patarimas = (TextView) findViewById(R.id.Patarimas);
        Button baktomain = findViewById(R.id.BackToMainButton);

        TextView Person_Text_KeySpending=(TextView) findViewById(R.id.Spending_Person);
        TextView Person_Text_Investing=(TextView) findViewById(R.id.Investing_Person);
        TextView Person_Text_Savings=(TextView) findViewById(R.id.Lavish_PersonS);

        TextView Person_Text_ContSavings = findViewById(R.id.ContSavings);
        String filename = "Savings.txt";
        String filepath = "MyfileDirectory";
        File PathFile = new File(getExternalFilesDir(filepath),filename);
        double[] ex = GenerateSavingsoftheMounth();
        RewriteData(ex,PathFile);
        double[] Data = GetSavings(PathFile);


    baktomain.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
       BackTOMAIN();
    }
    });
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
                    ArrayList<MountData> SavingsL;
                    SavingsL = GetMounthData(myExternalFile);
                    double Savings = GetSUMofMounthByIndex(SavingsL,0,3);
                    double Keyspending = GetSUMofMounthByIndex(SavingsL,3,7);
                    double Investing = GetSUMofMounthByIndex(SavingsL,7,11);

                    Text_KeySpending.setText(String.format("%.2f",(Keyspending)));
                    Text_KeySpending.append(" €");
                    Text_Investing.setText(String.format("%.2f",(Investing)));
                    Text_Investing.append(" €");
                    Text_Savings.setText(String.format("%.2f",(Savings)));
                    Text_Savings.append(" €");
                    Person_Text_ContSavings.setText(String.format("%.2f",(Data[0])));
                    Person_Text_ContSavings.append(" €");

                    ///
                    Person_Text_KeySpending.setText(String.format("%.2f",(PradinesPajamos * 0.5)));
                    Person_Text_KeySpending.append(" €");
                    Person_Text_Investing.setText(String.format("%.2f",(PradinesPajamos * 0.3)));
                    Person_Text_Investing.append(" €");
                    Person_Text_Savings.setText(String.format("%.2f",(PradinesPajamos * 0.2)));
                    Person_Text_Savings.append(" €");
                    if (Keyspending <= Math.round(PradinesPajamos*0.5))
                    {
                        Text_KeySpending.setBackgroundColor(getColor(R.color.SavingsGreen));
                    }
                    else {
                        Text_KeySpending.setBackgroundColor(getColor(R.color.SavingsRed));
                        Random r = new Random();
                        int patarimas = r.nextInt(5);
                        Text_Patarimas.setText(Patarimai.get(patarimas));

                    }
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



                    Text_KeySpending.setText(String.format("%.2f",(Keyspending)));
                    Text_KeySpending.append(" €");
                    Text_Investing.setText(String.format("%.2f",(Investing)));
                    Text_Investing.append(" €");
                    Text_Savings.setText(String.format("%.2f",(Savings)));
                    Text_Savings.append(" €");
                    Person_Text_ContSavings.setText(String.format("%.2f",(Data[1])));
                    Person_Text_ContSavings.append(" €");

                    ///
                    Person_Text_KeySpending.setText(String.format("%.2f",(PradinesPajamos * 0.5)));
                    Person_Text_KeySpending.append(" €");
                    Person_Text_Investing.setText(String.format("%.2f",(PradinesPajamos * 0.3)));
                    Person_Text_Investing.append(" €");
                    Person_Text_Savings.setText(String.format("%.2f",(PradinesPajamos * 0.2)));
                    Person_Text_Savings.append(" €");
                    if (Keyspending <= Math.round(PradinesPajamos*0.5))
                    {
                        Text_KeySpending.setBackgroundColor(getColor(R.color.SavingsGreen));
                    }
                    else {
                        Text_KeySpending.setBackgroundColor(getColor(R.color.SavingsRed));
                        Random r = new Random();
                        int patarimas = r.nextInt(5);
                        Text_Patarimas.setText(Patarimai.get(patarimas));
                    }
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



                    Text_KeySpending.setText(String.format("%.2f",(Keyspending)));
                    Text_KeySpending.append(" €");
                    Text_Investing.setText(String.format("%.2f",(Investing)));
                    Text_Investing.append(" €");
                    Text_Savings.setText(String.format("%.2f",(Savings)));
                    Text_Savings.append(" €");
                    Person_Text_ContSavings.setText(String.format("%.2f",(Data[2])));
                    Person_Text_ContSavings.append(" €");

                    ///
                    Person_Text_KeySpending.setText(String.format("%.2f",(PradinesPajamos * 0.5)));
                    Person_Text_KeySpending.append(" €");
                    Person_Text_Investing.setText(String.format("%.2f",(PradinesPajamos * 0.3)));
                    Person_Text_Investing.append(" €");
                    Person_Text_Savings.setText(String.format("%.2f",(PradinesPajamos * 0.2)));
                    Person_Text_Savings.append(" €");
                    if (Keyspending <= Math.round(PradinesPajamos*0.5))
                    {
                        Text_KeySpending.setBackgroundColor(getColor(R.color.SavingsGreen));
                    }
                    else {
                        Text_KeySpending.setBackgroundColor(getColor(R.color.SavingsRed));
                        Random r = new Random();
                        int patarimas = r.nextInt(5);
                        Text_Patarimas.setText(Patarimai.get(patarimas));

                    }
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



                    Text_KeySpending.setText(String.format("%.2f",(Keyspending)));
                    Text_KeySpending.append(" €");
                    Text_Investing.setText(String.format("%.2f",(Investing)));
                    Text_Investing.append(" €");
                    Text_Savings.setText(String.format("%.2f",(Savings)));
                    Text_Savings.append(" €");
                    Person_Text_ContSavings.setText(String.format("%.2f",(Data[3])));
                    Person_Text_ContSavings.append(" €");

                    ///
                    Person_Text_KeySpending.setText(String.format("%.2f",(PradinesPajamos * 0.5)));
                    Person_Text_KeySpending.append(" €");
                    Person_Text_Investing.setText(String.format("%.2f",(PradinesPajamos * 0.3)));
                    Person_Text_Investing.append(" €");
                    Person_Text_Savings.setText(String.format("%.2f",(PradinesPajamos * 0.2)));
                    Person_Text_Savings.append(" €");
                    if (Keyspending <= Math.round(PradinesPajamos*0.5))
                    {
                        Text_KeySpending.setBackgroundColor(getColor(R.color.SavingsGreen));
                    }
                    else {
                        Text_KeySpending.setBackgroundColor(getColor(R.color.SavingsRed));
                        Random r = new Random();
                        int patarimas = r.nextInt(5);
                        Text_Patarimas.setText(Patarimai.get(patarimas));

                    }
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



                    Text_KeySpending.setText(String.format("%.2f",(Keyspending)));
                    Text_KeySpending.append(" €");
                    Text_Investing.setText(String.format("%.2f",(Investing)));
                    Text_Investing.append(" €");
                    Text_Savings.setText(String.format("%.2f",(Savings)));
                    Text_Savings.append(" €");
                    Person_Text_ContSavings.setText(String.format("%.2f",(Data[4])));
                    Person_Text_ContSavings.append(" €");

                    ///
                    Person_Text_KeySpending.setText(String.format("%.2f",(PradinesPajamos * 0.5)));
                    Person_Text_KeySpending.append(" €");
                    Person_Text_Investing.setText(String.format("%.2f",(PradinesPajamos * 0.3)));
                    Person_Text_Investing.append(" €");
                    Person_Text_Savings.setText(String.format("%.2f",(PradinesPajamos * 0.2)));
                    Person_Text_Savings.append(" €");
                    if (Keyspending <= Math.round(PradinesPajamos*0.5))
                    {
                        Text_KeySpending.setBackgroundColor(getColor(R.color.SavingsGreen));
                    }
                    else {
                        Text_KeySpending.setBackgroundColor(getColor(R.color.SavingsRed));
                        Random r = new Random();
                        int patarimas = r.nextInt(5);
                        Text_Patarimas.setText(Patarimai.get(patarimas));

                    }
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



                    Text_KeySpending.setText(String.format("%.2f",(Keyspending)));
                    Text_KeySpending.append(" €");
                    Text_Investing.setText(String.format("%.2f",(Investing)));
                    Text_Investing.append(" €");
                    Text_Savings.setText(String.format("%.2f",(Savings)));
                    Text_Savings.append(" €");
                    Person_Text_ContSavings.setText(String.format("%.2f",(Data[5])));
                    Person_Text_ContSavings.append(" €");

                    ///
                    Person_Text_KeySpending.setText(String.format("%.2f",(PradinesPajamos * 0.5)));
                    Person_Text_KeySpending.append(" €");
                    Person_Text_Investing.setText(String.format("%.2f",(PradinesPajamos * 0.3)));
                    Person_Text_Investing.append(" €");
                    Person_Text_Savings.setText(String.format("%.2f",(PradinesPajamos * 0.2)));
                    Person_Text_Savings.append(" €");
                    if (Keyspending <= Math.round(PradinesPajamos*0.5))
                    {
                        Text_KeySpending.setBackgroundColor(getColor(R.color.SavingsGreen));
                    }
                    else {
                        Text_KeySpending.setBackgroundColor(getColor(R.color.SavingsRed));
                        Random r = new Random();
                        int patarimas = r.nextInt(5);
                        Text_Patarimas.setText(Patarimai.get(patarimas));

                    }
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



                    Text_KeySpending.setText(String.format("%.2f",(Keyspending)));
                    Text_KeySpending.append(" €");
                    Text_Investing.setText(String.format("%.2f",(Investing)));
                    Text_Investing.append(" €");
                    Text_Savings.setText(String.format("%.2f",(Savings)));
                    Text_Savings.append(" €");
                    Person_Text_ContSavings.setText(String.format("%.2f",(Data[6])));
                    Person_Text_ContSavings.append(" €");
                    ///
                    Person_Text_KeySpending.setText(String.format("%.2f",(PradinesPajamos * 0.5)));
                    Person_Text_KeySpending.append(" €");
                    Person_Text_Investing.setText(String.format("%.2f",(PradinesPajamos * 0.3)));
                    Person_Text_Investing.append(" €");
                    Person_Text_Savings.setText(String.format("%.2f",(PradinesPajamos * 0.2)));
                    Person_Text_Savings.append(" €");
                    if (Keyspending <= Math.round(PradinesPajamos*0.5))
                    {
                        Text_KeySpending.setBackgroundColor(getColor(R.color.SavingsGreen));
                    }
                    else {
                        Text_KeySpending.setBackgroundColor(getColor(R.color.SavingsRed));
                        Random r = new Random();
                        int patarimas = r.nextInt(5);
                        Text_Patarimas.setText(Patarimai.get(patarimas));

                    }
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



                    Text_KeySpending.setText(String.format("%.2f",(Keyspending)));
                    Text_KeySpending.append(" €");
                    Text_Investing.setText(String.format("%.2f",(Investing)));
                    Text_Investing.append(" €");
                    Text_Savings.setText(String.format("%.2f",(Savings)));
                    Text_Savings.append(" €");
                    Person_Text_ContSavings.setText(String.format("%.2f",(Data[7])));
                    Person_Text_ContSavings.append(" €");

                    ///
                    Person_Text_KeySpending.setText(String.format("%.2f",(PradinesPajamos * 0.5)));
                    Person_Text_KeySpending.append(" €");
                    Person_Text_Investing.setText(String.format("%.2f",(PradinesPajamos * 0.3)));
                    Person_Text_Investing.append(" €");
                    Person_Text_Savings.setText(String.format("%.2f",(PradinesPajamos * 0.2)));
                    Person_Text_Savings.append(" €");
                    if (Keyspending <= Math.round(PradinesPajamos*0.5))
                    {
                        Text_KeySpending.setBackgroundColor(getColor(R.color.SavingsGreen));
                    }
                    else {
                        Text_KeySpending.setBackgroundColor(getColor(R.color.SavingsRed));
                        Random r = new Random();
                        int patarimas = r.nextInt(5);
                        Text_Patarimas.setText(Patarimai.get(patarimas));

                    }
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



                    Text_KeySpending.setText(String.format("%.2f",(Keyspending)));
                    Text_KeySpending.append(" €");
                    Text_Investing.setText(String.format("%.2f",(Investing)));
                    Text_Investing.append(" €");
                    Text_Savings.setText(String.format("%.2f",(Savings)));
                    Text_Savings.append(" €");
                    Person_Text_ContSavings.setText(String.format("%.2f",(Math.round(Data[8]))));
                    Person_Text_ContSavings.append(" €");

                    ///
                    Person_Text_KeySpending.setText(String.format("%.2f",(PradinesPajamos * 0.5)));
                    Person_Text_KeySpending.append(" €");
                    Person_Text_Investing.setText(String.format("%.2f",(PradinesPajamos * 0.3)));
                    Person_Text_Investing.append(" €");
                    Person_Text_Savings.setText(String.format("%.2f",(PradinesPajamos * 0.2)));
                    Person_Text_Savings.append(" €");
                    if (Keyspending <= Math.round(PradinesPajamos*0.5))
                    {
                        Text_KeySpending.setBackgroundColor(getColor(R.color.SavingsGreen));
                    }
                    else {
                        Text_KeySpending.setBackgroundColor(getColor(R.color.SavingsRed));
                        Random r = new Random();
                        int patarimas = r.nextInt(5);
                        Text_Patarimas.setText(Patarimai.get(patarimas));

                    }
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

                    Text_KeySpending.setText(String.format("%.2f",(Keyspending)));
                    Text_KeySpending.append(" €");
                    Text_Investing.setText(String.format("%.2f",(Investing)));
                    Text_Investing.append(" €");
                    Text_Savings.setText(String.format("%.2f",Savings));
                    Text_Savings.append(" €");
                    Person_Text_ContSavings.setText(String.format("%.2f",(Data[9])));
                    Person_Text_ContSavings.append(" €");

                    ///
                    Person_Text_KeySpending.setText(String.format("%.2f",(PradinesPajamos * 0.5)));
                    Person_Text_KeySpending.append(" €");
                    Person_Text_Investing.setText(String.format("%.2f",(PradinesPajamos * 0.3)));
                    Person_Text_Investing.append(" €");
                    Person_Text_Savings.setText(String.format("%.2f",(PradinesPajamos * 0.2)));
                    Person_Text_Savings.append(" €");
                    if (Keyspending <= Math.round(PradinesPajamos*0.5))
                    {
                        Text_KeySpending.setBackgroundColor(getColor(R.color.SavingsGreen));
                    }
                    else {
                        Text_KeySpending.setBackgroundColor(getColor(R.color.SavingsRed));
                        Random r = new Random();
                        int patarimas = r.nextInt(5);
                        Text_Patarimas.setText(Patarimai.get(patarimas));

                    }
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



                    Text_KeySpending.setText(String.format("%.2f",(Keyspending)));
                    Text_KeySpending.append(" €");
                    Text_Investing.setText(String.format("%.2f",(Investing)));
                    Text_Investing.append(" €");
                    Text_Savings.setText(String.format("%.2f",(Savings)));
                    Text_Savings.append(" €");
                    Person_Text_ContSavings.setText(String.format("%.2f",(Data[10])));
                    Person_Text_ContSavings.append(" €");

                    ///
                    Person_Text_KeySpending.setText(String.format("%.2f",(PradinesPajamos * 0.5)));
                    Person_Text_KeySpending.append(" €");
                    Person_Text_Investing.setText(String.format("%.2f",(PradinesPajamos * 0.3)));
                    Person_Text_Investing.append(" €");
                    Person_Text_Savings.setText(String.format("%.2f",(PradinesPajamos * 0.2)));
                    Person_Text_Savings.append(" €");
                    if (Keyspending <= Math.round(PradinesPajamos*0.5))
                    {
                        Text_KeySpending.setBackgroundColor(getColor(R.color.SavingsGreen));
                    }
                    else {
                        Text_KeySpending.setBackgroundColor(getColor(R.color.SavingsRed));
                        Random r = new Random();
                        int patarimas = r.nextInt(5);
                        Text_Patarimas.setText(Patarimai.get(patarimas));

                    }
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



                    Text_KeySpending.setText(String.format("%.2f",(Keyspending)));
                    Text_KeySpending.append(" €");
                    Text_Investing.setText(String.format("%.2f",(Investing)));
                    Text_Investing.append(" €");
                    Text_Savings.setText(String.format("%.2f",(Savings)));
                    Text_Savings.append(" €");
                    Person_Text_ContSavings.setText(String.format("%.2f",(Data[11])));
                    Person_Text_ContSavings.append(" €");

                    ///
                    Person_Text_KeySpending.setText(String.format("%.2f",(PradinesPajamos * 0.5)));
                    Person_Text_KeySpending.append(" €");
                    Person_Text_Investing.setText(String.format("%.2f",(PradinesPajamos * 0.3)));
                    Person_Text_Investing.append(" €");
                    Person_Text_Savings.setText(String.format("%.2f",(PradinesPajamos * 0.2)));
                    Person_Text_Savings.append(" €");
                    if (Keyspending <= Math.round(PradinesPajamos*0.5))
                    {
                        Text_KeySpending.setBackgroundColor(getColor(R.color.SavingsGreen));
                    }
                    else {
                        Text_KeySpending.setBackgroundColor(getColor(R.color.SavingsRed));
                        Random r = new Random();
                        int patarimas = r.nextInt(5);
                        Text_Patarimas.setText(Patarimai.get(patarimas));

                    }
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

    public double[] GetSavings(File PaimtasFailas) {
        String Textedit = "";
        FileReader fr = null;
        double[] op = new double[12];
        try {
            fr = new FileReader(PaimtasFailas);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(fr);
        try {
            while ((Textedit = br.readLine()) != null) {
                String[] Lines = Textedit.split(";");
                for (int i = 0; i < Lines.length; i++) {
                    String[] parts = Lines[i].split(" ");
                    double Name = (Double.parseDouble(parts[0]));
                    op[i] = Name;
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return op;
    }

    public double[] GenerateSavingsoftheMounth()
    {
        double[] generateddata = new double[12];
        double SUM=0;
        String filename1 = "InitialIncome.txt";
        String filepath = "MyfileDirectory";
        String [] Mounths = {"JanuaryData.txt","FeabuaryData.txt","MarchData.txt","AprilData.txt","MayData.txt",
                "JuneData.txt","JulyData.txt","AugustData.txt","SeptemberData.txt","OctoberData.txt","NovemberData.txt","DecemberData.txt"};
        File PirmoKartoData = new File(getExternalFilesDir(filepath), filename1);
        double PradinesPajamos = GetIncomeData(PirmoKartoData);
        for (int i=0; i<11; i++) {
            String filename = Mounths[i];
            SUM = GenerateASUM(filename, filepath, PradinesPajamos);
            generateddata[i] = SUM;
        }

        return generateddata;
    }
    public  double GenerateASUM(String filename, String filepath, double PradinesPajamos)
    {
        double SUM = 0;
        File myExternalFile = new File(getExternalFilesDir(filepath),filename);
        ArrayList<MountData> SavingsL;
        SavingsL = GetMounthData(myExternalFile);
        double Savings = GetSUMofMounthByIndex(SavingsL,0,3);
        double Keyspending = GetSUMofMounthByIndex(SavingsL,3,7);
        double Investing = GetSUMofMounthByIndex(SavingsL,7,11);
        SUM = (PradinesPajamos*0.5 - Keyspending)+(PradinesPajamos*0.3 - Investing)+(PradinesPajamos*0.2 - Savings);
        return SUM;
    }
    public void RewriteData (double[] data,File Paimtasfailas)
    {
        FileOutputStream fos = null;
        try{
            String text1 =data[0]+";";
            String text2 =data[1]+";";
            String text3 =data[2]+";";

            //////
            String text4=data[3]+";";
            String text5=data[4]+";";
            String text6=data[5]+";";
            String text7=data[6]+";";

            ////
            String text8 =data[7]+";";
            String text9 =data[8]+";";
            String text10=data[9]+";";;
            String text11=data[10]+";";
            String text12=data[11]+";";

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
            Writer.write(text11);

            Writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    public void BackTOMAIN()
    {
        Intent first = new Intent(this,MainActivity.class);
        startActivity(first);
    }

}