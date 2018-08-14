package id.technologue.com.learmrealm;

import android.util.Log;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by jauharibill on 8/14/2018.
 */

public class RealmHelper {

    Realm realm;

    public RealmHelper(Realm realm) {
        this.realm = realm;
    }

    public void save(final MahasiswaModel mahasiswaModel)
    {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                if (realm != null)
                {
                    Log.d("Created", "database was created");
                    Number curretnIdNum = realm.where(MahasiswaModel.class).max("id");
                    int nextId;
                    if (curretnIdNum == null){
                        nextId = 1;
                    }else{
                        nextId = curretnIdNum.intValue() + 1;
                    }

                    mahasiswaModel.setId(nextId);
                    MahasiswaModel model = realm.copyToRealm(mahasiswaModel);
                }else{
                    Log.d("pppp", "database not execute");
                }
            }
        });
    }


    public List<MahasiswaModel> getAllMahasiswa()
    {
        RealmResults<MahasiswaModel> results = realm.where(MahasiswaModel.class).findAll();
        return results;
    }

    public void update(final Integer id, final Integer nim, final String nama)
    {
        realm.executeTransactionAsync(new Realm.Transaction(){

            public void execute(Realm realm)
            {
                MahasiswaModel mahasiswaModel = realm.where(MahasiswaModel.class)
                        .equalTo("id", id)
                        .findFirst();
                mahasiswaModel.setNim(nim);
                mahasiswaModel.setNama(nama);

            }
        }, new Realm.Transaction.OnSuccess(){

            @Override
            public void onSuccess() {
                Log.d("Success", "success update");
            }
        }, new Realm.Transaction.OnError(){

            @Override
            public void onError(Throwable error) {
                Log.d("error", "failed to update");
            }
        });
    }

    public void delete(Integer id)
    {
        final RealmResults<MahasiswaModel> model = realm.where(MahasiswaModel.class)
                .equalTo("id", id)
                .findAll();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                model.deleteAllFromRealm();
            }
        });
    }
}
