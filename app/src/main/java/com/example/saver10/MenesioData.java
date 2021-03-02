package com.example.saver10;

import java.io.Serializable;
import java.util.ArrayList;

public class MenesioData {

    String[] scripts = new String [] {"Pencija","Islaidos","Menkniekiai"};
    int [] skaičiukai = new int[3];

   public String GetDataName(int Number) { return scripts[Number];}
   public int GetDataNumber(int Number) {return skaičiukai[Number];}
   public int ReaplaceData(int Where, int Value) {return  skaičiukai[Where] = Value;}
}
