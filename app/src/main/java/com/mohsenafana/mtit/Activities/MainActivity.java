package com.mohsenafana.mtit.Activities;

import android.content.Intent;
import android.os.PersistableBundle;

import android.view.Gravity;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ToolbarWidgetWrapper;
import androidx.cardview.widget.CardView;
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
import com.google.android.material.snackbar.Snackbar;
import com.mohsenafana.mtit.EmployeeServicesActivity;
import com.mohsenafana.mtit.Fingerprint.FingerprintActivity;
import com.mohsenafana.mtit.R;

import ps.gov.mtit.ssologin.SSOHelper;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String CLIENT_ID = "MAKTABI_MTIT";
    private static final String CLIENT_SECRET = "_7183453c90a726a27f4823956054e566c554e03a45";
    NavController navController;
    DrawerLayout drawer;
    NavigationView navigationView;

    AppBarConfiguration appBarConfiguration;

    BottomNavigationView bottomNavigationView;
    private View parent_view;

    Toolbar toolbar;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
        findViewById(R.id.menu).setOnClickListener(view -> drawer.openDrawer(Gravity.START));
        findViewById(R.id.title_toolbar).setVisibility(View.GONE);
        SSOHelper.doLogin(this, CLIENT_ID, CLIENT_SECRET);
    }


    private void make_toast() {
        View layout = getLayoutInflater().inflate(R.layout.toast_custom, (ViewGroup) findViewById(R.id.custom_toast_layout_id));
        TextView text = (TextView) layout.findViewById(R.id.text);
        text.setTextColor(Color.WHITE);
        text.setText("Success!");
        CardView lyt_card = layout.findViewById(R.id.lyt_card);
        lyt_card.setCardBackgroundColor(getResources().getColor(R.color.green_500));

        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SSOHelper.SSO_LOGIN) {
            if (resultCode == RESULT_OK) {
                if (data != null && data.getExtras() != null) {
                    String token =
                            data.getStringExtra("SSOTOKEN");
                    String refreshToken =
                            data.getStringExtra("SSOREFRESHTOKEN");
                    make_toast();

                }
            }
        }
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
        Log.d("mohsen", "onNavigationItemSelected");
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

  /*  public void setFragment(Fragment f) {
        getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, f).addToBackStack("").commit();
    }*/
}
