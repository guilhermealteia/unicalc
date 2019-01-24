package com.unicalc.guilhermealteia.unicalc;

import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

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

        //Instanciando o layout onde estao os campos de digitacao de notas
        LinearLayout linearLayoutInputNotas = findViewById(R.id.ll_input_notas);

        //Criando o linearLayout para abrigar o textView e editText do campo exame
        LinearLayout linearLayoutExame = new LinearLayout(this);
        linearLayoutExame.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        linearLayoutExame.setOrientation(LinearLayout.HORIZONTAL);

        //Criando o textView do exame
        TextView textViewExame = new TextView(this);
        textViewExame.setWidth(0);
        textViewExame.setHeight(30);
        textViewExame.setTypeface(null, Typeface.BOLD);
        textViewExame.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        textViewExame.setGravity(View.TEXT_ALIGNMENT_CENTER);
        textViewExame.setBackground(ContextCompat.getDrawable(this, R.drawable.tv_label_p1_p2_exame));
        textViewExame.setTextColor(getResources().getColor(R.color.colorWhite));
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                0, 30, 0.85f);
        lp.setMargins(3,3,0,0);
        textViewExame.setLayoutParams(lp);
        textViewExame.setText(R.string.tv_label_exame);

        EditText editTextExame = new EditText(this);
        LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(
                0, LinearLayout.LayoutParams.MATCH_PARENT, 0.15f);
        lp2.setMargins(0,3,3,3);
        editTextExame.setLayoutParams(lp2);
        editTextExame.setBackground(ContextCompat.getDrawable(this, R.drawable.tv_input_p1_p2_exame));
        editTextExame.setInputType(1);
        textViewExame.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        textViewExame.setHint(R.string.et_hint_input_nota);

        linearLayoutExame.addView(textViewExame);
        linearLayoutExame.addView(editTextExame);
        linearLayoutInputNotas.addView(linearLayoutExame);
        //Criando o editText do exame

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
