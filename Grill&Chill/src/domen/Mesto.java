/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

/**
 *
 * @author urosv
 */
public class Mesto {
    
    private int postanskiBroj;
    private String grad;
    private String drzava;

    public Mesto() {
    }
    public Mesto(int postanskiBroj, String grad, String drzava) {
        this.postanskiBroj = postanskiBroj;
        this.grad = grad;
        this.drzava = drzava;
    }
    
    public int getPostanskiBroj() {
        return postanskiBroj;
    }
    public void setPostanskiBroj(int postanskiBroj) {
        this.postanskiBroj = postanskiBroj;
    }

    public String getGrad() {
        return grad;
    }
    public void setGrad(String grad) {
        this.grad = grad;
    }

    public String getDrzava() {
        return drzava;
    }
    public void setDrzava(String drzava) {
        this.drzava = drzava;
    }

    @Override
    public String toString() {
        return drzava + ", " + grad;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Mesto other = (Mesto) obj;
        if (this.postanskiBroj != other.postanskiBroj) {
            return false;
        }
        return true;
    }
    
    

    
    
    
}
