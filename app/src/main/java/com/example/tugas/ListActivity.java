package com.example.tugas;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class ListActivity extends AppCompatActivity {

    private ListView listViewMhs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_mhs);  // Menggunakan layout ListView

        // Inisialisasi ListView
        listViewMhs = findViewById(R.id.listview_mhs);

        // Buat adapter untuk menghubungkan data (array) dengan ListView
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.daftar_mhs, // Referensi ke string-array daftar mahasiswa
                android.R.layout.simple_list_item_1 // Layout untuk setiap item list
        );

        // Set adapter ke ListView
        listViewMhs.setAdapter(adapter);
    }
}
