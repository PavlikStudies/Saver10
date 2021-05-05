package com.example.saver10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MenesiuActivity extends AppCompatActivity {
        ArrayList<MountData> data = new ArrayList<MountData>();
        String lapatai="";
    String filenameofredingfile = "Modification.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menesiu);
        Button IvedimasDuomenu = (Button) findViewById(R.id.button);
        Spinner MySpinner = (Spinner) findViewById(R.id.Pasirinkimai_Spinners);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(MenesiuActivity.this,
                android.R.layout.simple_expandable_list_item_1, getResources().getStringArray(R.array.options));
        myAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        MySpinner.setAdapter(myAdapter);
        Button buttonofpasirinkimai = findViewById(R.id.Button_Pasirinkti);
        PieChart Savings_Chart = findViewById(R.id.piechart);
        ArrayList<PieEntry> Savings = new ArrayList<>();
        PieChart KeySpending_Chart = findViewById(R.id.KeySpending_Chart);
        ArrayList<PieEntry> Keyspending = new ArrayList<>();
        PieChart Investing_Chart = findViewById(R.id.Investing_Chart);
        ArrayList<PieEntry> Investing = new ArrayList<>();
            ////
        String filepath = "MyfileDirectory";
        File myExternalFile = new File(getExternalFilesDir(filepath), filenameofredingfile);
        String namas = GetTextFileNameToRead(myExternalFile);
        File datafile = new File(getExternalFilesDir(filepath),namas);
        data = GetMounthData(datafile);
            ///
        /*Pradiniai duomenys ar rodo*/
        for (int i=0; i<2;i++)
        {Savings.add(new PieEntry
                (Integer.parseInt(String.valueOf(Math.round(data.get(i).Value))),data.get(i).Label));}
        for (int i=2 ;i<6; i++)
        {
            Keyspending.add(new PieEntry
                    (Integer.parseInt(String.valueOf(Math.round(data.get(i).Value))),data.get(i).Label));
        }
        for (int i=6 ;i<8; i++)
        {
            Investing.add(new PieEntry
                    (Integer.parseInt(String.valueOf(Math.round(data.get(i).Value))),data.get(i).Label));
        }


        /*Pirma diagrama*/
        PieDataSet pieDataSet = new PieDataSet(Savings, "");
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieDataSet.setValueTextColor(Color.BLACK);
        pieDataSet.setValueTextSize(8f);
        PieData pieData = new PieData(pieDataSet);
        Savings_Chart.setData(pieData);
        Savings_Chart.getDescription().setEnabled(false);
        Savings_Chart.setCenterText("Savings");

        /*AntraDiangrama*/
        PieDataSet pieDataSet1 = new PieDataSet(Keyspending, "");
        pieDataSet1.setColors(ColorTemplate.COLORFUL_COLORS);
        pieDataSet1.setValueTextColor(Color.BLACK);
        pieDataSet1.setValueTextSize(8f);
        PieData pieData1 = new PieData(pieDataSet1);
        KeySpending_Chart.setData(pieData1);
        KeySpending_Chart.getDescription().setEnabled(false);
        KeySpending_Chart.setCenterText("Keyspending");

        /*TreciaDiagrama*/
        PieDataSet pieDataSet2 = new PieDataSet(Investing, "");
        pieDataSet2.setColors(ColorTemplate.COLORFUL_COLORS);
        pieDataSet2.setValueTextColor(Color.BLACK);
        pieDataSet2.setValueTextSize(8f);
        PieData pieData2 = new PieData(pieDataSet2);
        Investing_Chart.setData(pieData2);
        Investing_Chart.getDescription().setEnabled(false);
        Investing_Chart.setCenterText("Investing");

        IvedimasDuomenu.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                NextActivity(v);

            }
        });


       buttonofpasirinkimai.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
               if(MySpinner.getSelectedItem().toString().equals("January"))
                {
                    Savings.clear();
                    Keyspending.clear();
                    Investing.clear();
                    ///

                    String filename = "JanuaryData.txt";
                    String filepath = "MyfileDirectory";
                    File PathFile = new File(getExternalFilesDir(filepath),filenameofredingfile);
                    Modification(PathFile,filename);

                    File myExternalFile = new File(getExternalFilesDir(filepath),filename);
                    ArrayList<MountData> SavingsL = new ArrayList<MountData>();
                    SavingsL = GetMounthData(myExternalFile);
                    for (int i=0 ;i<2; i++)
                    {
                        Savings.add(new PieEntry
                                (Integer.parseInt(String.valueOf(Math.round(SavingsL.get(i).Value))),SavingsL.get(i).Label));
                    }
                    PieDataSet pie = new PieDataSet(Savings,"");
                    pie.setColors(ColorTemplate.COLORFUL_COLORS);
                    pie.setValueTextColor(Color.BLACK);
                    pie.setValueTextSize(8f);
                    PieData data = new PieData(pie);
                    Savings_Chart.setData(data);
                    Savings_Chart.getDescription().setEnabled(false);
                    Savings_Chart.setCenterText("Savings");
                    Savings_Chart.animate();
                    Savings_Chart.invalidate();
                    ///
                    for (int i=2 ;i<6; i++)
                    {
                        Keyspending.add(new PieEntry
                                (Integer.parseInt(String.valueOf(Math.round(SavingsL.get(i).Value))),SavingsL.get(i).Label));
                    }
                    PieDataSet pie1 = new PieDataSet(Keyspending,"");
                    pie1.setColors(ColorTemplate.COLORFUL_COLORS);
                    pie1.setValueTextColor(Color.BLACK);
                    pie1.setValueTextSize(8f);
                    PieData data1 = new PieData(pie1);
                    KeySpending_Chart.setData(data1);
                    KeySpending_Chart.getDescription().setEnabled(false);
                    KeySpending_Chart.setCenterText("Keyspending");
                    KeySpending_Chart.animate();
                    KeySpending_Chart.invalidate();
                    ///
                    for (int i=6 ;i<8; i++)
                    {
                        Investing.add(new PieEntry
                                (Integer.parseInt(String.valueOf(Math.round(SavingsL.get(i).Value))),SavingsL.get(i).Label));
                    }
                    PieDataSet pie2 = new PieDataSet(Investing,"");
                    pie2.setColors(ColorTemplate.COLORFUL_COLORS);
                    pie2.setValueTextColor(Color.BLACK);
                    pie2.setValueTextSize(8f);
                    PieData data2 = new PieData(pie2);
                    Investing_Chart.setData(data2);
                    Investing_Chart.getDescription().setEnabled(false);
                    Investing_Chart.setCenterText("Investing");
                    Investing_Chart.animate();
                    Investing_Chart.invalidate();
                }
               if(MySpinner.getSelectedItem().toString().equals("February"))
               {
                   Savings.clear();
                   Keyspending.clear();
                   Investing.clear();
                   ///
                   String filename = "FeabuaryData.txt";
                   String filepath = "MyfileDirectory";
                   File PathFile = new File(getExternalFilesDir(filepath),filenameofredingfile);
                   Modification(PathFile,filename);

                   File myExternalFile = new File(getExternalFilesDir(filepath),filename);
                   ArrayList<MountData> Data = new ArrayList<MountData>();
                   Data = GetMounthData(myExternalFile);
                   for (int i=0; i<2;i++)
                   {Savings.add(new PieEntry
                           (Integer.parseInt(String.valueOf(Math.round(Data.get(i).Value))),Data.get(i).Label));}
                   PieDataSet pie = new PieDataSet(Savings,"");
                   pie.setColors(ColorTemplate.COLORFUL_COLORS);
                   pie.setValueTextColor(Color.BLACK);
                   pie.setValueTextSize(8f);
                   PieData data = new PieData(pie);
                   Savings_Chart.setData(data);
                   Savings_Chart.getDescription().setEnabled(false);
                   Savings_Chart.setCenterText("Savings");
                   Savings_Chart.animate();
                   Savings_Chart.invalidate();
                   ///
                   for (int i=2 ;i<6; i++)
                   {Keyspending.add(new PieEntry
                           (Integer.parseInt(String.valueOf(Math.round(Data.get(i).Value))),Data.get(i).Label));}
                   PieDataSet pie1 = new PieDataSet(Keyspending,"");
                   pie1.setColors(ColorTemplate.COLORFUL_COLORS);
                   pie1.setValueTextColor(Color.BLACK);
                   pie1.setValueTextSize(8f);
                   PieData data1 = new PieData(pie1);
                   KeySpending_Chart.setData(data1);
                   KeySpending_Chart.getDescription().setEnabled(false);
                   KeySpending_Chart.setCenterText("Keyspending");
                   KeySpending_Chart.animate();
                   KeySpending_Chart.invalidate();
                   ///
                   for (int i=6 ;i<8; i++)
                   {Investing.add(new PieEntry
                           (Integer.parseInt(String.valueOf(Math.round(Data.get(i).Value))),Data.get(i).Label));}
                   PieDataSet pie2 = new PieDataSet(Investing,"");
                   pie2.setColors(ColorTemplate.COLORFUL_COLORS);
                   pie2.setValueTextColor(Color.BLACK);
                   pie2.setValueTextSize(8f);
                   PieData data2 = new PieData(pie2);
                   Investing_Chart.setData(data2);
                   Investing_Chart.getDescription().setEnabled(false);
                   Investing_Chart.setCenterText("Investing");
                   Investing_Chart.animate();
                   Investing_Chart.invalidate();
               }
                if(MySpinner.getSelectedItem().toString().equals("March"))
                {
                    Savings.clear();
                    Keyspending.clear();
                    Investing.clear();
                    ///
                    Savings.add(new PieEntry (968,""));
                    Savings.add(new PieEntry(1589,""));;
                    PieDataSet pie = new PieDataSet(Savings,"");
                    pie.setColors(ColorTemplate.COLORFUL_COLORS);
                    pie.setValueTextColor(Color.BLACK);
                    pie.setValueTextSize(8f);
                    PieData data = new PieData(pie);
                    Savings_Chart.setData(data);
                    Savings_Chart.getDescription().setEnabled(false);
                    Savings_Chart.setCenterText("Savings");
                    Savings_Chart.animate();
                    Savings_Chart.invalidate();
                    ///
                    Keyspending.add(new PieEntry (459,""));
                    Keyspending.add(new PieEntry(783,""));
                    PieDataSet pie1 = new PieDataSet(Keyspending,"");
                    pie1.setColors(ColorTemplate.COLORFUL_COLORS);
                    pie1.setValueTextColor(Color.BLACK);
                    pie1.setValueTextSize(8f);
                    PieData data1 = new PieData(pie1);
                    KeySpending_Chart.setData(data1);
                    KeySpending_Chart.getDescription().setEnabled(false);
                    KeySpending_Chart.setCenterText("Keyspending");
                    KeySpending_Chart.animate();
                    KeySpending_Chart.invalidate();
                    ///
                    Investing.add(new PieEntry(1503,""));
                    Investing.add(new PieEntry(5820,""));
                    PieDataSet pie2 = new PieDataSet(Investing,"");
                    pie2.setColors(ColorTemplate.COLORFUL_COLORS);
                    pie2.setValueTextColor(Color.BLACK);
                    pie2.setValueTextSize(8f);
                    PieData data2 = new PieData(pie2);
                    Investing_Chart.setData(data2);
                    Investing_Chart.getDescription().setEnabled(false);
                    Investing_Chart.setCenterText("Investing");
                    Investing_Chart.animate();
                    Investing_Chart.invalidate();

                }
                if(MySpinner.getSelectedItem().toString().equals("April"))
                {
                    Savings.clear();
                    Keyspending.clear();
                    Investing.clear();
                    ///
                    Savings.add(new PieEntry (1245,""));
                    Savings.add(new PieEntry(2502,""));;
                    PieDataSet pie = new PieDataSet(Savings,"");
                    pie.setColors(ColorTemplate.COLORFUL_COLORS);
                    pie.setValueTextColor(Color.BLACK);
                    pie.setValueTextSize(8f);
                    PieData data = new PieData(pie);
                    Savings_Chart.setData(data);
                    Savings_Chart.getDescription().setEnabled(false);
                    Savings_Chart.setCenterText("Savings");
                    Savings_Chart.animate();
                    Savings_Chart.invalidate();
                    ///
                    Keyspending.add(new PieEntry (2646,""));
                    Keyspending.add(new PieEntry(548,""));
                    Keyspending.add(new PieEntry(1000,""));
                    PieDataSet pie1 = new PieDataSet(Keyspending,"");
                    pie1.setColors(ColorTemplate.COLORFUL_COLORS);
                    pie1.setValueTextColor(Color.BLACK);
                    pie1.setValueTextSize(8f);
                    PieData data1 = new PieData(pie1);
                    KeySpending_Chart.setData(data1);
                    KeySpending_Chart.getDescription().setEnabled(false);
                    KeySpending_Chart.setCenterText("Keyspending");
                    KeySpending_Chart.animate();
                    KeySpending_Chart.invalidate();
                    ///
                    Investing.add(new PieEntry(2154,""));
                    Investing.add(new PieEntry(478,""));
                    Investing.add(new PieEntry(589,""));
                    PieDataSet pie2 = new PieDataSet(Investing,"");
                    pie2.setColors(ColorTemplate.COLORFUL_COLORS);
                    pie2.setValueTextColor(Color.BLACK);
                    pie2.setValueTextSize(8f);
                    PieData data2 = new PieData(pie2);
                    Investing_Chart.setData(data2);
                    Investing_Chart.getDescription().setEnabled(false);
                    Investing_Chart.setCenterText("Investing");
                    Investing_Chart.animate();
                    Investing_Chart.invalidate();
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
                    String[] parts = Lines[i].split(" ");
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
        return  name;
    }
    public void NextActivity(View v)
    {
        Intent i = new Intent(this,DuomenuActivity.class);
        startActivity(i);
    }
    public void Modification (File Paimtasfailas, String nameoffile)
    {
        FileOutputStream fos = null;
        try{
            String text = nameoffile+";";

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