package com.tecsup.spacebear.arraylist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.tecsup.spacebear.arraylist.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<ExampleItem> mExampleList;

    private RecyclerView mRecyclerView;
    private ExampleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createExampleList();
        buildRecyclerView();

        EditText editText = findViewById(R.id.edittext);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });


    }

    private void filter(String text) {
        ArrayList<ExampleItem> filteredList = new ArrayList<>();

        for (ExampleItem item : mExampleList) {
            if (item.getText1().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }

        mAdapter.filterList(filteredList);
    }

    public void changeItem(int position, String text) {
        mExampleList.get(position).chanteText1(text);
        mAdapter.notifyItemChanged(position);
    }





    private void createExampleList() {
        mExampleList = new ArrayList<>();
        mExampleList.add(new ExampleItem(R.mipmap.im_licor, "Licoreria", "Todo tipo de licores. Delivery al 334-5322(Atención solo hasta las 11pm)"));
        mExampleList.add(new ExampleItem(R.mipmap.im_contr, "Contratistas", "Gran plana de trabajadores de distintas áreas a su disposición"));
        mExampleList.add(new ExampleItem(R.mipmap.im_elect, "Electricistas", "Reparación de circuitos cerrados y abiertos, a pequeña y gran escala"));
        mExampleList.add(new ExampleItem(R.mipmap.im_progrm, "Programadores", "Grupo de trabajadores independientes con años de experiencia"));
        mExampleList.add(new ExampleItem(R.mipmap.im_distr, "Distribuidor de Embutidos", "Envío a todas partes del Perú, nueva sede en Huancayo"));
        mExampleList.add(new ExampleItem(R.mipmap.im_dent, "Dentista Pediatra ", "Horarios de atención 9:00 am - 6:00 pm "));
    }

    private void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(mExampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

}