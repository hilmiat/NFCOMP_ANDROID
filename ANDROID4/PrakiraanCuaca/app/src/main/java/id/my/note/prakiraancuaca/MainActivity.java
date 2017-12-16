package id.my.note.prakiraancuaca;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    CuacaService cuacaService;
    TextView txtkota,txttemp,txtwind,txtcloud,txtpress,txthumid;
    ImageView icon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtkota = (TextView)findViewById(R.id.txt_kota);
        txttemp = (TextView)findViewById(R.id.txt_temp);
        txtwind = (TextView)findViewById(R.id.txt_wind);
        txtcloud = (TextView)findViewById(R.id.txt_cloud);
        txtpress = (TextView)findViewById(R.id.txt_press);
        txthumid = (TextView)findViewById(R.id.txt_humid);

        icon = (ImageView) findViewById(R.id.img_cuaca);

        String nama_kota = getSharedPreferences("DATA",0).getString("NAMAKOTA","Depok");

        cuacaService = APIClient.getClient().create(CuacaService.class);
        Call call = cuacaService.getCuaca(nama_kota);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                //jika dapat respon dari server
                Log.i("MyLog","KOta: "+((Cuaca)response.body()).getName());
                Cuaca cuaca_sekarang = (Cuaca) response.body();
                txtkota.setText(cuaca_sekarang.getName());
                txttemp.setText(cuaca_sekarang.getMain().getTemp()+" C");
                txtwind.setText(cuaca_sekarang.getWeather()[0].getDescription());
                txtcloud.setText(cuaca_sekarang.getClouds().getAll()+"");
                txtpress.setText(cuaca_sekarang.getMain().getPressure()+"");
                txthumid.setText(cuaca_sekarang.getMain().getHumidity()+"");
                Picasso.with(getApplicationContext())
                        .load("http://openweathermap.org/img/w/"
                                +cuaca_sekarang.getWeather()[0].getIcon()+".png")
                        .into(icon);
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                //jika gagal
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.setting){
            Intent i = new Intent(MainActivity.this,Setting.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}
