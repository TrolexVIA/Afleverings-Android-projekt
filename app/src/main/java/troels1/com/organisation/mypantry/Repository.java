package troels1.com.organisation.mypantry;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class Repository {

    private static Repository instance;
    //midlertidigt arrayliste for at have noget at vise i lister indtil backend kommer på plads
    private MutableLiveData<List<String>> holeList = new MutableLiveData<>();
    private List<String> list = new ArrayList<>();

    private Repository() {
        holeList.setValue(list);
    }


    public static Repository getInstance() {
     if (instance == null) {
         instance = new Repository();
     }
        return instance;
    }


    public LiveData<List<String>> getListInfo() {
        return holeList;
    }

    public boolean addToList(String text) {
        List<String> templist = holeList.getValue();
        templist.add(text);
        holeList.setValue(templist);
        return true;
    } //return en boolean for at kunne lave en toeast

}