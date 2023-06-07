import java.awt.GridLayout;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class Tests {
  private static String[] jautajumi;	//Masīvs, kas uzglabā jautājumus
  private static String[][] atbildes;	//Masīvs, kas uzglabā atbildes
  private static int[][] parVaiNepAtbildes;	//Masīvs, kas satur pareižo atbilžu vērtības
  //Galvenā metode
  public static void main(String[] args) {
    Object[] opcijas = { "Sākt", "Iziet" }; //Masīvs, kas uzglabā vērtības, lai izietu vai sāktu testu
    //Centrēts teksts, ko lietotājam parāda programmas sākumā, teksts centrēts izmantojot html funkcijas
    String teksts = "<html><div style='text-align: center;'>Sveiks, izvēlies \"Sākt\", lai pildītu testu par<br>"
        + "viendimensiju masīviem, \"Iziet\", lai aizvērtu aplikāciju.</div></html>";
    //Izvēles logs. kurā ir iespējams sākt testu vai iziet
    int izvele = JOptionPane.showOptionDialog(null, teksts, "Sākums",
        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcijas, opcijas[0]);
    //switch, lai lietotājs varētu izvēlēties turpmāko darbību
    switch (izvele) {
      case 0:	
        saktTestu();	//Aizsūta lietotāju uz testa pildīšanas daļu
        break;
      case 1:
        JOptionPane.showMessageDialog(null, "Aplikācija apstādināta.");	//Izvada ziņu par spēles aizvēršanu
        break;
      default:
        JOptionPane.showMessageDialog(null, "Aplikācija apstādināta.");	//Izvada ziņu par spēles aizvēršanu
    }
  }
  //Metode, kas satur 
  public static void saktTestu() {
    // Jautājumi uz kuriem lietotājam jāatbild
    jautajumi = new String[] {
        "Kas ir masīvs?",																	
        "Kā deklarēt masīvu Java programmēšanas valodā?",
        "Kā piekļūt masīva elementam?",
        "Kas ir masīva garums?",
        "Kā inicializēt masīvu ar vērtībām?",
        "Vai masīvā var uzglabāt dažāda tipa elementus?",
        "Kā atrast maksimālo vērtību veselo skaitļu masīvā?",
        "Vai masīva izmēru var mainīt pēc tam, kad tas ir deklarēts?",
        "Kā pārlūkot visus masīva elementus?",
        "Kas notiek, ja mēģina piekļūt masīva elementam ar indeksu, kas ir ārpus robežām?"
    };
    // Masīvs, kas satur JCheckBoxes
    JCheckBox[][] atbildesLodzini = new JCheckBox[jautajumi.length][4]; 
    // Atbildes uz jautājumiem
    atbildes = new String[][] {
    	// 1. jautājums
        { "Mainīgais, kas var uzglabāt vairākus vienāda tipa vērtības.", 								// A
            "Datu struktūra, kas var uzglabāt gan primārās, gan atsauces tipus.", 						// B
            "Objektu kolekcija, kam var dinamiski mainīt izmērus.",										// C
            "Atslēgvārds, ko izmanto mainīgo deklarēšanai" },											// D
        // 2. jautājums
        { "int[] mansMasīvs;", 																			// A
            "mansMasīvs = new int[];", 																	// B
            "int mansMasīvs[];", 																		// C
            "mansMasīvs = new int[];" }, 																// D
        // 3. jautājums
        { "Izmantojot elementa indeksu kvadrātiekavās.", 												// A
            "Izsaucot metodi masīva objektā.", 															// B
            "Izmantojot elementa vērtību.", 															// C
            "Nevar piekļūt masīva elementam." }, 														// D
        // 4. jautājums
        { "Pēdējā elementa indekss masīvā.", 															// A
            "Elementu skaits masīvā.", 																	// B
            "Atmiņas izmērs, kas piešķirts masīvam.", 													// C
            "Maksimālā vērtība, kas var tikt uzglabāta masīvā." }, 										// D
        // 5. jautājums
        { "int[] mansMasīvs = {1, 2, 3};", 																// A
            "int mansMasīvs[] = new int[3];", 															// B
            "mansMasīvs = {1, 2, 3};", 																	// C
            "int mansMasīvs[] = {1, 2, 3};" }, 															// D
        // 6. jautājums
        { "Nē, visiem masīva elementiem jābūt vienāda tipa.", 											// A
            "Jā, Java ļauj sajaukt dažāda tipa elementus masīvā.", 										// B
            "Tikai tad, ja masīvs ir deklarēts kā ģeneriskais tips.", 									// C
            "Tikai tad, ja masīvs ir deklarēts kā objekta tips." }, 									// D
        // 7. jautājums
        { "Izmantojot iebūvēto max() metodi klases Array.", 											// A
            "Sakārtojot masīvu augošā secībā.", 														// B
            "Izmantojot Math.max() funkciju.", 															// C
            "Izmantojot ciklu, lai salīdzinātu katru elementu ar pašreizējo maksimālo." }, 				// D
        // 8. jautājums
        { "Jā, var dinamiski pievienot vai noņemt elementus.",											// A
            "Nē, masīva izmērs ir fiksēts pēc deklarēšanas.", 											// B
            "Tikai tad, ja izmanto ArrayList klasi, nevis parasto masīvu.",								// C
            "Tikai tad, ja izmantojat resize() metodi, lai mainītu masīva izmēru." }, 					// D
        // 9. jautājums
        { "Izmantojot for ciklu ar indeksa mainīgo.", 													// A
            "Izmantojot forEach ciklu.", 																// B
            "Izmantojot while ciklu un palielinot skaitītāja mainīgo.", 								// C
            "Izsaucot iterate() metodi klases Array." }, 												// D
        // 10. jautājums
        { "Programma izmet ArrayIndexOutOfBoundsException kļūdu.", 										// A
            "Indeksēšana apvīžas un piekļūst citam elementam.", 										// B
            "Kompilators izmet brīdinājumu, bet programma normāli darbojas.", 							// C
            "Programma izmet kļūdu un aptur darbību." } 												// D
    };
    //Masīvs, kas satur pareizo atbilžu indeksus
    parVaiNepAtbildes = new int[][] {
        { 0, 1 },
        { 0, 2 },
        { 0, 3 },
        { 0, 1 },
        { 0, 3 },
        { 1, 3 },
        { 1, 3 },
        { 0, 1 },
        { 0, 2 },
        { 0, 3 }
    };
    // izveido interaktīvu logu, kurā tiek rādīti jautājumi un atbildes izvēles iespējas.
    // Izveido boolean masīvu "parVaiNep", kurā tiks glabāta informācija par to, vai katrs jautājums ir atbildēts pareizi vai nepareizi.
    boolean[] parVaiNep = new boolean[jautajumi.length];
    // Definē mainīgo "numJautajumi", kas norāda uz kopējo jautājumu skaitu.
    int numJautajumi = jautajumi.length;
    // Izveido JPanel ar 5 rindiņām un 1 kolonnas izkārtojumu.
    for (int i = 0; i < numJautajumi; i++) {
      JPanel panel = new JPanel(new GridLayout(5, 1));
      JLabel questionLabel = new JLabel(jautajumi[i]);
      // Izveido JLabel ar konkrēto jautājumu un pievieno to panelim.
      panel.add(questionLabel);
      for (int j = 0; j < 4; j++) {
        atbildesLodzini[i][j] = new JCheckBox(atbildes[i][j]);
        // Izveido JCheckBox komponentes ar atbildēm un pievieno tās panelim.
        panel.add(atbildesLodzini[i][j]);
      }
      // Parāda JOptionPane dialogu ar izveidoto paneli, kurā tiek attēlots jautājums un atbildes izvēles iespējas.
      // Lietotājs var noklikšķināt uz "OK" vai "Cancel" pogām.
      int izvele = JOptionPane.showConfirmDialog(null, panel, "Jautājums " + (i + 1),
          JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

      if (izvele == JOptionPane.OK_OPTION) {
    	// Izveido boolean masīvu "izveles" ar 4 elementiem, kas glabās informāciju par lietotāja izvēlētajām atbildēm.
        boolean[] izveles = new boolean[4];
        for (int j = 0; j < 4; j++) {
          // Saglabā lietotāja izvēlētās atbildes statusu (izvēlētas vai neizvēlētas) masīvā "izveles".
          izveles[j] = atbildesLodzini[i][j].isSelected();
        }
        // Izsauc funkciju "parbauditAtbildes", lai pārbaudītu, vai izvēlētās atbildes ir pareizas vai nepareizas, 
        // un rezultātu saglabā masīvā "parVaiNep".
        parVaiNep[i] = parbauditAtbildes(i, izveles);
      } else {
    	// Ja lietotājs ir atcēlis atbildi vai aizvēris logu, iestata "numJautajumi" vērtību uz sākuma vērtību
        numJautajumi = i;
        break;
      }
    }
    // Izvada lietotajam testa rezultātus
    paraditRezultatus(parVaiNep);
  }

  //Metode, kas pārbauda, vai lietotāja izvēlētie atbilžu varianti sakrīt ar pareizajiem indeksiem
  public static boolean parbauditAtbildes(int jautajumaIndeks, boolean[] izveles) {
	  int[] parVaiNepIndeksi = parVaiNepAtbildes[jautajumaIndeks];
	  // Iegūst pareizos un nepareizos indeksus no masīva "parVaiNepAtbildes", 
	  // kas atbilst jautājumam ar indeksu "jautajumaIndeks".

	  for (int i = 0; i < 4; i++) {
		  boolean irPareizi = satur(parVaiNepIndeksi, i);
		  // Pārbauda, vai indekss "i" ir sastopams masīvā "parVaiNepIndeksi" 
		  // un atgriež, vai tas ir pareizs vai nepareizs atbilžu variants.

		  boolean irIzvelets = izveles[i];
		  // Iegūst informāciju par to, vai lietotājs ir izvēlējies atbildi ar indeksu "i".

		  if (irPareizi != irIzvelets) {
			  // Ja pareizs/nepareizs indekss nesakrīt ar lietotāja izvēlēto atbildi,
			  // tad atgriežam "false", norādot, ka atbilde ir nepareiza.
			  return false;
		  }
	  }

	  // Ja visi pareizie/nepareizie indeksi sakrīt ar lietotāja izvēlētajām atbildēm,
	  // tad atgrieža "true", norādot, ka atbilde ir pareiza.
	  return true;
  }
  
  //Metode, kas pārbauda, vai masīvs satur norādīto vērtību
  public static boolean satur(int[] masivs, int vertiba) {
	  for (int i = 0; i < masivs.length; i++) {
		  if (masivs[i] == vertiba) {
			  return true;
		  }
	  }
	  // Iterē caur masīvu "masivs" un pārbauda, vai kāda vērtība sakrīt ar norādīto vērtību "vertiba".
	  // Ja sakrītība ir atrasta, tad atgriežam "true".

	  return false;
	  // Ja pēc masīva iterācijas nav atrasta sakrītība, atgriežam "false".
  }

  
  //Metode, kas parāda rezultātus pēc testa pabeigšanas
  public static void paraditRezultatus(boolean[] parVaiNep) {
	  StringBuilder rezultatuVeidotajs = new StringBuilder();
	  // Izveido StringBuilder objektu, kurā tiks veidots rezultāta teksts.

	  rezultatuVeidotajs.append("Testa rezultāti:\n\n");
	  // Pievieno sākuma tekstu rezultāta veidotājam.

	  int numJautajumi = jautajumi.length;
	  int numPareizi = 0;
	  // Definē mainīgos "numJautajumi" (jautājumu skaits) un "numPareizi" (pareizo atbilžu skaits) un inicializē tos.

	  for (int i = 0; i < numJautajumi; i++) {
		  char atzime = parVaiNep[i] ? '\u2713' : '\u2717';
		  // Iegūst atzīmi (simbolu) - '✓' vai '✗' - atkarībā no tā, vai atbilde ir pareiza vai nepareiza, 
		  // izmantojot operātoru "?".

		  rezultatuVeidotajs.append("Jautājums ").append(i + 1).append(": ").append(atzime).append("\n");
		  // Pievieno rezultāta tekstu veidotājam, norādot jautājuma numuru un atzīmi (pareizi vai nepareizi).

		  if (parVaiNep[i]) {
			  numPareizi++;
			  // Ja atbilde ir pareiza, palielina "numPareizi" vērtību par 1.
		  }
	  }

	  double procents = (double) numPareizi / numJautajumi * 100;
	  // Aprēķina pareizo atbilžu procentuālo daudzumu.

	  rezultatuVeidotajs.append("\nKopā pareizi: ").append(numPareizi).append(" / ").append(numJautajumi);
	  rezultatuVeidotajs.append(" (").append(String.format("%.2f", procents)).append("%)");
	  // Pievieno rezultātu tekstu veidotājam, norādot kopējo pareizo atbilžu skaitu un to procentuālo daudzumu.

	  JOptionPane.showMessageDialog(null, rezultatuVeidotajs.toString(), "Rezultāti", JOptionPane.PLAIN_MESSAGE);
	  // Rāda rezultātu dialoglodziņu ar veidoto rezultātu tekstu.
  	}
}