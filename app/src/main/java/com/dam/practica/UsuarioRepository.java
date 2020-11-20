package com.dam.practica;

import android.app.Application;
import android.util.Log;

import java.util.List;

public class UsuarioRepository implements OnUsuarioResultCallback {
    private DaoUsuario daoUsuario;
    //private PlateOrderRelationDAO plateOrderRelationDAO;
    private OnResultCallback callback;

    public UsuarioRepository(Application application, OnResultCallback context){
        AppDatabase db = AppDatabase.getInstance(application);
        daoUsuario = db.daoUsuario();
        callback = context;
    }

    @Override
    public void onResult(List usuarios) {
        Log.d("DEBUG", "Usuario found");
        callback.onResult(usuarios);
    }

    public void insert(final Usuario usuario){
        AppDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                daoUsuario.insert(usuario);
                callback.onInsert();
            }
        });
    }

    public void delete(final Usuario usuario){
        AppDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                daoUsuario.delete(usuario);
            }
        });
    }

    public void update(final Usuario usuario){
        AppDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                daoUsuario.update(usuario);
            }
        });
    }

    /*public void search(String id) {
        new SearchUsuarioById(daoUsuario, this).execute(id);
    }*/

    public List<Usuario> searchAll() {
        return daoUsuario.searchAll();
    }

    public interface OnResultCallback {
        void onResult(List<Usuario> result);
        void onInsert();
    }
}
