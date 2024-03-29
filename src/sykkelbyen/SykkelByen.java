
package sykkelbyen;

// Laget av Hans Christian Nenseth, s236334, Ingeniør Data
// og Torbjørn Brandrud, s236329, Ingeniør Data

public class SykkelByen{

    // Hovedklassen som inneholder main-metoden og oppretter utleiesteder
    
   private Utleiested[] steder;
   private PersonRegister register;

   public SykkelByen(int antall, PersonRegister r){
       register = r;
       steder = new Utleiested[antall];
       opprettSykkelSteder();
   }


   public void opprettSykkelSteder(){
       steder[0] = new Utleiested("Holbergs plass", 20, register);
       steder[1] = new Utleiested("Majorstua", 20, register);
       steder[2] = new Utleiested("Nasjonalteateret", 20, register);
       steder[3] = new Utleiested("Egertorvet", 20, register);
   }

   
   public static void main(String[] args){
       PersonRegister register = new PersonRegister(10);
       new SykkelByen(10, register);
   }
}