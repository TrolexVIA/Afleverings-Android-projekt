package troels1.com.organisation.mypantry.myShoppingLists;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import troels1.com.organisation.mypantry.databinding.ActivityMenuViewBinding;
import troels1.com.organisation.mypantry.mainListVIew.MenuActivity;
import troels1.com.organisation.mypantry.pantry.PantryActivity;
import troels1.com.organisation.mypantry.R;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;

import android.widget.ArrayAdapter;

import android.widget.ListView;

import java.util.ArrayList;

public class MyShoppingListActivity extends AppCompatActivity {

   private ActivityMenuViewBinding binding;
   private MyShoppingListActivityViewModel viewModel;

   private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_shoping_list);
        viewModel = new ViewModelProvider(this).get(MyShoppingListActivityViewModel.class);

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