package troels1.com.organisation.mypantry.CommonElements;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import troels1.com.organisation.mypantry.R;
import troels1.com.organisation.mypantry.localDatabase.Entity.Product;

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.ViewHolder> {

    private List<Product> products;
    private View.OnClickListener onClickListener;

    public ViewAdapter(List<Product> products, View.OnClickListener onClickListener) {
        this.products = products;
        this.onClickListener = onClickListener;
    }

    public void changeDataset(List<Product> list) {
        products = list;
    }

    public int getItemCount() {
        return products.size();
    }


    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recyclerview, parent, false);
        return new ViewHolder(view, onClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewholder, int position) {
        viewholder.productName.setText(products.get(position).getName() +": "+ products.get(position).getAntal());

    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView productName;
        ImageView productIcon;
        View.OnClickListener onClickListener;

        ViewHolder(View itemView, View.OnClickListener onClickListener) {
            super(itemView);
            productName = itemView.findViewById(R.id.productName);
            productIcon = itemView.findViewById(R.id.productIcon);
            this.onClickListener = onClickListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onClickListener.onClick(v);
        }
    }
}



