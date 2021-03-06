package troels1.com.organisation.mypantry.localDatabase.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import troels1.com.organisation.mypantry.localDatabase.Entity.Userinformation;

@Dao
public interface UserDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insert(Userinformation user);

    @Query("delete from Userinformation where first_name = :firstname and last_name = :lastname")
    public void delete(String firstname, String lastname);

    @Query("Select * from Userinformation")
    public List<Userinformation> loadAllUsers();

    @Query("DELETE from Userinformation where userID > 0")
    public void deleteAll();

    @Query("select * from Userinformation where userID > 0")
    public List<Userinformation> loadspecificUser();

}
