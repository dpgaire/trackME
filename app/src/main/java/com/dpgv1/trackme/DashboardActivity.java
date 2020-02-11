package com.dpgv1.trackme;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.dpgv1.trackme.adapter.AddFriendAdapter;
import com.dpgv1.trackme.url.RunActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class DashboardActivity extends AppCompatActivity {
    BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dashboard);
        setUpNavigation();
    }

    private void setUpNavigation() {
        navigationView = findViewById(R.id.nav_view1);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.navigation_notifications1:
                        Intent intent = new Intent(DashboardActivity.this, RunActivity.class);
                        startActivity(intent);
                        finish();
                        break;

                    case R.id.navigation_dashboard1:
                        Intent intent1 = new Intent(DashboardActivity.this, FriendActivity.class);
                        startActivity(intent1);
                        finish();
                        break;

                    case R.id.navigation_home1:
                        Intent intent2 = new Intent(DashboardActivity.this,RegisterActivity.class);
                        startActivity(intent2);
                        finish();
                        break;
                }return true;
            }
        });

    }


}
