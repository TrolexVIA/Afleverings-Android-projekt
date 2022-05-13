package troels1.com.organisation.mypantry.localDatabase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insert(Userinformation user);

    @Delete
    public void delete(Userinformation user);

    @Query("Select * from Userinformation")
    public List<Userinformation> loadAllUsers();

    @Query("DELETE from Userinformation where userID > 0")
    public void deleteAll();

    @Query("select * from Userinformation where userID > 0")
    public List<Userinformation> loadspecificUser();

    @Query("Delete from Userinformation where userID >= 0")
    public void delteAllother();

}
