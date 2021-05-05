package com.example.saver10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.graphics.Color;
import android.widget.RelativeLayout;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
     double pinigeliai;
        RelativeLayout relativeLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        relativeLayout = findViewById(R.id.relativeLayout);
        relativeLayout.setBackgroundColor(Color.LTGRAY);

        setContentView(R.layout.activity_main);
        TextView ivedimo_confirm = (TextView) findViewById(R.id.duomenu_ivedimas);
        TextView keespending = (TextView) findViewById(R.id.KeeSpending);
        TextView investing = (TextView) findViewById(R.id.Investing);
        TextView Savings = (TextView) findViewById(R.id.Savings);
        TextView LavishSpendings = (TextView) findViewById(R.id.Lavish);
        Button tekstoPakeitejas = findViewById(R.id.Text_Changer_Button);
        Button imenesius = findViewById(R.id.button_menesiai);
        try {
            String filename = "InitialIncome.txt";
            String filepath = "MyfileDirectory";
            File PirmoKartoData = new File(getExternalFilesDir(filepath), filename);
            double PradinesPajamos = GetIncomeData(PirmoKartoData);
            keespending.setText(String.valueOf(PradinesPajamos * 0.3));
            keespending.append(" €");
            investing.setText(String.valueOf(PradinesPajamos * 0.3));
            investing.append(" €");
            Savings.setText(String.valueOf(PradinesPajamos * 0.2));
            Savings.append(" €");
            LavishSpendings.setText(String.valueOf(PradinesPajamos * 0.2));
            LavishSpendings.append(" €");
        } catch (Exception e) {
            PirmoKartoTIkrinimas PirmasKartas = new PirmoKartoTIkrinimas();
            if (!PirmasKartas.getBooleanPreferenceValue(getApplicationContext(),"33"))
            {
                onStart();
                {
                    FirstTImeactivity();
                    PirmasKartas.setBooleanPreferenceValue(getApplicationContext(),"33", true);

                }
            }
        }






        tekstoPakeitejas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              FirstTImeactivity();

            }
        });
        imenesius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NextActivity(v);
            }
        });
    }

    public void NextActivity(View v)
    {
        Intent i = new Intent(this,MenesiuActivity.class);
        startActivity(i);
    }
    public void FirstTImeactivity()
    {
        Intent first = new Intent(this,PirmoKartoActivity.class);
        startActivity(first);
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