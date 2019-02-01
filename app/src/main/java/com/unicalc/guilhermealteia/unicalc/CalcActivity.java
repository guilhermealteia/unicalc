package com.unicalc.guilhermealteia.unicalc;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.unicalc.guilhermealteia.unicalc.common.Media;

public class CalcActivity extends AppCompatActivity {

//    Intent intent;
    String value;
    LinearLayout linearLayoutExame;
    ConstraintLayout constraintLayout;
    Button btSalvarNotas;
    EditText etP1;
    EditText etP2;
    EditText etExame;
    TextView tvmedia1;
    TextView tvmedia2;
    TextView tvmediaFinal;

    String universidade;
    String categoriaDeEnsino;
    Media media = new Media();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        universidade = Universidades.UNIP.toString();
        categoriaDeEnsino = CategoriasDeEnsino.GRADUACAO.toString();

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_calc);

        //Oculta a barra de título do app
//        getSupportActionBar().hide();

        linearLayoutExame = findViewById(R.id.linear_layout_exame);
        linearLayoutExame.setVisibility(View.GONE);

        constraintLayout = findViewById(R.id.constraintLayout);

        animarInicializacao(constraintLayout);

        btSalvarNotas = findViewById(R.id.bt_salvar_notas);
        etP1 = findViewById(R.id.et_p1);
        etP2 = findViewById(R.id.et_p2);
        etExame = findViewById(R.id.et_exame);
        tvmedia1 = findViewById(R.id.tv_media1);
        tvmedia2 = findViewById(R.id.tv_media2);
        tvmediaFinal = findViewById(R.id.tv_mediaFinal);

        etP1.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                return false;
            }
        });

        btSalvarNotas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Double notaP1 = !etP1.getText().toString().equals("") ? Double.parseDouble(etP1.getText().toString()) : 0.0;
                Double notaP2 = !etP2.getText().toString().equals("") ? Double.parseDouble(etP2.getText().toString()) : 0.0;
                Double notaExame = !etExame.getText().toString().equals("") ? Double.parseDouble(etExame.getText().toString()) : 0.0;

                Log.d("notaP1", notaP1.toString());

                media.setNotaP1(notaP1);
                media.setNotaP2(notaP2);
                media.setNotaExame(notaExame);

                toogleVisibilidadeExame(media);

                tvmedia1.setText(media.getNotaP1().toString());
                tvmedia2.setText(media.getNotaP2().toString());
                tvmediaFinal.setText(media.getMediaFinal().toString());
            }
        });
    }

    private void toogleVisibilidadeExame(Media media) {
        String etNotaP1 = etP1.getText().toString();
        String etNotaP2 = etP2.getText().toString();
        String exame = etExame.getText().toString();

        if(etNotaP1 != null && etNotaP2 != null //
         && etNotaP1.length() > 0 && etNotaP2.length() > 0//
                && media.getExame(universidade, categoriaDeEnsino)) {
            if(exame != null && exame.length() == 0 && linearLayoutExame.getVisibility() == View.GONE) {
                animarCampoExame(linearLayoutExame, "FADEIN");
            } else if(media.getExame(universidade, categoriaDeEnsino) && linearLayoutExame.getVisibility() == View.GONE){
                animarCampoExame(linearLayoutExame, "FADEIN");
            }
        } else {
            if (linearLayoutExame.getVisibility() == View.VISIBLE)
                animarCampoExame(linearLayoutExame, "FADEOUT");
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