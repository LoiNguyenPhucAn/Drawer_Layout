package com.example.animal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.animal.databinding.DrawerBinding;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawer;

    DrawerBinding drawerBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buildActionAppBar();

    }

    public void buildActionAppBar() {

        drawerBinding = DrawerBinding.inflate(getLayoutInflater());


        drawer = drawerBinding.drawer;
        toolbar = drawerBinding.hostContentWithAppbar.toolBar;
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        toggle = new ActionBarDrawerToggle(this,drawer,R.string.open,R.string.close );

        // set color for drawer indicator
        // https://stackoverflow.com/a/32518329
        // https://stackoverflow.com/a/59071537
        toggle.getDrawerArrowDrawable().setColor(ContextCompat.getColor(this,R.color.white));
        toggle.syncState();
        drawer.addDrawerListener(toggle);

        setContentView(drawerBinding.getRoot());
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (toggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}