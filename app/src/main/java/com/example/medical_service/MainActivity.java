package com.example.medical_service;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        navigation bar start

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(this,drawer,toolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toogle);
        toogle.syncState();


    //added fragment for initial condition when no fragment is selected
        if (savedInstanceState ==null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new MedecineFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_medecine);
            }
        }
        //added fragment
    @Override
    public boolean onNavigationItemSelected(@NonNull  MenuItem item) {
        switch (item.getItemId()){

            case R.id.nav_medecine:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new MedecineFragment()).commit();
                break;
            case R.id.nav_appointment:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                       new AppointmentFragment()).commit();
                break;
            case R.id.nav_doctor:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new DoctorFragment()).commit();
                break;
            case R.id.nav_emergency:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new EmergencyFragment()).commit();
                break;
            case R.id.nav_login:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new LoginFragment()).commit();
                break;
            case R.id.nav_about:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new AboutFragment()).commit();
                break;

        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    //end fragment




    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    //navigation bar end
}