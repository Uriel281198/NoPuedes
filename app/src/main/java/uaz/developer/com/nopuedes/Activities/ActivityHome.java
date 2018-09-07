package uaz.developer.com.nopuedes.Activities;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;



import uaz.developer.com.nopuedes.Fragments.FragentHome;

import uaz.developer.com.nopuedes.Fragments.FragmentCategory;
import uaz.developer.com.nopuedes.Fragments.FragmentConf;
import uaz.developer.com.nopuedes.Fragments.FragmentFavorite;
import uaz.developer.com.nopuedes.Fragments.FragmentWaifu;
import uaz.developer.com.nopuedes.R;

public class ActivityHome extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        //showToolbar(getResources().getString(R.string.title_actionbar),false);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_id);
        bottomNavigationView.setOnNavigationItemSelectedListener(navlistener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_id,
                new FragentHome()).commit();
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
        getSupportActionBar().setDisplayHomeAsUpEnabled(up);

    }
}
