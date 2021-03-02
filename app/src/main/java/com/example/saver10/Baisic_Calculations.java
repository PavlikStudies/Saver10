package com.example.saver10;

import com.example.saver10.MainActivity;

public class Baisic_Calculations {
    MainActivity getter = new MainActivity();
    double income = getter.GetIncome();
    public  double getMinSavings()  {  return income*0.2;    }
    public double getInvesting ()

    {
        return  income*0.3;
    }
    public double getLavishSpendings (){    return  income *0.2;    }
    public double getKeyExpenses ()
    {
        return  income *0.3;
    }

}
