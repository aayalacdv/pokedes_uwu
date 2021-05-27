package com.example.pokedexuwu;

import android.app.AlertDialog;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.example.pokedexuwu.models.Pokemon;

import java.util.ArrayList;

public class PokemonListAdapter extends RecyclerView.Adapter<PokemonListAdapter.ViewHolder> {

    private ArrayList<Pokemon> pokemons;
    private Context context;

    public static final String NAME = "com.example.podexuwu.NAME";
    public static final String IMAGE = "com.example.podexuwu.IMAGE";


    public PokemonListAdapter( Context context){
        pokemons = new ArrayList<>();
        this.context = context;
    }

    public ArrayList<Pokemon> getPokemons(){
        return this.pokemons;
    }

    public void setPokemons(ArrayList<Pokemon> pokemons){
        this.pokemons = pokemons;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pokemon_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       String name = this.pokemons.get(position).getName();
       holder.name.setText(name);
       holder.number = this.pokemons.get(position).getNumber();
        Glide.with(context)
                .load("https://pokeres.bastionbot.org/images/pokemon/"+ pokemons.get(position).getNumber()+".png")
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return this.pokemons.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name;
        int number;

        public ViewHolder (View view){
            super(view);
            image = (ImageView)view.findViewById(R.id.pokeImage);
            name = (TextView)view.findViewById(R.id.name);

        }

    }




}
