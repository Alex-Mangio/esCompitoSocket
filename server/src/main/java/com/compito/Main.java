package com.compito;

import java.io.IOException;
import java.net.ServerSocket;

import main.java.com.compito.Biglietti;
import main.java.com.compito.ServerThread;

public class Main {
    public static void main(String[] args) throws IOException{
        
        ServerSocket ss = new ServerSocket(3000);
        Biglietti b = new Biglietti(100);

        System.out.println("Server avviato");

        while (true) {
            ServerThread st = new ServerThread(ss.accept(),b);
            st.start();
        }
    }
}