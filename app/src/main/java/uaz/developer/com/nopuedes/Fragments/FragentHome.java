package uaz.developer.com.nopuedes.Fragments;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.Toast;

import com.mancj.materialsearchbar.MaterialSearchBar;

import uaz.developer.com.nopuedes.Adapters.FragmentPagerAdapter;
import uaz.developer.com.nopuedes.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragentHome extends Fragment {

    Context context;

    public FragentHome (){

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_fragent_home, container, false);
        TabLayout tabLayout= v.findViewById(R.id.tabs_id);
        final ViewPager viewPager = v.findViewById(R.id.viewpager_home_id);

        tabLayout.addTab(tabLayout.newTab().setText("Nuevos"));
        tabLayout.addTab(tabLayout.newTab().setText("Populares"));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


        FragmentPagerAdapter adapter= new FragmentPagerAdapter(getFragmentManager(),tabLayout.getTabCount(),context);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position= tab.getPosition();
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                Toast.makeText(getContext(), "tabonrel", Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }

}
