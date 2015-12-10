import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Utama {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);
            DomainSiapa tanya = new DomainSiapa();
            System.out.print("Pesan : ");
            String in = input.nextLine();
            tanya.whois(in);
        }
        catch (UnknownHostException ex) {
            System.err.println(ex);
        }
        catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
