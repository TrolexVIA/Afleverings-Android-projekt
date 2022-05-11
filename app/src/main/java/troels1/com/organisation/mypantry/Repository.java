package troels1.com.organisation.mypantry;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class Repository {

    private static Repository instance;
    private DatabasePlaceholder database;

    private Repository (
    ) {
        database = new DatabasePlaceholder(); //midlertidig skal slettes
    }

    public static Repository getInstance() {
        if (instance == null) {
            instance = new Repository();
        }
        return instance;
    }


    public LiveData<List<String>> getListInfo() {
         return database.getListInfo();
    }

    public boolean addToList(String text) {
        return database.addToList(text);
    }
}