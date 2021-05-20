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
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
     double pinigeliai;
     String channel_ID = "0";
        RelativeLayout relativeLayout;
        String lapatai="";


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
        calendar.set(Calendar.HOUR_OF_DAY, 21);
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
            String filename1="Savings.txt";
            File AntroKartoData = new File(getExternalFilesDir(filepath), filename1);
            double[] ex = GenerateSavingsoftheMounth();
            RewriteData(ex,AntroKartoData);
            double[] Data = GetSavings(AntroKartoData);
            double SUMFINAL = 0;
            SUMFINAL=AllSum(Data,PradinesPajamos);
            if(SUMFINAL>0)
            {ivedimo_confirm.setText("You saved: "+String.format("%.2f",(SUMFINAL)));
            ivedimo_confirm.setBackgroundColor(getColor(R.color.SavingsGreen));
            }
            else
            {ivedimo_confirm.setText("You lost: "+String.format("%.2f",(SUMFINAL)));
            ivedimo_confirm.setBackgroundColor(getColor(R.color.SavingsRed));
            }

<<<<<<< HEAD

=======
<<<<<<< HEAD
=======

>>>>>>> c0a77eb0e85da7e31e757b9173e272b8505a43a9
            if (!PirmasKartas.getBooleanPreferenceValue(getApplicationContext(),"39"))


            if (!PirmasKartas.getBooleanPreferenceValue(getApplicationContext(),"38"))
>>>>>>> 28d0491652758a7748932ca2582674d8c8d57687

        } catch (Exception e) {
            PirmoKartoTIkrinimas PirmasKartas = new PirmoKartoTIkrinimas();

<<<<<<< HEAD
            if (!PirmasKartas.getBooleanPreferenceValue(getApplicationContext(),"39"))
=======

>>>>>>> 28d0491652758a7748932ca2582674d8c8d57687

            {
                onStart();
                {
                    FirstTImeactivity();

                    PirmasKartas.setBooleanPreferenceValue(getApplicationContext(),"39", true);

<<<<<<< HEAD
=======
<<<<<<< HEAD




=======
>>>>>>> c0a77eb0e85da7e31e757b9173e272b8505a43a9
>>>>>>> 28d0491652758a7748932ca2582674d8c8d57687
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
    public double[] GetSavings(File PaimtasFailas) {
        String Textedit = "";
        FileReader fr = null;
        double[] op = new double[12];
        try {
            fr = new FileReader(PaimtasFailas);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(fr);
        try {
            while ((Textedit = br.readLine()) != null) {
                String[] Lines = Textedit.split(";");
                for (int i = 0; i < Lines.length; i++) {
                    String[] parts = Lines[i].split(" ");
                    double Name = (Double.parseDouble(parts[0]));
                    op[i] = Name;
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return op;
    }
    public double[] GenerateSavingsoftheMounth()
    {
        double[] generateddata = new double[12];
        double SUM=0;
        String filename1 = "InitialIncome.txt";
        String filepath = "MyfileDirectory";
        String [] Mounths = {"JanuaryData.txt","FeabuaryData.txt","MarchData.txt","AprilData.txt","MayData.txt",
                "JuneData.txt","JulyData.txt","AugustData.txt","SeptemberData.txt","OctoberData.txt","NovemberData.txt","DecemberData.txt"};
        File PirmoKartoData = new File(getExternalFilesDir(filepath), filename1);
        double PradinesPajamos = GetIncomeData(PirmoKartoData);
        for (int i=0; i<11; i++) {
            String filename = Mounths[i];
            SUM = GenerateASUM(filename, filepath, PradinesPajamos);
            generateddata[i] = SUM;
        }

        return generateddata;
    }

    public double AllSum(double[] data,double pradinesincome)
    {
        double sum = 0;
        for (int i=0 ; i<11; i++)
        {
            if(pradinesincome != data[i])
            sum = sum + data[i];
        }
        return sum;
    }

    public  double GenerateASUM(String filename, String filepath, double PradinesPajamos)
    {
        double SUM = 0;
        File myExternalFile = new File(getExternalFilesDir(filepath),filename);
        ArrayList<MountData> SavingsL;
        SavingsL = GetMounthData(myExternalFile);
        double Savings = GetSUMofMounthByIndex(SavingsL,0,3);
        double Keyspending = GetSUMofMounthByIndex(SavingsL,3,7);
        double Investing = GetSUMofMounthByIndex(SavingsL,7,11);
        SUM = (PradinesPajamos*0.5 - Keyspending)+(PradinesPajamos*0.3 - Investing)+(PradinesPajamos*0.2 - Savings);
        return SUM;
    }
    public void RewriteData (double[] data,File Paimtasfailas)
    {
        FileOutputStream fos = null;
        try{
            String text1 =data[0]+";";
            String text2 =data[1]+";";
            String text3 =data[2]+";";

            //////
            String text4=data[3]+";";
            String text5=data[4]+";";
            String text6=data[5]+";";
            String text7=data[6]+";";

            ////
            String text8 =data[7]+";";
            String text9 =data[8]+";";
            String text10=data[9]+";";;
            String text11=data[10]+";";
            String text12=data[11]+";";

            FileWriter Writer = new FileWriter(Paimtasfailas);
            Writer.write(text1);
            Writer.write(text2);
            Writer.write(text3);
            Writer.write(text4);
            Writer.write(text5);
            Writer.write(text6);
            Writer.write(text7);
            Writer.write(text8);
            Writer.write(text9);
            Writer.write(text10);
            Writer.write(text11);
            Writer.write(text11);

            Writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<MountData> GetMounthData(File PaimtasFailas)
    {
        FileReader fr =null;
        try {
            fr = new FileReader(PaimtasFailas);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(fr);
        ArrayList<MountData> data = new ArrayList<MountData>();
        try {
            while ((lapatai = br.readLine()) != null)
            {
                String[] Lines = lapatai.split(";");
                for (int i = 0; i < Lines.length; i++)
                {
                    String[] parts = Lines[i].split(",");
                    String Name = (parts[0]);
                    double NumberOfMarks = Double.parseDouble(parts[1]);
                    MountData S = new MountData(Name,NumberOfMarks);
                    data.add(S);
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public  double GetSUMofMounthByIndex(ArrayList<MountData> Data, int i,int p)
    {
        double sum = 0;
        int k=0;
        for (k=i;i<p; i++)
        {
            sum = sum + Data.get(i).Value;
        }
        return sum;
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