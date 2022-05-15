package troels1.com.organisation.mypantry.localDatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import troels1.com.organisation.mypantry.localDatabase.DAO.InStockDAO;
import troels1.com.organisation.mypantry.localDatabase.DAO.MyListsDAO;
import troels1.com.organisation.mypantry.localDatabase.DAO.ProductDAO;
import troels1.com.organisation.mypantry.localDatabase.DAO.UserDAO;
import troels1.com.organisation.mypantry.localDatabase.Entity.InStock;
import troels1.com.organisation.mypantry.localDatabase.Entity.MyLists;
import troels1.com.organisation.mypantry.localDatabase.Entity.Product;
import troels1.com.organisation.mypantry.localDatabase.Entity.Userinformation;

@Database(entities = {Userinformation.class, Product.class, MyLists.class, InStock.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {

    private static UserDatabase instance;
    public abstract UserDAO userDAO();
    public abstract ProductDAO productDAO();
    public abstract MyListsDAO myListsDAO();
    public abstract InStockDAO inStockDAO();

    public static synchronized UserDatabase getInstance(Context context) {
        if(instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), UserDatabase.class, "Userinformation").fallbackToDestructiveMigration().build();
        }
        return instance;
    }
}
