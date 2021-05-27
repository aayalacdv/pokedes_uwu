package com.example.pokedexuwu.models;

public class Pokemon {
    private String name;
    private String url;
    int number;

    public int getNumber() {
        String[] ret = this.url.split("/");
        return Integer.parseInt(ret[ret.length-1]);
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
