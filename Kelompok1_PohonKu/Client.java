/* Nama     : Fadel Ariefa (1408107010004)
 *            Putri Afrah (1408107010039)
 * Kelompok : Satu
 * Tema     : PohonKu
 */


import java.net.Socket;
import java.net.UnknownHostException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.BufferedReader;

import java.io.OutputStreamWriter;
import java.io.Writer;
import java.io.BufferedWriter;

import java.util.Scanner;

public class Client {
    public void phn() 
    throws UnknownHostException, IOException {
        Socket socket = new Socket("localhost", 33333);
        Reader masukan=null;
        BufferedReader masukanBuff=null;

        try {

            Scanner keyboard = new Scanner(System.in);
            System.out.print("Pesan: ");
            String ketikanSatuBaris = keyboard.nextLine();

            // Tulis ke socket
            Writer keluaranWriter = new OutputStreamWriter(socket.getOutputStream()); 
            BufferedWriter keluaranBuff = new BufferedWriter(keluaranWriter);
            keluaranBuff.write(ketikanSatuBaris);
            keluaranBuff.write("\n");
            keluaranBuff.flush();

            // Baca dari Server
            System.out.print("Server: \n");

            masukan = new InputStreamReader(socket.getInputStream()); 
            masukanBuff = new BufferedReader(masukan);
            String baris = masukanBuff.readLine();
            // String baris= "";
            
            String data = masukanBuff.readLine();
            int i=1;
            
            while (data!=null) {
                baris =baris +"\n"+  data;
                data = masukanBuff.readLine();
                //i++;
            }

            System.out.println(baris);
            
        }
        catch(IOException salah) {
            System.out.println(salah);
        }
        finally {
            if (socket != null)
                socket.close();
        }
    }
}

