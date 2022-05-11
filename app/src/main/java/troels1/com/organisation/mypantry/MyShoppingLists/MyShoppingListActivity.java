package troels1.com.organisation.mypantry.MyShoppingLists;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import troels1.com.organisation.mypantry.MainListVIew.MenuActivity;
import troels1.com.organisation.mypantry.R;
import troels1.com.organisation.mypantry.databinding.ActivityMenuViewBinding;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MyShoppingListActivity extends AppCompatActivity {

   private ActivityMenuViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // midertidigt stuff
        TextView textOnMain = findViewById(R.id.TextInMain);
        Button testButton = findViewById(R.id.testButton);

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