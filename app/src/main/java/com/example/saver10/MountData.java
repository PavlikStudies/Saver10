package com.example.saver10;

public class MountData {
    public String Label ;
    public double Value;


    public MountData(String Name,double number)
    {
        Label =Name;
        Value = number;
    }

    public String GetDataName() { return Label;}
    public double GetValue() {return Value;}

    public void SetValue(double k) {
       Value = Value + k;
       }
       public void MinusValue(double k){Value = Value-k;}
}
