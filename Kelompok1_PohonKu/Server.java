/* Nama     : Fadel Ariefa (1408107010004)
 *            Putri Afrah (1408107010039)
 * Kelompok : Satu
 * Tema     : PohonKu
 */

import java.net.Socket;
import java.net.ServerSocket;
import java.net.BindException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;
public class Server {
    public Server() 
    throws BindException, IOException {
        tampung = new Simpan();
        serverSocket = new ServerSocket(33333);
    }

    public void dengar() throws IOException {
        System.out.println("Menunggu koneksi...");
        while (true) {
            Socket koneksi = null;
            try {
                koneksi = serverSocket.accept();
                Process satuProcess = new Process(koneksi, tampung);
                Thread satuProcessThread = new Thread(satuProcess);
                satuProcessThread.start();  
            }
            catch(IOException err) {
                System.out.println(err);
            }
        }
    }

    private Simpan tampung=null;
    
    private ServerSocket serverSocket = null;
}
