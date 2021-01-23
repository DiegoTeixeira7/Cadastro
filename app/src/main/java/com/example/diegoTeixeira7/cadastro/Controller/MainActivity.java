package com.example.diegoTeixeira7.cadastro.Controller;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;
import com.example.diegoTeixeira7.cadastro.R;
import com.example.diegoTeixeira7.cadastro.Util.MyAdapter;
import com.example.diegoTeixeira7.cadastro.Util.StateSpinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    final String[] select_genre = {
            "Selecione seu gênero", "Masculino", "Feminino", "Outro (Por favor especifique)", "Prefiro não dizer"};

    final String[] select_ocupation = {
            "Selecione sua ocupação", "Engenheiro", "Arquiteto", "Pedreiro", "Prefiro não dizer"};

    final String[] select_country = {
            "Selecione os países que você já visitou", "EUA", "Rússia", "França", "Nenhum"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner) findViewById(R.id.countrySpn);

        ArrayList<StateSpinner> listCountry = new ArrayList<>();

        for (int i = 0; i < select_country.length; i++) {
            StateSpinner stateSpnCountry = new StateSpinner();
            stateSpnCountry.setTitle(select_country[i]);
            stateSpnCountry.setSelected(false);
            listCountry.add(stateSpnCountry);
        }

        MyAdapter myAdapter = new MyAdapter(MainActivity.this, 0,
                listCountry);
        spinner.setAdapter(myAdapter);
    }

}