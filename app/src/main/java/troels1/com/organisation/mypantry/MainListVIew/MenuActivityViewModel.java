package troels1.com.organisation.mypantry.MainListVIew;

import androidx.lifecycle.ViewModel;

import troels1.com.organisation.mypantry.Repository;


public class MenuActivityViewModel extends ViewModel {

    private Repository repository;

    public MenuActivityViewModel() {
        repository = Repository.getInstance();
    }

}
