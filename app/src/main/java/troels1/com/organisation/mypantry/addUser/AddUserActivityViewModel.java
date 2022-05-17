package troels1.com.organisation.mypantry.addUser;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import java.util.ArrayList;

import troels1.com.organisation.mypantry.localDatabase.Entity.Userinformation;
import troels1.com.organisation.mypantry.repository.Repository;
import troels1.com.organisation.mypantry.repository.interfaces.AddUserRepositoryInterface;

public class AddUserActivityViewModel extends AndroidViewModel {

    private AddUserRepositoryInterface repository;

    public AddUserActivityViewModel(@NonNull Application application) {
        super(application);
        repository = Repository.getInstance(application);

    }

    public void addUserShopping(String name) {
        //konvertere string name til to strings: fornavn og efternavn
        char[] charArray = name.toCharArray();
        ArrayList<String> tempArray = new ArrayList<>();
        String temp = "";
        for (int i = 0; i < charArray.length; i++) {
            if (Character.isLetter(charArray[i]) || charArray[i] == '.') {
                temp += charArray[i];
            } else if (charArray[i] == ' ') {
                tempArray.add(temp);
                temp = "";
            }
            tempArray.add(temp);
        }
        String lastname = "";
        for (int i = 1; i < tempArray.size(); i++) {
            lastname += tempArray.get(i);
        }
        Userinformation newUser = new Userinformation(
                tempArray.get(0), lastname
        );
        repository.insertNewUser(newUser);
    }
}
