package io.javabrains.moviecatalogservice.resources;

import io.javabrains.moviecatalogservice.entity.CatalogItem;
import io.javabrains.moviecatalogservice.entity.Movie;
import io.javabrains.moviecatalogservice.entity.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResources {

    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){

        WebClient.Builder builder=WebClient.builder();
        //the movies the user has watched and his ratings
        List<Rating> ratings= Arrays.asList(
                new Rating("101",4),
                new Rating("102",2)
        );
        //getting the details of those movies through api call
        return ratings.stream().map(rating -> {
            //the url that it's going to get the response from and the class that
            // it's going to map the response to
            Movie movie = restTemplate.getForObject("http://localhost:9091/movies/"+rating.getMovieId(), Movie.class);

           /*Movie movie= builder.build()
                    .get()
                    .uri("http://localhost:9091/movies/"+rating.getMovieId())
                    .retrieve()
                    .bodyToMono(Movie.class)
                    .block();*/
            return new CatalogItem(movie.getName(),"Action type film",rating.getRating());
        }).collect(Collectors.toList()) ;



    }
}
