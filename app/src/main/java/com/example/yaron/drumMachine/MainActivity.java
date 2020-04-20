package com.example.yaron.drumMachine;

import android.media.AudioAttributes;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button hihat1, hihat2, clap, openhihat, snare1, snare2, kick1,kick2;
    private SoundPool soundPool;
    private int inthihat1, inthihat2, intclap, intopenhihat, intsnare1, intsnare2, intkick1, intkick2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AudioAttributes audioAttributes = new AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                .build();

        soundPool = new SoundPool.Builder()
                .setMaxStreams(8)
                .setAudioAttributes(audioAttributes)
                .build();

        inthihat1 = soundPool.load(this , R.raw.hihat1, 1);
        inthihat2 = soundPool.load(this , R.raw.hihat2, 1);
        intclap = soundPool.load(this , R.raw.clap, 1);
        intopenhihat = soundPool.load(this , R.raw.openhihat, 1);
        intsnare1 = soundPool.load(this , R.raw.snare1, 1);
        intsnare2 = soundPool.load(this , R.raw.snare2, 1);
        intkick1 = soundPool.load(this , R.raw.kick1, 1);
        intkick2 = soundPool.load(this , R.raw.kick2, 1);


        hihat1 = findViewById(R.id.hihat1);
        hihat2 = findViewById(R.id.hihat2);
        clap = findViewById(R.id.clap);
        openhihat = findViewById(R.id.openhihat);
        snare1 = findViewById(R.id.snare1);
        snare2 = findViewById(R.id.snare2);
        kick1 = findViewById(R.id.kick1);
        kick2 = findViewById(R.id.kick2);


        hihat1.setOnClickListener(this);
        hihat2.setOnClickListener(this);
        clap.setOnClickListener(this);
        openhihat.setOnClickListener(this);
        snare1.setOnClickListener(this);
        snare2.setOnClickListener(this);
        kick1.setOnClickListener(this);
        kick2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.hihat1:
                soundPool.play(inthihat1,1,1,0,0,1);
                break;

            case R.id.hihat2:
                soundPool.play(inthihat2,1,1,0,0,1);
                break;

            case R.id.clap:
                soundPool.play(intclap,1,1,0,0,1);
                break;

            case R.id.openhihat:
                soundPool.play(intopenhihat,1,1,0,0,1);
                break;

            case R.id.snare1:
                soundPool.play(intsnare1,1,1,0,0,1);
                break;

            case R.id.snare2:
                soundPool.play(intsnare2,1,1,0,0,1);
                break;

            case R.id.kick1:
                soundPool.play(intkick1,1,1,0,0,1);
                break;

            case R.id.kick2:
                soundPool.play(intkick2,1,1,0,0,1);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (soundPool != null){
            soundPool.release();
            soundPool = null;
        }
    }
}
