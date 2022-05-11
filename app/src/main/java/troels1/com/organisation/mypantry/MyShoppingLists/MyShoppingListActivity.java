package troels1.com.organisation.mypantry.MyShoppingLists;

import androidx.appcompat.app.AppCompatActivity;

import troels1.com.organisation.mypantry.MainListVIew.MenuActivity;
import troels1.com.organisation.mypantry.R;
import troels1.com.organisation.mypantry.databinding.ActivityMenuViewBinding;

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

public class MyShoppingListActivity extends AppCompatActivity {

   private ActivityMenuViewBinding binding;

   ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        TextView textOnMain = findViewById(R.id.TextInMain);
        Button testButton = findViewById(R.id.MyShoppingButton);

        testButton.setOnClickListener( v -> {
            Intent intent = new Intent(this, MenuActivity.class);
            startActivity(intent);
        });

        //navigation
//        binding = ActivityMenuViewBinding.inflate(getLayoutInflater());
  //      setContentView(binding.getRoot());
//
   //     BottomNavigationView navView = findViewById(R.id.nav_view);
  //      AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
   //             R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
     //           .build();
     //   NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_menu_view);
      //  NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
    //    NavigationUI.setupWithNavController(binding.navView, navController);
    }
}