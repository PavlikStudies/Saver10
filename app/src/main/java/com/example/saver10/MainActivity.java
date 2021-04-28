package com.example.saver10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.graphics.Color;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //  static TinyDB DuomenuSaugojimas;
   //  ArrayList <MenesioData> naujas = new ArrayList<MenesioData>();
    // TinyDB DuomenuSaugojimas;
     double pinigeliai;
  //static Users Vartotojas = new Users("Marius",2.0,2.0,2.0,2.0,
          //new ArrayList<MenesioData>());

        RelativeLayout relativeLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      TinyDB  DuomenuSaugojimas = new TinyDB(this.getApplicationContext());
        ArrayList<MenesioDataRasyti> TestData = new ArrayList<MenesioDataRasyti>();
        MenesioDataRasyti Shpempelis  = new MenesioDataRasyti("January",1000,1);
        TestData.add(Shpempelis);
        DuomenuSaugojimas.putListObject("PirmasMen",TestData);
      String labas;
      labas = DuomenuSaugojimas.getObject("PirmasMen",MenesioDataRasyti.class).getMenesis();

        setContentView(R.layout.activity_main);
        relativeLayout = findViewById(R.id.relativeLayout);
        relativeLayout.setBackgroundColor(Color.LTGRAY);

        setContentView(R.layout.activity_main);
        TextView ivedimo_confirm = (TextView) findViewById(R.id.duomenu_ivedimas);
        TextView keespending = (TextView) findViewById(R.id.KeeSpending);
        TextView investing = (TextView) findViewById(R.id.Investing);
        TextView Savings = (TextView) findViewById(R.id.Savingai);
        TextView LavishSpendings = (TextView) findViewById(R.id.Lavish);
        Button tekstoPakeitejas = findViewById(R.id.Text_Changer_Button);
        Button imenesius = findViewById(R.id.button_menesiai);
       keespending.setText(labas);


        PirmoKartoTIkrinimas PirmasKartas = new PirmoKartoTIkrinimas();
       if (!PirmasKartas.getBooleanPreferenceValue(getApplicationContext(),"13"))
        {
            onStart();
            {
                FirstTImeactivity();
                PirmasKartas.setBooleanPreferenceValue(getApplicationContext(),"13", true);
            }
        }
       pinigeliai = PirmoKartoActivity.alga;


        tekstoPakeitejas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//             ArrayList<Object> lala =  DuomenuSaugojimas.getListObject("Menesiai",new MenesioData().getClass());
//             investing.setText(((MenesioData) lala.get(0)).scripts[1]);

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