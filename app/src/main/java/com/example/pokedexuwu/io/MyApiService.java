package com.example.pokedexuwu.io;

import com.example.pokedexuwu.responses.PokemonResponse;
import com.example.pokedexuwu.responses.SkillResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MyApiService {

    @GET("pokemon/")
    Call<PokemonResponse> getPokemons();

    @GET("characteristic/{id}/")
    Call<SkillResponse> getSkill(@Path("id") String id);
}
