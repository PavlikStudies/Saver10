package com.example.saver10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.ListMenuItemView;

import android.app.LauncherActivity;
import android.content.ClipData;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int x = 1;
        Spinner MySpinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_expandable_list_item_1, getResources().getStringArray(R.array.options));
        myAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        MySpinner.setAdapter(myAdapter);
        onOptionsItemSelected(MySpinner);

    }
    public boolean onOptionsItemSelected (Spinner spinner)
    {
        String selected = spinner.getSelectedItem().toString();
        if (selected.equals("Senas"))
        {
                setContentView(R.layout.activity_menesiu);
        }

        return true;
    }
}