package troels1.com.organisation.mypantry.myShoppingLists;

import java.util.ArrayList;

public class Products {
    private String name;

    private int iconId;

   public Products (String name, int iconId) {
        this.name = name;
        this.iconId = iconId;
    }

    public Products(String hej) {
       this.name = hej;
    }

    public String getName(){
        return name;
    }

    public int getIconId() {
        return iconId;
    }

}
