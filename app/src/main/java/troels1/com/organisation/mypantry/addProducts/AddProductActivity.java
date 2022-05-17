package troels1.com.organisation.mypantry.addProducts;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import troels1.com.organisation.mypantry.R;
import troels1.com.organisation.mypantry.mainListVIew.MenuActivity;
import troels1.com.organisation.mypantry.myShoppingLists.MyShoppingListActivity;
import troels1.com.organisation.mypantry.pantry.PantryActivity;

public class AddProductActivity extends AppCompatActivity {

    private Button addShopping;
    private Button addPantry;
    private EditText productNavn;
    private EditText productAntal;
    private AddProductActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        viewModel = new ViewModelProvider(this).get(AddProductActivityViewModel.class);


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


        View menuitem = findViewById(R.id.MainMenuTopBar);
        menuitem.setOnClickListener(x -> {
            Intent intent = new Intent(this, MenuActivity.class);
            startActivity(intent);
        });

        addShopping = (Button) findViewById(R.id.tilføj);
        addPantry = (Button) findViewById(R.id.tilføj1);
        productNavn = (EditText) findViewById(R.id.produktNavn);
        productAntal = (EditText) findViewById(R.id.produktAntal);

        addShopping.setOnClickListener(
                view -> {
                    if (TextUtils.isEmpty(productNavn.getText().toString()) || TextUtils.isEmpty(productAntal.getText().toString())) {
                        Toast.makeText(AddProductActivity.this,
                                getString(R.string.error_add_product),
                                Toast.LENGTH_SHORT).show();
                    } else
                        viewModel.addProductShopping(productNavn.getText().toString(), productAntal.getText().toString());
                    productNavn.setText("");
                    productAntal.setText("");
                });

        addPantry.setOnClickListener(
                view -> {
                    if (TextUtils.isEmpty(productNavn.getText().toString()) || TextUtils.isEmpty(productAntal.getText().toString())) {
                        Toast.makeText(AddProductActivity.this,
                                getString(R.string.error_add_product),
                                Toast.LENGTH_SHORT).show();
                    } else {
                        viewModel.addProductPantry(productNavn.getText().toString(), productAntal.getText().toString());
                        productNavn.setText("");
                        productAntal.setText("");
                    }

                });
    }
}

