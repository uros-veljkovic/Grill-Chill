/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import kontroler.Kontroler;
import util.SettingsLoader;

/**
 *
 * @author urosv
 */
public class NitServer extends Thread{
    
        ServerSocket serverSocket;

    @Override
    public void run() {
        try {
            int port = Integer.parseInt(SettingsLoader.getInstance().getValue("port"));
            serverSocket = new ServerSocket(port);
            
            System.out.println("Server je pokrenut");
            
            NitStopServer stopServer = new NitStopServer(this);
            stopServer.start();
            
            while(!isInterrupted()){
                Socket socket = serverSocket.accept();
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                String vreme = sdf.format(new Date());
                NitKlijenta klijent = new NitKlijenta(socket, Kontroler.getInstance().getListaKlijenata().size() + 1, vreme);
                klijent.start();
                System.out.println("Klijent se povezao");
                Kontroler.getInstance().dodajKlijenta(klijent);
            }
        } catch (IOException ex) {
            System.out.println("Server je zaustavljen");
        }
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }
    
}
