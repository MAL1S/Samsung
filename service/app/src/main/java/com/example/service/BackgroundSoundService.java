package com.example.service;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class BackgroundSoundService extends Service {
    MediaPlayer player;
    Boolean isPlayedBefore = false;

    @Override
    public void onCreate() {
        super.onCreate();

        player = MediaPlayer.create(this, R.raw.music);
        player.setLooping(true);
        player.setVolume(100, 100);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (!isPlayedBefore) {
            player.seekTo(MainActivity.mediaPlayerCurrentPosition);
            isPlayedBefore = true;
        }
        player.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        MainActivity.mediaPlayerCurrentPosition = player.getCurrentPosition();
        isPlayedBefore = false;
        player.stop();
        player.release();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
