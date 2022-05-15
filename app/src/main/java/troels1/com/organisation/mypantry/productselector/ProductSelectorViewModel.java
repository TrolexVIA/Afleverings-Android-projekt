package troels1.com.organisation.mypantry.productselector;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

import troels1.com.organisation.mypantry.localDatabase.Entity.Userinformation;
import troels1.com.organisation.mypantry.repository.Repository;
import troels1.com.organisation.mypantry.repository.interfaces.MenuRepositoryInterface;

public class ProductSelectorViewModel extends AndroidViewModel {
    private MenuRepositoryInterface repositoryIF;
    private PropertyChangeSupport propertyChangeSupport;
    private List<Userinformation> list;

    public void MenuActivityViewModel(Application app) {

        repositoryIF = Repository.getInstance(app);
        propertyChangeSupport = new PropertyChangeSupport(this);
        repositoryIF.addPropertyChangeListener("eventUser", (PropertyChangeEvent evt) -> this.updateList());
    }

    public ProductSelectorViewModel(@NonNull Application application) {
        super(application);
    }

    public void SendUserQuery() {
        repositoryIF.SendUserQuery();
    }

    private void updateList() {
        list =  repositoryIF.getListUserinformation();
        Log.d("call", "updateList: viewmodel ");
        propertyChangeSupport.firePropertyChange("EventUserview", null, list);
    }

    public List<Userinformation> getUpdate() {
        return list;
    }

    public void addPropertyChangeListener(String name, PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(name, listener);
        listener.propertyChange(new PropertyChangeEvent(this, "EventUserview", null, list));
    }


}


