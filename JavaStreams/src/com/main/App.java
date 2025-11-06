package com.main;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ProductService productService = new ProductService();
        Scanner sc = new Scanner(System.in);
        List<Product> list= productService.polulateProducts();
        while(true){
            System.out.println("1. Filter");
            System.out.println("2. Map");
            System.out.println("5. Map");
            System.out.println("3. Sorting");
            System.out.println("4. Grouping");
            System.out.println("0. Exit");
            int input = sc.nextInt();
            if(input == 0){
                break;
            }
            switch(input){
                case 1:
                    List<Product> filteredList = productService.filterByCategory(list,Category.DESKTOPS);
                    filteredList.forEach(p-> System.out.println(p));
                    break;
                case 2:
                    System.out.println("List of Product Titles");
                    List<String> titleList = productService.getProductTitles(list);
                    titleList.forEach(title-> System.out.println(title));
                    break;
                case 5:
                    System.out.println("List of Product Categories");
                    List<Category> catList = productService.getProductCategories(list);
                    catList.forEach(c-> System.out.println(c));
                    break;
                case 3:
                    System.out.println("Sorting of Products by price ASC");
                    List<Product> sortedListAsc =productService.sortByPrice(list, SortDirection.ASC);
                    sortedListAsc.forEach(p-> System.out.println(p));
                    System.out.println("Sorting of Products by price DESC");
                    sortedListAsc =productService.sortByPrice(list, SortDirection.DESC);
                    sortedListAsc.forEach(p-> System.out.println(p));
                    break;
                case 4:
                    System.out.println("Grouping by Category and Counting");
                    Map<String, Integer> map = productService.groupByCategory(list);
                    map.entrySet().forEach(entry->{
                        System.out.println(entry.getKey() + "-->" + entry.getValue());
                    });
                    break;
                default:
                    break;
            }
        }
        sc.close();
    }
}
