
package sykkelbyen;

// Laget av Hans Christian Nenseth, s236334, Ingeniør Data
// og Torbjørn Brandrud, s236329, Ingeniør Data

public class Sykkel {
    
    //  Oppretter sykkelobjektet
    
    private int sykkelid;
    public static final int MAXTID = 3; // 3 timer
    private static int nesteid = 1;
    
    
    public Sykkel() {
        sykkelid = nesteid++;
    }
    
    public int getSykkel(){
        return sykkelid;
    }
}
