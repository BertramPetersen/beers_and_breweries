package com.example.beers_and_breweries.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("beer")
public class Beer {
    @Id
    private String id;
    @Field("name")
    private String beerName;
    @Field("alc")
    private double alc;
    @Field("kind")
    private String kind;
    @Field("brewery")
    private String brewery;

    public Beer(String id, String beerName, double alc, String kind, String brewery) {
        this.id = id;
        this.beerName = beerName;
        this.alc = alc;
        this.kind = kind;
        this.brewery = brewery;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBeerName() {
        return beerName;
    }

    public void setBeerName(String beerName) {
        this.beerName = beerName;
    }

    public double getAlc() {
        return alc;
    }

    public void setAlc(double alc) {
        this.alc = alc;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getBrewery() {
        return brewery;
    }

    public void setBrewery(String brewery) {
        this.brewery = brewery;
    }

    @Override
    public String toString() {
        return "Beer{" +
                "beerName='" + beerName + '\'' +
                ", alc=" + alc +
                ", kind='" + kind + '\'' +
                ", brewery='" + brewery + '\'' +
                '}';
    }
}
