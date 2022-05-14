package troels1.com.organisation.mypantry.localDatabase.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import troels1.com.organisation.mypantry.localDatabase.Entity.MyLists;
import troels1.com.organisation.mypantry.localDatabase.Entity.Product;

@Dao
public interface MyListsDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertProduct(MyLists myLists);

    @Delete
    public void deleteProduct(MyLists myLists);

    @Query("Select * from MyLists")
    public List<MyLists> loadAllProduct();

    @Query("DELETE from MyLists where productID > 0")
    public void deleteAllProduct();

    @Query("select * from MyLists where name = :name")
    public List<MyLists> loadspecificProduct(String name);


}
