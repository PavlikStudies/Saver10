package com.example.saver10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.ListMenuItemView;

import android.app.LauncherActivity;
import android.content.ClipData;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
   // TinyDB DuomenuSaugojimas = new TinyDB(MenesiuActivity);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView keespending = (TextView) findViewById(R.id.KeeSpending);
        TextView investing = (TextView) findViewById(R.id.Investing);
        TextView Savings = (TextView) findViewById(R.id.Savingai);
        TextView LavishSpendings = (TextView) findViewById(R.id.Lavish);
        Button tekstoPakeitejas = findViewById(R.id.Text_Changer_Button);
        tekstoPakeitejas.setOnClickListener(new View.OnClickListener() {
            Baisic_Calculations DUOMENYS;
            @Override
            public void onClick(View v) {
                keespending.setText(String.valueOf(DUOMENYS.getKeyExpenses()));
                investing.setText(String.valueOf(DUOMENYS.getInvesting()));
                Savings.setText(String.valueOf(DUOMENYS.getMinSavings()));
                LavishSpendings.setText(String.valueOf(DUOMENYS.getLavishSpendings()));
            }
        });


    }

    public double GetIncome()
    {
        TextView Income = (TextView) findViewById(R.id.Income_Number);
        /*Double salary = Double.parseDouble(Income.toString());*/
        Double salary = 100.0;
        return  salary;
    }


}