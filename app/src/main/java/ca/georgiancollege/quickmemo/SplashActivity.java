/*
 * Quick Memo
 * By: Blaine Parr, Richard Estrada and Cody Hutchinson
 * Date Last Edited: April 21, 2016
 * Last Edited By: Blaine Parr
 * Description: This class acts as a splash screen, displaying our splash image for 3 seconds then
 * disappearing and launching the MainActivity.
 */
package ca.georgiancollege.quickmemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;

public class SplashActivity extends AppCompatActivity {

    /*
     * This method shows the splash screen for 3 seconds upon creation then launches MainActivity.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_splash);

        Thread timerThread = new Thread() {
            public void run(){
                try{
                    sleep(3000);
                } //try ends
                catch(InterruptedException e){
                    e.printStackTrace();
                } //catch ends
                finally{
                    Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                    startActivity(intent);
                } //finally ends
            } //method run ends
        };
        timerThread.start();
    } //method onCreate ends

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        finish();
    } //method onPause ends

} //class SplashActivity ends
