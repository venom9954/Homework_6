package com.example.homework_6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;


import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar;


import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drower_activity_main);

        if (savedInstanceState == null) {
            NamesFragment namesFragment = NamesFragment.newInstance();
            getSupportFragmentManager().beginTransaction().replace(R.id.names, namesFragment).commit();
            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                Notes defaultNotes = new Notes("Пустая заметка", "Введите описание заметки", "nn.nn.nnnn");
                TextFragment textFragment = TextFragment.newInstance(defaultNotes);
                getSupportFragmentManager().beginTransaction().replace(R.id.text_fragment,textFragment).commit();
            }
        }
        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        DrawerLayout drawerLayout = findViewById(R.id.drawerLayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, myToolbar, R.string.burger_open, R.string.burger_close );
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case (R.id.action_about):{
                        getSupportFragmentManager().beginTransaction().replace(R.id.names, new AboutFragment()).addToBackStack("").commit();
                        return true;
                    }
                    case (R.id.action_close):{
                        finish();
                        return true;
                    }
                }
                return false;
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}