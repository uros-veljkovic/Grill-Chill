/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import domen.MernaJedinica;
import domen.Mesto;
import domen.Proizvod;
import domen.Racun;
import domen.StavkaRacuna;
import domen.Zaposleni;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import konstante.Operacija;
import konstante.Status;
import kontroler.Kontroler;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author urosv
 */
public class NitKlijenta extends Thread {

    private Socket socket;
    private int rb;
    private String vreme;

    public NitKlijenta(Socket socket, int rb, String vreme) {
        this.socket = socket;
        this.rb = rb;
        this.vreme = vreme;
    }

    @Override
    public void run() {
        try {
            izvrsenjeOperacija();
        } catch (IOException | ClassNotFoundException ex) {
            this.interrupt();
            Kontroler.getInstance().izbaciKlijenta(this);
        }
        System.out.println("Klijent je otisao");
    }

    private void izvrsenjeOperacija() throws IOException, ClassNotFoundException {
        while (!isInterrupted()) {
            KlijentskiZahtev zahtev = primiZahtev();
            ServerskiOdgovor odgovor = new ServerskiOdgovor();
            //NE ZABORAVI ***BREAK***
            switch (zahtev.getOperacija()) {
                case Operacija.PRIJAVI_ZAPOSLENOG:
                    prijaviZaposlenog(zahtev, odgovor);
                    break;
                case Operacija.DAJ_SVE_ZAPOSLENE:
                    dajSveZaposlene(zahtev, odgovor);
                    break;
                case Operacija.DAJ_SVA_MESTA:
                    dajSvaMesta(zahtev, odgovor);
                    break;
                case Operacija.KREIRAJ_ZAPOSLENOG:
                    kreirajZaposlenog(zahtev, odgovor);
                    break;
                case Operacija.OBRISI_ZAPOSLENOG:
                    obrisiZaposlenog(zahtev, odgovor);
                    break;
                case Operacija.PRETRAZI_PROIZVODE:
                    pretraziProizvode(zahtev, odgovor);
                    break;
                case Operacija.IZMENI_PROIZVOD:
                    izmeniProizvod(zahtev, odgovor);
                    break;
                case Operacija.KREIRAJ_PROIZVOD:
                    kreirajProizvod(zahtev, odgovor);
                    break;
                case Operacija.OBRISI_PROIZVOD:
                    obrisiProizvod(zahtev, odgovor);
                    break;
                case Operacija.DAJ_SVE_PROIZVODE:
                    dajSveProizvode(zahtev, odgovor);
                    break;
                case Operacija.KREIRAJ_RACUN:
                    kreirajRacun(zahtev, odgovor);
                    break;
                case Operacija.STORNIRAJ_RACUN:
                    stornirajRacun(zahtev, odgovor);
                    break;
                case Operacija.PRETRAZI_RACUNE:
                    pretraziRacune(zahtev, odgovor);
                    break;
                case Operacija.IZMENI_RACUN:
                    izmeniRacun(zahtev, odgovor);
                    break;
            }
            posaljiOdgovor(odgovor);

        }
    }

    public void dajSveProizvode(KlijentskiZahtev zahtev, ServerskiOdgovor odgovor) {
        try {
            Proizvod proizvod = (Proizvod) zahtev.getParametar();
            ArrayList<Proizvod> listaProizvoda = Kontroler.getInstance().dajSveProizvode(proizvod);
            odgovor.setStatus(Status.USPESNO);
            odgovor.setObject(listaProizvoda);
        } catch (Exception ex) {
            odgovor.setStatus(Status.NEUSPESNO);
            odgovor.setPoruka(ex.getMessage());
        }
    }

    public void obrisiProizvod(KlijentskiZahtev zahtev, ServerskiOdgovor odgovor) {
        try {
            Proizvod proizvod = (Proizvod) zahtev.getParametar();
            proizvod = Kontroler.getInstance().obrisiProizvod(proizvod);
            odgovor.setStatus(Status.USPESNO);
            odgovor.setObject(proizvod);
        } catch (Exception ex) {
            odgovor.setStatus(Status.NEUSPESNO);
            odgovor.setPoruka(ex.getMessage());
        }
    }

    public void kreirajProizvod(KlijentskiZahtev zahtev, ServerskiOdgovor odgovor) {
        try {
            Proizvod proizvod = (Proizvod) zahtev.getParametar();
            proizvod = Kontroler.getInstance().kreirajProizvod(proizvod);
            odgovor.setStatus(Status.USPESNO);
            odgovor.setObject(proizvod);
        } catch (Exception ex) {
            odgovor.setStatus(Status.NEUSPESNO);
            odgovor.setObject("Sistem nije uspeo da kreira proizvod");
        }
    }

    public void izmeniProizvod(KlijentskiZahtev zahtev, ServerskiOdgovor odgovor) {
        try {
            Proizvod proizvod = (Proizvod) zahtev.getParametar();
            proizvod = Kontroler.getInstance().izmeniProizvod(proizvod);
            if (proizvod != null) {
                odgovor.setStatus(Status.USPESNO);
                odgovor.setObject(proizvod);
            } else {
                odgovor.setStatus(Status.NEUSPESNO);
                odgovor.setPoruka("Proizvod nije uspesno izmenjen");
            }
        } catch (Exception ex) {
            odgovor.setStatus(Status.NEUSPESNO);
            odgovor.setPoruka(ex.getMessage());
        }
    }

    public void pretraziProizvode(KlijentskiZahtev zahtev, ServerskiOdgovor odgovor) {
        try {
            ArrayList<Proizvod> listaProizvoda = Kontroler.getInstance().pretraziProizvode((Proizvod) zahtev.getParametar());
            odgovor.setStatus(Status.USPESNO);
            odgovor.setObject(listaProizvoda);
        } catch (Exception ex) {
            odgovor.setStatus(Status.NEUSPESNO);
            odgovor.setPoruka(ex.getMessage());
        }
    }

    public void obrisiZaposlenog(KlijentskiZahtev zahtev, ServerskiOdgovor odgovor) {
        try {
            Zaposleni zaposleni = (Zaposleni) zahtev.getParametar();
            zaposleni = Kontroler.getInstance().obrisiZaposlenog(zaposleni);
            odgovor.setStatus(Status.USPESNO);
            odgovor.setObject(zaposleni);
        } catch (Exception ex) {
            odgovor.setStatus(Status.NEUSPESNO);
            odgovor.setPoruka(ex.getMessage());
        }
    }

    public void kreirajZaposlenog(KlijentskiZahtev zahtev, ServerskiOdgovor odgovor) {
        try {
            Zaposleni zaposleni = (Zaposleni) zahtev.getParametar();
            zaposleni = Kontroler.getInstance().kreirajZaposlenog(zaposleni);
            odgovor.setStatus(Status.USPESNO);
            odgovor.setObject(zaposleni);
        } catch (Exception ex) {
            odgovor.setStatus(Status.NEUSPESNO);
            odgovor.setPoruka(ex.getMessage());
        }
    }

    public void dajSvaMesta(KlijentskiZahtev zahtev, ServerskiOdgovor odgovor) {
        try {
            ArrayList<Mesto> listaMesta = Kontroler.getInstance().dajSvaMesta((Mesto) zahtev.getParametar());
            odgovor.setStatus(Status.USPESNO);
            odgovor.setObject(listaMesta);
        } catch (Exception ex) {
            odgovor.setStatus(Status.NEUSPESNO);
            odgovor.setPoruka(ex.getMessage());
        }
    }

    public void dajSveZaposlene(KlijentskiZahtev zahtev, ServerskiOdgovor odgovor) {
        try {
            ArrayList<Zaposleni> listaZaposlenih = Kontroler.getInstance().dajSveZaposlene((Zaposleni) zahtev.getParametar());
            odgovor.setStatus(Status.USPESNO);
            odgovor.setObject(listaZaposlenih);
        } catch (Exception ex) {
            odgovor.setStatus(Status.NEUSPESNO);
            odgovor.setPoruka(ex.getMessage());
        }
    }

    public void prijaviZaposlenog(KlijentskiZahtev zahtev, ServerskiOdgovor odgovor) {
        try {
            Zaposleni zaposleni = (Zaposleni) zahtev.getParametar();
            zaposleni = Kontroler.getInstance().prijaviZaposlenog(zaposleni);
            odgovor.setStatus(Status.USPESNO);
            odgovor.setObject(zaposleni);
        } catch (Exception ex) {
            odgovor.setStatus(Status.NEUSPESNO);
            odgovor.setPoruka(ex.getMessage());
        }
    }

    public void spremiZaPrijaviZaposlenog_Neuspesno(ServerskiOdgovor odgovor, Exception ex) {

    }

    public void spremiZaPrijaviZaposlenog_Uspesno(KlijentskiZahtev zahtev, ServerskiOdgovor odgovor) throws Exception {

    }

    public KlijentskiZahtev primiZahtev() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        return (KlijentskiZahtev) in.readObject();
    }

    public void posaljiOdgovor(ServerskiOdgovor odgovor) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        out.writeObject(odgovor);
        out.flush();
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public String getVreme() {
        return vreme;
    }

    public void setVreme(String vreme) {
        this.vreme = vreme;
    }

    private void kreirajRacun(KlijentskiZahtev zahtev, ServerskiOdgovor odgovor) {
        try {
            Racun racun = (Racun) zahtev.getParametar();
            racun = Kontroler.getInstance().kreirajRacun(racun);
            odgovor.setStatus(Status.USPESNO);
            odgovor.setObject(racun);
        } catch (Exception ex) {
            odgovor.setStatus(Status.NEUSPESNO);
            odgovor.setPoruka(ex.getMessage());
        }
    }
    //NE IMPLEMENTIRANO DO KRAJ, POGLEDAJ DA NAPRAVIS IZMENU U DOMENSKOJ KLASI RACUN
    //KOD KREIRANJA UPITA ZA "BRISANJE" RACUNA
    private void stornirajRacun(KlijentskiZahtev zahtev, ServerskiOdgovor odgovor) {
        try {
            Racun racun = (Racun) zahtev.getParametar();
            racun = Kontroler.getInstance().stornirajRacun(racun);
            odgovor.setStatus(Status.USPESNO);
            odgovor.setObject(racun);
        } catch (Exception ex) {
            
        }
    }

    private void pretraziRacune(KlijentskiZahtev zahtev, ServerskiOdgovor odgovor) {
        try {
            //Pronasao sve racune za odredjenog zaposlenog
            ArrayList<Racun> listaRacuna = Kontroler.getInstance().pretraziRacune((Racun) zahtev.getParametar());
            odgovor.setStatus(Status.USPESNO);
            odgovor.setObject(listaRacuna);
        } catch (Exception ex) {
            odgovor.setStatus(Status.NEUSPESNO);
            odgovor.setPoruka(ex.getMessage());
            odgovor.setObject(null);
            ex.printStackTrace();
        }
    }

    private void izmeniRacun(KlijentskiZahtev zahtev, ServerskiOdgovor odgovor) {
        try {
            Racun racun = Kontroler.getInstance().izmeniRacun((Racun) zahtev.getParametar());
            odgovor.setStatus(Status.USPESNO);
            odgovor.setObject(racun);
        } catch (Exception ex) {
            odgovor.setStatus(Status.NEUSPESNO);
            odgovor.setPoruka(ex.getMessage());
            ex.printStackTrace();
        }
    }
}
