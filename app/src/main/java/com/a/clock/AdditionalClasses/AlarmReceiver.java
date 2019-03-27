package com.a.clock.AdditionalClasses;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.widget.Toast;

import java.io.IOException;

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "received", Toast.LENGTH_SHORT).show();
        final MediaPlayer ring = new MediaPlayer();
        try {
            ring.setDataSource(context, RingtoneManager.getActualDefaultRingtoneUri(context, RingtoneManager.TYPE_ALARM));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ring.setAudioStreamType(AudioManager.STREAM_ALARM);
        try {
            ring.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ring.start();
    }
}
