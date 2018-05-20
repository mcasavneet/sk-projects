package com.techsavvy.by.sep.demo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/**
 * Created by savneet on 20-05-2018.
 */
public class ByteSepDemoApp {
    public static void main(String[] args) throws IOException {
        String EOR = "<EOR>";
        String r1 = "Hello";
        String r2 = "World";
        String r3 = "Check";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        outputStream.write(r1.getBytes());
        outputStream.write(EOR.getBytes());
        outputStream.write(r2.getBytes());
        outputStream.write(EOR.getBytes());
        outputStream.write(r3.getBytes());
        outputStream.write(EOR.getBytes());
        byte[] buf = outputStream.toByteArray();

        ByteBuffer byteBufferData = ByteBuffer.allocate(2048);
        int eorCounter = 0;
        int offset = 0;
        for(byte b : buf){
            if(eorCounter >= 1 && eorCounter < 5){
                eorCounter++;
                continue;
            }
            ByteArrayOutputStream eorStream = new ByteArrayOutputStream();
            eorStream.write(buf,offset,5);
            String eoRString = new String(eorStream.toByteArray());
            if(eoRString.equals(EOR)){
                String data = new String(byteBufferData.array());
                System.out.println(data);
                offset+=5;
                eorCounter = 1;
                byteBufferData = ByteBuffer.allocate(2048);
                continue;
            }
            byteBufferData.put(b);
            offset++;
        }
    }
}
