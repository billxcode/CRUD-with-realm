package id.technologue.com.learmrealm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnSimpan, btnTampil;
    EditText textNim, textNama;
    Integer sNim;
    String sNama;
    MahasiswaModel mahasiswaModel;
    RealmHelper realmHelper;
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSimpan = findViewById(R.id.btn_simpan);
        btnTampil = findViewById(R.id.btn_tampil);

        textNim = findViewById(R.id.nim_text);
        textNama = findViewById(R.id.nama_text);

        Realm.init(this);

        RealmConfiguration configuration = new RealmConfiguration.Builder()
                .name("mahasiswa.db")
                .schemaVersion(0)
                .build();

        Realm.setDefaultConfiguration(configuration);

        btnTampil.setOnClickListener(this);
        btnSimpan.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if (view == btnSimpan)
        {
            sNim = Integer.parseInt(textNim.getText().toString());
            sNama = textNama.getText().toString();

            if (sNim.equals("") || sNama.equals(""))
            {
                Toast.makeText(this, "Silahkan lengkapi form terlebih dahulu", Toast.LENGTH_SHORT).show();
            }else{
                mahasiswaModel = new MahasiswaModel();
                mahasiswaModel.setNim(sNim);
                mahasiswaModel.setNama(sNama);

                realmHelper = new RealmHelper(realm);
                realmHelper.save(mahasiswaModel);

                Toast.makeText(this, "Berhasil Menyimpan data", Toast.LENGTH_SHORT).show();

                textNim.setText("");
                textNama.setText("");
            }
        }
    }
}
