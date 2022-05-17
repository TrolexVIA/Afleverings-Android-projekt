package troels1.com.organisation.mypantry.pantry;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

import troels1.com.organisation.mypantry.CommonElements.ViewAdapter;
import troels1.com.organisation.mypantry.R;
import troels1.com.organisation.mypantry.addProducts.AddProductActivity;
import troels1.com.organisation.mypantry.databinding.ActivityPantryBinding;
import troels1.com.organisation.mypantry.localDatabase.Entity.Product;
import troels1.com.organisation.mypantry.mainListVIew.MenuActivity;
import troels1.com.organisation.mypantry.myShoppingLists.MyShoppingListActivity;


public class PantryActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityPantryBinding binding;
    private PantryActivityViewModel viewModel;
    public RecyclerView pantryList;
    private List<Product> productsList = new ArrayList<>();
    private PropertyChangeSupport propertyChangeSupport;
    private ViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this).get(PantryActivityViewModel.class);
        setContentView(R.layout.activity_pantry);
        binding = ActivityPantryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        pantryList = findViewById(R.id.rvPantry);
        pantryList.hasFixedSize();
        pantryList.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ViewAdapter(productsList, this);
        pantryList.setAdapter(adapter);

        propertyChangeSupport = new PropertyChangeSupport(this);
        viewModel.addPropertyChangeListener("EventProductPantryView", (PropertyChangeEvent evt) -> this.listSetup());
        viewModel.loadProducts();

        View menuitem = findViewById(R.id.MainMenuTopBar);
        menuitem.setOnClickListener(x -> {
            Intent intent = new Intent(this, MenuActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide, R.anim.slide);
        });

        View listitem = findViewById(R.id.listTopBar);
        listitem.setOnClickListener(y -> {
            Intent intent = new Intent(this, MyShoppingListActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide, R.anim.slide);
        });
        View listitems = findViewById(R.id.findProdukter);
        listitems.setOnClickListener(k -> {
            Intent intent = new Intent(this, AddProductActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide, R.anim.slide);
        });
    }


    public void listSetup() {
        productsList = viewModel.getProductList();
        if (productsList.size() != 0) {
            adapter.changeDataset(productsList);
            adapter.notifyDataSetChanged();
        }
    }
    public void onClick(int position) {
        Toast.makeText(this, "tryk på " + position + " Virker", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view) {

    }
}