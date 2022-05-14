package troels1.com.organisation.mypantry.pantry;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

import troels1.com.organisation.mypantry.repository.Repository;
import troels1.com.organisation.mypantry.repository.interfaces.PantryRepositoryInterface;

public class PantryActivityViewModel extends AndroidViewModel {

    private PantryRepositoryInterface repository;

    public PantryActivityViewModel (Application app) {
        super(app);
        repository = Repository.getInstance(app);
    }

    public void getActivUser(String list) {
        repository.getActivUser();
    }

}
