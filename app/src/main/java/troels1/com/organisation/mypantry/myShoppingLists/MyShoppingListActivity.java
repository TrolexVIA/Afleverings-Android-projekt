package troels1.com.organisation.mypantry.myShoppingLists;

import androidx.appcompat.app.AppCompatActivity;


import troels1.com.organisation.mypantry.localDatabase.Entity.Product;
import troels1.com.organisation.mypantry.mainListVIew.MenuActivity;
import troels1.com.organisation.mypantry.R;
import troels1.com.organisation.mypantry.databinding.ActivityMenuViewBinding;
import troels1.com.organisation.mypantry.pantry.PantryActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;

import android.widget.Toast;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class MyShoppingListActivity extends AppCompatActivity implements ShoppingAdapter.OnClickListener {


    private ActivityMenuViewBinding binding;
    private MyShoppingListActivityViewModel viewModel;
    public RecyclerView shoppingList;
    private List<Product> productsList = new ArrayList<Product>();
    private PropertyChangeSupport propertyChangeSupport;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(MyShoppingListActivityViewModel.class);
        setContentView(R.layout.activity_my_shoping_list);
        productsList.add(new Product("virker ikke", null, null, null, false, false)); //for at initiere productsList
        shoppingList = findViewById(R.id.rv);
        shoppingList.hasFixedSize();
        shoppingList.setLayoutManager(new LinearLayoutManager(this));
        Object shoppingAdapter = new ShoppingAdapter(productsList, this);
        shoppingList.setAdapter((RecyclerView.Adapter) shoppingAdapter);

        //requesting inforation fra repository
        propertyChangeSupport = new PropertyChangeSupport(this);
        viewModel.addPropertyChangeListener("EventProductView", (PropertyChangeEvent evt) -> this.listSetup());
        viewModel.loadProducts();

        //navigation
        View menuitem = findViewById(R.id.MainMenuTopBar);
        menuitem.setOnClickListener(x -> {
            Intent intent = new Intent(this, MenuActivity.class);
            startActivity(intent);
        });

        View pantryitem = findViewById(R.id.pantryTopBar);
        pantryitem.setOnClickListener(y -> {
            Intent intent = new Intent(this, PantryActivity.class);
            startActivity(intent);
        });
    }

    //sender update request til adapter
    public void listSetup() {
        productsList = viewModel.getProductList();
        Toast.makeText(this, "load done", Toast.LENGTH_LONG).show();
        //updataing information fra viewcontroller
        shoppingList.getAdapter().notifyDataSetChanged();
    }


    public void onClick(int position) {
        Toast.makeText(this, "tryk på " + position + " Virker", Toast.LENGTH_LONG).show();
    }
}
