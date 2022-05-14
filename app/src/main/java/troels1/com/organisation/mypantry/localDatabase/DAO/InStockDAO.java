package troels1.com.organisation.mypantry.localDatabase.DAO;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import troels1.com.organisation.mypantry.localDatabase.Entity.InStock;
import troels1.com.organisation.mypantry.localDatabase.Entity.Product;

@Dao
public interface InStockDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertProduct(InStock inStock);

    @Delete
    public void deleteProduct(InStock inStock);

    @Query("Select * from InStock")
    public List<Product> loadAllProduct();

    @Query("DELETE from InStock where productID > 0")
    public void deleteAllProduct();

    @Query("select * from Product where name = :name")
    public List<InStock> loadspecificProduct(String name);
}
