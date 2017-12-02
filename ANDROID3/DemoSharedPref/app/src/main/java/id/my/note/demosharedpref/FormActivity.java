package id.my.note.demosharedpref;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FormActivity extends AppCompatActivity
        implements View.OnClickListener {
    private EditText form_username;
    private SharedPreferences setting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        form_username = (EditText)findViewById(R.id.form_username);

        //baca username dari penyimpanan
        setting = getSharedPreferences("MYDATA",0);
        String username = setting.getString("username",null);
        //cek ada username atau tdk,jika ada isi ke form
        if(username!=null){
            form_username.setText(username);
        }
        //jika tombol simpan ditekan, simpan data ke sharedpreference
        Button simpan = (Button)findViewById(R.id.tbl_simpan);
        simpan.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        //baca form
        String isian_username = form_username.getText().toString();
        //simpan data ke SP
        SharedPreferences.Editor editor = setting.edit();
        editor.putString("username",isian_username);
        editor.commit();
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}
