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

import troels1.com.organisation.mypantry.localDatabase.DAO.ProductDAO;
import troels1.com.organisation.mypantry.localDatabase.DAO.UserDAO;
import troels1.com.organisation.mypantry.localDatabase.Entity.Product;
import troels1.com.organisation.mypantry.localDatabase.ProductsDatabase;
import troels1.com.organisation.mypantry.localDatabase.UserDatabase;
import troels1.com.organisation.mypantry.localDatabase.Entity.Userinformation;
import troels1.com.organisation.mypantry.repository.interfaces.MenuRepositoryInterface;
import troels1.com.organisation.mypantry.repository.interfaces.MyShoppingListRepositoryInterface;
import troels1.com.organisation.mypantry.repository.interfaces.PantryRepositoryInterface;

public class Repository<addPropertyChangeListner> implements MenuRepositoryInterface, PantryRepositoryInterface, MyShoppingListRepositoryInterface {

    private static Repository instance;
    private UserDAO userDAO;
    private ProductDAO productDAO;
    private ExecutorService executorService;
    private PropertyChangeSupport propertyChangeSupport;
    private List<Userinformation> listUserinformation;
    private List<Product> listOfProducts;
    private Handler mainThreadHandler;
    private Userinformation activUser; //saettes så de andre aktiviteter ved hvilke lister de skal vise

    private Repository(Application application) {
        userDAO = UserDatabase.getInstance(application).userDAO();
        productDAO = ProductsDatabase.getInstance(application).productDAO();
        propertyChangeSupport = new PropertyChangeSupport(this);
        executorService = Executors.newFixedThreadPool(2);
        mainThreadHandler = HandlerCompat.createAsync(Looper.getMainLooper());
    }

    //instance
    public static Repository getInstance(Application app) {
        if (instance == null) {
            instance = new Repository(app);
        }
        return instance;
    }


    //Menu Userinformation
    public void SendUserQuery() {
        executorService.execute(() -> {
            Log.d("call", "executable");
            List<Userinformation> list = userDAO.loadAllUsers();
            Log.d("call", "executable done");
            mainThreadHandler.post(() -> {
                callbackUser(list);
            });
        });
    }

    @Override
    public void setActivUser(Userinformation activUser) {
        this.activUser = activUser;
    }

    //Menu CRUD

    public boolean insertNewUser(Userinformation newUser) {
        executorService.execute(() -> {
            userDAO.deleteAll();
            userDAO.insert(newUser);
        });
        return true;
    }

    public void deleteUser(Userinformation user) {
        executorService.execute(() -> {
            userDAO.delete(user);
        });
    }

    //property change listner

    public void addPropertyChangeListener(String name, PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(name, listener);
        if (name.equals("eventUser")) {
            listener.propertyChange(new PropertyChangeEvent(this, "eventUser", null, listUserinformation));
        } else if (name.equals("eventProduct")) {
            listener.propertyChange(new PropertyChangeEvent(this, "eventProduct", null, listUserinformation));
        } else {
            Log.d("call", "Der var en fejl i propertychangelistner");
        }
    }

    public List<Userinformation> getListUserinformation() {
        return listUserinformation;
    }

    public void callbackUser(List<Userinformation> list) {
        Log.d("callback", "callbackUser: repository");
        listUserinformation = list;
        propertyChangeSupport.firePropertyChange("eventUser", null, listUserinformation);
    }

    // Pantry Activ user
    @Override
    public Userinformation getActivUser() {
        return activUser;
    }


    // MyShoppingList CRUD

    public void loadProducts() {
        executorService.execute(() -> {
                    List<Product> lists = productDAO.loadAllProduct();
                    mainThreadHandler.post(() -> {
                        callbackProduct(lists);
                    });
                }
        );
    }

    public void callbackProduct(List<Product> list) {
        Log.d("callback", "callbackUser: repository");
        listOfProducts = list;
        propertyChangeSupport.firePropertyChange("eventProduct", null, listUserinformation);
    }

    @Override
    public List<Product> getProducts() {
        return listOfProducts;
    }
}