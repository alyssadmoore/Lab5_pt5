package com.AlyssaMoore;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Main {

    static Scanner numberScanner = new Scanner(System.in);

    public static void main(String[] args){

        // Started with template
        int numberOfHouses = 8;

        ArrayList cratesPerHouse = getRecyclingPerHouse(numberOfHouses);
        int totalCrates = calculateTotal(cratesPerHouse);
        int maxCrates = calculateMax(cratesPerHouse);
        int minCrates = calculateMin(cratesPerHouse);
        ArrayList houseWithMostRecycling = 	calculateHouseWithMostRecycling(cratesPerHouse);

        System.out.println("Total crates from all houses = " + totalCrates);
        System.out.println("Max crates at any house = " + maxCrates);
        System.out.println("Min crates at any house = " + minCrates);
        System.out.println("House with most recycling = " + houseWithMostRecycling);

        // Creating buffered writer bufWriter to use with filewriter for cratesReport.txt
        try{BufferedWriter bufWriter = new BufferedWriter(new FileWriter("cratesReport.txt"));

        // for each house, add the number of crates to the report
        for (int x = 0; x < 7; x++) {
            bufWriter.write("House " + x + " recycled " + cratesPerHouse.get(x) + " crate(s)\r\n");
        }

        // Adding total crates to report
        bufWriter.write("\r\nTotal crates recycled = " + totalCrates + "\r\n");

        // Adding houses with most crates to report
        bufWriter.write("\r\nHouses that recycled the most:\r\n" + "Houses " + houseWithMostRecycling + " with " + maxCrates + " crates each.");

        bufWriter.close();}
        catch (IOException ioe){
            System.out.println("Sorry, there was an IOException.");
        }
        numberScanner.close();
    }

    // Ask user for number of crates for each house. Store in array and return this array.
    public static ArrayList getRecyclingPerHouse(int houses){
        ArrayList numCratesArrayList = new ArrayList();
        for (int x = 0; x < 8; x++) {
            System.out.println("How many crates for house " + x + "?");
            int numCrates = numberScanner.nextInt();
            numCratesArrayList.add(numCrates);
        }
        return numCratesArrayList;
    }

    //Add up all of the numbers in the array and return that total
    public static int calculateTotal(ArrayList cratesPerHouse) {
        int total = 0;
        for (int x = 0; x < cratesPerHouse.size(); x++) {
            int numbersInArrayList = (Integer) cratesPerHouse.get(x);
            total += numbersInArrayList;
        }
        return total;
    }

    /* Finding max crates by setting max at house 0 and testing each house
       against the max - if a number is higher, that is set as the new max */
    public static int calculateMax(ArrayList cratesPerHouse) {
        int max = (Integer) cratesPerHouse.get(0);
        for (int x = 0; x < cratesPerHouse.size(); x++) {
            if ((Integer) cratesPerHouse.get(x) > max) {
                max = (Integer) cratesPerHouse.get(x);
            }
        }
        return max;
    }

    /* Found the minumum crates with the same method as for max crates above */
    public static int calculateMin(ArrayList cratesPerHouse) {
        int min = (Integer) cratesPerHouse.get(0);
        for (int x = 0; x < cratesPerHouse.size(); x++) {
            if ((Integer) cratesPerHouse.get(x) < min) {
                min = (Integer) cratesPerHouse.get(x);
            }
        }
        return min;
    }

    /* Use similar method as max to find max values, then loop over houses to 	find matching index, add each that match to an array */
    public static ArrayList calculateHouseWithMostRecycling(ArrayList cratesPerHouse) {
        int max = (Integer) cratesPerHouse.get(0);
        for (int x = 0; x < cratesPerHouse.size(); x++) {
            if ((Integer) cratesPerHouse.get(x) > max) {
                max = (Integer) cratesPerHouse.get(x);
            }
        }
        int maxHouseNum = 0;
        ArrayList maxHouseNumbers = new ArrayList();
        for (int x = 0; x < cratesPerHouse.size(); x++) {
            if ((Integer) cratesPerHouse.get(x) == max) {
                maxHouseNumbers.add(x);
            }
        }
        return maxHouseNumbers;
    }
}