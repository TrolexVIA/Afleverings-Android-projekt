package troels1.com.organisation.mypantry.pantry;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import troels1.com.organisation.mypantry.Repository.Repository;

public class PantryActivityViewModel extends ViewModel {

    private static PantryActivityViewModel instance;

    private Repository repository;

    public PantryActivityViewModel () {
        repository = Repository.getInstance();
    }

    public LiveData<List<String>> getListInfo(String list) {
        return repository.getListInfo();
    }

    public static PantryActivityViewModel getInstancePantryViewModel() {
        if (instance == null) {
            instance = new PantryActivityViewModel();
        }
        return instance;
    }

}
