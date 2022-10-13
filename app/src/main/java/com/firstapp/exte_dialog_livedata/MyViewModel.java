package com.firstapp.exte_dialog_livedata;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class MyViewModel extends ViewModel {
//    MyModel myModel;



    ArrayList<MyModel> datamodelList=new ArrayList<>();

    MutableLiveData<ArrayList<MyModel>>mutableLiveData;

    public MyViewModel(){

        mutableLiveData=new MutableLiveData<>();

    }

    public MutableLiveData<ArrayList<MyModel>> getMutableLiveData(){

        return mutableLiveData;


    }

    public void setMutableLiveData(ArrayList<MyModel> datamodelList)
    {
//        mymodel=new MyModel[datamodelList.size()];


//        for (int i=0;i<datamodelList.size();i++)
//        {
//            info[i]=datamodelList.get(i);
            mutableLiveData.setValue(datamodelList);


        }

    }








