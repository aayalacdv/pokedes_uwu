package com.example.pokedexuwu.responses;

import com.example.pokedexuwu.models.Pokemon;

import java.util.ArrayList;

public class PokemonResponse {

    private ArrayList<Pokemon> results;


    public ArrayList<Pokemon> getResults() {
        return results;
    }

    public void setPokemonArrayList(ArrayList<Pokemon> pokemonArrayList) {
        this.results = pokemonArrayList;
    }


}
