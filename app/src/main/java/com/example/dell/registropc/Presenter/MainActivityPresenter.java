package com.example.dell.registropc.Presenter;

import com.example.dell.registropc.Pojo.Registro;

import java.util.List;

/**
 * Created by Ciglesias on 18/02/2018.
 */

public interface MainActivityPresenter {
    void onErrorLoadingRegistros();

    void showListRegistros(List<Registro> list);

    void onCompleteListRegistro();
}
