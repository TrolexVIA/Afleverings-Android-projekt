package troels1.com.organisation.mypantry.mainListVIew;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

import troels1.com.organisation.mypantry.repository.Interfaceses.MenuRepositoryIF;


public class MenuActivityViewModel extends AndroidViewModel {

    private MenuRepositoryIF repository;

    public MenuActivityViewModel(Application app) {
        super(app);
        repository = MenuRepositoryIF.getInstance(app);
    }

}
