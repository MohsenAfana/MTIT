package com.mohsenafana.mtit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.annotation.SuppressLint;
import android.os.Bundle;
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
        NavigationUI.setupWithNavController(navigationView, navController);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);

        getSupportFragmentManager().beginTransaction().
                replace(R.id.main_fragment, new TrainingFragment()).commit();
        navigationView.setCheckedItem(R.id.messagesId);
    }

    private void initView() {
        drawer = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigationView);
        bottomNavigationView = findViewById(R.id.bottomNavigation);
        getSupportFragmentManager().beginTransaction().
                replace(R.id.main_fragment, new TrainingFragment()).commit();
        navigationView.setCheckedItem(R.id.messagesId);
        navController = Navigation.findNavController(this, R.id.main_fragment);
        appBarConfiguration = new AppBarConfiguration.Builder(R.id.home, R.id.profile,R.id.LoginId, R.id.fingerprint,R.id.PersonnelId,R.id.LogoutId,
                R.id.EmployeeServicesId,R.id.StoreId,R.id.messagesId,R.id.TrainingId)
                .setDrawerLayout(drawer)
                .build();


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
    public boolean onNavigationItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.PersonnelId:
                getSupportFragmentManager().beginTransaction().
                        replace(R.id.main_fragment, new PersonnelFragment()).commit();
                break;
            case R.id.EmployeeServicesId:
                getSupportFragmentManager().beginTransaction().
                        replace(R.id.main_fragment, new EmployeeServicesFragment()).commit();
                break;
            case R.id.LoginId:
                getSupportFragmentManager().beginTransaction().
                        replace(R.id.main_fragment, new SigninFragment()).commit();
                break;
            case R.id.messagesId:
                getSupportFragmentManager().beginTransaction().
                        replace(R.id.main_fragment, new MessagesFragment()).commit();
                break;
            case R.id.StoreId:
                getSupportFragmentManager().beginTransaction().
                        replace(R.id.main_fragment, new StoreFragment()).commit();
                break;
            case R.id.TrainingId:
                getSupportFragmentManager().beginTransaction().
                        replace(R.id.main_fragment, new TrainingFragment()).commit();
                break;
            case R.id.LogoutId:
                Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
