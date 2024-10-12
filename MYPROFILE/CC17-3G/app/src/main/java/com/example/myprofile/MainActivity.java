package com.example.myprofile;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    BiographyFragment biographyFragment = new BiographyFragment();
    DefinitionFragment definitionFragment = new DefinitionFragment();
    InterestFragment interestFragment = new InterestFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Set default fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.container, biographyFragment).commit();

        // Handle BottomNavigationView item selection
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                if (item.getItemId() == R.id.nav_biography) {
                    selectedFragment = biographyFragment;
                } else if (item.getItemId() == R.id.nav_interests) {
                    selectedFragment = interestFragment;
                } else if (item.getItemId() == R.id.nav_definition) {
                    selectedFragment = definitionFragment;
                }

                if (selectedFragment != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, selectedFragment).commit();
                    return true;
                }
                return false;
            }
        });
    }
}
