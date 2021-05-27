package com.example.pokedexuwu.models;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;

import com.example.pokedexuwu.R;


public class CustomLoading {
    private Activity myActivity;
    private AlertDialog alertDialog;

    public CustomLoading ( Activity myActivity){
        this.myActivity = myActivity;
    }

    public void showDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(myActivity);
        LayoutInflater layoutInflater = myActivity.getLayoutInflater();
        builder.setView(layoutInflater.inflate(R.layout.loadin_layout,null));
        alertDialog = builder.create();
        alertDialog.show();

    }

    public void cancelDialog(){
        this.alertDialog.cancel();
    }


}
