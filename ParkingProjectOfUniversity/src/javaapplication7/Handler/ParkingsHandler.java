/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication7.Handler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import javax.swing.JOptionPane;
/**
 *
 * @author jake
 */
public class ParkingsHandler {
    
    private static ParkingsHandler instance;
    public Random random = new Random();
    public File PARKINGS = new File("/root/NetBeansProjects/ParkingProjectOfUniversity/src/javaapplication7/Handler/parking.txt");  
    public double payForParking = 20.5;
    private ArrayList basement1 = new ArrayList();
    private ArrayList basement2 = new ArrayList();
    private ArrayList basement3 = new ArrayList();
    
    private ParkingsHandler() {
    
    }
    
    public static ParkingsHandler getInstancia() {
        
        if(instance == null) {
            instance = new ParkingsHandler();
        }
        
        return instance;
    }       
    
    public void createDB(File file) {                
        try {          
            if(!file.exists()){
                file.createNewFile();
            }          
        } catch (IOException ex) {            
            System.out.println(ex.getMessage());
        } 
    }                  
    
    public void createParking(String name, int basement, int parking) {
        try {
          
            if(!PARKINGS.exists()){  
                PARKINGS.createNewFile();
            }
            
            BufferedWriter writter =new BufferedWriter(new OutputStreamWriter(new FileOutputStream(PARKINGS,true), "utf-8"));
            
            writter.write(this.generateParkingId() + "," + name + "," + basement + "," + parking + "," + this.getActualDate() + "," + this.getActualTime() + "\r\n");
            writter.close();
            
            System.out.println("Se ha generado el log");
            
        } catch (Exception ex) {
          //Captura un posible error le imprime en pantalla 
            System.out.println(ex.getMessage());
        }         
    }  
    
    public String getActualDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        
        return dateFormat.format(date);
    }
    
    public String getActualTime() {
        
        DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        
        return hourFormat.format(date);
    }
       
    public String generateParkingId() {
        
        random = new Random();
        int number = random.nextInt();
        
        return Integer.toString(number);
    }      
    
    public void searchInParking(String name) {
        try {
    
            BufferedReader buffer = new BufferedReader(new FileReader(PARKINGS));                
            String lines;           
            
            while((lines = buffer.readLine())!= null) {
                if(lines.indexOf(",")!= -1){
                    if (lines.split(",")[1].equalsIgnoreCase(name)) {                        
                        System.out.println("Hora: " + lines.split(",")[4]);
                        System.out.println("Fecha: " + lines.split(",")[5]);                        
                        
                        JOptionPane.showMessageDialog(null, "Su hora de entradas fue: " + lines.split(",")[5] + " en el parqueo " + lines.split(",")[2] + " del sotano " + lines.split(",")[3]);        
                        JOptionPane.showMessageDialog(null, "Su total a pagar es: " + payForParking + " Q");        
                    } 
                }
            }

            buffer.close();
        } catch(Exception ex) {
            System.out.println("Error in the lecture");
        }        
    }
}
