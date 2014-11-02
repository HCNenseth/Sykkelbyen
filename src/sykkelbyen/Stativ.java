
package sykkelbyen;

// Laget av Hans Christian Nenseth, s236334, Ingeniør Data
// og Torbjørn Brandrud, s236329, Ingeniør Data

public class Stativ {
    
    // Sette inn og ta ut sykkler av stativene
    
    private Sykkel[] stativ;
    
    public Stativ(int antallSykler){
        stativ = new Sykkel[antallSykler];
        fyllStativet();
    }
    
    
    public void fyllStativet(){
        for (int i=0; i<10; i++) {
            stativ[i] = new Sykkel();
        }
    }
    
    
    public String leiUt(Person s){
        if (s.godkjent()){
            if (stativ.length > 0){
                for (int i = 0; i< stativ.length; i++){
                    if (stativ[i] != null){
                        s.leiSykkel(stativ[i]);
                        int sykId = stativ[i].getSykkel();
                        stativ[i] = null;
                        return "Ta sykkel (id = " + sykId + ") fra plass " + (i+1)+ "\n";
                    }
                }
                return "Tull \n";
            }
            return "Ingen sykler ledig på dette stativet\n";
        }
        return "Sykkelen kan ikke leies ut da du\nenten har en sykkel fra før eller har anmerkninger\n";
   }
    
    
   public String leverInn(Person s ){
       for (int i=0; i<stativ.length; i++){
           if ( stativ[i] == null){
              stativ[i] = s.gets();
              s.leverInn();
              return "Sett sykkelen på plass " + (1+i) + "\n";
           }
       }
       return "Stativet er fullt, finn et annet stativ.\n";
   }
}