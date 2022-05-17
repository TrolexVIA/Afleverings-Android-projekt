package troels1.com.organisation.mypantry.pantry;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

import troels1.com.organisation.mypantry.localDatabase.Entity.Product;
import troels1.com.organisation.mypantry.repository.Repository;
import troels1.com.organisation.mypantry.repository.interfaces.PantryRepositoryInterface;

public class PantryActivityViewModel extends AndroidViewModel {

    private PantryRepositoryInterface repository;
    private PropertyChangeSupport propertyChangeSupport;
    private List<Product> list = new ArrayList<>();

    public PantryActivityViewModel (Application app) {
        super(app);
        repository = Repository.getInstance(app);
        propertyChangeSupport = new PropertyChangeSupport(this);
        repository.addPropertyChangeListener("EventProductPantry", (PropertyChangeEvent evt) -> this.getProductPantryRepository());
    }


    public void addPropertyChangeListener(String name, PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(name, listener);
        listener.propertyChange(new PropertyChangeEvent(this, "EventProductPantryView", null, list));
    }

    public void getProductPantryRepository() {
        list = repository.getProductsPantry();
        propertyChangeSupport.firePropertyChange("EventProductPantryView", null, list);
    }

    public void loadProducts() {
        repository.loadProductsPantry();
    }

    public List<Product> getProductList() {
        return list;
    }
}
