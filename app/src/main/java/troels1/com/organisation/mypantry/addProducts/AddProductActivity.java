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

    private AddProductActivityViewModel viewModel;
    private EditText productNavn;
    private EditText productAntal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        viewModel = new ViewModelProvider(this).get(AddProductActivityViewModel.class);


        View listitem = findViewById(R.id.listTopBar);
        listitem.setOnClickListener(x -> {
            Intent intent = new Intent(this, MyShoppingListActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide, R.anim.slide);
        });

        View pantryitem = findViewById(R.id.pantryTopBar);
        pantryitem.setOnClickListener(y -> {
            Intent intent = new Intent(this, PantryActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide, R.anim.slide);
        });


        View menuitem = findViewById(R.id.MainMenuTopBar);
        menuitem.setOnClickListener(x -> {
            Intent intent = new Intent(this, MenuActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide, R.anim.slide);
        });

        Button addShopping = (Button) findViewById(R.id.tilføj);
        Button addPantry = (Button) findViewById(R.id.tilføj1);
        productNavn = (EditText) findViewById(R.id.produktNavn);
        productAntal = (EditText) findViewById(R.id.produktAntal);

        Button removeShopping = (Button) findViewById(R.id.remove_shopping);
        Button removeInStock = (Button) findViewById(R.id.remove_pantry);

        addShopping.setOnClickListener(
                view -> {
                    if (feltChecker()) {
                        boolean toast = viewModel.addProductShopping(productNavn.getText().toString(), productAntal.getText().toString());
                        productNavn.setText("");
                        productAntal.setText("");
                        if (toast) {
                            toast(getString(R.string.add_product));
                        }
                    }
                });

        addPantry.setOnClickListener(
                view -> {
                    if (feltChecker()) {
                        boolean toast = viewModel.addProductPantry(productNavn.getText().toString(), productAntal.getText().toString());
                        productNavn.setText("");
                        productAntal.setText("");
                        if (toast) {
                            toast(getString(R.string.add_product));
                        }
                    }
                });

        removeInStock.setOnClickListener(
                view -> {
                    if (feltChecker()) {
                        boolean toast = viewModel.deleteProduct(productNavn.getText().toString(), productAntal.getText().toString(), true);
                        productNavn.setText("");
                        productAntal.setText("");
                        if (toast) {
                            toast(getString(R.string.delete_product));

                        }
                    }
                });
        removeShopping.setOnClickListener(
                view -> {
                    if (feltChecker()) {
                        boolean toast = viewModel.deleteProduct(productNavn.getText().toString(), productAntal.getText().toString(), false);
                        productNavn.setText("");
                        productAntal.setText("");
                        if (toast) {
                            toast(getString(R.string.delete_product));
                        }

                    }
                });
    }

    public boolean feltChecker() {
        if (TextUtils.isEmpty(productNavn.getText().toString()) || TextUtils.isEmpty(productAntal.getText().toString())) {
            toast(getString(R.string.error_add_product));
            return false;
        } else {
            return true;
        }
    }

    public void toast(String toastMessage) {
        Toast.makeText(AddProductActivity.this,
                toastMessage,
                Toast.LENGTH_SHORT).show();
    }
}


