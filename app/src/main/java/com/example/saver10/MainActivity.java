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
import android.content.Context;

import com.example.saver10.libs.Users;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //  static TinyDB DuomenuSaugojimas;
     ArrayList <MenesioData> naujas = new ArrayList<MenesioData>();
  static Users Vartotojas = new Users("Marius",2.0,2.0,2.0,2.0,
          new ArrayList<MenesioData>());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //        DuomenuSaugojimas.putListObject("Menesiai",naujas);
        //        DuomenuSaugojimas = new TinyDB(getApplicationContext());
        naujas.add(new MenesioData());
        Vartotojas.SetDataMonths(naujas);
        setContentView(R.layout.activity_main);
        TextView keespending = (TextView) findViewById(R.id.KeeSpending);
        TextView investing = (TextView) findViewById(R.id.Investing);
        TextView Savings = (TextView) findViewById(R.id.Savingai);
        TextView LavishSpendings = (TextView) findViewById(R.id.Lavish);
        Button tekstoPakeitejas = findViewById(R.id.Text_Changer_Button);
        tekstoPakeitejas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//             ArrayList<Object> lala =  DuomenuSaugojimas.getListObject("Menesiai",new MenesioData().getClass());
//             investing.setText(((MenesioData) lala.get(0)).scripts[1]);
                keespending.setText(String.valueOf(Vartotojas.GetKeyExpenses()));
                investing.setText(String.valueOf(Vartotojas.GetInvesting()));
            }
        });
    }
}