package id.my.note.layoutdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListArrayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listarray_layout);
        //buat obj listview
        ListView lv = (ListView) findViewById(R.id.listView1);
        //siapkan data
        List<String> data = new ArrayList<String>();
        for(int i = 0;i<50;i++){
            data.add("Data ke-"+i);
        }
        //set adapter
        ArrayAdapter aa = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                data);

        //isi adapter ke list
        lv.setAdapter(aa);
    }
}
