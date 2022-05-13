package troels1.com.organisation.mypantry.MyShoppingLists;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import troels1.com.organisation.mypantry.R;

public class ShoppingAdapter extends RecyclerView.Adapter<ShoppingAdapter.ViewHolder> {

    public ArrayList<Products> products;
    ShoppingAdapter (ArrayList<Products>products) {
        this.products = products;
    }
    public int getItemCount(){
        return products.size();
    }

    public ShoppingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.activity_my_shoping_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewholder, int position) {
    viewholder.productName.setText(products.get(position).getName());
    viewholder.productIcon.setImageResource(products.get(position).getIconId());

    }
    class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView productName;
        private final ImageView productIcon;

        ViewHolder(View itemView){
            super(itemView);
            productName = itemView.findViewById(R.id.productName);
            productIcon = itemView.findViewById (R.id.productIcon);
        }

    }
}
