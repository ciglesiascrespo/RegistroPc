package com.example.dell.registropc.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dell.registropc.Db.ConstansDb;
import com.example.dell.registropc.R;
import com.example.dell.registropc.Pojo.Registro;

import java.util.List;

/**
 * Created by Ciglesias on 18/02/2018.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.FormViewHolder> {

    List<Registro> listItems;

    Context context;

    public RecyclerAdapter(List<Registro> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;

    }

    public void addListRegistros(List<Registro> listItems) {
        this.listItems.addAll(listItems);
        notifyDataSetChanged();
    }

    public void updateListRegistros(List<Registro> listItems) {
        this.listItems = listItems;
        notifyDataSetChanged();
    }

    @Override
    public FormViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_registro, parent, false);
        return new RecyclerAdapter.FormViewHolder(view);

    }

    @Override
    public void onBindViewHolder(FormViewHolder holder, int position) {
        Registro itemList = listItems.get(position);

        holder.txtFechaSalida.setText(itemList.getFechaSalida());
        holder.txtFechaIngreso.setText(itemList.getFechaIngreso());
        holder.txtNombre.setText(itemList.getNombrePc() + " - " + itemList.getSerial());

        holder.imgEstadoPendiente.setVisibility(itemList.getEstado() == ConstansDb.ID_ESTADO_PENDIENTE ? View.VISIBLE : View.GONE);
        holder.imgEstadoEnviado.setVisibility(itemList.getEstado() == ConstansDb.ID_ESTADO_ENVIADO ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public static class FormViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgEstadoEnviado, imgEstadoPendiente;
        private TextView txtNombre, txtFechaIngreso, txtFechaSalida;


        private View v;

        public FormViewHolder(View itemView) {
            super(itemView);

            imgEstadoEnviado = itemView.findViewById(R.id.id_img_item_estado_enviado);
            imgEstadoPendiente = itemView.findViewById(R.id.id_img_item_estado_pendiente);
            txtFechaIngreso = itemView.findViewById(R.id.id_txt_item_fecha);
            txtFechaSalida = itemView.findViewById(R.id.id_txt_item_fecha_fin);
            txtNombre = itemView.findViewById(R.id.id_txt_item_registro);


            v = itemView;
        }
    }
}
