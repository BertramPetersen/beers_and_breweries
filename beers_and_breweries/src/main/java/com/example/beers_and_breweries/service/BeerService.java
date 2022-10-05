package com.example.beers_and_breweries.service;

import com.example.beers_and_breweries.model.Beer;
import com.example.beers_and_breweries.repository.BeerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BeerService {
    private final BeerRepository beerRepository;

    public BeerService(BeerRepository beerRepository){
        this.beerRepository = beerRepository;
    }

    public void addBeer(Beer beer){
        beerRepository.insert(beer);

    }

    public void updateBeer(Beer beer){
        Beer savedBeer = beerRepository.findByName(beer.getId())
                .orElseThrow(()-> new RuntimeException(
                        String.format("Cannot find Beer by Id %s", beer.getId())));
        savedBeer.setBeerName(beer.getBeerName());
        savedBeer.setAlc(beer.getAlc());
        savedBeer.setKind(beer.getKind());
        savedBeer.setBrewery(beer.getBrewery());

        beerRepository.save(beer);
    }
    public List<Beer> getAllBeers(){
        return beerRepository.findAll();
    }

    public Beer getBeerByName(String name) {
        return beerRepository.findByName(name).orElseThrow(() -> new RuntimeException(
                String.format("Cannot Find Beer by Name %s", name)));
    }

    public void deleteBeer(String id) {
        beerRepository.deleteById(id);
    }
}
