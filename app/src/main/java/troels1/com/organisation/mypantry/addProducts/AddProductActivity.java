package troels1.com.organisation.mypantry.addProducts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import troels1.com.organisation.mypantry.R;
import troels1.com.organisation.mypantry.mainListVIew.MenuActivity;
import troels1.com.organisation.mypantry.myShoppingLists.MyShoppingListActivity;
import troels1.com.organisation.mypantry.pantry.PantryActivity;

public class AddProductActivity extends AppCompatActivity {

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
}
}
