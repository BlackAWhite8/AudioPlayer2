package com.example.audioplayer2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    MediaPlayer player1;
    Button btnPlay,btnPause,btnStop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlay = (Button) findViewById(R.id.play);
        btnPause = (Button) findViewById(R.id.pause);
        btnStop = (Button) findViewById(R.id.stop);

        player1 = MediaPlayer.create(this,R.raw.music);
        player1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer player1) {
                player1.stop();
                btnPause.setEnabled(false);
                btnStop.setEnabled(false);
                try {
                    player1.prepare();
                    player1.seekTo(0);
                    btnPlay.setEnabled(true);
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play: {
                player1.start();
                btnPlay.setEnabled(false);
                btnPause.setEnabled(true);
                btnStop.setEnabled(true);
                break;
            }
            case R.id.stop: {
                player1.stop();
                btnPause.setEnabled(false);
                btnStop.setEnabled(false);
                try {
                    player1.prepare();
                    player1.seekTo(0);
                    btnPlay.setEnabled(true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
            case R.id.pause: {
                player1.pause();
                btnPause.setEnabled(false);
                btnPlay.setEnabled(true);
                break;
            }
            case R.id.change: {
                Intent i = new Intent(MainActivity.this,SecMainActivity.class);
                startActivity(i);
            }
            default: {
                break;
            }
        }
    }
}