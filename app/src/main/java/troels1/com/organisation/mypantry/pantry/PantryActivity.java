package troels1.com.organisation.mypantry.pantry;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

import troels1.com.organisation.mypantry.CommonElements.ViewAdapter;
import troels1.com.organisation.mypantry.addProducts.AddProductActivity;
import troels1.com.organisation.mypantry.databinding.ActivityMenuViewBinding;
import troels1.com.organisation.mypantry.databinding.ActivityPantryBinding;
import troels1.com.organisation.mypantry.localDatabase.Entity.Product;
import troels1.com.organisation.mypantry.mainListVIew.MenuActivity;
import troels1.com.organisation.mypantry.mainListVIew.MenuActivityViewModel;
import troels1.com.organisation.mypantry.myShoppingLists.MyShoppingListActivity;
import troels1.com.organisation.mypantry.R;
import troels1.com.organisation.mypantry.myShoppingLists.MyShoppingListActivityViewModel;


public class PantryActivity extends AppCompatActivity implements ViewAdapter.OnClickListener {

    private ActivityPantryBinding binding;
    private PantryActivityViewModel viewModel;
    public RecyclerView pantryList;
    private List<Product> productsList = new ArrayList<Product>();
    private PropertyChangeSupport propertyChangeSupport;
    private ViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this).get(PantryActivityViewModel.class);
        setContentView(R.layout.activity_pantry);
        binding = ActivityPantryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        FloatingActionButton fab = binding.fab;

        pantryList = findViewById(R.id.rvPantry);
        pantryList.hasFixedSize();
        pantryList.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ViewAdapter(productsList, this);
        pantryList.setAdapter((RecyclerView.Adapter) adapter);

        //requesting inforation fra repository
        propertyChangeSupport = new PropertyChangeSupport(this);
        viewModel.addPropertyChangeListener("EventProductPantryView", (PropertyChangeEvent evt) -> this.listSetup());
        viewModel.loadProducts();


        //floating button
 //       fab.setOnClickListener(new View.OnClickListener() {
 //           @Override
 //           public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
  //                      .setAction("Action", null).show();
  //          }
  //      });

        //navigation
        View menuitem = findViewById(R.id.MainMenuTopBar);
        menuitem.setOnClickListener(x -> {
            Intent intent = new Intent(this, MenuActivity.class);
            startActivity(intent);
        });

        View listitem = findViewById(R.id.listTopBar);
        listitem.setOnClickListener(y -> {
            Intent intent = new Intent(this, MyShoppingListActivity.class);
            startActivity(intent);
        });
        View listitems = findViewById(R.id.findProdukter);
        listitems.setOnClickListener(k -> {
            Intent intent = new Intent(this, AddProductActivity.class);
            startActivity(intent);
        });
    }


    //sender update request til adapter
    public void listSetup() {
        productsList = viewModel.getProductList();
        if (productsList.size() != 0) {
            //updataing information fra viewcontroller
            adapter.changeDataset(productsList);
            adapter.notifyDataSetChanged();
        }
    }

    public void onClick(int position) {
        Toast.makeText(this, "tryk på " + position + " Virker", Toast.LENGTH_LONG).show();
    }
}