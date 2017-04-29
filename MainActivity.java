package com.example.samyeo.drumset;

import android.content.res.Configuration;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private SoundManager soundManager;
    private int african, alien, cymbal, gong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        soundManager = new SoundManager(this);
        african = soundManager.addSound(R.raw.african);
        alien = soundManager.addSound(R.raw.alien);
        cymbal = soundManager.addSound(R.raw.cymbal_1);
        gong = soundManager.addSound(R.raw.cymbal_2);

        int screenSize = getResources().getConfiguration().screenLayout;
    }

    public boolean onTouchEvent(MotionEvent event){
        if(event.getAction()!= MotionEvent.ACTION_UP){
            return super.onTouchEvent(event);
        }

        float x ,y ;

        x = event.getX() ;
        y = event.getY() ;
        System.out.println("X: "+x+" Y: "+y);
        //soundManager.play(african);
        soundManager.play(cymbal);

        return super.onTouchEvent(event);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            getMenuInflater().inflate(R.menu.menu_main, menu);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
