package com.example.pokedexuwu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.pokedexuwu.io.MyApiAdapter;
import com.example.pokedexuwu.io.MyApiService;
import com.example.pokedexuwu.models.CustomLoading;
import com.example.pokedexuwu.models.Pokemon;
import com.example.pokedexuwu.responses.PokemonResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    final static String TAG = "Pokedex";
    private PokemonListAdapter listAdapter;
    private RecyclerView recyclerView;
    AlertDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        listAdapter = new PokemonListAdapter(this);
        CustomLoading custom  = new CustomLoading(this);
        custom.showDialog();

        Call<PokemonResponse> call = MyApiAdapter.getApiService().getPokemons();
        call.enqueue(new Callback<PokemonResponse>() {
            @Override
            public void onResponse(Call<PokemonResponse> call, Response<PokemonResponse> response) {
               PokemonResponse res = response.body();
               ArrayList<Pokemon> pokemons = res.getResults();
               Handler handler  = new Handler();
               handler.postDelayed(new Runnable() {
                   @Override
                   public void run() {
                       custom.cancelDialog();
                   }
               },2000);
               loadData(pokemons);
               setAdapter();


            }

            @Override
            public void onFailure(Call<PokemonResponse> call, Throwable t) {
                Handler handler  = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        custom.cancelDialog();
                    }
                },2000);
                Log.d(TAG,"Failure: " + t.getMessage());
            }
        });



    }

    private void loadData(ArrayList<Pokemon> pokemons){
        this.listAdapter.setPokemons(pokemons);
    }

    private void setAdapter(){
        RecyclerView.LayoutManager manager = new GridLayoutManager(getApplicationContext(), 3);
        this.recyclerView.setItemAnimator(new DefaultItemAnimator());
        this.recyclerView.setLayoutManager(manager);
        this.recyclerView.setAdapter(this.listAdapter);
    }




}