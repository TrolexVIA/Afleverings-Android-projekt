package troels1.com.organisation.mypantry.mainListVIew;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

import troels1.com.organisation.mypantry.repository.Repository;


public class MenuActivityViewModel extends AndroidViewModel {

    private Repository repository;

    public MenuActivityViewModel(Application app) {
        super(app);
        repository = Repository.getInstance(app);
    }

}
