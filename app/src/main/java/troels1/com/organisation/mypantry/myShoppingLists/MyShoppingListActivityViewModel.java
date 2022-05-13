package troels1.com.organisation.mypantry.myShoppingLists;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

import troels1.com.organisation.mypantry.repository.Repository;

public class MyShoppingListActivityViewModel extends AndroidViewModel {

    private Repository repository;

    public MyShoppingListActivityViewModel (Application app) {
        super(app);
        repository = Repository.getInstance(app);
    }

    public void getListInfo() {
        repository.SendUserQuery();
    }
}
