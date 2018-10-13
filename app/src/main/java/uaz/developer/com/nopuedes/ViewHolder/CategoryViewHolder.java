package uaz.developer.com.nopuedes.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import uaz.developer.com.nopuedes.Interface.ItemClickListener;
import uaz.developer.com.nopuedes.R;


/**
 * Created by Uriel on 03/08/2018.
 */

public class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {
    public TextView category_name;
    public ImageView background_image;
    ItemClickListener itemClickListener;

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
    public CategoryViewHolder(View itemView) {
        super(itemView);
        category_name = itemView.findViewById(R.id.name_category);
        background_image= (ImageView) itemView.findViewById(R.id.image_category);
        itemView.setOnClickListener( this );
    }

    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v,getAdapterPosition());

    }
}
