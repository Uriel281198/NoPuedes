package uaz.developer.com.nopuedes.Activities;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;


import uaz.developer.com.nopuedes.Fragments.FragentHome;

import uaz.developer.com.nopuedes.Fragments.FragmentCategory;
import uaz.developer.com.nopuedes.Fragments.FragmentConf;
import uaz.developer.com.nopuedes.Fragments.FragmentFavorite;
import uaz.developer.com.nopuedes.Fragments.FragmentWaifu;
import uaz.developer.com.nopuedes.R;

public class ActivityHome extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        showToolbar(getResources().getString(R.string.title_actionbar),true);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_id);
        bottomNavigationView.setOnNavigationItemSelectedListener(navlistener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_id,
                new FragentHome()).commit();


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.nav_camera) {
                    // Handle the camera action
                } else if (id == R.id.nav_gallery) {
                    Toast.makeText(ActivityHome.this, "ada", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.nav_slideshow) {

                } else if (id == R.id.nav_manage) {

                } else if (id == R.id.nav_share) {

                } else if (id == R.id.nav_send) {

                }

                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }




    private BottomNavigationView.OnNavigationItemSelectedListener navlistener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment =null;
                    switch (item.getItemId()){

                        case R.id.navigation_home:
                            selectedFragment = new FragentHome();
                            break;
                        case R.id.navigation_category:
                            selectedFragment = new FragmentCategory();
                            break;
                        case R.id.navigation_favorite:
                            selectedFragment= new FragmentFavorite();
                            break;
                        case R.id.navigation_waifu:
                            selectedFragment= new FragmentWaifu();
                            break;
                        case R.id.navigation_configuracion:
                            selectedFragment= new FragmentConf();
                            break;

                    }

                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_id,
                            selectedFragment).commit();
                    return true;
                }
            };



    public void showToolbar (String tiitle ,boolean up){
        Toolbar toolbar = findViewById(R.id.toolbar_id);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tiitle);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_action_newburger);
        getSupportActionBar().setDisplayHomeAsUpEnabled(up);

    }

    @Override

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }




}
