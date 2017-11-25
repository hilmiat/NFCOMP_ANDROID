package id.my.note.layoutdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

public class GridActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        //buat obj grid
        GridView gv = (GridView)findViewById(R.id.gridview1);
        gv.setAdapter(new ImageAdapter(this));
    }
}
