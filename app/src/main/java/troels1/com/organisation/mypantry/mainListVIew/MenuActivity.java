package troels1.com.organisation.mypantry.mainListVIew;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;


import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;
import java.util.List;

import troels1.com.organisation.mypantry.CommonElements.UserAdapter;
import troels1.com.organisation.mypantry.addProducts.AddProductActivity;
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
        //viewmodel til observerpattern og til at sende infromation ned i lasangen
        viewModel = new ViewModelProvider(this).get(MenuActivityViewModel.class);
        viewModel.getUpdate();

        setContentView(R.layout.activity_menu_view);


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

        View listitems = findViewById(R.id.findProdukter);
        listitems.setOnClickListener(k -> {
            Intent intent = new Intent(this, AddProductActivity.class);
            startActivity(intent);
        });



        // Setting the right User
    //    Button notYou = findViewById(R.id.insert);
    //    notYou.setOnClickListener(z -> {
    //            toast(viewModel.insert()); //midlertidigt sp vi kan se om det virker
    //            Log.d("call", "onclick");
    //            viewModel.SendUserQuery();
    //        }
    //    );


        // retrival af information fra databasen
        propertyChangeSupport = new PropertyChangeSupport(this);
        viewModel.addPropertyChangeListener("EventUserview", (PropertyChangeEvent evt) -> this.updateList());

        //userselct fragment
        toUserSelctFragment = findViewById(R.id.insert);
        NavController navController = Navigation.findNavController(this, R.id.fragmentContainerView);

        toUserSelctFragment.setOnClickListener(v-> navController.navigate(R.id.fragmentUserSelector));
    }

    public void updateList() {
        list = viewModel.getUpdate();
        list.add(new Userinformation("test", "fragment virker"));
        Log.d("call", "updateList: viewcontroller");
        if (list != null) {
            String activUser = "" + list.get(0).getFirstName() + list.get(0).getLastName();
           FragmentMain.activUserTextView.setText(activUser);
        }
    }



    public void toast(boolean bool) {
        if (bool) {
            Toast.makeText(this, "Profiler er hentet", Toast.LENGTH_LONG).show();
        }
    }
}

