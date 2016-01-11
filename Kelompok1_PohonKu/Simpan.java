/* Nama     : Fadel Ariefa (1408107010004)
 *            Putri Afrah (1408107010039)
 * Kelompok : Satu
 * Tema     : PohonKu
 */

import java.util.ArrayList;
import java.util.Scanner; 

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.*;
import java.text.*;

public class Simpan{

    ArrayList <pohonku> tampung;
    public Simpan()
    {
        //instansiasi
        tampung = new ArrayList<pohonku>();
    }

    public void isiData(String id, String waktu, 
    String suhu, String lem, String uv, String nit)
    {
        tampung.add(new pohonku(id, waktu, suhu, lem, uv, nit));
    }

    public void showData()
    {
        for(pohonku pohon:tampung){

            
            System.out.println(pohon.getSuhu());
            System.out.println(pohon.getLem());
            System.out.println(pohon.getUv());
            System.out.println(pohon.getNit());

        }

    }
    public String ambilData(String keadaan, String id) {
        String tampil="";
        for(pohonku pohon:tampung){
           
            if(id.equals(pohon.getId()) && keadaan.equals("SUHU")){
                tampil = tampil + pohon.getSuhu()+"\n";
                System.out.println("");
            }

            if(id.equals(pohon.getId()) && keadaan.equals("UV")){
                tampil = tampil + pohon.getUv()+"\n";
                System.out.println("");
            }

            if(id.equals(pohon.getId()) && keadaan.equals("NITROGEN")){
                tampil = tampil + pohon.getNit()+"\n";
                System.out.println("");
            }

            if(id.equals(pohon.getId()) && keadaan.equals("LEMBAB")){
                tampil = tampil + pohon.getLem()+"\n";
                System.out.println("");
            }

        }
        
        return tampil;
    }
    
    public String ambilWaktu(String id, String waktu) {
        String tampil="";
        for(pohonku pohon:tampung){
           
            if(id.equals(pohon.getId()) && waktu.equals(pohon.getWaktu())){
                tampil = tampil + pohon.showAll()+"\n";
            }

        }
        return tampil;
    } 
}