package troels1.com.organisation.mypantry.myShoppingLists;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

import troels1.com.organisation.mypantry.localDatabase.Entity.Product;
import troels1.com.organisation.mypantry.repository.Repository;
import troels1.com.organisation.mypantry.repository.interfaces.MyShoppingListRepositoryInterface;

public class MyShoppingListActivityViewModel extends AndroidViewModel {

    private MyShoppingListRepositoryInterface repository;
    private PropertyChangeSupport propertyChangeSupport;
    private List<Product> list = new ArrayList<>();

    public MyShoppingListActivityViewModel(Application app) {
        super(app);
        repository = Repository.getInstance(app);
      //  repository.insertProduct(new Product("Fisk","lækker fisk", null, null,false,true));
        propertyChangeSupport = new PropertyChangeSupport(this);
        repository.addPropertyChangeListener("eventProduct", (PropertyChangeEvent evt) -> this.getProductListRepository());
    }

    //bliver ikke brugt endnu
 //   public void getInfo() {
  //      repository.getActivUser();
  //  }


    public void addPropertyChangeListener(String name, PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(name, listener);
        listener.propertyChange(new PropertyChangeEvent(this, "EventProductView", null, list));
    }

    public void loadProducts() {
       repository.loadProducts();
    }

    public void getProductListRepository() {
        list = repository.getProducts();
        propertyChangeSupport.firePropertyChange("EventProductView", null, list);
    }

    public List<Product> getProductList() {
        return list;
    }

    public void insertProduct(Product product) {
        repository.insertProduct(product);
    }
}

