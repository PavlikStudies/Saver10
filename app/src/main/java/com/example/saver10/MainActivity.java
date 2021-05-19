package com.example.saver10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.graphics.Color;
import android.widget.RelativeLayout;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
     double pinigeliai;
     String channel_ID = "0";
        RelativeLayout relativeLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        relativeLayout = findViewById(R.id.relativeLayout);
        relativeLayout.setBackgroundColor(Color.LTGRAY);

        //NOTIFICATIONS//NOTIFICATIONS//NOTIFICATIONS//NOTIFICATIONS//NOTIFICATIONS//NOTIFICATIONS//NOTIFICATIONS

        createNotificationChannel();



        Intent intent = new Intent(MainActivity.this, ReminderReport.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, intent, 0);

        AlarmManager alarmManager =(AlarmManager)  getSystemService(ALARM_SERVICE);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, 8);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 1);

        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);




        //NOTIFICATIONS//NOTIFICATIONS//NOTIFICATIONS//NOTIFICATIONS//NOTIFICATIONS//NOTIFICATIONS//NOTIFICATIONS



        setContentView(R.layout.activity_main);
        TextView ivedimo_confirm = (TextView) findViewById(R.id.duomenu_ivedimas);
        TextView keespending = (TextView) findViewById(R.id.KeeSpending_First_Screen);
        TextView investing = (TextView) findViewById(R.id.Investin_Screen_First);
        TextView LavishSpendings = (TextView) findViewById(R.id.Lavish_First_Screen);
        Button tekstoPakeitejas = findViewById(R.id.Text_Changer_Button);
        Button ataskaitos_button = findViewById(R.id.ataskaita_button);
        Button imenesius = findViewById(R.id.button_menesiai);
        try {
            String filename = "InitialIncome.txt";
            String filepath = "MyfileDirectory";
            File PirmoKartoData = new File(getExternalFilesDir(filepath), filename);
            double PradinesPajamos = GetIncomeData(PirmoKartoData);
            keespending.setText(String.format("%.2f",(PradinesPajamos * 0.5)));
            keespending.append(" €");
            investing.setText(String.format("%.2f",(PradinesPajamos * 0.3)));
            investing.append(" €");
            LavishSpendings.setText(String.format("%.2f",(PradinesPajamos * 0.2)));
            LavishSpendings.append(" €");
        } catch (Exception e) {
            PirmoKartoTIkrinimas PirmasKartas = new PirmoKartoTIkrinimas();


            if (!PirmasKartas.getBooleanPreferenceValue(getApplicationContext(),"39"))

            {
                onStart();
                {
                    FirstTImeactivity();

                    PirmasKartas.setBooleanPreferenceValue(getApplicationContext(),"39", true);


                }
            }
        }





ataskaitos_button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        AtaskaitaActivity();
    }
});
        tekstoPakeitejas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              FirstTImeactivity();

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
    public  void AtaskaitaActivity()
    {
        Intent atask = new Intent(this,ReportActivity.class);
        startActivity(atask);
    }
    public double GetIncomeData(File PaimtasFailas)
    {
        String Textedit = "";
        double Pajamos = 0;
        FileReader fr =null;
        try {
            fr = new FileReader(PaimtasFailas);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(fr);
        try {
            while ((Textedit = br.readLine()) != null)
            {
                String[] Lines = Textedit.split(";");
                for (int i = 0; i < Lines.length; i++)
                {
                    String[] parts = Lines[i].split(" ");
                    String Name = (parts[0]);
                    Pajamos = Double.parseDouble(parts[1]);

                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Pajamos;
    }




    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            CharSequence name = "Notif";
            String description = "Month Report notification";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(channel_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }







}