package troels1.com.organisation.mypantry.mainListVIew;

import android.content.Intent;
import android.os.Bundle;;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;


import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;
import java.util.List;

import troels1.com.organisation.mypantry.addProducts.AddProductActivity;
import troels1.com.organisation.mypantry.addUser.AddUserActivity;
import troels1.com.organisation.mypantry.databinding.ActivityMenuViewBinding;
import troels1.com.organisation.mypantry.localDatabase.Entity.Userinformation;
import troels1.com.organisation.mypantry.mainListVIew.Fragment.FragmentMain;
import troels1.com.organisation.mypantry.myShoppingLists.MyShoppingListActivity;
import troels1.com.organisation.mypantry.pantry.PantryActivity;
import troels1.com.organisation.mypantry.R;


public class MenuActivity extends AppCompatActivity {

    private ActivityMenuViewBinding binding;
    private MenuActivityViewModel viewModel;
    private PropertyChangeSupport propertyChangeSupport;
    private List<Userinformation> list;
    private Button toUserSelctFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(MenuActivityViewModel.class);
        viewModel.SendUserQuery();

        setContentView(R.layout.activity_menu_view);

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

        View listitems = findViewById(R.id.findProdukter);
        listitems.setOnClickListener(k -> {
            Intent intent = new Intent(this, AddProductActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide, R.anim.slide);
        });

        Button newUser = findViewById(R.id.NewUserButton);
        newUser.setOnClickListener(z -> {
            Intent intent = new Intent(this, AddUserActivity.class);
            startActivity(intent);
        });

        propertyChangeSupport = new PropertyChangeSupport(this);
        viewModel.addPropertyChangeListener("EventUserview", (PropertyChangeEvent evt) -> this.updateList());

        toUserSelctFragment = findViewById(R.id.SelectUserButton);
        NavController navController = Navigation.findNavController(this, R.id.fragmentContainerView);

        toUserSelctFragment.setOnClickListener(v -> navController.navigate(R.id.fragmentUserSelector));
    }

    public void updateList() {
        list = viewModel.getUpdate();
        if (list.size() > 0) {
            String activUser = "" + list.get(0).getFirstName() + " " + list.get(0).getLastName();
            FragmentMain.activUserTextView.setText(activUser);
        }
    }
}

