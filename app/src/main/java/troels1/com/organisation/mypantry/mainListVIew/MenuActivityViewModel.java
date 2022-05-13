package troels1.com.organisation.mypantry.mainListVIew;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

import troels1.com.organisation.mypantry.Repository.Interfaceses.MenuRepositoryIF;
import troels1.com.organisation.mypantry.Repository.Repository;


public class MenuActivityViewModel extends AndroidViewModel {

    private MenuRepositoryIF repository;

    public MenuActivityViewModel(Application app) {
        super(app);
        repository = MenuRepositoryIF.getInstance(app);
    }

}
