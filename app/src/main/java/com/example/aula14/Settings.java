package com.example.aula14;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Settings extends AppCompatActivity {

    Button buttonSalvar;
    Button buttonVoltar;

    EditText editTextNome;
    EditText editTextSobreNome;
    EditText editTextIdade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        buttonSalvar = findViewById(R.id.buttonSalvar);
        buttonVoltar = findViewById(R.id.buttonVoltar);

        editTextNome = findViewById(R.id.editTextNome);
        editTextSobreNome = findViewById(R.id.editTextSobreNome);
        editTextIdade = findViewById(R.id.editTextIdade);

        buttonVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentConfig = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intentConfig);
            }
        });

        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = editTextNome.getText().toString();
                String sobrenome = editTextSobreNome.getText().toString();
                String idade = editTextIdade.getText().toString();

                SharedPreferences sharedPref = getSharedPreferences(getString(R.string.preferenc_file_key), Context.MODE_PRIVATE);

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("nome", nome);
                editor.putString("sobrenome", sobrenome);
                editor.putString("idade", idade);
                editor.commit();
            }
        });
    }
}