package com.example.saver10;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

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
        Button buttonofpasirinkimai = findViewById(R.id.Button_Pasirinkti);
        TextView menesis_kuris = findViewById(R.id.Labas);
        PieChart pieChart = findViewById(R.id.piechart);
        ArrayList<PieEntry> visitors = new ArrayList<>();
        visitors.add(new PieEntry(508,2067));
        visitors.add(new PieEntry(600,2017));
        PieDataSet pieDataSet = new PieDataSet(visitors, "Pencija");
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieDataSet.setValueTextColor(Color.BLACK);
        pieDataSet.setValueTextSize(8f);
        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.getDescription().setEnabled(false);
        pieChart.setCenterText("Visitors");

       buttonofpasirinkimai.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
               if(MySpinner.getSelectedItem().toString().equals("January"))
                {
                    visitors.clear();
                    menesis_kuris.setText("Atejau"+visitors.size());
                    visitors.add(new PieEntry(508,2067));
                    visitors.add(new PieEntry(600,2017));
                    PieDataSet nx = new PieDataSet(visitors,"Lalaa");
                    nx.setColors(ColorTemplate.COLORFUL_COLORS);
                    nx.setValueTextColor(Color.BLACK);
                    nx.setValueTextSize(8f);
                    PieData koks = new PieData(nx);
                    pieChart.setData(koks);
                    pieChart.getDescription().setEnabled(false);
                    pieChart.setCenterText("Visitors");
                    pieChart.animate();
                    pieChart.getDisplay();

                }
               if(MySpinner.getSelectedItem().toString().equals("February"))
               {
                   visitors.clear();
                   menesis_kuris.setText("Atejau"+visitors.size());
                   visitors.add(new PieEntry(200,2034));
                   visitors.add(new PieEntry(300,2040));
                   PieDataSet nx = new PieDataSet(visitors,"Lalaa");
                   nx.setColors(ColorTemplate.COLORFUL_COLORS);
                   nx.setValueTextColor(Color.BLACK);
                   nx.setValueTextSize(8f);
                   PieData koks = new PieData(nx);
                   pieChart.setData(koks);
                   pieChart.getDescription().setEnabled(false);
                   pieChart.setCenterText("Visitors");
                   pieChart.animate();
                   pieChart.getDisplay();
               }
            }
        });
    }
}