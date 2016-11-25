package com.supriyalahade.session8asign2;

import android.content.SharedPreferences;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

    boolean check;
    String password;

    SharedPreferences sp;
    SharedPreferences.Editor mEditor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction().replace(android.R.id.content, new MyPreferenceFragment()).commit();

        sp = PreferenceManager.getDefaultSharedPreferences(this);

        check = sp.getBoolean("CHECKBOX",false);
        password = sp.getString("Password","No Password");

        mEditor = sp.edit();

    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sp, String key) {

        Log.i("Key",key);

        if(key.equals("CHECKBOX")){

            check = sp.getBoolean("CHECKBOX",false);

            if(Boolean.toString(check).equals(true)){


                password = sp.getString("Password","No Password");


            }

            if(Boolean.toString(check).equals(false)){

                password = sp.getString("Password","No Password");

            }

        }

        if(key.equals("Password")){

            password = sp.getString("PHONE_NO","No Number");
            Toast.makeText(MainActivity.this, password+" Saved", Toast.LENGTH_SHORT).show();


        }

    }


    public static class MyPreferenceFragment extends PreferenceFragment{
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preferences);
        }
    }
}
