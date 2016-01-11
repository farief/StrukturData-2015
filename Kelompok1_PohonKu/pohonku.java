
/* Nama     : Fadel Ariefa (1408107010004)
 *            Putri Afrah (1408107010039)
 * Kelompok : Satu
 * Tema     : PohonKu
 */

public class pohonku
{


    String waktu;
    String id;
    String [] id2;
    String suhu, lem, uv, nit;
    String tampil;
    
  // DateFormat df = new SimpleDateFormat ("HH:mm");

    public pohonku(String id, String waktu, 
    String suhu, String lem, String uv, String nit)
    {
        this.id = id;
        this.waktu = waktu;
        this.suhu = suhu;
        this.lem = lem;
        this.uv = uv;
        this.nit = nit;
        
        id2 = id.split("-");
        
    }

    public String getSuhu()
    {
        tampil = getWaktu()+" Pohon-"+id2[1]+" "+suhu;
        return tampil;
    }

    public String getLem()
    {
        tampil = getWaktu()+" Pohon-"+id2[1]+" "+lem;
        return tampil;
    }

    public String getUv()
    {
        tampil = getWaktu()+" Pohon-"+id2[1]+" "+uv;
        return tampil;
    }

    public String getNit()
    {
        tampil = getWaktu()+" Pohon-"+id2[1]+" "+nit;
        return tampil;
    }

    public String getId()
    {
        return id;
    }

    public String getWaktu()
    {
       
        return waktu;
    }
    
    public String showAll()
    {
         tampil = getWaktu()+" Pohon-"+id2[1]+" "+suhu+"::"+lem+"::"+uv+"::"+nit;
        return tampil;
    }
    
}