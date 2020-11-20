package com.dam.practica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity4 extends AppCompatActivity {

    private RecyclerView nombresRecyclerView;
    private RecyclerView.Adapter listAdapter;
    private RecyclerView.LayoutManager listLayoutManager;
    UsuarioRepository repository;
    ArrayList<String> nombres = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        nombresRecyclerView = findViewById(R.id.nombresRecyclerView);
        nombresRecyclerView.setHasFixedSize(true);

        listLayoutManager = new LinearLayoutManager(this);
        nombresRecyclerView.setLayoutManager(listLayoutManager);

        List<Usuario> usuarios = repository.searchAll();

        for(Usuario u: usuarios)
            nombres.add(u.getNombre());

        listAdapter = new UsuariosListAdapter(nombres,this);
        nombresRecyclerView.setAdapter(listAdapter);

    }
}