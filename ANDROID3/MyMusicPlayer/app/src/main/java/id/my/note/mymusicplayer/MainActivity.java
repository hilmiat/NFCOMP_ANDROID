package id.my.note.mymusicplayer;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {
    private MediaPlayer mp;
    boolean isPlay = false;
    Button play;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mp = MediaPlayer.create(this,R.raw.music);
        //#1 buat obj tombol
        play = (Button) findViewById(R.id.play);
        //#2 register
        play.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        if(isPlay){
            mp.pause();
            isPlay = false;
            play.setText("PLAY");
        }else {
            mp.start();
            Log.i("MYPlayer", "Playing music..");
            isPlay = true;
            play.setText("PAUSE");
        }
    }
}
