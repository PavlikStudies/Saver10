package com.example.saver10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.ListMenuItemView;

import android.app.LauncherActivity;
import android.content.ClipData;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
   // TinyDB DuomenuSaugojimas = new TinyDB(MenesiuActivity);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public double GetIncome()
    {
        TextView Income = (TextView) findViewById(R.id.Income_Number);
        Double salary = Double.parseDouble(Income.toString());
        return  salary;
    }


}