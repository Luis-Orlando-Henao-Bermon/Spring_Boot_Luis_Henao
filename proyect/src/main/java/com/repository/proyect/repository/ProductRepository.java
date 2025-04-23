package com.repository.proyect.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.repository.proyect.Domain.Product;

@Repository
public class ProductRepository {

    private final List<Product> products = new ArrayList<>();

    

    public ProductRepository() {
        products.add(new Product(1L, "Laptop Lenovo", "Tecnología", 2500.0, 15));
        products.add(new Product(2L, "Mouse Logitech", "Tecnología", 80.0, 50));
        products.add(new Product(3L, "Teclado Mecánico", "Tecnología", 150.0, 30));
        products.add(new Product(4L, "Monitor Samsung", "Tecnología", 1200.0, 10));
        products.add(new Product(5L, "Silla Gamer", "Muebles", 850.0, 20));
        products.add(new Product(6L, "Escritorio", "Muebles", 500.0, 12));
        products.add(new Product(7L, "Libro Java", "Libros", 100.0, 40));
        products.add(new Product(8L, "Agenda 2025", "Papelería", 25.0, 60));
        products.add(new Product(9L, "Lámpara LED", "Iluminación", 45.0, 35));
        products.add(new Product(10L, "Smartphone Xiaomi", "Tecnología", 1400.0, 18));
        products.add(new Product(11L, "Cámara Web", "Tecnología", 320.0, 22));
        products.add(new Product(12L, "Impresora HP", "Tecnología", 780.0, 8));
        products.add(new Product(13L, "Reloj Digital", "Accesorios", 210.0, 25));
        products.add(new Product(14L, "Auriculares Bluetooth", "Tecnología", 180.0, 30));
        products.add(new Product(15L, "Mochila Escolar", "Accesorios", 95.0, 40));
        products.add(new Product(16L, "Botella Térmica", "Hogar", 60.0, 50));
        products.add(new Product(17L, "Set de Plumas", "Papelería", 15.0, 100));
        products.add(new Product(18L, "Parlante Portátil", "Tecnología", 250.0, 27));
        products.add(new Product(19L, "Cargador USB-C", "Tecnología", 90.0, 45));
        products.add(new Product(20L, "Tablet Samsung", "Tecnología", 1800.0, 12));
    }


    public List<Product> findAll() { return products; }

}
