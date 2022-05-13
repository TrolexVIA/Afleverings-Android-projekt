package troels1.com.organisation.mypantry.localDatabase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insert(Userinformation user);

    @Query("Select * from Userinformation")
    public LiveData<List<Userinformation>> loadAllUsers();

}
