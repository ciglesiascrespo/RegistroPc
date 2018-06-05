package com.example.dell.registropc.View;

import android.content.Context;

import com.example.dell.registropc.Pojo.Registro;

import java.util.List;

/**
 * Created by Ciglesias on 18/02/2018.
 */

public interface MainActivityView {
    void newForm();

    void updateListRegistros(List<Registro> listItems);

    void addListRegistros(List<Registro> listItems);

    void showLoading();



    void showErrorDialog();

    void showList();

    void showMsj();

    Context getContext();
}
