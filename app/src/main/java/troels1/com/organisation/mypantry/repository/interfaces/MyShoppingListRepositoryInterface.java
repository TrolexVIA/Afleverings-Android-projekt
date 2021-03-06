package troels1.com.organisation.mypantry.repository.interfaces;

import java.beans.PropertyChangeListener;
import java.util.List;

import troels1.com.organisation.mypantry.localDatabase.Entity.Product;
import troels1.com.organisation.mypantry.localDatabase.Entity.Userinformation;

public interface MyShoppingListRepositoryInterface {

    public Userinformation getActivUser();

    public void addPropertyChangeListener(String name, PropertyChangeListener listener);

    List<Product> getProducts();

    void loadProductsShoping();


}
