package com.trial.kk.trial;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by mehmetcanolgun on 16.01.2019.
 */

public class Konular extends Fragment {

    private BottomNavigationView bottomNav;
    private TytFragment tytFragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.konular_layout, container, false);


        bottomNav = view.findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        //bottomNav.setSelectedItemId(R.id.tyt);

        //tytFragment = new TytFragment();

        getChildFragmentManager().beginTransaction().replace(R.id.cs,new KonularHmFragment()).commit();


        return view;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            switch (item.getItemId()){
                case R.id.tyt:
                    selectedFragment = Hmp.tytfr;
                    break;
                case R.id.ayt:
                    selectedFragment = new AytFragment();
                    break;
                case R.id.nav:
                    selectedFragment = new KonularHmFragment();
                    break;
            }
            getChildFragmentManager().beginTransaction().replace(R.id.cs,selectedFragment).commit();
            return true;
        }
    };
}
