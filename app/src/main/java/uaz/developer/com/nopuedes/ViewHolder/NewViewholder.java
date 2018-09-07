package uaz.developer.com.nopuedes.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import uaz.developer.com.nopuedes.Interface.ItemClickListener;
import uaz.developer.com.nopuedes.R;

/**
 * Created by Uriel on 06/09/2018.
 */

public class NewViewholder extends RecyclerView.ViewHolder implements View.OnClickListener{
    ItemClickListener itemClickListener;
    public ImageView wallpaper_item;

    public void setItemClickListener (ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    public NewViewholder(View itemView) {
        super(itemView);
        wallpaper_item = (ImageView) itemView.findViewById(R.id.wallpaper_id);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v,getAdapterPosition());
    }
}
