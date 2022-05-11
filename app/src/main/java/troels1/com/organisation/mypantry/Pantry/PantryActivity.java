package troels1.com.organisation.mypantry.Pantry;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import troels1.com.organisation.mypantry.MainListVIew.MenuActivity;
import troels1.com.organisation.mypantry.MyShoppingLists.MyShoppingListActivity;
import troels1.com.organisation.mypantry.Pantry.ui.main.SectionsPagerAdapter;
import troels1.com.organisation.mypantry.R;
import troels1.com.organisation.mypantry.databinding.ActivityPantryBinding;


public class PantryActivity extends AppCompatActivity {

    private ActivityPantryBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPantryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);
        FloatingActionButton fab = binding.fab;

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

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
    }
}