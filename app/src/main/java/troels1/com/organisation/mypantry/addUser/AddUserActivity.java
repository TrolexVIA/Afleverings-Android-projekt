package troels1.com.organisation.mypantry.addUser;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import troels1.com.organisation.mypantry.R;
import troels1.com.organisation.mypantry.mainListVIew.MenuActivity;
import troels1.com.organisation.mypantry.myShoppingLists.MyShoppingListActivity;
import troels1.com.organisation.mypantry.pantry.PantryActivity;

public class AddUserActivity extends AppCompatActivity {

    private Button addUser;
    private EditText userNavn;
    private AddUserActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        viewModel = new ViewModelProvider(this).get(AddUserActivityViewModel.class);

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


        addUser = findViewById(R.id.add_user_button);
        userNavn = findViewById(R.id.add_user_textfield);

        addUser.setOnClickListener(
                view -> {
                    if (TextUtils.isEmpty(userNavn.getText().toString())) {
                        Toast.makeText(AddUserActivity.this,
                                getString(R.string.error_add_user),
                                Toast.LENGTH_SHORT).show();
                    } else
                        viewModel.addUserShopping(userNavn.getText().toString());
                    userNavn.setText("");
                });
    }
}



