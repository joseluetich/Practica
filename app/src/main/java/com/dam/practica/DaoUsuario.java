package com.dam.practica;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface DaoUsuario {
    @Insert
    void insert(Usuario usuario);

    @Delete
    void delete(Usuario usuario);

    @Update
    void update(Usuario usuario);

    @Query("SELECT * FROM usuario WHERE id = :id LIMIT 1")
    Usuario search(String id);

    @Query("SELECT * FROM usuario")
    List<Usuario> searchAll();
}
