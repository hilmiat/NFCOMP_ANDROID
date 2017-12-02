package id.my.note.demosharedpref;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //baca username dari penyimpanan
        SharedPreferences setting = getSharedPreferences("MYDATA",0);
        String username = setting.getString("username",null);
        //cek ada username atau tdk, jika belum ada isi(pindah ke form)
        if(username==null){
            //pindah ke form untuk isi data
            pindahKeForm();
        }else{
            //tampilkan username
            TextView txt_username = (TextView) findViewById(R.id.username);
            txt_username.setText(username);
        }
        Button edit = (Button)findViewById(R.id.tbl_edit);
        edit.setOnClickListener(this);
    }

    private void pindahKeForm() {
        Intent i = new Intent(this,FormActivity.class);
        startActivity(i);
    }

    @Override
    public void onClick(View view) {
        pindahKeForm();
    }
}
