package uaz.developer.com.nopuedes.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.squareup.picasso.Picasso;
import java.util.List;
import uaz.developer.com.nopuedes.Interface.ItemClickListener;
import uaz.developer.com.nopuedes.Models.ImageModel;
import uaz.developer.com.nopuedes.R;
import uaz.developer.com.nopuedes.ViewHolder.NewViewholder;

/**
 * Created by Uriel on 06/09/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<NewViewholder> {

    private Context context;
    private List<ImageModel> items;

    public RecyclerViewAdapter(Context context, List<ImageModel> imageModels) {
        this.context = context;
        this.items = imageModels;
    }


    @NonNull
    @Override
    public NewViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull NewViewholder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
