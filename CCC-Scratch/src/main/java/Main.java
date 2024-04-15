/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


import java.util.*;

/**
 *
 * @author Administrator
 */
public class Main {
    
    static int c;
    static int s;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //User input to determine gnome array  
        Scanner input = new Scanner(System.in);
        System.out.println("Input gnome array length: ");
        int size = input.nextInt();
        Gnome[] arr = new Gnome[size];
        
        //fill array with random gnomes
        for(int i = 0; i < arr.length;i++){
            arr[i] = new Gnome();
            arr[i].randomiseGnome();
        }
        //print the gnomes
        System.out.println("Unsorted:");
        printGnomes(arr);
        
        //calculate how long the sort took and actual do it
        long time = System.currentTimeMillis();
        GnomeSort(arr);
        time = System.currentTimeMillis() - time;
        
        //print the sorted gnomes
        System.out.println("\nSorted");
        printGnomes(arr);
        
        //print the stats on the sort
        System.out.println("It took " + time + "ms. Using " + c + " comparisons and " + s + " swaps.");   
    }
    
    static void printGnomes(Gnome[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
            System.out.println(",");
        }
        
    }
    
    static void GnomeSort(Gnome[] arr){
        //the int i is a tracker of the current position being analysed
        int i = 0;
        //do not go outside the bounds of the array
        while(i < arr.length){
            //if there is no index below or if the array is sorted at the current position; move forward
            if(i == 0 || arr[i-1].compareTo(arr[i]) <= 0){
                i++;
            }else{
                //if an unsorted element is found, swap them and move down one position
                Gnome temp = arr[i];
                arr[i] = arr[i-1];
                arr[--i] = temp;
                s++; //increment swap count
            }
            c++;//increment comparison count
        }
    }
}
