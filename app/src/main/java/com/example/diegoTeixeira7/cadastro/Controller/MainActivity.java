package com.example.diegoTeixeira7.cadastro.Controller;


import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.diegoTeixeira7.cadastro.R;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class MainActivity extends AppCompatActivity {

    private Button btn;

    private CharSequence[] select_genre;
    private CharSequence[] select_occupation;
    private CharSequence[] select_country;
    private CharSequence[] select_pets;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.genreBtn);

        select_genre = new CharSequence[] {
            "Masculino", "Feminino", "Outro (Por favor especifique)", "Prefiro não dizer"
        };


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(MainActivity.this)
                        .setTitle("Seu gênero");

                builder.setSingleChoiceItems(select_genre, 0, new DialogInterface.OnClickListener() {
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

        select_occupation = new CharSequence[] {
                "Engenheiro", "Feminino", "França", "Nenhum"
        };

        select_country = new CharSequence[] {
                "EUA", "Rússia", "Pedreiro", "Prefiro não dizer"
        };

        select_pets = new CharSequence[] {
                "Cachorro", "Gato", "Pássaro", "Nenhum"
        };
    }
}