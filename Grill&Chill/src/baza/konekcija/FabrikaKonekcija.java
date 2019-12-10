/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baza.konekcija;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import util.SettingsLoader;

/**
 *
 * @author urosv
 */
public class FabrikaKonekcija {

    private static FabrikaKonekcija instance;
    private Connection konekcija;

    private FabrikaKonekcija() throws SQLException {

        String url = SettingsLoader.getInstance().getValue("url");
        String username = SettingsLoader.getInstance().getValue("username");
        String password = SettingsLoader.getInstance().getValue("password");

        konekcija = DriverManager.getConnection(url, username, password);
        konekcija.setAutoCommit(false);
    }

    public static FabrikaKonekcija getInstance() throws SQLException {
        if (instance == null) {
            instance = new FabrikaKonekcija();
        }
        return instance;
    }

    public Connection getKonekcija() {
        return konekcija;
    }

    public void commit() throws SQLException {
        konekcija.commit();
    }

    public void rollback() throws SQLException {
        konekcija.rollback();
    }

}
