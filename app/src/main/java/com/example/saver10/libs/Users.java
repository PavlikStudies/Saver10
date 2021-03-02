package com.example.saver10.libs;

import com.example.saver10.MenesioData;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Users {

    static String name ;
    static double Investing;
    static double Savings ;
    static double MinSavings;
    static double KeyExpenses ;
    static ArrayList<MenesioData> Mounths;
    public Users() {
       name = "";
       Investing = 0;
       Savings = 0;
       MinSavings = 0;
       KeyExpenses = 0;
       Mounths = new ArrayList<MenesioData>();
    }
    public  Users (String Name, double investing, double savings, double minSavings, double keyExpenses, ArrayList<MenesioData> mounths)
    {
        name = Name;
        Investing = investing *0.3;
        Savings = savings;
        MinSavings = minSavings;
        KeyExpenses = keyExpenses;
        Mounths = mounths;
    }

    public String GetName() { return name; }
    public double GetInvesting() { return Investing; }
    public double GetSavings() { return Savings; }
    public double GetMinSavings() { return MinSavings; }
    public double GetKeyExpenses() {return KeyExpenses;}
    public ArrayList<MenesioData> GetMounts() {return Mounths;}

    public String SetName(String newName) {return name = newName;}
    public double SetInvesting(double newInvesting) {return Investing = newInvesting;}
    public double SetSavings(double newSavings) {return Savings = newSavings;}
    public double SetMinSavings(double newMinSavings) {return MinSavings =  newMinSavings;}
    public double SetKeyExpenses(double newKeyExpenses) {return KeyExpenses =  newKeyExpenses;}
    public ArrayList<MenesioData> SetDataMonths(ArrayList<MenesioData> newMonths) {return Mounths = newMonths;}

}
