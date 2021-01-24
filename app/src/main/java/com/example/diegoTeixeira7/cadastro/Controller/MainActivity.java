package com.example.diegoTeixeira7.cadastro.Controller;


import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.diegoTeixeira7.cadastro.R;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class MainActivity extends AppCompatActivity {

    private Button genreBtn;
    private Button occupationBtn;
    private Button countryBtn;
    private Button petsBtn;

    private CharSequence[] selectGenre;
    private CharSequence[] selectOccupation;
    private CharSequence[] selectCountry;
    private CharSequence[] selectPets;

    private boolean[] selectCountryItems;
    private boolean[] selectPetItems;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        genreBtn = findViewById(R.id.genreBtn);

        selectGenre = new CharSequence[] {
            "Masculino", "Feminino", "Outro", "Prefiro não dizer"
        };

        genreBtn.setOnClickListener(new View.OnClickListener() {
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

        occupationBtn = findViewById(R.id.occupationBtn);

        selectOccupation = new CharSequence[] {
                "Estudante", "Engenheiro(a)", "Médico(a)", "Arquieto(a)", "Eletricista", "Diarista", "Professor", "Outro"
        };

        occupationBtn.setOnClickListener(new View.OnClickListener() {
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

        countryBtn = findViewById(R.id.countryBtn);

        selectCountry = new CharSequence[] {
                "EUA", "Rússia", "Argentina", "Canadá", "Irlanda", "Outro(s)", "Nenhum"
        };

        selectCountryItems = new boolean[]{
                false, false, false, false, false, false, false
        };

        countryBtn.setOnClickListener(new View.OnClickListener() {
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


        petsBtn = findViewById(R.id.petsBtn);

        selectPets = new CharSequence[] {
                "Cachorro", "Gato", "Pássaro", "Outro(s)", "Nenhum"
        };

        selectPetItems = new boolean[]{
                false, false, false, false, false
        };

        petsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(MainActivity.this)
                        .setTitle("Selecione os pets que você possui em sua residência");

                builder.setMultiChoiceItems(selectPets, selectPetItems, new DialogInterface.OnMultiChoiceClickListener() {
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
    }
}