
import java.io.*;
import java.util.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Administrator
 */
public class Gnome extends Fey implements Comparable<Gnome>{
    //oh yeah its gnome time 
    
    private double height;
    private String vestColour;
    private final ArrayList<String> colours = new ArrayList<String>();
    
    private void initColours(){
        try{
            Scanner input = new Scanner(new File("C://Users/Administrator//Documents//NetBeansProjects//CCC-Scratch//res//VestColours.txt"));
            while(input.hasNextLine()){
                colours.add(input.nextLine().trim());
            }
            input.close();
        } catch(Exception e){
            System.out.println("Error reading or parsing VestColours.txt");
        }
        
    }
    
    public Gnome(){
        super();
        this.height = 1.0;
        this.vestColour = "Red";
        initColours();
    }
    
    public Gnome(String name, double height,String vestColour,String favPie, int whimsyLevel){
        super(name,whimsyLevel,favPie);
        this.setHeight(height);
        this.vestColour = vestColour;
        initColours();
    }
    
    double getHeight(){
        return this.height;
    }
    
    @Override
    public int compareTo(Gnome g){
        int heightComparison = (int)Math.signum(this.height - g.getHeight());
        if(heightComparison == 0){
            int whimsyComparison = (int)Math.signum(this.getWhimsyLevel() - g.getWhimsyLevel());    
            return whimsyComparison;
        }
        return heightComparison;
    }
    
    public void setHeight(double height){
        if(height < 0.0){
            height = 0.0; 
        }
        if(height > 30.0){
            height = 30.0;
        }
        this.height = height;
    }
    
    public void randomiseGnome(){
        this.height = Math.random() * 30.0;
        this.height = (int)(this.height*100.0);
        this.height = this.height/100.0;
        this.vestColour = this.colours.get((int)(Math.random() * colours.size()));
        this.setWhimsyLevel((int)(Math.random() * 101));
        this.setRandomName();
        this.setRandomPie();
    }
    
    public String toString(){
        String stringGnome = "";
        stringGnome += "Name: " + this.getName();
        stringGnome += "\nHeight: " + this.height + "cm";
        stringGnome += "\nVest Colour: " + this.vestColour;
        stringGnome += "\nWhimsy Level: " + this.getWhimsyLevel() + "%";
        stringGnome += "\nFavorite Pie: " + this.getFavoritePie();
        return stringGnome;
    }
    
}
