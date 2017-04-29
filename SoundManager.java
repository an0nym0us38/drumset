package com.example.samyeo.drumset;

import android.content.Context;
import android.media.SoundPool;

/**
 * Created by Sam Yeo on 4/25/2017.
 */

public class SoundManager {

    private SoundPool pool;
    private Context context;

    public SoundManager(Context context){
        this.context = context;
        SoundPool.Builder builder = new SoundPool.Builder();
        builder.setMaxStreams(10);
        pool = builder.build();
    }

    public int addSound(int resourceID){
        return pool.load(context, resourceID, 1);
    }

    public void play(int soundID){
        pool.play(soundID, 1, 1, 1, 0, 1);
    }
}
