package troels1.com.organisation.mypantry.MyShoppingLists;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import troels1.com.organisation.mypantry.Repository;

public class MyShoppingListActivityViewModel extends ViewModel {

    private Repository repository;


    public MyShoppingListActivityViewModel () {
        repository = Repository.getInstance();
    }


    public LiveData<List<String>> getListInfo(String list) {
        return repository.getListInfo();
    }
}
