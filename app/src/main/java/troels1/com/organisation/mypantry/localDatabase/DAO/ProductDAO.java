package troels1.com.organisation.mypantry.localDatabase.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import troels1.com.organisation.mypantry.localDatabase.Entity.Product;
import troels1.com.organisation.mypantry.localDatabase.Entity.Userinformation;

@Dao
public interface ProductDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertProduct(Product product);

    @Delete
    public void deleteProduct(Product product);

    @Query("Select * from Product")
    public List<Product> loadAllProduct();

    @Query("DELETE from Product where productID > 0")
    public void deleteAllProduct();

    @Query("select * from Product where name = :name")
    public List<Product> loadspecificProduct(String name);

    @Query("Select * from Product where inStock = 1")
    public List<Product> getAllInPantry();
}
