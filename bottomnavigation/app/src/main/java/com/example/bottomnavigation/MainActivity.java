package com.example.bottomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Switch;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().replace(R.id.framlayout,new Home()).commit();
        view=findViewById(R.id.bottomnavi);
        view.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                Fragment fragment=null;
                switch (item.getItemId())
                {
                    case R.id.home_id:
                        fragment=new Home();
                        break;
                    case R.id.search_id:
                        fragment=new Search();
                        break;
                    case R.id.setting_id:
                        fragment=new Settings();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.framlayout,fragment).commit();
            }
        });

    }
}