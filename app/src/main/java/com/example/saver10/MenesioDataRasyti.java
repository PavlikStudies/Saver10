package com.example.saver10;

public class MenesioDataRasyti {
    Investavimas InvestavimoData = new Investavimas();
    String Menesis;
    double Pinigeliai;
    int Skaitiklis;

    public MenesioDataRasyti(String menesis, double pinigeliai, int skaitiklis
                             ) {
        Menesis = menesis;
        Pinigeliai = pinigeliai;
        Skaitiklis = skaitiklis;
       // InvestavimoData = investavimoData;

    }

    public void setMenesis(String value) {
        Menesis = value;
    }

    public void setPinigeliai(double value) {
    Pinigeliai = value;
    }

    public void setSkaitiklis(int value)
    {
        Skaitiklis = value;
    }
    public String getMenesis()
    {
        return Menesis;
    }
    public  double getPinigeliai()
    {
        return  Pinigeliai;
    }
    public  int getSkaitiklis()
    {
        return  Skaitiklis;
    }




}
