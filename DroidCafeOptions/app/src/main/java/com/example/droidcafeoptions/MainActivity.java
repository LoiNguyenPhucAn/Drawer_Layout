package com.example.droidcafeoptions;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.droidcafeoptions.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // set content view = layout activity_main.xml
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View layoutMain = activityMainBinding.getRoot();
        setContentView(layoutMain);

        // gán thuộc tích ActionBar cho thành phần toolbar trong layout appbar_content_main.xml
        setSupportActionBar(activityMainBinding.contentMainLayout.toolbarActionbar);

        // Enable Burger button trên ActionBar
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Tạo mới thành phần toggle trên ActionBar để ghi nhận trạng thái open/close Navigation
        drawer = activityMainBinding.drawerLayout;
        toggle = new ActionBarDrawerToggle(this,drawer,R.string.navigation_drawer_open,R.string.navigation_drawer_close);

        // Lắng nghe sự kiện trên toggle và đồng bộ trạng thái
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        // Lắng nghe và xử lý sự kiện click on item của Navigation
        NavigationView navigationView = activityMainBinding.NavLeftSlideMenu;
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.itemMenu_Map:

                        Toast.makeText(getApplicationContext(), "Item Map clicked", Toast.LENGTH_SHORT).show();

                        // hiển thị Fragment MapInMenuFrg
                        MapInMenuFrg mapFrg = new MapInMenuFrg();
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.host_fragment_content_main, mapFrg,null)
                                .commit();
                        break;

                    case R.id.itemMenu_Status:
                        Toast.makeText(getApplicationContext(), "Item Status clicked", Toast.LENGTH_SHORT).show();

                        // hiển thị Fragment StatusInMenu
                        StatusInMenuFrg statusFrg = new StatusInMenuFrg();
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.host_fragment_content_main,statusFrg,null)
                                .commit();
                        break;
                }

                // thực hiện đóng Navigation
                drawer.closeDrawer(GravityCompat.START);

                return true;
            }
        });
    }

    /**
     * Phương thức onOptionItemSelected() dùng để bắt sự kiện
     * khi click trên item của Menu
     * https://developer.android.com/guide/topics/ui/menus#RespondingOptionsMenu
     * */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        // xử lý sự kiện click on toggle để hiển thị Navigation
        if (toggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}