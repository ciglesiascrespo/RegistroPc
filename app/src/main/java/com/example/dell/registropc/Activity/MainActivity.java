package com.example.dell.registropc.Activity;

import android.content.Context;
import android.content.DialogInterface;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dell.registropc.Adapter.RecyclerAdapter;
import com.example.dell.registropc.ItemDecoration.SpacingDecoration;
import com.example.dell.registropc.Pojo.Registro;
import com.example.dell.registropc.Presenter.MainActivityPresenterImpl;
import com.example.dell.registropc.R;
import com.example.dell.registropc.View.MainActivityView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainActivityView {
    RecyclerView recyclerView;
    TextView txtNoForm;
    FloatingActionButton fab;
    LinearLayout linearProgress;


    MainActivityPresenterImpl presenter;
    RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainActivityPresenterImpl(this);

        recyclerView = findViewById(R.id.id_recyclerview_list_items);
        txtNoForm = findViewById(R.id.id_txt_no_form);
        fab = findViewById(R.id.id_fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                presenter.onClickFab();
            }
        });

        generarLinearLayout();
        initAdapterRV();

    }


    @Override
    protected void onResume() {
        super.onResume();
        presenter.getListRegistros();
    }

    public void generarLinearLayout() {
        LinearLayoutManager manager = new LinearLayoutManager(this);

        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.spacing);
        recyclerView.addItemDecoration(new SpacingDecoration(spacingInPixels));
        recyclerView.setLayoutManager(manager);

    }


    public void initAdapterRV() {
        ArrayList<Registro> listItems = new ArrayList<>();
        adapter = new RecyclerAdapter(listItems, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void newForm() {

    }

    @Override
    public void updateListRegistros(List<Registro> listItems) {
        adapter.updateListRegistros(listItems);
    }

    @Override
    public void addListRegistros(List<Registro> listItems) {
        adapter.addListRegistros(listItems);
    }

    @Override
    public void showLoading() {
        linearProgress.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
        txtNoForm.setVisibility(View.GONE);
    }


    @Override
    public void showErrorDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.myDialog);

        builder.setTitle(getResources().getString(R.string.str_title_alert_error));
        builder.setMessage(getResources().getString(R.string.str_msj_alert_error_formularios));
        builder.setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void showList() {
        linearProgress.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
        txtNoForm.setVisibility(View.GONE);
    }

    @Override
    public void showMsj() {
        linearProgress.setVisibility(View.GONE);
        recyclerView.setVisibility(View.GONE);
        txtNoForm.setVisibility(View.VISIBLE);
    }

    @Override
    public Context getContext() {
        return this;
    }
}
