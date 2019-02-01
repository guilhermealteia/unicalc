package com.unicalc.guilhermealteia.unicalc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        //Oculta a barra de título do app
        getSupportActionBar().hide();

        RelativeLayout rlDetalhesCurso = findViewById(R.id.rl_detalhes_curso);
        rlDetalhesCurso.setVisibility(View.GONE);

        TextView tvWelcome = findViewById(R.id.tv_welcome);

        AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(3000);
        anim.setFillAfter(true);
        anim.setFillBefore(true);
        tvWelcome.startAnimation(anim);

        tvWelcome.setVisibility(View.GONE);
        rlDetalhesCurso.setVisibility(View.VISIBLE);

        Spinner spUniversidades = findViewById(R.id.sp_universidades);
        Spinner spCategoriasDeEnsino = findViewById(R.id.sp_categorias_de_ensino);

        List<String> universidades = new ArrayList<>();
        universidades.add("UNIP - Universidade Paulista");

        List<String> categoriasDeEnsino = new ArrayList<>();
        categoriasDeEnsino.add("Graduação");

        ArrayAdapter<String> adapterUniversidades = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, universidades);

        ArrayAdapter<String> adapterCategoriasDeEnsino = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, categoriasDeEnsino);

        spUniversidades.setAdapter(adapterUniversidades);
        spCategoriasDeEnsino.setAdapter(adapterCategoriasDeEnsino);
    }
}
