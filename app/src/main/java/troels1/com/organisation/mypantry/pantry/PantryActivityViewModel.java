package troels1.com.organisation.mypantry.pantry;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

import troels1.com.organisation.mypantry.localDatabase.Entity.Product;
import troels1.com.organisation.mypantry.repository.Repository;
import troels1.com.organisation.mypantry.repository.interfaces.PantryRepositoryInterface;

public class PantryActivityViewModel extends AndroidViewModel {

    private PantryRepositoryInterface repository;
    private PropertyChangeSupport propertyChangeSupport;
    private List<Product> list;

    public PantryActivityViewModel (Application app) {
        super(app);
        repository = Repository.getInstance(app);
    }

    public void getActivUser(String list) {
        repository.getActivUser();
    }

    public void addPropertyChangeListener(String name, PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(name, listener);
        listener.propertyChange(new PropertyChangeEvent(this, "EventProductView", null, list));
    }

    public void loadProducts() {
    }

    public List<Product> getProductList() {
        return null;
    }
}
