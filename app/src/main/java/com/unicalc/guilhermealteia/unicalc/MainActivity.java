package com.unicalc.guilhermealteia.unicalc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
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
        final Spinner spUniversidades = findViewById(R.id.sp_universidades);
        final Spinner spCategoriasDeEnsino = findViewById(R.id.sp_categorias_de_ensino);
        Button btSalvarMain = findViewById(R.id.bt_salvar_main);


        AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(3000);
        anim.setFillAfter(true);
        anim.setFillBefore(true);
        tvWelcome.startAnimation(anim);

        tvWelcome.setVisibility(View.GONE);
        rlDetalhesCurso.setVisibility(View.VISIBLE);


        List<String> universidades = new ArrayList<>();

        for(Universidades s : Universidades.values()){
            universidades.add(s.toString());
        }

        List<String> categoriasDeEnsino = new ArrayList<>();

        for(CategoriasDeEnsino t : CategoriasDeEnsino.values()){
            categoriasDeEnsino.add(t.toString());
        }

        ArrayAdapter<String> adapterUniversidades = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, universidades);

        ArrayAdapter<String> adapterCategoriasDeEnsino = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, categoriasDeEnsino);

        spUniversidades.setAdapter(adapterUniversidades);
        spCategoriasDeEnsino.setAdapter(adapterCategoriasDeEnsino);

        btSalvarMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, CalcActivity.class);
                myIntent.putExtra("universidade", spUniversidades.getSelectedItem().toString());
                myIntent.putExtra("categoriaDeEnsino", spCategoriasDeEnsino.getSelectedItem().toString());
                MainActivity.this.startActivity(myIntent);
            }
        });
    }
}
