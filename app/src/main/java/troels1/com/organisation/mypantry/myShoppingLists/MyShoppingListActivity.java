package troels1.com.organisation.mypantry.myShoppingLists;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


import troels1.com.organisation.mypantry.mainListVIew.MenuActivity;
import troels1.com.organisation.mypantry.myShoppingLists.Products;
import troels1.com.organisation.mypantry.R;
import troels1.com.organisation.mypantry.databinding.ActivityMenuViewBinding;
import troels1.com.organisation.mypantry.pantry.PantryActivity;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;

import android.widget.ArrayAdapter;

import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.navigation.fragment.DialogFragmentNavigatorDestinationBuilder;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class MyShoppingListActivity extends AppCompatActivity implements ShoppingAdapter.OnClickListener {


    private ActivityMenuViewBinding binding;
    private MyShoppingListActivityViewModel viewModel;
    public RecyclerView shoppingList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_shoping_list);

        shoppingList = findViewById(R.id.rv);
        shoppingList.hasFixedSize();
        shoppingList.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Products> products = new ArrayList<>();
        products.add(new Products("Apples"));
        products.add(new Products("jbjnbjnjndf"));
        products.add(new Products("Apples"));
        products.add(new Products("Apples"));
        products.add(new Products("Apples"));
        products.add(new Products("Apples"));
        products.add(new Products("Apples"));
        products.add(new Products("Apples"));
        products.add(new Products("Apples"));
        products.add(new Products("Apples"));
        products.add(new Products("Apples"));
        products.add(new Products("Apples"));
        products.add(new Products("Apples"));
        products.add(new Products("Apples"));
        products.add(new Products("Apples"));
        products.add(new Products("Apples"));
        products.add(new Products("Apples"));
        products.add(new Products("Apples"));
        products.add(new Products("Apples"));
        products.add(new Products("Apples"));
        products.add(new Products("Apples"));
        products.add(new Products("Apples"));
        products.add(new Products("Apples"));


        Object shoppingAdapter = new ShoppingAdapter(products, this);



        shoppingList.setAdapter((RecyclerView.Adapter) shoppingAdapter);



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

    public void onClick(int position) {
        Toast.makeText(this, "Virker", Toast.LENGTH_LONG).show();
    }



// list observer metode
//  String listname = "fisk"; // denne bør nok ikke være her, men holder det lige samlet indtil det virker
//
//          viewModel.getListInfo(listname).observe(this, new Observer<List<String>>() {
//            @Override
//          public void onChanged(List<String> list) {
//            arrayList.clear();
//          for(int i = 0; i < list.size(); i++) {
//             arrayList.add(list.get(i));
//        }
//    }
//  });


}
