package com.firstapp.exte_dialog_livedata;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton floatingActionButton;
    RecyclerView recyclerView;
    MyAdapter myAdapter;
    MyModel myModel;

    ArrayList<MyModel> datamodelList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        floatingActionButton = findViewById(R.id.floating_action);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final MyViewModel viewModel = ViewModelProviders.of(this).get(MyViewModel.class);

        viewModel.getMutableLiveData().observe(this, new Observer<ArrayList<MyModel>>() {
            @Override
            public void onChanged(ArrayList<MyModel> myModels) {
                myAdapter=new MyAdapter(getApplicationContext(),myModels);
                recyclerView.setAdapter(myAdapter);
            }
        });

        viewModel.getMutableLiveData().observe(this, new Observer<ArrayList<MyModel>>() {
            @Override
            public void onChanged(ArrayList<MyModel> myModels) {
                viewModel.getMutableLiveData();
            }
        });





        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MyFragmentDialog myFragmentDialog = new MyFragmentDialog();
                myFragmentDialog.show(getFragmentManager(), "myFragmentDialog");


            }
        });
    }




}


//    private void saveData() {
//        // method for saving the data in array list.
//        // creating a variable for storing data in
//        // shared preferences.
//
//
//
//
//    }