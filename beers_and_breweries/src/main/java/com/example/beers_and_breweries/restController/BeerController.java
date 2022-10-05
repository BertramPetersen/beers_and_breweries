package com.example.beers_and_breweries.restController;

import com.example.beers_and_breweries.model.Beer;
import com.example.beers_and_breweries.service.BeerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/beer")
public class BeerController {
    private final BeerService beerService;

    public BeerController(BeerService beerService){
        this.beerService = beerService;
    }
    @PostMapping
    public ResponseEntity addBeer(@RequestBody Beer beer){
        beerService.addBeer(beer);
        System.out.println(beer.toString());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity updateBeer(@RequestBody Beer beer){
        beerService.updateBeer(beer);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Beer>> getAllBeers(){
        return ResponseEntity.ok(beerService.getAllBeers());
    }
    @GetMapping("/{name}")
    public ResponseEntity<Beer> getBeerByName(@PathVariable String name) {
        return ResponseEntity.ok(beerService.getBeerByName(name));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteBeer(@PathVariable String id) {
        beerService.deleteBeer(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
