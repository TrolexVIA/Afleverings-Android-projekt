package troels1.com.organisation.mypantry.pantry;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import troels1.com.organisation.mypantry.repository.Repository;

public class PantryActivityViewModel extends AndroidViewModel {

    private Repository repository;

    public PantryActivityViewModel (Application app) {
        super(app);
        repository = Repository.getInstance(app);
    }

    public LiveData<List<String>> getListInfo(String list) {
        return repository.getListInfo();
    }

}
