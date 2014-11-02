
package sykkelbyen;

// Laget av Hans Christian Nenseth, s236334, Ingeniør Data
// og Torbjørn Brandrud, s236329, Ingeniør Data

import java.util.Date;
import java.text.DateFormat;


public class Person {
    
    // Prson-objektet og alle dets atributter
    
    private String navn;
    private int idNr;
    private Sykkel s;
    private String merknad;
    private Date startTid;
    private static int nesteNr = 1;
    public static final int MAXTIMER = 3;

    public Person(String n){
        navn = n;
        idNr = nesteNr++;
    }

    public int getidNr(){
        return idNr;
    }
    
    public Sykkel gets() {
        return s;
    }

   public boolean godkjent(){
       if((s == null) && (merknad == null))
           return true;
       return false;
    }   

   public void setMerknad(Date t, String m){
       DateFormat df = DateFormat.getInstance();
       merknad += df.format(t) + ":" + m + "\n";
   }

   public boolean leiSykkel(Sykkel s){
       if(godkjent()){
           this.s = s;
           startTid = new Date();
           return true;
       }
       return false;
   }

   public int leieTid(Date sluttTid){
       long varighet = sluttTid.getTime() - startTid.getTime();
       int tid = (int) Math.ceil(varighet/3_600_000); // antall påbegynte timer
       return tid;
   }

   public void leverInn(){
       Date sluttTid = new Date();
       if(leieTid(sluttTid) > Sykkel.MAXTID) {
           setMerknad(sluttTid, "Sykkel ble levert " + (leieTid(sluttTid)-Sykkel.MAXTID) +
                   "lovlig leietid er overskredet");
       }
       this.s = null;
   }

//   public String toString()  // Fant ingen bruk for denne!!
}
