/* Nama     : Fadel Ariefa (1408107010004)
 *            Putri Afrah (1408107010039)
 * Kelompok : Satu
 * Tema     : PohonKu
 */


import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

import java.net.Socket;
import java.net.UnknownHostException;

public class UtamaServer {
    public static void main(String[] args) 
    throws UnknownHostException, IOException {
        Server server = new Server();
        server.dengar();
    }
}