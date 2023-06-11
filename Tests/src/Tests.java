import java.awt.GridLayout;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class Tests {
  private static String[] jautajumi;		//Masīvs, kas uzglabā jautājumus.
  private static String[][] atbildes;		//Masīvs, kas uzglabā atbildes.
  private static int[][] parVaiNepAtbildes;	//Masīvs, kas satur pareižo atbilžu vērtības.
  
  //Galvenā metode.
  public static void main(String[] args) {
    String[] opcijas = { "Sākt", "Iziet" }; //Masīvs, kas uzglabā vērtības, lai izietu vai sāktu testu.
    //Centrēts teksts, ko lietotājam parāda programmas sākumā, teksts centrēts izmantojot html funkcijas.
    String teksts = "<html><div style='text-align: center;'>Sveiks, izvēlies \"Sākt\", lai pildītu testu par<br>"
        + "viendimensiju masīviem, \"Iziet\", lai aizvērtu aplikāciju."
        + "<br>Katrā jautājumā ieķeksē divas pareizās atbildes."
        + "<br>Veiksmi!</div></html>";
    //Izvēles logs kurā ir iespējams sākt testu vai iziet.
    int izvele = JOptionPane.showOptionDialog(null, teksts, "Sākums",
        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcijas, opcijas[0]);
    //switch, lai lietotājs varētu izvēlēties turpmāko darbību
    switch (izvele) {
      case 0:	
        saktTestu();	//Aizsūta lietotāju uz testa pildīšanas daļu.
        break;
      case 1:
        JOptionPane.showMessageDialog(null, "Aplikācija apstādināta.");	//Izvada ziņu par spēles aizvēršanu.
        break;
      default:
        JOptionPane.showMessageDialog(null, "Aplikācija apstādināta.");	//Izvada ziņu par spēles aizvēršanu.
    }
  }
  //Metode, kas satur 
  public static void saktTestu() {
    // Jautājumi uz kuriem lietotājam jāatbild.
    jautajumi = new String[] {
        "Kas ir masīvs?",																				//1														
        "Kā deklarēt masīvu Java programmēšanas valodā?",												//2
        "Kā piekļūt masīva elementam?",																	//3
        "Kas ir masīva garums?",																		//4
        "Kā inicializēt masīvu ar vērtībām?",															//5
        "Vai masīvā var uzglabāt dažāda tipa elementus?",												//6
        "Kā atrast maksimālo vērtību veselo skaitļu masīvā?",											//7
        "Vai masīva izmēru var mainīt pēc tam, kad tas ir deklarēts?",									//8
        "Kā pārlūkot visus masīva elementus?",															//9
        "Kas notiek, ja mēģina piekļūt masīva elementam ar indeksu, kas ir ārpus robežām?"				//10
    };
    // Masīvs, kas satur JCheckBoxes.
    JCheckBox[][] atbildesLodzini = new JCheckBox[jautajumi.length][4]; 
    // Atbildes uz jautājumiem..
    atbildes = new String[][] {
    	// 1. jautājums
        { "Mainīgais, kas var uzglabāt vairākas vienāda tipa vērtības.", 								// 0
            "Datu struktūra, kas var uzglabāt gan primārās, gan atsauces tipus.", 						// 1
            	"Objektu kolekcija, kam var dinamiski mainīt izmērus.",									// 2
            		"Atslēgvārds, ko izmanto mainīgo deklarēšanai" },									// 3
        // 2. jautājums
        { "int[] mansMasīvs;", 																			// 0
            "mansMasīvs = new[] int;", 																	// 1
            	"int mansMasīvs[];", 																	// 2
            		"mansMasīvs = new int[];" }, 														// 3
        // 3. jautājums
        { "Izmantojot elementa indeksu kvadrātiekavās.", 												// 0
            "Izsaucot metodi masīva objektā.", 															// 1
            	"Izmantojot indeksa elementu kvadrātiekavās.", 											// 2
            		"Norādot atbilstošu indeksu, kas attiecas uz konkrētu elementu." }, 				// 3
        // 4. jautājums
        { "Pēdējā elementa indekss masīvā.", 															// 0
            "Elementu skaits masīvā.", 																	// 1
            	"Atmiņas izmērs, kas piešķirts masīvam.", 												// 2
            		"Maksimālā vērtība, kas var tikta uzglabāta masīvā." }, 							// 3
        // 5. jautājums
        { "int[] mansMasīvs = {1, 2, 3};", 																// 0
            "int mansMasīvs[] = new int[3];", 															// 1
            	"mansMasīvs = {1, 2, 3};", 																// 2
            		"int mansMasīvs[] = {1, 2, 3};" }, 													// 3
        // 6. jautājums
        { "Masīva elementiem jābūt vienāda tipa.", 														// 0
            "Java ļauj jaukt dažāda tipa elementus masīvā.", 											// 1
            	"Ja masīvs ir deklarēts kā dinamiskais tips.", 											// 2
            		"Masīvs var uzglabāt objektus, kas var saturēt dažādu elementu tipus." }, 			// 3
        // 7. jautājums
        { "Izmantojot ciklu, lai savienotu katru vērtību ar pašreizējo maksimālo.", 														// 0
            "Izmantojot funkciju, lai pašreizējo elementu salīdzinātu ar atlikušo masīvu un atgrieztu maksimālo vērtību.", 					// 1
            	"Izmantojot Math.max() funkciju.", 																							// 2
            		"Izmantojot ciklu, lai salīdzinātu katru elementu ar pašreizējo maksimālo." }, 											// 3
        // 8. jautājums
        { "Nē, Jāizveido jauns masīvs ar lielāku izmēru un jākopē vērtības",							// 0
            "Nē, Masīva izmērs ir fiksēts pēc deklarēšanas.", 											// 1
            	"Jā, masīva izmēru vienmēr var mainīt pēc tam, kad tas ir deklarēts.",					// 2
        			"Tikai tad, ja nav iegūta ArrayIndexOutOfBoundsException kļūda" }, 					// 3
        // 9. jautājums
        { "Izmantojot for ciklu ar indeksa mainīgo.", 													// 0
            "Izmantojot File Reader, lai nolasītu indeksa vērtību.", 									// 1
            	"Izmantojot while ciklu un palielinot skaitītāja mainīgo.", 							// 2
            		"Izmantojot File Writer, lai izvadītu indeksa vērtību." }, 							// 3
        // 10. jautājums
        { "Programma izmet ArrayIndexOutOfBoundsException kļūdu.", 										// 0
            "Indeksēšana turpinās un piekļūst citam elementam.", 										// 1
            	"Kompilators izmet brīdinājumu, bet programma turpina strādāt.", 						// 2
            		"Programma izmet kļūdu un aptur darbību." } 										// 3
    };
    //Masīvs, kas satur pareizo atbilžu indeksus.
    parVaiNepAtbildes = new int[][] {
        { 0, 1 },	//1
        { 0, 2 },	//2
        { 0, 3 },	//3
        { 0, 1 },	//4
        { 0, 3 },	//5
        { 0, 3 },	//6
        { 1, 3 },	//7
        { 0, 1 },	//8
        { 0, 2 },	//9
        { 0, 3 }	//10
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
    	// Ja lietotājs ir atcēlis atbildi vai aizvēris logu, iestata "numJautajumi" vērtību uz sākuma vērtību.
        numJautajumi = i;
        break;
      }
    }
    // Izvada lietotajam testa rezultātus.
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
	  // Ja sakrītība ir atrasta, tad atgriež "true".

	  return false;
	  // Ja pēc masīva iterācijas nav atrasta sakrītība, atgriež "false".
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