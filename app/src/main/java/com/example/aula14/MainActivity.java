package com.example.aula14;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Button buttonConfig;
    EditText textNome;
    EditText textSobreNome;
    EditText textIdade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonConfig = findViewById(R.id.buttonConfig);

        textNome = findViewById(R.id.textNome);
        textSobreNome = findViewById(R.id.textSobreNome);
        textIdade = findViewById(R.id.textIdade);

        buttonConfig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentConfig = new Intent(getApplicationContext(), Settings.class);
                startActivity(intentConfig);
            }
        });

        recuperarDados();
    }

    private void recuperarDados() {
        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.preferenc_file_key), Context.MODE_PRIVATE);

        String nome = sharedPref.getString("nome", "");
        String sobrenome = sharedPref.getString("sobrenome", "");
        String idade = sharedPref.getString("idade", "");

        textNome.setText("Nome: " + nome);
        textSobreNome.setText("Sobrenome: " + sobrenome);
        textIdade.setText("Idade: " + idade);
    }
}