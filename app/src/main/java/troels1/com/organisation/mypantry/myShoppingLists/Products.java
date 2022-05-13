package troels1.com.organisation.mypantry.MyShoppingLists;

import java.util.ArrayList;

public class Products {
    private String name;

    private int iconId;

    Products (String name, int iconId) {
        this.name = name;
        this.iconId = iconId;
    }

    public Products(String hej) {
    }

    public String getName(){
        return name;
    }

    public int getIconId() {
        return iconId;
    }

}
