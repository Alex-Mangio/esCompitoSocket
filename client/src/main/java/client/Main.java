package client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

import main.java.com.compito.Biglietti;

public class Main {
    public static void main(String[] args) throws IOException {

        try {
            Socket s = new Socket("localhost", 3000);

            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());

            System.out.println("Benvenuto alla biglietteria");

            Biglietti biglietti = new Biglietti(100);

            boolean loop = true;

            do {

                System.out.println("Prima inserisci il tuo username:");
                Scanner username = new Scanner(System.in);
                String usernameStr = username.nextLine();
                out.writeBytes(usernameStr + "\n");
                String risp = in.readLine();
                if (risp.equals("OK")) {
                    break;
                }

            } while (true);

            do {

                System.out.println("COSA VUOI FARE? \n ");
                System.out.println("1)Vedi la disponibilita dei biglietti \n");
                System.out.println("2)Acquista i biglietti \n");
                System.out.println("3)Fine \n");

                Scanner azione = new Scanner(System.in);
                String azioneStr = azione.nextLine();

                switch (azioneStr) {
                    case "1":
                        azioneStr = "N";
                        out.writeBytes(azioneStr + "\n");
                        String risposta = in.readLine();
                        System.out.println(risposta);
                        break;

                    case "2":
                        azioneStr = "BUY";
                        out.writeBytes(azioneStr + "\n");
                        String stringa = in.readLine();
                        System.out.println(stringa);
                        Scanner numBigl = new Scanner(System.in);
                        String numBiglStr = numBigl.nextLine();
                        out.writeBytes(numBiglStr + "\n");
                        String acquisto = in.readLine();
                        if (acquisto.equals("KO")) {
                            System.out.println("Non ci sono biglietti sufficenti :(");
                            System.out.println("O non hai inserito un numero");
                        } else {
                            biglietti.setBiglietti(biglietti.getBiglietti()-Integer.parseInt(numBiglStr));
                            System.out.println("Biglietti acquistati con successo :)");
                        }
                        break;

                    case "3":
                        System.out.println("Disconnessione in corso");
                        azioneStr = "QUIT";
                        out.writeBytes(azioneStr + "\n");
                        loop = false;
                        break;
                }

            } while (loop);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}