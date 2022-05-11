package troels1.com.organisation.mypantry.MainListVIew;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;


import troels1.com.organisation.mypantry.MyShoppingLists.MyShoppingListActivity;
import troels1.com.organisation.mypantry.Pantry.PantryActivity;
import troels1.com.organisation.mypantry.R;
import troels1.com.organisation.mypantry.databinding.ActivityMenuViewBinding;

public class MenuActivity extends AppCompatActivity {

    private ActivityMenuViewBinding binding;
    private MenuActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_menu_view);
        //viewmodel til observerpattern og til at sende infromation ned i lasangen
        viewModel = new ViewModelProvider(this).get(MenuActivityViewModel.class);

        //midlertidigt stuff


        //navigation
        View listitem = findViewById(R.id.listTopBar);
        listitem.setOnClickListener(x -> {
            Intent intent = new Intent(this, MyShoppingListActivity.class);
            startActivity(intent);
        });

        View pantryitem = findViewById(R.id.pantryTopBar);
        pantryitem.setOnClickListener(y -> {
            Intent intent = new Intent(this, PantryActivity.class);
            startActivity(intent);
        });
    }

}

// Toast.makeText(context:this, text:"text1",toast.LENGTH_LONG).show();