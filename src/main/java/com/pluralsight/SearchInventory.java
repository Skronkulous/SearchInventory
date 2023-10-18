package com.pluralsight;
import java.util.ArrayList;
import java.util.Scanner;

import static com.pluralsight.FileManipulators.*;
import static com.pluralsight.SearchingFunctions.*;


public class SearchInventory {
    public static Scanner userInput = new Scanner(System.in);
    public static ArrayList<Products> productList = new ArrayList<Products>();
    public static void main(String[] args) {
        csvReader();
    }
    public static void menu(){
        System.out.print("Hello! Please enter an option (1, 2, 3, 4, or 5).\n\t1) List all products\n\t2) Lookup a product by its ID\n\t3) Find all products within a price range\n\t4) Add a new product\n\t5) Quit the application\nUser Input: ");
        String userChoice = userInput.nextLine();
        switch(userChoice){
            case("1"):
                listAllProducts();
                break;
            case("2"):
                listIdProduct();
                break;
            case("3"):
                listPricedProduct();
                break;
            case("4"):
                addProduct();
                break;
            case("5"):
                System.out.println("See you again soon!");
                break;
            default:
                System.out.println("Please enter a valid option (1, 2, 3, 4, or 5).");
                menu();
                break;

        }
    }
}
