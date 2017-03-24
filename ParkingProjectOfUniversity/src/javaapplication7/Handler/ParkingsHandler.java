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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
/**
 *
 * @author jake
 */
public class ParkingsHandler {
    
    private static ParkingsHandler instance;
    public Random random = new Random();
    private File PARKINGS = new File("/Users/jake/NetBeansProjects/JavaApplication7/src/javaapplication7/Handler/parking.txt");
    private int[][][] logicParking = new int[1][2][1];    
    
    private ParkingsHandler() {
    
    }
    
    public static ParkingsHandler getInstancia() {
        
        if(instance == null) {
            instance = new ParkingsHandler();
        }
        
        return instance;
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
    
    private void createParking(File file, int basement, int parking) {
        try {
          
            if(!file.exists()){  
                file.createNewFile();
            }
            
            BufferedWriter writter =new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,true), "utf-8"));
            
            writter.write(this.generateParkingId() + "," + basement + "," + parking + this.getActualDate() + this.getActualTime());
            writter.close();
            
        } catch (Exception ex) {
          //Captura un posible error le imprime en pantalla 
            System.out.println(ex.getMessage());
        }         
    }  
    
    private String getActualDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        
        return dateFormat.format(date);
    }
    
    private String getActualTime() {
        
        DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        
        return hourFormat.format(date);
    }
       
    private String generateParkingId() {
        
        random = new Random();
        
        return random.toString();
    }  
    
    private void fillBasements() {        
        for(int basement = 0; basement <= 3; basement++) {
            for(int parking = 0; parking <= 11; parking++) {            
                for(int place = 0; place <= 1; place++) {                        
                    logicParking[basement][parking][place] = place;
                }
            }
        }            
    }
    
    private void showBasements() {
        for(int basement = 0; basement <= 3; basement++) {
            for(int parking = 0; parking <= 11; parking++) {            
                for(int place = 0; place <= 1; place++) {                        
                    System.out.println(logicParking[basement][parking][place]);
                }
            }
        }             
    }
    
}
