package com.mohsenafana.mtit.Activities;

import android.content.Intent;
import android.os.PersistableBundle;

import android.view.Gravity;
import android.view.View.OnClickListener;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.mohsenafana.mtit.EmployeeServicesActivity;
import com.mohsenafana.mtit.Fingerprint.FingerprintActivity;
import com.mohsenafana.mtit.R;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    NavController navController;

    DrawerLayout drawer;

    NavigationView navigationView;

    AppBarConfiguration appBarConfiguration;

    BottomNavigationView bottomNavigationView;
    Toolbar toolbar;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
        LayoutInflater inflator = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflator.inflate(R.layout.custom_imageview, null);

        findViewById(R.id.menu).setOnClickListener(view -> drawer.openDrawer(Gravity.START));
        findViewById(R.id.title_toolbar).setVisibility(View.GONE);
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
        return NavigationUI.navigateUp(navController, drawer);
    }


    @Override
    public void onPostCreate(@Nullable final Bundle savedInstanceState,
                             @Nullable final PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        getActionBar().setHomeButtonEnabled(true);
        getActionBar().setDisplayHomeAsUpEnabled(true);
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
                Intent PersonnelActivity = new Intent(this, PersonnelActivity.class);
                startActivity(PersonnelActivity);
                break;
            case R.id.EmployeeServicesId:
                Intent EmployeeServicesId = new Intent(this, EmployeeServicesActivity.class);
                startActivity(EmployeeServicesId);
                break;
            case R.id.LoginId:
                Intent Fingerprint = new Intent(this, FingerprintActivity.class);
                startActivity(Fingerprint);

                break;
            case R.id.messagesId:
                Intent messagesId = new Intent(this, MessagesActivity.class);
                startActivity(messagesId);
                break;
            case R.id.StoreId:
                Toast.makeText(MainActivity.this, "Store", Toast.LENGTH_SHORT).show();

                break;
            case R.id.TrainingId:
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

    public void setFragment(Fragment f) {
        getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, f).addToBackStack("").commit();
    }
}
