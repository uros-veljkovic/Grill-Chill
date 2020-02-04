/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komunikacija;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author urosv
 */
public class Komunikator {

    private Socket socket;
    private static Komunikator instance;

    public Komunikator() {
        poveziSeSaServerom();
    }

    public static Komunikator getInstance() {
        if (instance == null) {
            instance = new Komunikator();
        }
        return instance;
    }

    private void poveziSeSaServerom() {
        try {
            socket = new Socket("localhost", 9000);
            System.out.println("Uspostavljena je konekcija sa serverom !");
        } catch (IOException ex) {
            System.err.println("Greska prilikom uspostavljanja konekcije...");
            ex.printStackTrace();
        }
    }

    public void posaljiZahtev(KlijentskiZahtev zahtev) {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(zahtev);
                    
        } catch (IOException ex) {
            System.err.println("GRESKA PRILIKOM SLANJA ZAHTEVA.");
        }

    }
    
    public ServerskiOdgovor primiOdgovor(){
        ServerskiOdgovor odgovor = new ServerskiOdgovor();
        
        try {
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            odgovor = (ServerskiOdgovor) inputStream.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("GRESKA PRILIKOM PRIJEMA ODGOVORA");
        }        
        return odgovor;
    }

}
