package troels1.com.organisation.mypantry.localDatabase.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.LocalDate;

@Entity
public class InStock {

    @PrimaryKey(autoGenerate = true)
    public int productID;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "desrciption")
    public String description;

    @ColumnInfo(name = "kategori")
    public String kategori;

    @ColumnInfo(name = "udloebsdato")
    public LocalDate udloebsdato;


    @ColumnInfo
    public int maengde;

    public InStock(String name, String description, String kategori, LocalDate udloebsdato, int maengde) {
        this.name = name;
        this.kategori = kategori;
        this.udloebsdato = udloebsdato;
        this.description = description;
        this.maengde = maengde;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public LocalDate getUdloebsdato() {
        return udloebsdato;
    }

    public void setUdloebsdato(LocalDate udloebsdato) {
        this.udloebsdato = udloebsdato;
    }

    public int getMaengde() {
        return maengde;
    }

    public void setMaengde(int maengde) {
        this.maengde = maengde;
    }
}