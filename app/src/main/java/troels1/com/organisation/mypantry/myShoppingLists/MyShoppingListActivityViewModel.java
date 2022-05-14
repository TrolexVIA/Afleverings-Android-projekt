package troels1.com.organisation.mypantry.myShoppingLists;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

import troels1.com.organisation.mypantry.repository.Repository;
import troels1.com.organisation.mypantry.repository.interfaces.MyShoppingListRepositoryInterface;

public class MyShoppingListActivityViewModel extends AndroidViewModel {

    private MyShoppingListRepositoryInterface repository;

    public MyShoppingListActivityViewModel(Application app) {
        super(app);
        repository = Repository.getInstance(app);
    }

    public void getInfo() {
        repository.getActivUser();
    }
}
