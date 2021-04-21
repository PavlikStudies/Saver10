package com.example.saver10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.jar.Attributes;

public class DuomenuActivity extends AppCompatActivity {

    InputStream is;
    String lapatai="tuscia";
    ArrayList<MountData> menesio = new ArrayList<MountData>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duomenu);
        TextView labas = (TextView) findViewById(R.id.First_Atribute);
        try {
            is = getApplicationContext().getAssets().open("bla.txt");
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(),"Problems: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
        menesio = GetMounthData(br);
        labas.setText(menesio.get(0).Label);
    }
    public ArrayList<MountData> GetMounthData(BufferedReader br)
    {
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
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}