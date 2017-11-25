package id.my.note.layoutdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.layout_frame);

//        RelativeLayout rl = new RelativeLayout(this);
//        TextView tv = new TextView(this);
//        RelativeLayout.LayoutParams tvParams = new RelativeLayout.LayoutParams(
//                RelativeLayout.LayoutParams.WRAP_CONTENT,
//                RelativeLayout.LayoutParams.WRAP_CONTENT
//        );
//        tvParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
//        tv.setText("Assalamualaikum");
//        rl.addView(tv,tvParams);
//        setContentView(rl);

//          setContentView(R.layout.main);
//          TextView tv = findViewById(R.id.textView3);
//          tv.setText("Assalamualaikum");
        setContentView(R.layout.listview_layout);

    }
}
