package troels1.com.organisation.mypantry.productselector;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;


import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

import troels1.com.organisation.mypantry.databinding.ActivityMenuViewBinding;
import troels1.com.organisation.mypantry.localDatabase.Entity.Userinformation;
import troels1.com.organisation.mypantry.myShoppingLists.MyShoppingListActivity;
import troels1.com.organisation.mypantry.pantry.PantryActivity;
import troels1.com.organisation.mypantry.R;


public class ProductsSelectorActivity extends AppCompatActivity {
    private TextView addProduct;
    private TextView addNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.products);
        addProduct = (findViewById(R.id.addProduct));
        addNumber = (findViewById(R.id.addNumber));


        viewModel = new ViewModelProvider(this).get(ProductSelectorViewModel.class);
        viewModel.getUpdate();

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


        // Setting the right User
        Button tilføj = findViewById(R.id.insert);
        tilføj.setOnClickListener(z -> {
                    toast(viewModel.insert()); //midlertidigt sp vi kan se om det virker
                    Log.d("call", "onclick");
                    viewModel.SendUserQuery();
                }
        );
