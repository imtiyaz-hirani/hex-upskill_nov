package com.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductService {

    public List<Product> polulateProducts(){
       return List.of(
                new Product(101, "Inspiron Laptop 15", Category.LAPTOPS, 899.99),
        new Product(102, "MacBook Pro M3", Category.LAPTOPS, 1999.00),
        new Product(103, "HP Pavilion Desktop", Category.DESKTOPS, 750.50),
        new Product(104, "Alienware Aurora R16", Category.DESKTOPS, 2499.99),
        new Product(105, "Lenovo ThinkPad X1", Category.LAPTOPS, 1450.75),
        new Product(106, "iPhone 16 Pro Max", Category.MOBILES, 1399.00),
        new Product(107, "Samsung Galaxy S25", Category.MOBILES, 1099.50),
        new Product(108, "Google Pixel 9", Category.MOBILES, 799.00),
        new Product(109, "OnePlus 13", Category.MOBILES, 650.99),
        new Product(110, "Motorola Edge+", Category.MOBILES, 549.99),
        new Product(111, "Epson EcoTank Printer", Category.PRINTERS, 329.00),
        new Product(112, "Brother Laser Printer", Category.PRINTERS, 199.95),
        new Product(113, "HP OfficeJet Pro", Category.PRINTERS, 275.50),
        new Product(114, "Custom Gaming PC", Category.DESKTOPS, 1800.00),
        new Product(115, "Dell OptiPlex Micro", Category.DESKTOPS, 499.99),
        new Product(116, "Surface Laptop Studio", Category.LAPTOPS, 1699.00),
        new Product(117, "iPad Pro M4", Category.MOBILES, 999.00), // Treating tablets as MOBILES
        new Product(118, "Canon Photo Printer", Category.PRINTERS, 129.50),
        new Product(119, "Small Form Factor PC", Category.DESKTOPS, 620.25),
        new Product(120, "Budget Android Phone", Category.MOBILES, 299.99));

    }
    public List<Product> filterByCategory(List<Product> list, Category category) {
        return   list.stream()
                .filter(p -> p.getCategory().equals(category))
                .toList();
    }

    public List<String> getProductTitles(List<Product> list) {
        return list.stream()
                .map(p->p.getTitle())
                .toList(); // List<String>
    }

    public List<Category> getProductCategories(List<Product> list) {
        return list.stream()
                .map(p->p.getCategory())
                .distinct()
                .toList();
    }

    public List<Product> sortByPrice(List<Product> list, SortDirection sortDirection) {
        switch(sortDirection.toString()){
            case "ASC":
                return list.stream()
                        .sorted((p1,p2)->(int) (p1.getPrice() - p2.getPrice()))
                        .toList();

            case "DESC":
                return list.stream()
                        .sorted((p1,p2)->(int) (p2.getPrice() - p1.getPrice()))
                        .toList();
            default:
                break;
        }
    return null;
     }

    public Map<String, Integer> groupByCategory(List<Product> list) {
        Map<Category, List<Product>> map =
        list.stream()
                .collect(Collectors.groupingBy(Product::getCategory));

        Map<String, Integer> mapResp = new HashMap<>();
        map.entrySet().forEach(entry->{
            mapResp.put(entry.getKey().toString(), entry.getValue().size());
        });
        return mapResp;
    }
}
//10-15 = -5 -ve : [p1,p2]

//20-10 = +Ve  [p2,p1]