package com.example.helloworld.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.helloworld.domain.Producto;

@RestController
public class ApiController {

    @GetMapping("/")
    public String saludar(){
        String saludo="";
        for (int i=0;i<5;i++){
            saludo+=i+"\n";
        }
        return saludo;
    }

    @GetMapping("/saludo")
    public String saludo(
        @RequestParam(name="nombre",required = true) String name,
        @RequestParam(name="numero",required = false,defaultValue = "5") int nume
        ) {
        String numeros="";
        for (int i=0; i<nume;i++){
            numeros+=i+1+"\n";
        }
        return "Hola, "+name+"\n"+numeros;
    }

    @GetMapping("/search") // /saludo?nombre=Adrian
    public Map<String, String> buscar(
        @RequestParam(name = "name", defaultValue = "Ciudades") String name
    ) {
        Map<String, String> cities = new HashMap<>();
        cities.put("BUC", "Bucaramanga");
        cities.put("NYC", "New York");
        cities.put("BOG", "Bogotá");
        cities.put("NVA", "Neiva");
        cities.put("LET", "Leticia");
        cities.put("PER", "Pereira");
        
        if(cities.containsKey(name)){
            return Map.of(name,cities.get(name));

        }else{
            return  cities;
        }
    }
    
    
    
    @GetMapping("/tax")
    public Map<String,Object> calcular(
        @RequestParam(defaultValue = "0") double percent
    ) {
        List<Producto> productos = new ArrayList<>(List.of(new Producto(1,"Pan", 2000)));
        productos.add(new Producto(2,"Gaseosa", 3500));
        productos.add(new Producto(3,"Salchichon Zenu", 1500));

        double precios = productos.stream()
            .map(producto -> producto.getPrice())
            .reduce(0.0, (precioA, precioB) -> precioA + precioB);


        double total=0;
        for (int i=0;i<productos.size();i++){
            total+=productos.get(i).getPrice();
        }

        double impuesto=percent/100;

        return Map.of("Productos",productos,"Total",total+total*impuesto,"Valor_neto",total,"IVA",percent+"%");
}


}
