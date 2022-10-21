package com.example.myapplication.client;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.myapplication.BR;

public class ClientViewModel extends BaseObservable {
    private Client model ;

    public ClientViewModel(Client model) {
        this.model = model;
    }

    @Bindable
    public String getName () {
        return model.getNom();
    }
    public void setName ( String nom ) {
        model.setNom(nom);
// BR . name is automatically generated
        notifyPropertyChanged (BR.name);
    }

    @Bindable
    public String getPrenom () {
        return model.getPrenom();
    }
    public void setPrenom ( String prenom ) {
        model.setPrenom(prenom);
// BR . name is automatically generated
        notifyPropertyChanged (BR.name);
    }
}