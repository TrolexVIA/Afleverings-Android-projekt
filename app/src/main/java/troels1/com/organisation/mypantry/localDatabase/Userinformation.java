package troels1.com.organisation.mypantry.localDatabase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Userinformation {

    @PrimaryKey (autoGenerate = true)
    public int userID;

    @ColumnInfo(name = "first_name")
    public String firstName;

    @ColumnInfo(name = "last_name")
    public String lastName;

    public Userinformation (String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getuserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName() {
        this.lastName = lastName;
    }

    //her kan så tilføjese mere information når vi faar styr paa pantry siden
}
