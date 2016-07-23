package com.sdsu.cs646.lakshmi.myfirstfragmenttrial;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Communicator

{
    String selectedValue = "";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void respond(String valueToPass)
    {
        selectedValue = valueToPass;
        if (valueToPass.equals(getResources().getString(R.string.country_india)) ||
                valueToPass.equals(getResources().getString(R.string.country_usa)) ||
                valueToPass.equals(getResources().getString(R.string.country_mexico)))
        {

            FragmentManager fragments = getFragmentManager();
            SportsFragment resultFragment =(SportsFragment)fragments.findFragmentById(R.id.fragment2);

            resultFragment.changeSports(valueToPass);
        }
    }
}
