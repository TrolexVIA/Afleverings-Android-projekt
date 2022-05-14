package troels1.com.organisation.mypantry.myShoppingLists;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import troels1.com.organisation.mypantry.R;

public class ShoppingAdapter extends RecyclerView.Adapter<ShoppingAdapter.ViewHolder> {

    private ArrayList<Products> products;
    private OnClickListener pOnClickListener;

    public ShoppingAdapter (ArrayList<Products> products,OnClickListener onClickListener)  {
        this.products = products;
        this.pOnClickListener = onClickListener;
    }


    public int getItemCount() {
        return products.size();
    }


    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.activity_my_shoping_list, parent, false);
        return new ViewHolder(view, pOnClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewholder, int position) {
        viewholder.productName.setText(products.get(position).getName());
        viewholder.productIcon.setImageResource(products.get(position).getIconId());

    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView productName;
        ImageView productIcon;
        OnClickListener OnClickListener;
        ViewHolder(View itemView, OnClickListener onClickListener) {
            super(itemView);
            productName = itemView.findViewById(R.id.productName);
            productIcon = itemView.findViewById(R.id.productIcon);
            this.OnClickListener = onClickListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
          pOnClickListener.onClick(getBindingAdapterPosition());
        }
    }


   public interface OnClickListener {
        void onClick(int position);
    }





    }



