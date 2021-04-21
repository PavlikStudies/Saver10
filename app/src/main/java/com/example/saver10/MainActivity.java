package com.example.saver10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.ListMenuItemView;
import androidx.core.app.AppLaunchChecker;

import android.app.Activity;
import android.app.LauncherActivity;
import android.content.ClipData;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.example.saver10.libs.Users;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.PrimitiveIterator;

public class MainActivity extends AppCompatActivity {
    //  static TinyDB DuomenuSaugojimas;
     ArrayList <MenesioData> naujas = new ArrayList<MenesioData>();
     double pinigeliai;
  static Users Vartotojas = new Users("Marius",2.0,2.0,2.0,2.0,
          new ArrayList<MenesioData>());

        RelativeLayout relativeLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //        DuomenuSaugojimas.putListObject("Menesiai",naujas);
        //        DuomenuSaugojimas = new TinyDB(getApplicationContext());
        naujas.add(new MenesioData());
        setContentView(R.layout.activity_main);
        relativeLayout = findViewById(R.id.relativeLayout);
        relativeLayout.setBackgroundColor(Color.LTGRAY);
        Vartotojas.SetDataMonths(naujas);
        setContentView(R.layout.activity_main);
        TextView ivedimo_confirm = (TextView) findViewById(R.id.duomenu_ivedimas);
        TextView keespending = (TextView) findViewById(R.id.KeeSpending);
        TextView investing = (TextView) findViewById(R.id.Investing);
        TextView Savings = (TextView) findViewById(R.id.Savingai);
        TextView LavishSpendings = (TextView) findViewById(R.id.Lavish);
        Button tekstoPakeitejas = findViewById(R.id.Text_Changer_Button);
        Button imenesius = findViewById(R.id.button_menesiai);

        PirmoKartoTIkrinimas PirmasKartas = new PirmoKartoTIkrinimas();
       if (!PirmasKartas.getBooleanPreferenceValue(getApplicationContext(),"9"))
        {
            onStart();
            {
                FirstTImeactivity();
                PirmasKartas.setBooleanPreferenceValue(getApplicationContext(),"9", true);
            }
        }

       pinigeliai = PirmoKartoActivity.alga;
       Vartotojas.SetInvesting(pinigeliai);

        tekstoPakeitejas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//             ArrayList<Object> lala =  DuomenuSaugojimas.getListObject("Menesiai",new MenesioData().getClass());
//             investing.setText(((MenesioData) lala.get(0)).scripts[1]);
                keespending.setText(String.valueOf(Vartotojas.GetKeyExpenses()));
                investing.setText(String.valueOf(Vartotojas.GetInvesting()));

                ivedimo_confirm.setText("Data entered succsesfully!");

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

}