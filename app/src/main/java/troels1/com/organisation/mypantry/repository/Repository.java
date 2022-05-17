package troels1.com.organisation.mypantry.repository;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import androidx.core.os.HandlerCompat;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import troels1.com.organisation.mypantry.localDatabase.DAO.ProductDAO;
import troels1.com.organisation.mypantry.localDatabase.DAO.UserDAO;
import troels1.com.organisation.mypantry.localDatabase.Entity.Product;
import troels1.com.organisation.mypantry.localDatabase.Entity.Userinformation;
import troels1.com.organisation.mypantry.localDatabase.ProductsDatabase;
import troels1.com.organisation.mypantry.localDatabase.UserDatabase;
import troels1.com.organisation.mypantry.repository.interfaces.AddProductInterface;
import troels1.com.organisation.mypantry.repository.interfaces.AddUserRepositoryInterface;
import troels1.com.organisation.mypantry.repository.interfaces.MenuRepositoryInterface;
import troels1.com.organisation.mypantry.repository.interfaces.MyShoppingListRepositoryInterface;
import troels1.com.organisation.mypantry.repository.interfaces.PantryRepositoryInterface;
import troels1.com.organisation.mypantry.repository.interfaces.UserAdapterRepositoryInterface;

public class Repository implements MenuRepositoryInterface, PantryRepositoryInterface, MyShoppingListRepositoryInterface, AddProductInterface, UserAdapterRepositoryInterface, AddUserRepositoryInterface {


    private static Repository instance;
    private final UserDAO userDAO;
    private final ProductDAO productDAO;
    private final ExecutorService executorService;
    private PropertyChangeSupport propertyChangeSupport;
    private List<Userinformation> listUserinformation = new ArrayList<>();
    private List<Product> listOfProducts = new ArrayList<>();
    private Handler mainThreadHandler;
    private Userinformation activUser; //kan saettes så de andre aktiviteter ved hvilke lister de skal vise

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
            List<Userinformation> list = userDAO.loadAllUsers();
            mainThreadHandler.post(() -> callbackUser(list));
        });
    }


    //public void setActivUser(Userinformation activUser) {
    //   this.activUser = activUser;
    // }

    //Menu CRUD
    public boolean insertNewUser(Userinformation newUser) {
        executorService.execute(() -> {
            userDAO.insert(newUser);
        });
        return true;
    }

    public boolean deleteUser(Userinformation userdelte) {
        boolean tjeck = false;
        for (int i = 0; i < listUserinformation.size(); i++) {
            if (listUserinformation.get(i).getFirstName().equals(userdelte.getFirstName()) && listUserinformation.get(i).getLastName().equals(userdelte.getLastName())) {
                tjeck = true;
                executorService.execute(() -> userDAO.delete(userdelte.getFirstName(), userdelte.getLastName()));
            }
        }
        return tjeck;
    }

    //property change listner

    public void addPropertyChangeListener(String name, PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(name, listener);
        switch (name) {
            case "eventUser":
                listener.propertyChange(new PropertyChangeEvent(this, "eventUser", null, listUserinformation));
                break;
            case "EventProduct":
                listener.propertyChange(new PropertyChangeEvent(this, "EventProductView", null, listOfProducts));
                break;
            case "EventProductPantry":
                listener.propertyChange(new PropertyChangeEvent(this, "EventProductPantry", null, listOfProducts));
                break;
            default:
                Log.d("call", "Der var en fejl i propertychangelistner");
                break;
        }
    }

    public List<Userinformation> getListUserinformation() {
        return listUserinformation;
    }

    public void callbackUser(List<Userinformation> list) {
        listUserinformation = list;
        propertyChangeSupport.firePropertyChange("eventUser", null, listUserinformation);
    }

    // Pantry Activ user
    @Override
    public Userinformation getActivUser() {
        return activUser;
    }


    // MyShoppingList CRUD

    public void loadProductsShoping() {
        executorService.execute(() -> {
                    List<Product> lists = productDAO.loadProductShopping();
                    mainThreadHandler.post(() -> callbackProduct(lists));
                }
        );
    }

    public boolean deleteProduct(String name, boolean inStock) {
        boolean tjeck = false;
        int productnumber = -1;
        for (int i = 0; i < listOfProducts.size(); i++) {
            if (listOfProducts.get(i).getName().equals(name) && listOfProducts.get(i).inStock == inStock) {
                tjeck = true;
                productnumber = i;
            }
        }
        if (tjeck) {
            int finalProductnumber = productnumber;
            executorService.execute(() -> {
                productDAO.deleteProduct(listOfProducts.get(finalProductnumber));
            });
        }
        return tjeck;
    }

    // Myshopping metoder
    public void callbackProduct(List<Product> list) {
        listOfProducts = list;
        propertyChangeSupport.firePropertyChange("EventProductPantry", null, listOfProducts);
        propertyChangeSupport.firePropertyChange("EventProduct", null, listOfProducts);
    }

    @Override
    public List<Product> getProducts() {
        return listOfProducts;
    }


    //Pantry metoder

    @Override
    public List<Product> getProductsPantry() {
        return listOfProducts;
    }

    //retunere alle hvor inPantry er True
    @Override
    public void loadProductsPantry() {
        executorService.execute(() -> {
            List<Product> list = productDAO.getAllInPantry();
            mainThreadHandler.post(() -> callbackProduct(list));
        });
    }

    //Kommer fra AddproductActivityVM
    @Override
    public boolean insertProductIntoLists(Product product) {
        executorService.execute(() ->
                productDAO.insertProduct(product)
        );
        return true;
    }
}
