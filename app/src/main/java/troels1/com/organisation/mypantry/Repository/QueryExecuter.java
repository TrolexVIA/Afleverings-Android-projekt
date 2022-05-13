package troels1.com.organisation.mypantry.Repository;

import androidx.lifecycle.LiveData;
import java.util.List;
import java.util.concurrent.Executor;
import troels1.com.organisation.mypantry.localDatabase.UserDAO;
import troels1.com.organisation.mypantry.localDatabase.UserDatabase;
import troels1.com.organisation.mypantry.localDatabase.Userinformation;

public class QueryExecuter implements Executor, UserDAO {

    private UserDAO dao;
    private Repository repository;


    private QueryExecuter () {
        UserDatabase userDatabase = UserDatabase.getInstance(null); //siden den er instancieret af repository burde den ikke behoeve en app context
        dao = userDatabase.userDAO();
    }

    @Override
    public void execute(Runnable runnable) {

    }

    @Override
    public void insert(Userinformation user) {
    }

    @Override
    public LiveData<List<Userinformation>> loadAllUsers() {
        return null;
    }
}
