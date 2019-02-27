package com.trial.kk.trial;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class Hmp extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //kbf onlayn

    static int kontrol=0;
    private static AlertDialog.Builder builder;
    private Hmp hmp = this;
    Fragment currentFragment;
    Fragment kronometre;
    Konular konular;
    static TytFragment tytfr;
    //static AytFragment aytfr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hmp);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        kronometre = new Kronometre();

        konular = new Konular();

        tytfr = new TytFragment();

        //aytfr = new AytFragment();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        new Hedefler();

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.hmp, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent i = new Intent(this,SettingsActivity.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        String tag = "initial";

        if (id == R.id.nav_countdown) {

            tag = "countdown";

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new GeriSayim(),tag).commit();

        } else if (id == R.id.nav_konular) {

            tag = "konular";
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,konular,tag).commit();

        } else if (id == R.id.nav_kronometre) {

            tag = "sayac";

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,kronometre).commit();




        } else if (id == R.id.nav_hedefler) {

            currentFragment = new Hedefler();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,currentFragment).commit();

        } else if (id == R.id.nav_sonuclar) {

            tag = "sonuclar";
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Sonuclar(),tag).commit();

        } else if (id == R.id.nav_sorular) {

            tag = "sorular";
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Sorular(),tag).commit();

        } else if (id == R.id.homepage){

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new AnaSayfa()).commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

