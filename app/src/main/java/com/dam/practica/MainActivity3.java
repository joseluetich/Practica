package com.dam.practica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity implements UsuarioRepository.OnResultCallback {

    TextView nombreTextView;
    Button agregarButton;
    UsuarioRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        nombreTextView = findViewById(R.id.nombreTextView);
        agregarButton = findViewById(R.id.agregarButton);

        repository = new UsuarioRepository(this.getApplication(),this);

        Intent i2 = new Intent(this, MainActivity4.class);

        agregarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Usuario usuario = new Usuario();
                usuario.setNombre(nombreTextView.getText().toString());

                repository.insert(usuario);

                startActivity(i2);
            }
        });

    }

    @Override
    public void onResult(List result) {

    }

    @Override
    public void onInsert() {

    }
}