package com.example.dell.registropc.Iterator;

import android.content.Context;

import com.example.dell.registropc.Db.DbHandler;
import com.example.dell.registropc.Pojo.Registro;
import com.example.dell.registropc.Presenter.MainActivityPresenter;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Ciglesias on 18/02/2018.
 */

public class MainIterator {
    private MainActivityPresenter presenter;
    private DbHandler dbHandler;

    public MainIterator(Context context, MainActivityPresenter presenter) {
        this.presenter = presenter;
        dbHandler = DbHandler.getInstance(context);
    }

    public void getListRegistros() {
        Observable.create(new Observable.OnSubscribe<List<Registro>>() {
            @Override
            public void call(Subscriber<? super List<Registro>> subscriber) {
                subscriber.onNext(dbHandler.getRegistros());
                subscriber.onCompleted();
            }
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io()).subscribe(new Subscriber<List<Registro>>() {
            @Override
            public void onCompleted() {
                presenter.onCompleteListRegistro();
            }

            @Override
            public void onError(Throwable e) {
                presenter.onErrorLoadingRegistros();
            }

            @Override
            public void onNext(List<Registro> registros) {

                presenter.showListRegistros(registros);
            }
        });
    }

}
