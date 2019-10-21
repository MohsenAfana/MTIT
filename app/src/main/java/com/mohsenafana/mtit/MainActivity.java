package com.mohsenafana.mtit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.mohsenafana.mtit.Fragments.EmployeeServicesFragment;
import com.mohsenafana.mtit.Fragments.MessagesFragment;
import com.mohsenafana.mtit.Fragments.PersonnelFragment;
import com.mohsenafana.mtit.Fragments.SigninFragment;
import com.mohsenafana.mtit.Fragments.StoreFragment;
import com.mohsenafana.mtit.Fragments.TrainingFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    NavController navController;
    DrawerLayout drawer;
    NavigationView navigationView;
    AppBarConfiguration appBarConfiguration;
    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }

    private void initView() {
        drawer = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigationView);
        navigationView.setItemTextColor(ColorStateList.valueOf(Color.WHITE));
        bottomNavigationView = findViewById(R.id.bottomNavigation);
        navController = Navigation.findNavController(this, R.id.main_fragment);
        appBarConfiguration = new AppBarConfiguration.Builder(R.id.home, R.id.profile, R.id.LoginId,
                R.id.fingerprint, R.id.PersonnelId, R.id.LogoutId,
                R.id.EmployeeServicesId, R.id.StoreId, R.id.messagesId, R.id.TrainingId)
                .setDrawerLayout(drawer)
                .build();
        navigationView.setNavigationItemSelectedListener(this);

    }


    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, appBarConfiguration);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Log.d("ttt", "onNavigationItemSelected");
        switch (menuItem.getItemId()) {
            case R.id.PersonnelId:
                getSupportFragmentManager().beginTransaction().
                        replace(R.id.main_fragment, new PersonnelFragment()).commit();
                Toast.makeText(MainActivity.this, "PersonnelId", Toast.LENGTH_SHORT).show();

                break;
            case R.id.EmployeeServicesId:
                getSupportFragmentManager().beginTransaction().
                        replace(R.id.main_fragment, new EmployeeServicesFragment()).commit();
                Toast.makeText(MainActivity.this, "EmployeeServicesId", Toast.LENGTH_SHORT).show();

                break;
            case R.id.LoginId:
                getSupportFragmentManager().beginTransaction().
                        replace(R.id.main_fragment, new SigninFragment()).commit();
                Toast.makeText(MainActivity.this, "LoginId", Toast.LENGTH_SHORT).show();

                break;
            case R.id.messagesId:
                getSupportFragmentManager().beginTransaction().
                        replace(R.id.main_fragment, new MessagesFragment()).commit();
                Toast.makeText(MainActivity.this, "messagesId", Toast.LENGTH_SHORT).show();

                break;
            case R.id.StoreId:
                getSupportFragmentManager().beginTransaction().
                        replace(R.id.main_fragment, new StoreFragment()).commit();
                Toast.makeText(MainActivity.this, "Store", Toast.LENGTH_SHORT).show();


                break;
            case R.id.TrainingId:
                getSupportFragmentManager().beginTransaction().
                        replace(R.id.main_fragment, new TrainingFragment()).commit();
                Toast.makeText(MainActivity.this, "Training", Toast.LENGTH_SHORT).show();

                break;
            case R.id.LogoutId:
                Toast.makeText(MainActivity.this, "Logout", Toast.LENGTH_SHORT).show();
                break;
        }
        closeDrawer();
        return true;


    }

    public void closeDrawer() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
    }
}
