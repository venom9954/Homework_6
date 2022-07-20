package com.example.homework_6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            NamesFragment namesFragment = new NamesFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.names, namesFragment).commit();
            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                TextFragment textFragment = new TextFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.text_fragment,textFragment).commit();
            }
        }
    }
}