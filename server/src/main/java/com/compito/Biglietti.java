package main.java.com.compito;

public class Biglietti {
    
    int biglietti;
    int bigliettiGOLD;
    int bigliettiPIT;
    int bigliettiPARTERRE;

    public Biglietti(int biglietti){
        this.biglietti = biglietti;
        this.bigliettiGOLD = 100;
        this.bigliettiPIT = 100;
        this.bigliettiPARTERRE = 100;
    }

    public int getBiglietti() {
        return biglietti;
    }

    public void setBiglietti(int biglietti) {
        this.biglietti = biglietti;
    }

    
    public int getBigliettiGOLD() {
        return bigliettiGOLD;
    }

    public void setBigliettiGOLD(int bigliettiGOLD) {
        this.bigliettiGOLD = bigliettiGOLD;
    }

    public int getBigliettiPIT() {
        return bigliettiPIT;
    }

    public void setBigliettiPIT(int bigliettiPIT) {
        this.bigliettiPIT = bigliettiPIT;
    }

    public int getBigliettiPARTERRE() {
        return bigliettiPARTERRE;
    }

    public void setBigliettiPARTERRE(int bigliettiPARTERRE) {
        this.bigliettiPARTERRE = bigliettiPARTERRE;
    }

}
