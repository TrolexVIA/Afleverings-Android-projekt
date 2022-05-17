package troels1.com.organisation.mypantry.repository.interfaces;

import java.beans.PropertyChangeListener;
import java.util.List;

import troels1.com.organisation.mypantry.localDatabase.Entity.Userinformation;

public interface MenuRepositoryInterface {
    
    public void addPropertyChangeListener(String name, PropertyChangeListener listener);

    public void SendUserQuery();

    public List<Userinformation> getListUserinformation();

    public void setActivUser(Userinformation activUser); //skal sættes op i menu
}
