package com.example.homework_6;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;


import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import androidx.appcompat.widget.Toolbar;


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
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}