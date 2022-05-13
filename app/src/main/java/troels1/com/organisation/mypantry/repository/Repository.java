package troels1.com.organisation.mypantry.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import troels1.com.organisation.mypantry.localDatabase.UserDAO;
import troels1.com.organisation.mypantry.localDatabase.UserDatabase;
import troels1.com.organisation.mypantry.localDatabase.Userinformation;

public class Repository {

    private static Repository instance;
    private UserDAO dao;
    private ExecutorService executorService;
    private PropertyChangeSupport propertyChangeSupport;
    private LiveData<List<Userinformation>> listUserinformation;

    private Repository(Application application) {
        UserDatabase userDatabase = UserDatabase.getInstance(application);
        propertyChangeSupport = new PropertyChangeSupport(this);
        dao = userDatabase.userDAO();
        executorService = Executors.newFixedThreadPool(2);
    }

    public static Repository getInstance(Application app) {
        if (instance == null) {
            instance = new Repository(app);
        }
        return instance;
    }

    // executable metoder
    public void getListInfoOnUser() {
        executorService.execute(() -> {
            this.callbackUser(dao.loadAllUsers());
        });
    }

    public boolean insertNewUser(Userinformation newUser) {
        executorService.execute(() -> {
            dao.insert(newUser);
        });
        return true;
    }

    //property change

    public void addPropertyChangeListener(String name, PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(name, listener);
        listener.propertyChange(new PropertyChangeEvent(this, "eventUser", null, listUserinformation));
    }

    public LiveData<List<Userinformation>> getListUserinformation() {
        return listUserinformation;
    }

    public void callbackUser(LiveData<List<Userinformation>> list) {
        listUserinformation = list;
        propertyChangeSupport.firePropertyChange("eventUser", null, listUserinformation);
    }


}