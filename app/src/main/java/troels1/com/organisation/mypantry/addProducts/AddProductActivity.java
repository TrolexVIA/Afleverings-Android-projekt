package troels1.com.organisation.mypantry.addProducts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import troels1.com.organisation.mypantry.R;
import troels1.com.organisation.mypantry.mainListVIew.MenuActivity;
import troels1.com.organisation.mypantry.myShoppingLists.MyShoppingListActivity;
import troels1.com.organisation.mypantry.myShoppingLists.MyShoppingListActivityViewModel;
import troels1.com.organisation.mypantry.pantry.PantryActivity;

public class AddProductActivity extends AppCompatActivity {

    private Button tilføj;
    private EditText productNavn;
    private EditText productAntal;
    private AddProductActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

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

            tilføj = (Button)findViewById(R.id.tilføj);
            productNavn = (EditText)findViewById(R.id.produktNavn);
        productAntal = (EditText)findViewById(R.id.produktAntal);

            tilføj.setOnClickListener(
                    new View.OnClickListener()
                    {
                        public void onClick(View view)
                        {
                            Toast.makeText(this, "tryk på Virker", Toast.LENGTH_LONG).show();
                        }


                    });
        }
}

