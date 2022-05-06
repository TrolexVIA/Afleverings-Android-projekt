package troels1.com.organisation.mypantry.MyShoppingLists;

import androidx.lifecycle.ViewModel;

import troels1.com.organisation.mypantry.Repository;

public class MyShoppingListActivityViewModel extends ViewModel {

    private Repository repository;

    public MyShoppingListActivityViewModel () {
        repository = Repository.getInstance();
    }
}
