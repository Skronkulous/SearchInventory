package com.pluralsight;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

import static com.pluralsight.SearchInventory.*;

public class FileManipulators {
    public static Scanner userInput = new Scanner(System.in);
    public static void addProduct(){
        try{
            while(1>0){
                FileWriter fw = new FileWriter("src/main/resources/inventory.csv", true);
                BufferedWriter bw = new BufferedWriter(fw);
                System.out.print("\nPlease enter the ID of the new product (Ex: 1234): ");
                int id = userInput.nextInt();
                for(Products products: productList){
                    if(products.getId() == id){
                        System.out.println("Please enter an ID that doesn't already exist.");
                        addProduct();
                        break;
                    }
                }
                userInput.nextLine();
                System.out.print("Please enter the name of the new product (Ex: Steel Hammer): ");
                String name = (userInput.nextLine()).trim();
                for(Products products: productList){
                    if(products.getName().equals(name)){
                        System.out.println("Please enter a name that doesn't already exist.");
                        addProduct();
                        break;
                    }
                }
                System.out.print("Please enter the price of the new product (Ex: 4.44): $");
                double price = userInput.nextDouble();
                bw.newLine();
                bw.write(id + "|" + name + "|" + price);
                System.out.println("Your new item has been successfully added!\nNow returning to the main menu.\n");
                bw.close();
                break;
            }
        }
        catch(Exception e){
            System.out.println("There seems to be a problem with a user input, please try again.");
            addProduct();
        }
        menu();
    }
    public static void csvReader(){
        try{
            FileReader fr = new FileReader("src/main/resources/inventory.csv");
            BufferedReader br = new BufferedReader(fr);
            String tempInfo = "";
            while ((tempInfo = br.readLine()) != null) {
                String[] splitLine = tempInfo.split("\\|");
                int id = (Integer.parseInt(splitLine[0].trim()));
                String name = (splitLine[1]);
                double price = Double.parseDouble(splitLine[2]);
                Products newProduct = new Products(id, name, price);
                productList.add(newProduct);
            }
            fr.close();
            br.close();
            menu();
        }
        catch(Exception e){
            System.out.println("There seems to be a problem with the current file path, please update and try again.");
            e.printStackTrace();
        }
    }
}
