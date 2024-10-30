package main.java.com.compito;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerThread extends Thread {

    Socket s;
    List<String> listaUsername;
    Biglietti biglietti = new Biglietti(100);

    public ServerThread(Socket s, Biglietti biglietti) {
        this.s = s;
        this.biglietti = biglietti;
        listaUsername = new ArrayList<>();
    }

    public void run() {

        boolean loop = true;
        boolean loopAcquisto = true;

        try {

            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());

            String usernameRicevuto = in.readLine();

            while (loop) {

                if (getArrayElements(listaUsername, usernameRicevuto) == true) {

                    out.writeBytes("NO" + "\n");

                } else {

                    loop = false;
                    out.writeBytes("OK" + "\n");
                }
            }

            do {
                String azioneRicevuta = in.readLine();

                switch (azioneRicevuta) {
                    case "N":
                        Integer.toString(biglietti.getBiglietti());
                        out.writeBytes("Sono rimasti: " + biglietti.getBiglietti() + " biglietti" + "\n");
                        break;

                    case "BUY":
                        out.writeBytes("Digita il numero di biglietti che vuoi acquistare \n");
                        String numBiglRicevuto = in.readLine();
                        try {
                            if (biglietti.getBiglietti() < Integer.parseInt(numBiglRicevuto) || Integer.parseInt(numBiglRicevuto) > 100) {
                                out.writeBytes("KO" + "\n");
                            } else {
                                out.writeBytes("OK" + "\n");
                            }
                        } catch (Exception e) {
                            out.writeBytes("KO" + "\n");
                        }
                        break;

                    case "QUIT":
                        loopAcquisto = false;
                        break;
                }
            } while (loopAcquisto);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public boolean getArrayElements(List<String> listaUsername2, String stringa) {
        for (int i = 0; i < listaUsername2.size(); i++) {
            if (listaUsername2.get(i).equals(stringa)) {
                return true;
            }
        }
        return false;
    }
}
