/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconsole.filehandle;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class FileHandle {
    public static void main(String[] args){
        try {
            FileInputStream fis = new FileInputStream("hello.txt");
            //FileOutputStream fos = new FileOutputStream("hello_clone.txt");1
            int b;
            while((b = fis.read()) != -1){
                System.out.print((char) b);
                //fos.write(b);1
            }
            fis.close();
            //fos.close();1
        } catch (FileNotFoundException e) {
            
        } catch (IOException ex) {
            Logger.getLogger(FileHandle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
