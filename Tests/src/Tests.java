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
        // Rest of the code for running the test
    }
}