import java.awt.GridLayout;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class Tests {
  private static String[] jautajumi;
  private static String[][] atbildes;
  private static int[][] pareizasAtbildes;

  public static void main(String[] args) {
    Object[] opcijas = { "Sākt", "Iziet" };
    String message = "<html><div style='text-align: center;'>Sveiks, izvēlies \"Sākt\", lai pildītu testu par<br>"
        + "viendimensiju masīviem, \"Iziet\", lai aizvērtu aplikāciju.</div></html>";

    int izvele = JOptionPane.showOptionDialog(null, message, "Sākums",
        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcijas, opcijas[0]);

    switch (izvele) {
      case 0:
        saktTestu();
        break;
      case 1:
        JOptionPane.showMessageDialog(null, "Aplikācija apstādināta.");
        break;
      default:
        JOptionPane.showMessageDialog(null, "Izvēle neeksistē!");
    }
  }

  public static void saktTestu() {
    // Initialize the answerCheckboxes array
    // Jautājumi
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

    JCheckBox[][] answerCheckboxes = new JCheckBox[jautajumi.length][4]; // Initialize the answerCheckboxes array

    // Atbildes uz jautājumiem
    atbildes = new String[][] {
        { "Mainīgais, kas var uzglabāt vairākus vienāda tipa vērtības.", // A
            "Datu struktūra, kas var uzglabāt gan primārās, gan atsauces tipus.", // B
            "Objektu kolekcija, kam var dinamiski mainīt izmērus.", // C
            "Atslēgvārds, ko izmanto mainīgo deklarēšanai" }, // D

        { "int[] mansMasīvs;", // A
            "mansMasīvs = new int[];", // B
            "int mansMasīvs[];", // C
            "mansMasīvs = new int[];" }, // D

        { "Izmantojot elementa indeksu kvadrātiekavās.", // A
            "Izsaucot metodi masīva objektā.", // B
            "Izmantojot elementa vērtību.", // C
            "Nevar piekļūt masīva elementam." }, // D

        { "Pēdējā elementa indekss masīvā.", // A
            "Elementu skaits masīvā.", // B
            "Atmiņas izmērs, kas piešķirts masīvam.", // C
            "Maksimālā vērtība, kas var tikt uzglabāta masīvā." }, // D

        { "int[] mansMasīvs = {1, 2, 3};", // A
            "int mansMasīvs[] = new int[3];", // B
            "mansMasīvs = {1, 2, 3};", // C
            "int mansMasīvs[] = {1, 2, 3};" }, // D

        { "Nē, visiem masīva elementiem jābūt vienāda tipa.", // A
            "Jā, Java ļauj sajaukt dažāda tipa elementus masīvā.", // B
            "Tikai tad, ja masīvs ir deklarēts kā ģeneriskais tips.", // C
            "Tikai tad, ja masīvs ir deklarēts kā objekta tips." }, // D

        { "Izmantojot iebūvēto max() metodi klases Array.", // A
            "Sakārtojot masīvu augošā secībā.", // B
            "Izmantojot Math.max() funkciju.", // C
            "Izmantojot ciklu, lai salīdzinātu katru elementu ar pašreizējo maksimālo." }, // D

        { "Jā, var dinamiski pievienot vai noņemt elementus.", // A
            "Nē, masīva izmērs ir fiksēts pēc deklarēšanas.", // B
            "Tikai tad, ja izmanto ArrayList klasi, nevis parasto masīvu.", // C
            "Tikai tad, ja izmantojat resize() metodi, lai mainītu masīva izmēru." }, // D

        { "Izmantojot for ciklu ar indeksa mainīgo.", // A
            "Izmantojot forEach ciklu.", // B
            "Izmantojot while ciklu un palielinot skaitītāja mainīgo.", // C
            "Izsaucot iterate() metodi klases Array." }, // D

        { "Programma izmet ArrayIndexOutOfBoundsException kļūdu.", // A
            "Indeksēšana apvīžas un piekļūst citam elementam.", // B
            "Kompilators izmet brīdinājumu, bet programma normāli darbojas.", // C
            "Programma izmet kļūdu un aptur darbību." } // D
    };
    // Pareizo atbilžu indeksi
    pareizasAtbildes = new int[][] {
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

    boolean[] pareizas = new boolean[jautajumi.length];
    int numJautajumi = jautajumi.length;

    for (int i = 0; i < numJautajumi; i++) {
      JPanel panel = new JPanel(new GridLayout(5, 1));

      JLabel questionLabel = new JLabel(jautajumi[i]);
      panel.add(questionLabel);

      for (int j = 0; j < 4; j++) {
        answerCheckboxes[i][j] = new JCheckBox(atbildes[i][j]);
        panel.add(answerCheckboxes[i][j]);
      }

      int izvele = JOptionPane.showConfirmDialog(null, panel, "Jautājums " + (i + 1),
          JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

      if (izvele == JOptionPane.OK_OPTION) {
        boolean[] izveles = new boolean[4];
        for (int j = 0; j < 4; j++) {
          izveles[j] = answerCheckboxes[i][j].isSelected();
        }

        pareizas[i] = parbauditAtbildes(i, izveles);
      } else {
        numJautajumi = i;
        break;
      }
    }

    paraditRezultatus(pareizas);
  }

  // Metode, kas pārbauda, vai lietotāja izvēlētie atbilžu varianti sakrīt ar
  // pareizajiem indeksiem
  public static boolean parbauditAtbildes(int jautajumaIndeks, boolean[] izveles) {
    int[] pareizasIndeksi = pareizasAtbildes[jautajumaIndeks];

    for (int i = 0; i < 4; i++) {
      boolean irPareizi = satur(pareizasIndeksi, i);
      boolean irIzvelets = izveles[i];

      if (irPareizi != irIzvelets) {
        return false;
      }
    }

    return true;
  }

  // Metode, kas parada rezultātus pēc testa pabeigšanas
  public static void paraditRezultatus(boolean[] pareizas) {
    StringBuilder rezultatuVeidotajs = new StringBuilder();
    rezultatuVeidotajs.append("Testa rezultāti:\n\n");

    int numJautajumi = jautajumi.length;
    int numPareizi = 0;

    for (int i = 0; i < numJautajumi; i++) {
      char atzime = pareizas[i] ? '\u2713' : '\u2717';
      rezultatuVeidotajs.append("Jautājums ").append(i + 1).append(": ").append(atzime).append("\n");

      if (pareizas[i]) {
        numPareizi++;
      }
    }

    double procents = (double) numPareizi / numJautajumi * 100;
    rezultatuVeidotajs.append("\nKopā pareizi: ").append(numPareizi).append(" / ").append(numJautajumi);
    rezultatuVeidotajs.append(" (").append(String.format("%.2f", procents)).append("%)");

    JOptionPane.showMessageDialog(null, rezultatuVeidotajs.toString(), "Rezultāti", JOptionPane.PLAIN_MESSAGE);
  }

  // Metode, kas pārbauda, vai masīvs satur norādīto vērtību
  public static boolean satur(int[] masivs, int vertiba) {
    for (int i = 0; i < masivs.length; i++) {
      if (masivs[i] == vertiba) {
        return true;
      }
    }
    return false;
  }
}