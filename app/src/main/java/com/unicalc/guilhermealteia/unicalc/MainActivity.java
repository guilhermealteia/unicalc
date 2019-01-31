package com.unicalc.guilhermealteia.unicalc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

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

        Spinner elvListaUniversidades = findViewById(R.id.lv_lista_universidades);

        List<String> universidades = new ArrayList<>();
        universidades.add("UNIP - UNIVERSIDADE PAULISTA");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, universidades);

        elvListaUniversidades.setAdapter(adapter);
    }
}
