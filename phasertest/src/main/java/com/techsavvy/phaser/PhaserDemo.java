package com.techsavvy.phaser;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Created by savneet on 04-04-2018.
 */

@Component
public class PhaserDemo {

    public void testPhaser() {
        String namesStr = "Kanishka,Niti,Nanu,Preeti,Guddu,Gurpreet,Pritam,Pappu,Swaran,Sharanjeet,Japjot,Harpal,Swati,Shikha,Mitali";
        String[] names = namesStr.split(",");
        int batchCount = 2;
        int totalCount = names.length;
        ExecutorService executor = Executors.newFixedThreadPool(totalCount/batchCount);
        final Phaser phaser = new Phaser(1);
        ArrayList<String> args = new ArrayList<>();
        ArrayList<Future> resp = new ArrayList<>();
        int counter = 0;
        int numOfBatches = 0;
        for(String temp : names){
            args.add(temp);
            counter++;
            if(counter == batchCount || numOfBatches*batchCount+counter == totalCount ){
                numOfBatches++;
                resp.add(executor.submit(new MyThread(args, phaser)));
                args.clear();
                counter = 0;
            }


        }

        phaser.arriveAndAwaitAdvance();
        System.out.println("It should print after all names");
    }

    class MyThread implements Runnable{
        ArrayList<String> args = new ArrayList<>();
        Phaser phaser;
        MyThread(ArrayList<String> names, Phaser phaser){
            for(String name : names){
                args.add(name);
            }
            this.phaser = phaser;
            phaser.register();
        }

        @Override
        public void run() {
            for(String s : args)
                System.out.println("Name " + s);
            phaser.arriveAndDeregister();
        }
    }
}
