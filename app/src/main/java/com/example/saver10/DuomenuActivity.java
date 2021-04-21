package com.example.saver10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Path;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;
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
        TextView labas2 = (TextView) findViewById(R.id.first_Atribute2);
        try {
            is = getApplicationContext().getAssets().open("bla.txt");
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(),"Problems: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
        menesio = GetMounthData(br);
        labas.setText(menesio.get(0).Label);
        menesio.get(0).SetValue(2);
        RewriteData(menesio,is);
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

    public void RewriteData (ArrayList<MountData> data, InputStream la)
    {
        /*FileOutputStream outputStream = new FileOutputStream(getApplicationContext().getFileStreamPath("ba.txt"));*/
            File file = new File(DuomenuActivity.this.getFilesDir(), "text");
            if (!file.exists()) {
                file.mkdir();
            }
            try {
                File gpxfile = new File(file, "sample");
                FileWriter writer = new FileWriter(gpxfile);
                writer.append("Labas");
                writer.flush();
                writer.close();
                Toast.makeText(DuomenuActivity.this, "Saved your text", Toast.LENGTH_LONG).show();
            } catch (Exception e) { }

 /*       String path = "lalaa";
        Log.i("lala",path);
        File myDir = new File("labas.txt");
        try {
            myDir.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            Log.i("lala","Nepaejo");
        }
*/
        /*BufferedWriter bw = new BufferedWriter();
        for(int i=0; i<data.size(); i++) {
            try {
                bw.write(data.get(i).Label + " " + data.get(i).Value + ";");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
    }
}