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
        setContentView(R.layout.list_mhs);


        listViewMhs = findViewById(R.id.listview_mhs);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.daftar_mhs,
                android.R.layout.simple_list_item_1
        );


        listViewMhs.setAdapter(adapter);
    }
}
