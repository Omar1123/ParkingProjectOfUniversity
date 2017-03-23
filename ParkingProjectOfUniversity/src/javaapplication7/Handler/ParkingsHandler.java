/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication7.Handler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Random;
/**
 *
 * @author jake
 */
public class ParkingsHandler {
    
    private static ParkingsHandler instance;
    public Random random = new Random();
    private File PARKINGS = new File("/Users/jake/NetBeansProjects/JavaApplication7/src/javaapplication7/Handler/parking.txt");
    
    private ParkingsHandler() {
    
    }
    
    public static ParkingsHandler getInstancia() {
        
        if(instance == null) {
            instance = new ParkingsHandler();
        }
        
        return instance;
    }
    
    private void newParking(String idParking, String username, int basement, 
            int parking, String hour, String date) {
               
        this.createDB(PARKINGS);
        
    }
    
    private String generateParkingId() {
        
        random = new Random();
        
        return random.toString();
    }    
    
    private void createDB(File file) {                
        try {          
            if(!file.exists()){
                file.createNewFile();
            }          
        } catch (IOException ex) {            
            System.out.println(ex.getMessage());
        } 
    } 
    
    private void createParking(File file,String username, int basement, int parking) {
        try {
          
            if(!file.exists()){  
                file.createNewFile();
            }
            
            BufferedWriter writter =new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,true), "utf-8"));
            
            writter.write(username + "," + basement + "," + parking);
            writter.close();
            
        } catch (Exception ex) {
          //Captura un posible error le imprime en pantalla 
            System.out.println(ex.getMessage());
        }         
    }      
}
