package uaz.developer.com.nopuedes.Fragments;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import uaz.developer.com.nopuedes.Adapters.RecyclerViewAdapter;
import uaz.developer.com.nopuedes.Models.ImageModel;
import uaz.developer.com.nopuedes.R;

public class FragmentNew extends Fragment {

    List<ImageModel> items;

    RecyclerView recyclerView;

    public FragmentNew() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_fragment_new, container, false);
        return v;
    }

}
