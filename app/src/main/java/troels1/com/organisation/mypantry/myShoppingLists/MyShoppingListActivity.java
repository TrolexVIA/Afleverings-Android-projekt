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

import android.view.View;

import android.widget.ArrayAdapter;

import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class MyShoppingListActivity extends AppCompatActivity {

    private ActivityMenuViewBinding binding;
    private MyShoppingListActivityViewModel viewModel;


    public RecyclerView shoppingList;
    private Object ShoppingAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_shoping_list);

        shoppingList = findViewById(R.id.rv);
        shoppingList.hasFixedSize();
        shoppingList.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Products> products = new ArrayList<>();
        products.add(new Products("Apples"));


        ShoppingAdapter = new ShoppingAdapter(products);


        shoppingList.setAdapter((RecyclerView.Adapter) ShoppingAdapter);


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