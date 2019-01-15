package com.unicalc.guilhermealteia.unicalc;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RelativeLayout;

public class CalcActivity extends AppCompatActivity {

//    Intent intent;
    String value;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        //Oculta a barra de título do app
        getSupportActionBar().hide();
        setContentView(R.layout.activity_calc);

        ConstraintLayout constraintLayout = findViewById(R.id.constraintLayout);

        RelativeLayout relativeLayout = findViewById(R.id.relativeLayout);

        AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(1500);
        anim.setFillAfter(true);
        anim.setFillBefore(true);
        constraintLayout.startAnimation(anim);

//
//        anim = new AlphaAnimation(0.0f, 1.0f);
//        anim.setDuration(3000);
//        anim.setFillBefore(true);
//        relativeLayout.startAnimation(anim);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        intent = getIntent();
//        value = intent.getStringExtra("email");
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        waitTime(fab,1000);
//        Snackbar.make(fab, value, Snackbar.LENGTH_LONG).setAction("Action", null).show();
//
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
    }
}
