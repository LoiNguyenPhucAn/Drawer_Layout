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

import com.example.animal.databinding.ActivityMainBinding;
import com.example.animal.databinding.DrawerBinding;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawer;

    DrawerBinding drawerBinding;
    ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showFrg(new FrgMH001());

    }

    public void showFrg (Fragment frg){
        getSupportFragmentManager().beginTransaction().replace(R.id.ln_main,frg,null).commit();
    }

}