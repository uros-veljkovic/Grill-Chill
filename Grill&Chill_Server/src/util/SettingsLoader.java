/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author urosv
 */
public class SettingsLoader {
    
    private static SettingsLoader instance;
    private Properties properties;
    
    private SettingsLoader(){
        loadProperties();
    }
    
    public static SettingsLoader getInstance(){
        if(instance == null)
            instance = new SettingsLoader();
        return instance;
    }
    
    //TODO: napraviti settings.properties fajl
    private void loadProperties() {
        try {
            FileInputStream fis =new FileInputStream("settings.properties");
            properties = new Properties();
            properties.load(fis);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Settings fajl nije pronadjen.");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public String getValue(String key){
        return properties.getProperty(key);
    }
    
}
