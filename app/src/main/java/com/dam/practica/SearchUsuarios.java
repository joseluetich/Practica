package com.dam.practica;

import android.os.AsyncTask;

import java.util.List;

public class SearchUsuarios extends AsyncTask<String, Void, List<Usuario>> {

    private DaoUsuario daoUsuario;
    private OnUsuarioResultCallback callback;

    public SearchUsuarios(DaoUsuario daoUsuario, OnUsuarioResultCallback context) {
        this.daoUsuario = daoUsuario;
        this.callback = context;
    }

    @Override
    protected List<Usuario> doInBackground(String... strings) {
        List<Usuario> usuarios = daoUsuario.searchAll();
        return usuarios;
    }

    @Override
    protected void onPostExecute(List<Usuario> usuarios) {
        super.onPostExecute(usuarios);
        callback.onResult(usuarios);
    }
}