import javax.swing.JOptionPane;

public class Tests {
    public static void main(String[] args) {

        Object[] opcijas = {"Sākt", "Iziet"};
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
    	//Jautajumi
        String[] jautajumi = {
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
        //Atbildes uz jautājumiem
        String[][] atbildes = {
                {"Mainīgais, kas var uzglabāt vairākus vienāda tipa vērtības.",							//A
                	"Datu struktūra, kas var uzglabāt gan primārās, gan atsauces tipus.",				//B
                		"Objektu kolekcija, kam var dinamiski mainīt izmērus.",							//C
                 			"Atslēgvārds, ko izmanto mainīgo deklarēšanai"},							//D
                
                {"int[] mansMasīvs;",																	//A
                	 "mansMasīvs = new int[];",															//B
                	 	"int mansMasīvs[];",															//C
                 			"mansMasīvs = new int[];"},													//D
                
                {"Izmantojot elementa indeksu kvadrātiekavās.",											//A
                	"Izsaucot metodi masīva objektā.",													//B
                		"Izmantojot elementa vērtību.",													//C
                			"Izmantojot ciklu, lai pārlūkotu visus elementus."},						//D
                
                {"Elementu skaits masīvā.",																//A
                	"Atmiņas izmērs, kas piešķirts masīvam.",											//B
                		"Maksimālā vērtība, kas var tikt uzglabāta masīvā.",							//C
                			"Pēdējā elementa indekss masīvā."},											//D
                
                {"int[] mansMasīvs = {1, 2, 3};",														//A
                	"int mansMasīvs[] = new int[3];",													//B
                		"mansMasīvs = {1, 2, 3};",														//C
                			"int mansMasīvs[] = {1, 2, 3};"},											//D
                
                {"Jā, Java ļauj sajaukt dažāda tipa elementus masīvā.",									//A
                	"Nē, visiem masīva elementiem jābūt vienāda tipa.",									//B
                		"Tikai tad, ja masīvs ir deklarēts kā ģeneriskais tips.",						//C
                			"Tikai tad, ja masīvs ir deklarēts kā objekta tips."},						//D
                
                {"Sakārtojot masīvu augošā secībā.",													//A
                	"Izmantojot ciklu, lai salīdzinātu katru elementu ar pašreizējo maksimālo.",		//B
                		"Izmantojot iebūvēto max() metodi klases Array.",								//C
                			"Izmantojot Math.max() funkciju."},											//D
                
                {"Jā, var dinamiski pievienot vai noņemt elementus.",									//A
                	"Nē, masīva izmērs ir fiksēts pēc deklarēšanas.",									//B
                		"Tikai tad, ja izmanto ArrayList klasi, nevis parasto masīvu.",					//C
                			"Tikai tad, ja izmantojat resize() metodi, lai mainītu masīva izmēru."},	//D
                
                {"Izmantojot for ciklu ar indeksa mainīgo.",											//A
                	"Izmantojot while ciklu un palielinot skaitītāja mainīgo.",							//B
                		"Izmantojot forEach ciklu.",													//C
                			"Izsaucot iterate() metodi klases Array."},									//D
                
                {"Programma izmet kļūdu un aptur darbību.",												//A
                	"Indeksēšana apvīžas un piekļūst citam elementam.",									//B
                		"Kompilators izmet brīdinājumu, bet programma normāli darbojas.",				//C
                			"Programma izmet ArrayIndexOutOfBoundsException kļūdu."}					//D
        };
        //Pareizo atbilžu indeksi
        int[][] pareizasAtbildes = {
                {0, 1},
                {0, 2},
                {0, 3},
                {0, 1},
                {0, 3},
                {1, 3},
                {1, 3},
                {0, 1},
                {0, 2},
                {0, 3}
        };
    }
}