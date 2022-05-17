package troels1.com.organisation.mypantry.repository.interfaces;

import java.beans.PropertyChangeListener;
import java.util.List;

import troels1.com.organisation.mypantry.localDatabase.Entity.Userinformation;

public interface UserAdapterRepositoryInterface {
    List<Userinformation> getListUserinformation();

    public void addPropertyChangeListener(String name, PropertyChangeListener listener);
}
