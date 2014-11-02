
package sykkelbyen;

// Laget av Hans Christian Nenseth, s236334, Ingeniør Data
// og Torbjørn Brandrud, s236329, Ingeniør Data

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Utleiested extends JFrame implements ActionListener {
    
    // Display-vinduer for hvert av utleiestedene
    
   private Stativ stativet;
   private JTextField  personIdFelt, sykkelIdFelt;
   private JTextArea display;
   private JButton ut, inn ;
   private PersonRegister personer;

   
   public Utleiested(String navn, int antall, PersonRegister p)
   {
     super("BYSYKKEL " + navn);
     personer = p;
     stativet = new Stativ(antall);
     
     personIdFelt = new JTextField( 2 );
     sykkelIdFelt = new JTextField( 2 );
     display = new JTextArea( 10, 25 );
     display.setEditable( false );
     ut = new JButton( "Leie" );
     ut.addActionListener( this );
     inn = new JButton( "Levere" );
     inn.addActionListener( this );
     Container c = getContentPane();
     setLayout(new FlowLayout());
     add( new JLabel( "Person Id:" ) );
     add( personIdFelt );
     add(ut);
     add( new JLabel( "Sykkel Id:" ) );
     add( sykkelIdFelt );
     add(inn);
     add(new JScrollPane( display));
     setSize(400, 300);
     setVisible(true);
     setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   }

   
   public void leiUt(){
       int id = Integer.parseInt(personIdFelt.getText());
       if (personer.finnPerson(id) != null ){
           String resultat = stativet.leiUt(personer.finnPerson(id));
           display.append(resultat);
       }
       else
           display.append("Personen finnes ikke i registeret.\n");
   }

   
   public void leverInn(){
       String resultat;
       int id = Integer.parseInt(sykkelIdFelt.getText());
       if (personer.finnSykkelBruker(id) != null )
           resultat = stativet.leverInn(personer.finnSykkelBruker(id));
       else
           resultat = "Det finnes ingen sykkel med dette ID\neller så har ingen leid denne sykkelen.\n";
       display.append(resultat);
   }

   
   public void actionPerformed(ActionEvent e ){
       if (e.getSource() == ut)
           this.leiUt();
       else if (e.getSource() == inn)
           this.leverInn();
   }
}
