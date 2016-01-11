/* Nama     : Fadel Ariefa (1408107010004)
 *            Putri Afrah (1408107010039)
 * Kelompok : Satu
 * Tema     : PohonKu
 */

import java.net.*;
import java.io.*;
import java.util.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ArrayList;

public class Process implements Runnable {
    Simpan tampung;

    String Kirim= null;
    OutputStream keluaran =null;
    BufferedWriter keluaranBuf = null;
    Calendar kalender = Calendar.getInstance();
    String waktuStr = kalender.getTime().toString();

    public Process(Socket koneksiKiriman, Simpan tampung) {
        koneksi = koneksiKiriman;
        this.tampung=tampung;

    }

    public void run() {
        try{
            if (koneksi != null)
                prosesPermintaanClient(koneksi);
        }   
        catch(IOException err) {
            System.out.println(err);
        }
        catch(InterruptedException err) {
            System.out.println(err);
        }
    }

    private void prosesPermintaanClient(Socket koneksi) 
    throws InterruptedException, IOException {
        String ip = koneksi.getInetAddress().getHostAddress();
        System.out.println("Dari: " + ip);

        // Ambil dan tampilkan masukan

        InputStream masukan = koneksi.getInputStream();
        BufferedReader masukanReader = new BufferedReader(new InputStreamReader(masukan)); 
        String baris = masukanReader.readLine();

        OutputStream keluaran = koneksi.getOutputStream();
        BufferedWriter keluaranBuf = new BufferedWriter(new OutputStreamWriter(keluaran));

        Date waktu = new Date();
        DateFormat df = new SimpleDateFormat ("HH:mm");
        String d1 = df.format(waktu);

        try{
            String [] split1 = baris.split(" ");       // "(" ")|("::")"
            String [] identitas = split1[1].split("::");

            if(identitas.length==4){
                //(ID SUHU LEMBAB UV NITROGEN)
                tampung.isiData(split1[0], d1, identitas[0], identitas[1], identitas[2], identitas[3]);

                tampung.showData();

                keluaran = koneksi.getOutputStream();
                keluaranBuf = new BufferedWriter (new OutputStreamWriter(keluaran));
                keluaranBuf.write("Data telah disimpan");
                keluaranBuf.newLine();
                keluaranBuf.flush();
                koneksi.close();
            }
            else if(identitas.length==1) {
                if(Character.isLetter(identitas[0].charAt(0))){
                    String tampilkan="";

                    tampilkan = tampung.ambilData(identitas[0], split1[0]);
                    if(tampilkan==""){ 
                        tampilkan="Pohon tidak ditemukan";
                    }

                    keluaran = koneksi.getOutputStream();
                    keluaranBuf = new BufferedWriter (new OutputStreamWriter(keluaran));
                    keluaranBuf.write(tampilkan);
                    keluaranBuf.newLine();
                    keluaranBuf.flush();
                    koneksi.close();
                } 
                else if(Character.isDigit(identitas[0].charAt(0))){
                    String tampilkan="";

                    tampilkan = tampung.ambilWaktu(split1[0], split1[1]);

                    if(tampilkan==""){ 
                        tampilkan="Pohon tidak ditemukan";
                    }

                    keluaran = koneksi.getOutputStream();
                    keluaranBuf = new BufferedWriter (new OutputStreamWriter(keluaran));
                    keluaranBuf.write(tampilkan);
                    keluaranBuf.newLine();
                    keluaranBuf.flush();
                    koneksi.close();

                    /*           else if(identitas.length==1) {
                    if(Character.isNumeric(identitas[0])){

                    keluaran = koneksi.getOutputStream();
                    keluaranBuf = new BufferedWriter (new OutputStreamWriter(keluaran));
                    keluaranBuf.write("Perintah tidak dikenal!");
                    keluaranBuf.newLine();
                    keluaranBuf.flush();
                    } **/

                    //keluaranBuf.newLine();
                    //keluaranBuf.flush();

                }
            }
            else {
                keluaran = koneksi.getOutputStream();
                keluaranBuf = new BufferedWriter (new OutputStreamWriter(keluaran));
                keluaranBuf.write("Data telah disimpan");
                keluaranBuf.newLine();
                keluaranBuf.flush();
                koneksi.close();
            }
        }catch(Exception e){
            keluaran = koneksi.getOutputStream();
                keluaranBuf = new BufferedWriter (new OutputStreamWriter(keluaran));
                keluaranBuf.write("Penulisan format salah");
                keluaranBuf.newLine();
                keluaranBuf.flush();
                koneksi.close();
            
        }

    }

    private void prosesPermintaanClient() {
        try {
            // IP address asal koneksi                                                                   
            String ip = koneksi.getInetAddress().getHostAddress();
            // Tampilkan pesan
            System.out.println("Dari : " + ip);
            // Baca dari socket
            InputStream masukan = koneksi.getInputStream();
            BufferedReader masukanReader = new BufferedReader(new InputStreamReader(masukan)); 
            String baris = masukanReader.readLine();
            while (baris != null) {
                System.out.println(baris);
                baris = masukanReader.readLine();
            }

            // Tunggu 2 detik
            System.out.println("Tunggu...");
            Thread.sleep(2000);
            System.out.println("Selesai tunggu...");

            koneksi.close();
        }
        catch(IOException err) {
            System.out.println(err);
        }
        catch(InterruptedException err) {
            System.out.println(err);
        }
    }
    private Socket koneksi; 
}