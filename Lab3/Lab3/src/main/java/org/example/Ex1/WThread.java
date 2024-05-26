package org.example.Ex1;

import org.example.Ex1.FileService;
import org.example.Ex1.Main;

public class WThread extends Thread{
    FileService service;

    public WThread(FileService service) {

        this.service = service;

    }

    public void run(){

        while(!Main.isStopThreads()){

            String msg=String.valueOf(Math.round(Math.random()*100));

            service.write(msg);

            try {

                Thread.sleep(2000);

            } catch (InterruptedException e) {

                e.printStackTrace();

            }

        }

    }
}
