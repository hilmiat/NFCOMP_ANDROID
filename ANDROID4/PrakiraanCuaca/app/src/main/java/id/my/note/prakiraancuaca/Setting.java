package id.my.note.prakiraancuaca;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Setting extends AppCompatActivity {
    EditText txt_namakota;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        txt_namakota = (EditText) findViewById(R.id.txt_namakota);
    }

    public void simpanKota(View v){
        String kota = txt_namakota.getText().toString().trim();
        SharedPreferences.Editor editor  = getSharedPreferences("DATA",0).edit();
        editor.putString("NAMAKOTA",kota);
        editor.commit();
        Intent intent = new Intent(Setting.this,MainActivity.class);
        startActivity(intent);
    }
}
