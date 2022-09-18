package io.javabrains.moviecatalogservice.resources;

import io.javabrains.moviecatalogservice.entity.CatalogItem;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResources {

    @GetMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){

        return Collections.singletonList(new CatalogItem("BladeRunner","Action type film",5));
    }
}
