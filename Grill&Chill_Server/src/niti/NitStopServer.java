/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import java.io.IOException;

/**
 *
 * @author urosv
 */
public class NitStopServer extends Thread {

    NitServer nitServer;

    public NitStopServer(NitServer nitServer) {
        this.nitServer = nitServer;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            if (nitServer.isInterrupted()) {
                if (!nitServer.getServerSocket().isClosed()) {
                    try {
                        nitServer.getServerSocket().close();
                        this.interrupt();
                    } catch (IOException ex) {
                        System.out.println("Greska prilikom zatvaranja serverskog soketa");
                    }
                }
            }
        }
    }

}
