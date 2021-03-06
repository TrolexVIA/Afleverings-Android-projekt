package troels1.com.organisation.mypantry.addProducts;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import troels1.com.organisation.mypantry.localDatabase.Entity.Product;
import troels1.com.organisation.mypantry.repository.Repository;
import troels1.com.organisation.mypantry.repository.interfaces.AddProductInterface;

public class AddProductActivityViewModel extends AndroidViewModel {
    private AddProductInterface repository;

    public AddProductActivityViewModel(@NonNull Application application) {
        super(application);
        repository = Repository.getInstance(application);
    }

    public boolean addProductShopping(String name, String antal) {
        Product product = new Product(name, null, null, null, false, true, Integer.parseInt(antal));
       return repository.insertProductIntoLists(product);
    }

    public boolean addProductPantry(String name, String antal) {
        Product product = new Product(name, null, null, null, true, false, Integer.parseInt(antal));
       return repository.insertProductIntoLists(product);
    }

    public boolean deleteProduct(String name, String number, boolean inStock) {
       return repository.deleteProduct(name, inStock);
    }
}
