package troels1.com.organisation.mypantry;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class DatabasePlaceholder {

    private MutableLiveData<List<String>> holeList = new MutableLiveData<>();
    private List<String> list = new ArrayList<>();

    public DatabasePlaceholder() {
        //testdata der skal slettes senere
       // addToList("fiks");
       // addToList("henning");
       // addToList("motren");
       // addToList("smør");
        // ikke slettes bruges i singelton pattern
        holeList.setValue(list);
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
