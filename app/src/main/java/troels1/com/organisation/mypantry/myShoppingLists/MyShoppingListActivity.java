package troels1.com.organisation.mypantry.myShoppingLists;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


import troels1.com.organisation.mypantry.MyShoppingLists.Products;
import troels1.com.organisation.mypantry.R;
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

import troels1.com.organisation.mypantry.databinding.ActivityMenuViewBinding;

public class MyShoppingListActivity extends AppCompatActivity {

   private ActivityMenuViewBinding binding;
   private MyShoppingListActivityViewModel viewModel;


 public RecyclerView pokemonList;
   public troels1.com.organisation.mypantry.MyShoppingLists.ShoppingAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pokemonList = findViewById(R.id.rv);
        pokemonList.hasFixedSize();
        pokemonList.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Products> products = new ArrayList<Products>();
        products.add(new Products("Apples"));



        ShoppingAdapter = new ShoppingAdapter(products);

        ShoppingAdapter.setOnClickListener(pokemon -> {
            Toast.makeText(this, pokemon.getName(), Toast.LENGTH_SHORT).show();
        });

      productsList.setAdapter(ShoppingAdapter);
    }
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
}