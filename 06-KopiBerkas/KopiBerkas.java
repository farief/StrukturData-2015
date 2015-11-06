import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Write a description of class kopiBerkas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KopiBerkas{
    
   public static void main(String [] args){
       try{
           KopiBerkas x = new KopiBerkas();
           x.kopi("Tes1.txt","TesAkhir.txt");
        }
        
         catch(IOException kesalahan){
           System.out.printf("Terjadi kesalahan: %s", kesalahan);
        
        
        }
        }
    
   public void kopi ( String sumber, String sasaran) throws IOException {
       FileInputStream masukan= null;
       FileOutputStream keluaran= null;
       try{
           masukan= new FileInputStream(sumber);
           keluaran= new FileOutputStream(sasaran);
           int karakter = masukan.read();
        while(karakter!=-1){
            keluaran.write(karakter);
            karakter=masukan.read();
        }
        keluaran.flush();
        }
    
       catch(IOException kesalahan){
           System.out.printf("Terjadi kesalahan: %s", kesalahan);
        
        
        }
    
        finally {
            // Tutup stream masukan
            if (masukan != null)
                masukan.close();
             if(keluaran != null)
                keluaran.close();
            }
               
    }
    
   
}

