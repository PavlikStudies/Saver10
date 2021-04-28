package com.example.saver10;

public class Investavimas {
    double Taupomoji_saskaita;
    double Investavimo_saskaita;
    double Nenumatytu_atveju;
    double PencijuFondas;
    double JuodosDienos;
    public  Investavimas()
    {
        Taupomoji_saskaita =0;
        Investavimo_saskaita = 0;
        Nenumatytu_atveju = 0;
        PencijuFondas = 0;
        JuodosDienos = 0;

    }
    public  Investavimas(double taupomoji, double investavimo, double nenumatytu,
                         double penciju, double juodos)
    {
        Taupomoji_saskaita = taupomoji;
        Investavimo_saskaita = investavimo;
        Nenumatytu_atveju = nenumatytu;
        PencijuFondas = penciju;
        JuodosDienos = juodos;
    }

}
