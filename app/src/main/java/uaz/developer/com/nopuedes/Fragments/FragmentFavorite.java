package uaz.developer.com.nopuedes.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import uaz.developer.com.nopuedes.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentFavorite extends Fragment {


    public FragmentFavorite() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_favorite, container, false);
    }

}
