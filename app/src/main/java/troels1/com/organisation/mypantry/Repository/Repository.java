package troels1.com.organisation.mypantry.Repository;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import androidx.core.os.HandlerCompat;
import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import troels1.com.organisation.mypantry.Repository.Interfaceses.MenuRepositoryIF;
import troels1.com.organisation.mypantry.localDatabase.UserDAO;
import troels1.com.organisation.mypantry.localDatabase.UserDatabase;
import troels1.com.organisation.mypantry.localDatabase.Userinformation;

public class Repository implements MenuRepositoryIF {

    private static Repository instance;
    private UserDAO dao;
    private ExecutorService executorService;
    private Handler mainThreadHandler;



    private Repository(Application application
    ) {
        UserDatabase userDatabase = UserDatabase.getInstance(application);
        dao = userDatabase.userDAO();
        executorService = Executors.newFixedThreadPool(2);
        mainThreadHandler = HandlerCompat.createAsync(Looper.getMainLooper());
    }

    public Repository getInstance(Application app) {
        if (instance == null) {
            instance = new Repository(app);
        }
        return instance;
    }


    // executable metoder
    public void loadAllUsers() {
        executorService.execute(() -> {
          LiveData<List<Userinformation>> result = dao.loadAllUsers();
          mainThreadHandler.post(() -> {callback.onComplete(result)});
        });
    }



}