package uaz.developer.com.nopuedes.Adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import uaz.developer.com.nopuedes.Fragments.FragmentNew;
import uaz.developer.com.nopuedes.Fragments.FragmentPopular;

/**
 * Created by Uriel on 05/09/2018.
 */

public class FragmentPagerAdapter extends FragmentStatePagerAdapter {

    Context context;
    int numerotabs;
    public FragmentPagerAdapter(FragmentManager fm ,int number ,Context context) {
        super(fm);
        this.numerotabs=number;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0 :
                FragmentNew fn = new FragmentNew();
                return fn;
            case 1:
                FragmentPopular fp = new FragmentPopular();
                return fp;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numerotabs;
    }
}
