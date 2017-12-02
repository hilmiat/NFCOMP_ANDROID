package id.my.note.demolistener;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Handle with anonymous inner class
        //#1 hubungkan antara layout dgn obj
        Button tbl3 = (Button)findViewById(R.id.tbl3);
        //#2 hubungkan antara listener dgn handler
        tbl3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //#3 handle click
                Log.i("My Log","Tombol 3 ditekan");
            }
        });

        //Handle dgn activity
        //#1 hubungkan antara layout dgn obj
        Button tbl4 = (Button)findViewById(R.id.tbl4);
        //#2 hubungkan listener dgn handler
        tbl4.setOnClickListener(this);

        tbl4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Log.i("My Log","Tombol 4 ditekan lama");
                return true;
            }
        });
     

    }
    public void handleClick(View v){
        //handle click event
        Button tombol = (Button) v;
        Log.i("My Log","Tombol "
                +tombol.getText()
                +" ditekan..");
    }

    @Override
    public void onClick(View view) {
        //#3 handle click
        Log.i("My Log","Tombom 4 ditekan");
    }
}
