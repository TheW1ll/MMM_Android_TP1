package com.example.myapplication.client;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.client.ClientData;

public class SharedInfoVM extends ViewModel {
        private final MutableLiveData<ClientData> data = new MutableLiveData<ClientData>();

        public void setdata(ClientData newdata) {
            data.setValue(newdata);
        }

        public LiveData<ClientData> getData() {
            return data;
        }
}

