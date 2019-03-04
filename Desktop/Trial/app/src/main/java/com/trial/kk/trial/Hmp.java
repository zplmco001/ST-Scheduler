package com.trial.kk.trial;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;
import java.util.List;

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
    private TextView textView;


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

        textView = (TextView) findViewById(R.id.anasayfapostit);


        Log.e("",String.valueOf(Calendar.MONDAY));
        Log.e("",""+Calendar.TUESDAY);
        Log.e("",""+Calendar.WEDNESDAY);
        Log.e("",""+Calendar.THURSDAY);
        Log.e("",""+Calendar.FRIDAY);
        Log.e("",""+Calendar.SATURDAY);
        Log.e("",""+Calendar.SUNDAY);

        DatabaseConnection db = new DatabaseConnection(getBaseContext());
        db.open();
        List<NewPostit> list = db.hedefAl();
        db.close();

        int sure=0, soru=0;

        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);

        for (int i=0;i<list.size();i++){
            if ((day-2)%7==list.get(i).gun){
                sure += list.get(i).sure;
                soru += list.get(i).soru;
            }
        }

        String daytext="";

        switch (day) {
            case Calendar.SUNDAY:
                daytext = "Pazar";
                break;
            case Calendar.MONDAY:
                daytext = "Pazartesi";
                break;
            case Calendar.TUESDAY:
                daytext = "Salı";
                break;
            case Calendar.WEDNESDAY:
                daytext = "Çarşamba";
                break;
            case Calendar.THURSDAY:
                daytext = "Perşembe";
                break;
            case Calendar.FRIDAY:
                daytext = "Cuma";
                break;
            case Calendar.SATURDAY:
                daytext = "Cumartesi";
                break;

        }
        textView.setText(daytext+"\n"+soru+" soru\n"+sure+" dk");
        textView.setTextSize(30);
        textView.setTextColor(Color.BLACK);
        textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        Typeface tp = Typeface.createFromAsset(getBaseContext().getAssets(), "Architext.ttf");
        textView.setTypeface(tp);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        TextView tv = (TextView) findViewById(R.id.name);

        /*SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String name = preferences.getString("stringValue",""+SettingsActivity.name+"");

        Log.e("name",name);*/

        //tv.setText(name);


        new Hedefler();

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new AnaSayfa()).commit();

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

