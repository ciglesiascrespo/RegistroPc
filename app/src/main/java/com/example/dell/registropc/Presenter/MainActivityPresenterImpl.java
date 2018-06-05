package com.example.dell.registropc.Presenter;

import com.example.dell.registropc.Iterator.MainIterator;
import com.example.dell.registropc.Pojo.Registro;
import com.example.dell.registropc.View.MainActivityView;

import java.util.List;

/**
 * Created by Ciglesias on 18/02/2018.
 */

public class MainActivityPresenterImpl implements MainActivityPresenter {
    private String TAG = getClass().getName();
    MainActivityView view;
    MainIterator iterator;

    public MainActivityPresenterImpl(MainActivityView view) {
        this.view = view;
        iterator = new MainIterator(view.getContext(), this);

    }

    public void onClickFab(){
        view.newForm();
    }

    public void getListRegistros() {
        view.showLoading();
        iterator.getListRegistros();
    }

    @Override
    public void onErrorLoadingRegistros() {
        view.showErrorDialog();
        view.showMsj();
    }

    @Override
    public void showListRegistros(List<Registro> list) {
        if (list.size() > 0) {
            view.showList();
            view.updateListRegistros(list);
        } else {
            view.showMsj();
        }
    }

    @Override
    public void onCompleteListRegistro() {

    }
}
