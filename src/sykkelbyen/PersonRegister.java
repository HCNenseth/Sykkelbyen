
package sykkelbyen;

// Laget av Hans Christian Nenseth, s236334, Ingeniør Data
// og Torbjørn Brandrud, s236329, Ingeniør Data

public class PersonRegister {
    
    // Liste over person-objektene
    
    private Person[] personer;

   public PersonRegister(int antall)
   {
     personer = new Person[antall];
     opprettPersonregister();
   }

   public  void opprettPersonregister(){
       personer[0] = new Person("Zeynep");
       personer[1] = new Person("Anja");
       personer[2] = new Person("Bjørn");
       personer[3] = new Person("Mats");
       personer[4] = new Person("Jan");
       personer[5] = new Person("Aleksander");
       personer[6] = new Person("Jan Ivar");
       personer[7] = new Person("Elin");
   }

   public Person finnPerson(int personId){
       for (int i = 0; i<personer.length; i++)
           if (personer[i] != null && personer[i].getidNr() == personId)
              return personer[i];
       return null;
   }

   public Person finnSykkelBruker(int sykkelId){
       for (int i = 0; i<personer.length; i++)
           if (personer[i] != null && personer[i].gets() != null && personer[i].gets().getSykkel() == sykkelId)
               return personer[i];
       return null;
   }
}
