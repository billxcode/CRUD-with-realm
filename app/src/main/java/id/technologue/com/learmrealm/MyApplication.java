package id.technologue.com.learmrealm;

import android.app.Application;
import android.os.Bundle;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by jauharibill on 8/15/2018.
 */

public class MyApplication extends Application {

    public void onCreate()
    {
        super.onCreate();

        Realm.init(this);

        RealmConfiguration configuration = new RealmConfiguration.Builder()
                .name("mahasiswa.db")
                .schemaVersion(0)
                .build();

        Realm.setDefaultConfiguration(configuration);
    }
}
