package troels1.com.organisation.mypantry.mainListVIew;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.AndroidViewModel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

import troels1.com.organisation.mypantry.localDatabase.Entity.Userinformation;
import troels1.com.organisation.mypantry.repository.Repository;
import troels1.com.organisation.mypantry.repository.interfaces.MenuRepositoryInterface;


public class MenuActivityViewModel extends AndroidViewModel {

    private MenuRepositoryInterface repositoryIF;
    private PropertyChangeSupport propertyChangeSupport;
    private List<Userinformation> list;

    public MenuActivityViewModel(Application app) {
        super(app);
        repositoryIF = Repository.getInstance(app);
        propertyChangeSupport = new PropertyChangeSupport(this);
        repositoryIF.addPropertyChangeListener("eventUser", (PropertyChangeEvent evt) -> this.updateList());
    }

    public void SendUserQuery() {
         repositoryIF.SendUserQuery();
    }

    private void updateList() {
       list =  repositoryIF.getListUserinformation();
        Log.d("call", "ViewModel: updateUserList " + list.size());
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
