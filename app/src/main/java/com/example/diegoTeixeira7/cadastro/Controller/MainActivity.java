package com.example.diegoTeixeira7.cadastro.Controller;


import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.diegoTeixeira7.cadastro.Util.BancoDadosSingleton;
import com.example.diegoTeixeira7.cadastro.Util.ValidaCPF;
import com.example.diegoTeixeira7.cadastro.R;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;

import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity {

    private CharSequence[] selectGenre;
    private CharSequence[] selectOccupation;
    private CharSequence[] selectCountry;
    private CharSequence[] selectPets;

    private boolean[] selectCountryItems;
    private boolean[] selectPetItems;

    private int age;
    private String name;
    private String CPF;
    private String genre = "Masculino";
    private String occupation = "Estudante";
    private String countries = "";
    private String pets = "";

    private boolean[] confirm = new boolean[]{
        false, false, false, false
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // creates the genre choice dialogue
        Button genreBtn = findViewById(R.id.genreBtn);

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
                        genre = selectGenre[which].toString();
                    }
                });

                builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        confirm[0] = true;
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

        // creates the occupation choice dialogue
        Button occupationBtn = findViewById(R.id.occupationBtn);

        selectOccupation = new CharSequence[] {
                "Estudante", "Engenheiro(a)", "Médico(a)", "Arquiteto(a)", "Eletricista", "Diarista", "Professor", "Outro"
        };

        occupationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(MainActivity.this)
                        .setTitle("Sua Ocupação");

                builder.setSingleChoiceItems(selectOccupation, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        occupation = selectOccupation[which].toString();
                    }
                });

                builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        confirm[1] = true;
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

        // creates the country choice dialogue
        Button countryBtn = findViewById(R.id.countryBtn);

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
                        confirm[2] = true;
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

        // creates the pets choice dialogue
        Button petsBtn = findViewById(R.id.petsBtn);

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
                        confirm[3] = true;
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

    public void Cadastrar(View view) {
        TextInputEditText nameEdit = findViewById(R.id.nameEdit);
        TextInputEditText ageEdit = findViewById(R.id.ageEdit);
        TextInputEditText CPFEdit = findViewById(R.id.cpfEdit);

        name = nameEdit.getText().toString();
        CPF = CPFEdit.getText().toString();

        if (name.equals("") || ageEdit.getText().toString().equals("") || CPF.equals("")) {
            Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
        } else {
            name = name.trim().toLowerCase();
            try {
                age = parseInt((ageEdit.getText().toString()).replaceAll(" ", ""));

                if(age < 0 || age > 150) {
                    Toast.makeText(this, "Idade inválida!", Toast.LENGTH_SHORT).show();
                } else {
                    CPF = CPF.replaceAll("[^0-9]+", "");

                    if (ValidaCPF.isCPF(CPF)) {
                        //  Validating dialogs

                        if(!confirm[0]) {
                            Toast.makeText(this, "Por favor, confirme seu gênero!", Toast.LENGTH_SHORT).show();
                        } else {
                            if (!confirm[1]) {
                                Toast.makeText(this, "Por favor, confirme sua ocupação!", Toast.LENGTH_SHORT).show();
                            } else {
                                if (!confirm[2]) {
                                    Toast.makeText(this, "Por favor, selecione os países que já visitou!", Toast.LENGTH_SHORT).show();
                                } else {
                                    countries = "";

                                    for (int i = 0; i < selectCountryItems.length; i++) {
                                        if (selectCountryItems[i]) {
                                            if ((i == (selectCountryItems.length - 1)) && (countries.length() == 0)) {
                                                countries = selectCountry[i].toString();
                                            } else if (i != (selectCountryItems.length - 1)) {
                                                countries = (countries.length() > 0) ? countries + ", " + selectCountry[i] :
                                                        selectCountry[i].toString();
                                            }
                                        }
                                    }

                                    if (countries.length() == 0) {
                                        countries = "Nenhum";
                                    }

                                    if (!confirm[3]) {
                                        Toast.makeText(this, "Por favor, selecione os pets que possui!", Toast.LENGTH_SHORT).show();
                                    } else {
                                        pets = "";

                                        for (int i = 0; i < selectPetItems.length; i++) {
                                            if (selectPetItems[i]) {
                                                if ((i == (selectPetItems.length - 1)) && (pets.length() == 0)) {
                                                    pets = selectPets[i].toString();
                                                } else if (i != (selectPetItems.length - 1)) {
                                                    pets = (pets.length() > 0) ? pets + ", " + selectPets[i] :
                                                            selectPets[i].toString();
                                                }
                                            }
                                        }

                                        if (pets.length() == 0) {
                                            pets = "Nenhum";
                                        }

                                        // Function to check the data
                                        save();
                                    }
                                }
                            }
                        }

                    } else {
                        Toast.makeText(this, "Erro, CPF invalido", Toast.LENGTH_SHORT).show();
                    }
                }

            }catch (Exception e) {
                Toast.makeText(this, "Digite apenas número no campo idade", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void save() {
        // creates dialog to confirm data

        String data = "Nome: " + name + "\n" +
                "Idade: " + age + "\n" +
                "CPF: " + ValidaCPF.imprimeCPF(CPF) + "\n" +
                "Gênero: " + genre + "\n" +
                "Ocupação: " + occupation + "\n" +
                "Países já visitados: " + countries + "\n" +
                "Pets na residência: " + pets + "\n";

        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(MainActivity.this)
                .setTitle("Confirme seus dados")
                .setMessage(data);

        builder.setPositiveButton("Salvar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               saveBD();
            }
        });

        builder.setNegativeButton("Editar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.show();
    }

    private void saveBD() {
        // search the BD if there is a user with the registered cpf registered, if not registered

        Cursor c = BancoDadosSingleton.getInstance().buscar("Records", new String[]{"CPF"}, "CPF='"+CPF+"'", "");
        String register = "";
        while (c.moveToNext()) {
            int L = c.getColumnIndex("CPF");
            register = c.getString(L);
        }

        c.close();

        if(register.equals("")) {
            ContentValues valores = new ContentValues();
            valores.put("name", name);
            valores.put("age", age);
            valores.put("CPF", CPF);
            valores.put("genre", genre);
            valores.put("occupation", occupation);
            valores.put("countries", countries);
            valores.put("pets", pets);

            BancoDadosSingleton.getInstance().inserir("Records", valores);

            cleanVariables();
            Toast.makeText(this, "Cadastro realizado!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Erro, CPF já estava cadastrado!", Toast.LENGTH_LONG).show();
        }
    }

    private void cleanVariables() {
        name = "";
        age = -1;
        CPF = "";
        genre = "";
        occupation = "";
        countries = "";
        pets = "";

        TextInputEditText CPFEdit = findViewById(R.id.cpfEdit);
        TextInputEditText ageEdit = findViewById(R.id.ageEdit);
        TextInputEditText nameEdit = findViewById(R.id.nameEdit);

        CPFEdit.setText("");
        ageEdit.setText("");
        nameEdit.setText(name);

        confirm[0] = false;
        confirm[1] = false;
        confirm[2] = false;
        confirm[3] = false;

    }
}