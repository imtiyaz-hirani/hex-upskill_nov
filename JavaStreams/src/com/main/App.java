package com.main;

import java.util.List;
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
                default:
                    break;
            }
        }
        sc.close();
    }
}
