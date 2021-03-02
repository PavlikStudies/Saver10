package com.example.saver10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MenesiuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menesiu);
        Spinner MySpinner = (Spinner) findViewById(R.id.Pasirinkimai_Spinners);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(MenesiuActivity.this,
                android.R.layout.simple_expandable_list_item_1, getResources().getStringArray(R.array.options));
        myAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        MySpinner.setAdapter(myAdapter);
        TextView naujas = (TextView) findViewById(R.id.Tekstas_Koks_Menuo);

        Button buttonofpasirinkimai = findViewById(R.id.Button_Pasirinkti);
       buttonofpasirinkimai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if( MySpinner.getSelectedItem().toString().equals("January"))
                {
                    naujas.setText("January");

                }
            }
        });
    }
}