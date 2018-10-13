package uaz.developer.com.nopuedes.Fragments;


import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.Random;

import uaz.developer.com.nopuedes.Activities.WallpaperListActivity;
import uaz.developer.com.nopuedes.Common.Common;
import uaz.developer.com.nopuedes.Interface.ItemClickListener;
import uaz.developer.com.nopuedes.Models.CategoryItem;
import uaz.developer.com.nopuedes.R;
import uaz.developer.com.nopuedes.ViewHolder.CategoryViewHolder;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentCategory extends Fragment {


    FirebaseDatabase database;
    DatabaseReference category;
    FirebaseRecyclerOptions<CategoryItem> options;
    //recibe nuestro clase y viewholder
    FirebaseRecyclerAdapter<CategoryItem,CategoryViewHolder> adapter;


    RecyclerView recyclerView;
    public FragmentCategory() {



        //our constructor taking of instance of database
        database = FirebaseDatabase.getInstance();
        //set reference
        category = database.getReference(Common.STR_CATEGORY_BACKGROUND);
        //create our recycler optios with our model and set query
        options = new FirebaseRecyclerOptions.Builder<CategoryItem>()
                 .setQuery(category,CategoryItem.class)
                .build();

        adapter = new FirebaseRecyclerAdapter<CategoryItem, CategoryViewHolder>(options) {

            @NonNull
            @Override
            public CategoryViewHolder   onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View itemview = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.l,parent,false);

                return  new CategoryViewHolder(itemview);
            }

            @Override
            protected void onBindViewHolder(@NonNull final CategoryViewHolder holder, int position, @NonNull final CategoryItem model) {

                Picasso.get()
                        .load(model.getImageLink())
                        .networkPolicy(NetworkPolicy.OFFLINE)
                        .placeholder(R.color.white)
                        .into(holder.background_image, new Callback() {
                            @Override
                            public void onSuccess() {

                            }

                            @Override
                            public void onError(Exception e) {
                                Picasso.get()
                                        .load(model.getImageLink())
                                        .error(R.drawable.foto1)
                                        .into(holder.background_image, new Callback() {
                                            @Override
                                            public void onSuccess() {

                                            }

                                            @Override
                                            public void onError(Exception e) {
                                                Log.e ("asdas","sdsa");}
                                        });
                            }
                        });
                holder.category_name.setText(model.getName());
                holder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position) {

                        Common.CATEGORY_ID_SELECTED = adapter.getRef(position).getKey();
                        Common.CATEGORY_SELECTED = model.getName();
                        Intent intent = new Intent(getActivity(), WallpaperListActivity.class);
                        startActivity(intent);
                    }
                });

            }

        };
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_fragment_category, container, false);
        recyclerView= v.findViewById(R.id.recycler_categoryf);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager= new GridLayoutManager(getActivity(),1);
        recyclerView.setLayoutManager(gridLayoutManager);

        setCategory();

        return v;

    }

    private void setCategory() {

        adapter.startListening();
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onStart() {
        super.onStart();
        if (adapter!=null)
            adapter.startListening();
    }

    @Override
    public void onStop() {
        if (adapter!=null)
            adapter.stopListening();
        super.onStop();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (adapter!=null)
            adapter.startListening();
    }

    public void color (){

    }

}
