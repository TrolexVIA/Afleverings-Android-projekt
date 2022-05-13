package troels1.com.organisation.mypantry.MyShoppingLists;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import troels1.com.organisation.mypantry.MainListVIew.MenuActivity;
import troels1.com.organisation.mypantry.Pantry.PantryActivity;
import troels1.com.organisation.mypantry.R;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.ArrayList;
import troels1.com.organisation.mypantry.databinding.ActivityMenuViewBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;

public class MyShoppingListActivity extends AppCompatActivity {

   private ActivityMenuViewBinding binding;

    RecyclerView recyclerView;
    ShoppingAdapter shoppingAdapter;
    private Object ShoppingAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_shoping_list);
        recyclerView =findViewById(R.id.rv);
    recyclerView.hasFixedSize();
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    recyclerView.setAdapter(shoppingAdapter);

    ArrayList<Products> products = new ArrayList<>();
    products.add(new Products("Hej"));
        products.add(new Products("Troels"));


    ShoppingAdapter adapter = new ShoppingAdapter(products);
    recyclerView.setAdapter(adapter);


        // midertidigt stuff


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