package troels1.com.organisation.mypantry.pantry;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import troels1.com.organisation.mypantry.repository.Repository;

public class PantryActivityViewModel extends AndroidViewModel {

    private static PantryActivityViewModel instance;

    private Repository repository;

    private PantryActivityViewModel (Application app) {
        super(app);
        repository = Repository.getInstance(app);
    }

    public LiveData<List<String>> getListInfo(String list) {
        return repository.getListInfo();
    }

    public static PantryActivityViewModel getInstancePantryViewModel(Application app) {
        if (instance == null) {
            instance = new PantryActivityViewModel(app);
        }
        return instance;
    }

}
