package troels1.com.organisation.mypantry.MyShoppingLists;

import androidx.appcompat.app.AppCompatActivity;

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

public class MyShoppingListActivity extends AppCompatActivity {

   private ActivityMenuViewBinding binding;

   ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_shoping_list);

        listView=(ListView)findViewById(R.id.listview);

        ArrayList<String> arrayList= new ArrayList<>();
        arrayList.add("Hej");
        arrayList.add("Troels");
        arrayList.add("Så");
        arrayList.add("Er");
        arrayList.add("Der");
        arrayList.add("Liste");

        ArrayAdapter arrayAdapter= new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList);

        listView.setAdapter(arrayAdapter);


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