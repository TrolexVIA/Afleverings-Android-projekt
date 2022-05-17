package troels1.com.organisation.mypantry.repository.interfaces;

import troels1.com.organisation.mypantry.localDatabase.Entity.Userinformation;

public interface AddUserRepositoryInterface {

    boolean insertNewUser(Userinformation newUser);

    boolean deleteUser(Userinformation deleteuser);
}
