package troels1.com.organisation.mypantry.mainListVIew;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

import troels1.com.organisation.mypantry.databinding.ActivityMenuViewBinding;
import troels1.com.organisation.mypantry.localDatabase.Userinformation;
import troels1.com.organisation.mypantry.myShoppingLists.MyShoppingListActivity;
import troels1.com.organisation.mypantry.pantry.PantryActivity;
import troels1.com.organisation.mypantry.R;

public class MenuActivity extends AppCompatActivity {

    private ActivityMenuViewBinding binding;
    private MenuActivityViewModel viewModel;
    private ArrayList<String> listOfUsers;
    private PropertyChangeSupport propertyChangeSupport;
    private LiveData<List<Userinformation>> list;
    private TextView menuText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_view);
        menuText = (findViewById(R.id.MenuTextfelt));

        //viewmodel til observerpattern og til at sende infromation ned i lasangen
        viewModel = new ViewModelProvider(this).get(MenuActivityViewModel.class);

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
        Button notYou = findViewById(R.id.insert);
        notYou.setOnClickListener(z -> {
                toast(viewModel.insert()); //midlertidigt sp vi kan se om det virker
                updateList();
            }
        );


        // retrival af information fra databasen
        propertyChangeSupport = new PropertyChangeSupport(this);
        viewModel.addPropertyChangeListener("eventUser", (PropertyChangeEvent evt) -> this.updateList());
    }

    public void updateList() {
        list = viewModel.getUpdate();
        String test = "hej ";
        if (list == null) {
            test += "virker ikke";
        } else {
            test += "virker";
        }
        menuText.setText(test);
    }

    public void toast(boolean bool) {
        if (bool == true) {
            Toast.makeText(this, "Repository", Toast.LENGTH_LONG).show();
        }
    }

}

