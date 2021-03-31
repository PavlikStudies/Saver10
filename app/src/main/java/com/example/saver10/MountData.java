package com.example.saver10;

public class MountData {
    public String Label ;
    public int Value;
    public String GetDataName() { return Label;}
    public double GetValue() {return Value;}

    public MountData(String Name,int number)
    {
        Label =Name;
        Value = number;
    }
}
