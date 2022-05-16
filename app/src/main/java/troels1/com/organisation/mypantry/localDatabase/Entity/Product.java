package troels1.com.organisation.mypantry.localDatabase.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.LocalDate;

@Entity
public class Product {

    @PrimaryKey(autoGenerate = true)
    public int productID;

    @ColumnInfo(name = "UserID")
    public int userID;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "numberOf")
    public int antal;

    @ColumnInfo(name = "desrciption")
    public String description;

    @ColumnInfo(name = "kategori")
    public String kategori;

    @ColumnInfo(name = "udloebsdato")
    public String udloebsdato;

    @ColumnInfo(name = "inStock")
    public Boolean inStock;

    @ColumnInfo(name = "inList")
    public Boolean inList;

    public Product(String name, String description, String kategori, String udloebsdato, Boolean inStock, Boolean inList, int antal) {
        this.name = name;
        this.kategori = kategori;
        this.udloebsdato = udloebsdato;
        this.description = description;
        this.inStock = inStock;
        this.inList = inList;
        this.antal = antal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getAntal() {
        return antal;
    }

    public void setAntal(int antal) {
        this.antal = antal;
    }

    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getUdloebsdato() {
        return udloebsdato;
    }

    public void setUdloebsdato(String udloebsdato) {
        this.udloebsdato = udloebsdato;
    }


    public Boolean getInStock() {
        return inStock;
    }

    public void setInStock(Boolean inStock) {
        this.inStock = inStock;
    }

    public Boolean getInList() {
        return inList;
    }

    public void setInList(Boolean inList) {
        this.inList = inList;
    }

}
