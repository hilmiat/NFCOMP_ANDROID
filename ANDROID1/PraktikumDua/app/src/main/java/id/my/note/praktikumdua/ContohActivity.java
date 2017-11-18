package id.my.note.praktikumdua;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

/**
 * Created by hilmiat on 18/11/17.
 */

public class ContohActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_contoh);

        Button tmbl = (Button)findViewById(R.id.button1);
        tmbl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(ContohActivity.this,
                        UtamaActivity.class);
                startActivity(in);
            }
        });
    }
}
