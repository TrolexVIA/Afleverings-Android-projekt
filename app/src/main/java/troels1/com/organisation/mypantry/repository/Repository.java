package troels1.com.organisation.mypantry.repository;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import androidx.core.os.HandlerCompat;

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
    private List<Userinformation> listUserinformation;
    private Handler mainThreadHandler;

    private Repository(Application application) {
        UserDatabase userDatabase = UserDatabase.getInstance(application);
        propertyChangeSupport = new PropertyChangeSupport(this);
        dao = userDatabase.userDAO();
        executorService = Executors.newFixedThreadPool(2);
        mainThreadHandler = HandlerCompat.createAsync(Looper.getMainLooper());
    }

    public static Repository getInstance(Application app) {
        if (instance == null) {
            instance = new Repository(app);
        }
        return instance;
    }

    // executable metoder
    public void SendUserQuery() {
    //    List<Userinformation> list = new ArrayList<>();
    //    list.add(new Userinformation("fisk", "henning"));
    //    Log.d("Callonclick", "getListInfoOnUser: ");
    //    callbackUser(list);
            executorService.execute(() -> {
            List<Userinformation> list = dao.loadAllUsers();
            mainThreadHandler.post(() -> { callbackUser(list);});
        });
    }

    // CRUD

    public boolean insertNewUser(Userinformation newUser) {
        executorService.execute(() -> {
            dao.deleteAll();
            dao.insert(newUser);
        });
        return true;
    }

    public void deleteUser(Userinformation user) {
        executorService.execute(() -> {
            dao.delete(user);
        });
    }

    //property change

    public void addPropertyChangeListener(String name, PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(name, listener);
        listener.propertyChange(new PropertyChangeEvent(this, "eventUser", null, listUserinformation));
    }

    public List<Userinformation> getListUserinformation() {
        return listUserinformation;
    }

    public void callbackUser(List<Userinformation> list) {
        Log.d("callback", "callbackUser: repository");
        listUserinformation = list;
        propertyChangeSupport.firePropertyChange("eventUser", null, listUserinformation);
    }
}