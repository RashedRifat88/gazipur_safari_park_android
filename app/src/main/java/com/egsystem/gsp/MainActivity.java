package com.egsystem.gsp;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.widget.RelativeLayout;

import com.egsystem.gsp.ui.animal.AnimalActivity;
import com.egsystem.gsp.ui.enclosure.EnclosureActivity;
import com.egsystem.gsp.ui.food.FoodActivity;
import com.egsystem.gsp.ui.medication.MedicationActivity;
import com.egsystem.gsp.ui.observation.ObservationActivity;
import com.egsystem.gsp.ui.park_section.ParkSectionActivity;
import com.egsystem.gsp.ui.reports.ReportsActivity;
import com.egsystem.gsp.ui.vaccination.VaccinActivity;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.egsystem.gsp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    RelativeLayout rl1, rl2, rl3, rl4, rl5, rl6, rl7, rl8, rl9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        setSupportActionBar(binding.appBarMain.toolbar);
//        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//        DrawerLayout drawer = binding.drawerLayout;
//        NavigationView navigationView = binding.navView;
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
//        mAppBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
//                .setOpenableLayout(drawer)
//                .build();
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
//        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
//        NavigationUI.setupWithNavController(navigationView, navController);


        initStatusBar();
        initComponents();


    }


    private void initComponents() {


        rl1 = findViewById(R.id.rl1);
        rl2 = findViewById(R.id.rl2);
        rl3 = findViewById(R.id.rl3);
        rl4 = findViewById(R.id.rl4);
        rl5 = findViewById(R.id.rl5);
        rl6 = findViewById(R.id.rl6);
        rl7 = findViewById(R.id.rl7);
        rl8 = findViewById(R.id.rl8);
//        rl9 = findViewById(R.id.rl9);

        rl1.setOnClickListener(view -> {
            Log.d("tag_main", "card1 is clicked");
            Intent intent = new Intent(MainActivity.this, FoodActivity.class);
            startActivity(intent);
        });


        rl2.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ObservationActivity.class);
            startActivity(intent);
        });

        rl3.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, AnimalActivity.class);
            startActivity(intent);
        });

        rl4.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, VaccinActivity.class);
            startActivity(intent);
        });

        rl5.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, MedicationActivity.class);
            startActivity(intent);
        });

        rl6.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ParkSectionActivity.class);
            startActivity(intent);
        });

        rl7.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, EnclosureActivity.class);
            startActivity(intent);
        });

        rl8.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ReportsActivity.class);
            startActivity(intent);
        });




    }


    private void initStatusBar() {
        View decor = getWindow().getDecorView();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.background, this.getTheme()));
            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.background));
            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}