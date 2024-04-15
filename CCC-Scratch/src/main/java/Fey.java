
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
public class Fey {
    
    private String name;
    private int whimsyLevel;
    private String favPie;
    private final ArrayList<String> names = new ArrayList<String>();
    private final ArrayList<String> pies = new ArrayList<String>();
    
    public Fey(){
        name = "Philipo";
        whimsyLevel = 0;
        favPie = "Elderberry";
        initNames();
        initPies();
    }
    public Fey(String name, int whimsy,String favPie){
        this.name = name;
        this.whimsyLevel = whimsy;
        this.favPie = favPie;
        initNames();
        initPies();
    }
    
    private void initNames(){
        try{
            Scanner input = new Scanner(new File("C://Users/Administrator//Documents//NetBeansProjects//CCC-Scratch//res//Names.txt"));
            while(input.hasNextLine()){
                names.add(input.nextLine().trim());
            }
            input.close();
        }catch(Exception e){
            System.out.println("Error reading or parsing Names.txt");
        }
    }
    
    private void initPies(){
        try{
            Scanner input = new Scanner(new File("C://Users/Administrator//Documents//NetBeansProjects//CCC-Scratch//res//PieFlavours.txt"));
            while(input.hasNextLine()){
                pies.add(input.nextLine().trim());
            }
            input.close();
        }catch(Exception e){
            System.out.println("Error reading or parsing PieFlavours.txt");
        }
    }
    
    public void setWhimsyLevel(int whimsyLevel){
        if(whimsyLevel > 100){
            whimsyLevel = 100;
        }
        if(whimsyLevel < 0){
            whimsyLevel = 0;
        }
        this.whimsyLevel = whimsyLevel;
    }
    
    public void setRandomName(){
        this.name = this.names.get((int)(Math.random() * names.size()));
    }
    
    public void setRandomPie(){
        this.favPie = this.pies.get((int)(Math.random() * pies.size()));
    }
    
    public int getWhimsyLevel(){
        return this.whimsyLevel;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getFavoritePie(){
        return this.favPie;
    }
    
    public ArrayList<String> getNames(){
        return this.names;
    }
    
    
}
