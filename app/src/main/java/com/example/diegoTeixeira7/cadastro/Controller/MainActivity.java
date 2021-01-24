package com.example.diegoTeixeira7.cadastro.Controller;


import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.diegoTeixeira7.cadastro.R;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class MainActivity extends AppCompatActivity {

    private Button btnGenre;
    private Button btnOccupation;
    private Button btnCountry;
    private Button btnPets;

    private CharSequence[] selectGenre;
    private CharSequence[] selectOccupation;
    private CharSequence[] selectCountry;
    private CharSequence[] selectPets;

    private boolean[] selectCountryItems;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGenre = findViewById(R.id.genreBtn);

        selectGenre = new CharSequence[] {
            "Masculino", "Feminino", "Outro", "Prefiro não dizer"
        };

        btnGenre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(MainActivity.this)
                        .setTitle("Seu gênero");

                builder.setSingleChoiceItems(selectGenre, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                builder.setNegativeButton("Sair", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                builder.show();
            }
        });

        btnOccupation = findViewById(R.id.occupationBtn);

        selectOccupation = new CharSequence[] {
                "Estudante", "Engenheiro(a)", "Médico(a)", "Arquieto(a)", "Eletricista", "Diarista", "Professor", "Outro"
        };

        btnOccupation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(MainActivity.this)
                        .setTitle("Sua Ocupação");

                builder.setSingleChoiceItems(selectOccupation, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                builder.setNegativeButton("Sair", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                builder.show();
            }
        });

        btnCountry = findViewById(R.id.countryBtn);

        selectCountry = new CharSequence[] {
                "EUA", "Rússia", "Argentina", "Canadá", "Irlanda", "Outro(s)", "Nenhum"
        };

        selectCountryItems = new boolean[]{
                false, false, false, false, false, false, false
        };

        btnCountry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(MainActivity.this)
                        .setTitle("Selecione os países que você já visitou");

                builder.setMultiChoiceItems(selectCountry, selectCountryItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                    }
                });

                builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                builder.setNegativeButton("Sair", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                builder.show();
            }
        });


        btnPets = findViewById(R.id.petsBtn);

        selectPets = new CharSequence[] {
                "Cachorro", "Gato", "Pássaro", "Outro", "Nenhum"
        };
    }
}