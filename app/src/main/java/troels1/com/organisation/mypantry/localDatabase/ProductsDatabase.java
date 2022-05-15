package troels1.com.organisation.mypantry.localDatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import troels1.com.organisation.mypantry.localDatabase.DAO.ProductDAO;
import troels1.com.organisation.mypantry.localDatabase.DAO.UserDAO;
import troels1.com.organisation.mypantry.localDatabase.Entity.Product;
import troels1.com.organisation.mypantry.localDatabase.Entity.Userinformation;

@Database(entities = {Product.class}, version = 1)
public abstract class ProductsDatabase extends RoomDatabase {

    private static ProductsDatabase instance;
    public abstract ProductDAO productDAO();

    public static synchronized ProductsDatabase getInstance(Context context) {
        if(instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), ProductsDatabase.class, "ProductsDatabase").fallbackToDestructiveMigration().build();
        }
        return instance;
    }
}
