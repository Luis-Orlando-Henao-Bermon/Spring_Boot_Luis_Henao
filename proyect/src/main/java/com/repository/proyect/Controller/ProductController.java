package com.repository.proyect.Controller;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.repository.proyect.Domain.Product;
import com.repository.proyect.repository.ProductRepository;

@RestController
@RequestMapping("/api")
public class ProductController {

    private final ProductRepository repo;
    public ProductController(ProductRepository repo) { this.repo = repo; }

    @GetMapping("/products")
    public List<Product> getProducts(
        @RequestParam(required = false) Double minPrice,
        @RequestParam(required = false) Double maxPrice,
        @RequestParam(required = false) String category,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size
    ) {
      	//Aplica los filtros de minPrice, maxPrice y category, recuerda que pueden aplicarse todos o ninguno
        
        int skip = page * size;

        List<Product> listadoFiltrado=repo.findAll().stream()
            .filter(p -> minPrice == null || p.getPrice() >= minPrice)
            .filter(p -> maxPrice == null || p.getPrice() <= maxPrice)
            .filter(p -> category == null || p.getCategory().equalsIgnoreCase(category))
            .skip(skip)
            .limit(size)
            .toList();
        
        return listadoFiltrado;
    }

    
    @GetMapping("/products/stats")
    public Map<String, Double> getStats(
        @RequestParam(required = false) String category
    ) {
    
    //Obtenga el listado de productos filtrados por categoría
        DoubleSummaryStatistics statistics = repo.findAll().stream()
                .filter(p -> category == null || p.getCategory().equalsIgnoreCase(category))
                .mapToDouble(p -> p.getPrice())
                .summaryStatistics();
                
        return Map.of(
            "count", (double) statistics.getCount(),
            "avgPrice", statistics.getAverage(),
            "minPrice", statistics.getMin(),
            "maxPrice", statistics.getMax(),
            "totalValue", statistics.getSum()
        );
    }

}
