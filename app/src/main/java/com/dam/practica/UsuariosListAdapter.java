package com.dam.practica;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class UsuariosListAdapter extends RecyclerView.Adapter<UsuariosListAdapter.UsuariosViewHolder> {

    private List<String> nombres;
    Activity mainActivity4;

    public UsuariosListAdapter(List<String> nombres, Activity activity) {
        this.nombres = nombres;
        this.mainActivity4 = activity;
    }

    @NonNull
    @Override
    public UsuariosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //se ejecuta una vez por cada fila
        //obtenemos una vista y la inflamos con el layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fila_nombre, parent, false);
        UsuariosViewHolder usuariosViewHolder = new UsuariosViewHolder(v);

        return usuariosViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UsuariosViewHolder holder, int position) {
        String nombre = nombres.get(position);
        holder.nombreText.setText(nombre);
    }

    @Override
    public int getItemCount() {
        return nombres.size();
    }

    public class UsuariosViewHolder extends RecyclerView.ViewHolder {
        TextView nombreText;

        public UsuariosViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreText = itemView.findViewById(R.id.nombreText);

        }
    }

}
