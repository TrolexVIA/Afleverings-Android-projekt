package troels1.com.organisation.mypantry.mainListVIew;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

import troels1.com.organisation.mypantry.localDatabase.Userinformation;
import troels1.com.organisation.mypantry.repository.Repository;


public class MenuActivityViewModel extends AndroidViewModel {

    private Repository repository;
    private PropertyChangeSupport propertyChangeSupport;
    private LiveData<List<Userinformation>> list;

    public MenuActivityViewModel(Application app) {
        super(app);
        repository = Repository.getInstance(app);
        propertyChangeSupport = new PropertyChangeSupport(this);
        repository.addPropertyChangeListener("eventUser", (PropertyChangeEvent evt) -> this.updateList());
    }

    public void getListInfo() {
         repository.getListInfoOnUser();
    }

    private void updateList() {
       list =  repository.getListUserinformation();
    }

    public LiveData<List<Userinformation>> getUpdate() {
        return list;
    }

    public void addPropertyChangeListener(String name, PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(name, listener);
        listener.propertyChange(new PropertyChangeEvent(this, "eventUser", null, list));
    }

    public boolean insert() { //temp for at se om det virker
        String first = String.valueOf(Math.random());
        String last = String.valueOf(Math.random());
        Userinformation newUser = new Userinformation(first, last);
        return repository.insertNewUser(newUser);
    }
}
