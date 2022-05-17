package troels1.com.organisation.mypantry.repository.interfaces;

import troels1.com.organisation.mypantry.localDatabase.Entity.Product;

public interface AddProductInterface {
    void insertProductIntoLists(Product product);

    boolean deleteProduct(String name);
}
