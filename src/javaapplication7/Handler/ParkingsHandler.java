/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication7.Handler;

import java.util.Random;

/**
 *
 * @author jake
 */
public class ParkingsHandler {
    
    private static ParkingsHandler instance;
    public Random random = new Random();
    
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
                        
    }
    
    private String generateParkingId() {
        
        random = new Random();
        
        return random.toString();
    }
    
    
    
    
}
