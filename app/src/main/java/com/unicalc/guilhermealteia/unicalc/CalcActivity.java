package com.unicalc.guilhermealteia.unicalc;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class CalcActivity extends AppCompatActivity {

//    Intent intent;
    String value;
    LinearLayout linearLayoutExame;
    ConstraintLayout constraintLayout;
    Button btSalvarNotas;
    EditText etP1;
    EditText etP2;
    EditText etExame;

    String universidade;
    String tipoDeCurso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        universidade = Universidades.UNIP.toString();
        tipoDeCurso = TiposDeCurso.GRADUACAO.toString();

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        //Oculta a barra de título do app
        getSupportActionBar().hide();

        setContentView(R.layout.activity_calc);
        linearLayoutExame = findViewById(R.id.linear_layout_exame);
        linearLayoutExame.setVisibility(View.GONE);

        constraintLayout = findViewById(R.id.constraintLayout);

        animarInicializacao(constraintLayout);

        btSalvarNotas = findViewById(R.id.bt_salvar_notas);
        etP1 = findViewById(R.id.et_p1);
        etP2 = findViewById(R.id.et_p2);
        etExame = findViewById(R.id.et_exame);

        btSalvarNotas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toogleVisibilidadeExame();
            }
        });
    }

    private void toogleVisibilidadeExame() {
        String notaP1 = etP1.getText().toString();
        String notaP2 = etP2.getText().toString();
        String exame = etExame.getText().toString();

        if(notaP1 != null && notaP2 != null //
         && notaP1.length() > 0 && notaP2.length() > 0//
                && isExameNeeded(notaP1, notaP2)) {
            if(exame != null && exame.length() == 0 && linearLayoutExame.getVisibility() == View.GONE)
                animarCampoExame(linearLayoutExame, "FADEIN");
        } else {
            if (linearLayoutExame.getVisibility() == View.VISIBLE)
                animarCampoExame(linearLayoutExame, "FADEOUT");
        }
    }

    private boolean isExameNeeded(String notaP1, String notaP2) {
        if (universidade.equals(Universidades.UNIP.toString())) {
            return ((Double.parseDouble(notaP1) + Double.parseDouble(notaP2)) / 2 < 7);
        } else {
            return ((Double.parseDouble(notaP1) + Double.parseDouble(notaP2)) / 2 < 6);
        }
    }

    private void animarInicializacao(ConstraintLayout constraintLayout) {
        AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(2500);
        anim.setFillAfter(true);
        anim.setFillBefore(true);
        constraintLayout.startAnimation(anim);
    }

    public void animarCampoExame(LinearLayout linearLayoutExame, String fadeMode){
        final LinearLayout layout = linearLayoutExame;

        if("FADEIN".equals(fadeMode)){
            AlphaAnimation fadeOut = new AlphaAnimation(0.0f, 1.0f);
            fadeOut.setDuration(1000);
            fadeOut.setFillBefore(true);
            fadeOut.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    layout.setVisibility(View.VISIBLE);
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                }
            });
            linearLayoutExame.startAnimation(fadeOut);

        } else if("FADEOUT".equals(fadeMode)){
            AlphaAnimation fadeIn = new AlphaAnimation(1.0f, 0.0f);
            fadeIn.setDuration(1000);
            fadeIn.setFillBefore(true);
            fadeIn.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    layout.setVisibility(View.GONE);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            linearLayoutExame.startAnimation(fadeIn);

        }
    }
}