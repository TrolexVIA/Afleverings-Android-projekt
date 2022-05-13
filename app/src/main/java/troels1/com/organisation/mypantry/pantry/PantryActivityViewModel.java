package troels1.com.organisation.mypantry.pantry;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

import troels1.com.organisation.mypantry.repository.Repository;

public class PantryActivityViewModel extends AndroidViewModel {

    private Repository repository;

    public PantryActivityViewModel (Application app) {
        super(app);
        repository = Repository.getInstance(app);
    }

    public void getListInfo(String list) {
        repository.SendUserQuery();
    }

}
