package com.pluralsight;
import java.util.Scanner;
import static com.pluralsight.SearchInventory.*;

public class SearchingFunctions {
    public static Scanner userInput = new Scanner(System.in);
    public static void listAllProducts(){
        System.out.println("\nAll Available Products: ");
        for(Products products: productList){
            System.out.println("Id: " + products.getId() + " | Name: " + products.getName() + " | Price: " + products.getPrice());
        }
        System.out.println();
        menu();
    }
    public static void listIdProduct(){
        try {
            System.out.print("\nPlease enter the ID of the product you are looking for (Ex: 1234): ");
            String input = userInput.nextLine();
            int temp = 0;
            for (Products products : productList) {
                if (Integer.toString(products.getId()).equals(input)) {
                    System.out.println("\nId: " + products.getId() + " | Name: " + products.getName() + " | Price: " + products.getPrice());
                    System.out.println();
                    break;
                }
                else
                    temp++;
            }
            if(temp == productList.size()){
                System.out.println("Please enter a valid ID.");
                listIdProduct();
            }
            else
                menu();
        }
        catch(Exception e){
            System.out.println("An unknown error occurred, please try again.");
            listIdProduct();
        }
    }
    public static void listPricedProduct(){
        try{
            System.out.print("\nPlease enter the minimum price for your product (Ex: 5.00): $");
            double minPrice = userInput.nextDouble();
            System.out.print("Please enter the maximum price for your product (Ex: 10.00): $");
            double maxPrice = userInput.nextDouble();
            int temp = 0;
            System.out.printf("\nProducts between: $%.2f and $%.2f:", minPrice, maxPrice);
            System.out.println();
            for(Products products: productList){
                if(products.getPrice() > minPrice && products.getPrice() < maxPrice){
                    System.out.println("Id: " + products.getId() + " | Name: " + products.getName() + " | Price: " + products.getPrice());
                }
                else
                    temp++;
            }
            if(temp == productList.size()){
                System.out.println("Could not find any products within given price range. Returning to main menu.\n");
                menu();
            }
            else{
                System.out.println();
                menu();
            }
        }
        catch(Exception e){
            System.out.println("Please enter a valid price in the format of \"X.XX\"");
            listIdProduct();
        }

    }
}
