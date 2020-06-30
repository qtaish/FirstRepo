package com.example.a3d_text;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ZoomControls;

public class MainActivity extends AppCompatActivity {
    TextView scaleGesture;
    ScaleGestureDetector scaleGestureDetector;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
        scaleGesture = (TextView)findViewById(R.id.article);
        scaleGesture.setText("this is some text");
        scaleGestureDetector = new ScaleGestureDetector(this, new ScaleGestureDetector.SimpleOnScaleGestureListener());
*/
        final TextView rotatingView = (TextView) findViewById(R.id.rotatingView);

        final ZoomControls simpleZoomControls = (ZoomControls) findViewById(R.id.simpleZoomControl); // initiate a ZoomControls
        final ZoomControls simpleZoomControls2 = (ZoomControls) findViewById(R.id.simpleZoomControl);

        final SeekBar seekBar_x;
        final SeekBar seekBar_y;
        final SeekBar seekBar_z;

        final TextView text_x = (TextView) findViewById(R.id.text_x);
        final TextView text_y = (TextView) findViewById(R.id.text_y);
        final TextView text_z = (TextView) findViewById(R.id.text_z);

        final int range = 120;

        seekBar_x = (SeekBar) findViewById(R.id.rotationX);
        seekBar_x.setMax(range);
        seekBar_x.setProgress(range/2);
        seekBar_x.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {





            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                // prevent seeking on app creation
                rotatingView.setRotationX((float)progress - range/2);
                text_x.setText("X = "+ (progress - range/2));
            }
        });



        seekBar_y = (SeekBar) findViewById(R.id.rotationY);
        seekBar_y.setMax(range);
        seekBar_y.setProgress(range/2);
        seekBar_y.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                // prevent seeking on app creation
                rotatingView.setRotationY((float)progress - range/2);
                text_y.setText("Y = "+ (progress - range/2));
            }
        });
        seekBar_z = (SeekBar) findViewById(R.id.rotationZ);
        seekBar_z.setMax(range);
        seekBar_z.setProgress(range/2);
        seekBar_z.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                // prevent seeking on app creation
                rotatingView.setRotation((float)progress - range/2);
                text_z.setText("Z = "+ (progress - range/2));
            }
        });


        final Button Btn_Clear = (Button) findViewById(R.id.button);
        Btn_Clear.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                seekBar_x.setProgress(range/2);
                seekBar_y.setProgress(range/2);
                seekBar_z.setProgress(range/2);

            }
        });


        

 // Zoooming Area


// perform  setOnZoomInClickListener event on ZoomControls
        simpleZoomControls.setOnZoomInClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// add zoom in code here
                // calculate current scale x and y value of ImageView
                float x = rotatingView.getScaleX();
                float y = rotatingView.getScaleY();
                // set increased value of scale x and y to perform zoom in functionality
                rotatingView.setScaleX((float) (x + 0.5));
                rotatingView.setScaleY((float) (y + 0.5));
                // display a toast to show Zoom In Message on Screen
                Toast.makeText(getApplicationContext(),"Zoom In",Toast.LENGTH_SHORT).show();
                // hide the ZoomControls from the screen

            }
        });



// perform  setOnZoomOutClickListener event on ZoomControls
        simpleZoomControls2.setOnZoomOutClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// add zoom out code here
                // calculate current scale x and y value of ImageView
                float x = rotatingView.getScaleX();
                float y = rotatingView.getScaleY();
                // set decreased value of scale x and y to perform zoom out functionality
                rotatingView.setScaleX((float) (x - 0.5));
                rotatingView.setScaleY((float) (y - 0.5));
                // display a toast to show Zoom Out Message on Screen
                Toast.makeText(getApplicationContext(),"Zoom Out",Toast.LENGTH_SHORT).show();
                // hide the ZoomControls from the screen


            }
        });
//=============================================================================

        // Zooming Area using Animation

        final Button Btn_ZoomOut = (Button) findViewById(R.id.button4);
        Btn_ZoomOut.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

//                Animation animZoomOut = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_out);
//                rotatingView.startAnimation(animZoomOut);

            }
        });



        final Button Btn_ZoomIn = (Button) findViewById(R.id.button5);
        Btn_ZoomIn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

//                Animation animZoomIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_in);
//                rotatingView.startAnimation(animZoomIn);


            }
        });

    }
}
