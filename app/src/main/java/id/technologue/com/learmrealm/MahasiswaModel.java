package id.technologue.com.learmrealm;

import io.realm.RealmObject;

/**
 * Created by jauharibill on 8/14/2018.
 */

public class MahasiswaModel extends RealmObject {

    private Integer id, nim;
    private String nama;

    public void setId(Integer id)
    {
        this.id = id;
    }

    public void setNim(Integer nim)
    {
        this.nim = nim;
    }

    public void setNama(String nama)
    {
        this.nama = nama;
    }

    public Integer getId()
    {
        return id;
    }

    public Integer getNim()
    {
        return nim;
    }

    public String getNama()
    {
        return nama;
    }

}
