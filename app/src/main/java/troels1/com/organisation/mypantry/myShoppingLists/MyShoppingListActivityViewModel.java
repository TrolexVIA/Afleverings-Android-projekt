package troels1.com.organisation.mypantry.myShoppingLists;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import troels1.com.organisation.mypantry.Repository.Repository;

public class MyShoppingListActivityViewModel extends ViewModel {

    private Repository repository;


    public MyShoppingListActivityViewModel () {
        repository = Repository.getInstance();
    }


    public LiveData<List<String>> getListInfo(String list) {
        return repository.getListInfo();
    }
}
