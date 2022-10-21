package com.example.myapplication.client;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.client.Client;

public class ClientShared extends ViewModel {

    private final MutableLiveData<ClientData> clientData = new MutableLiveData<ClientData>();

    public void setdata(ClientData newclient) {
        clientData.setValue(newclient);
    }

    public LiveData<ClientData> getData() {
        return clientData;
    }
}