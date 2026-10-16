import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Fronta fronta = new Fronta();

        System.out.println();
        fronta.pridatUchazece(new Uchazec("Jakub", "Eismann", "Střední škola", "programátor", 18));
        fronta.pridatUchazece(new Uchazec("Ondra", "Musil", "Vysoká škola", "junior", 21));
        fronta.pridatUchazece(new Uchazec("Daniel", "Fuchs", "Základní škola", "webař", 19));
        fronta.pridatUchazece(new Uchazec("Tomáš", "Jedno", "Střední škola", "tester", 19));
        fronta.pridatUchazece(new Uchazec("Lukáš", "Novák", "Vysoká škola", "analytik", 22));
        fronta.pridatUchazece(new Uchazec("Martin", "Černý", "Základní škola", "kodér", 16));
        fronta.pridatUchazece(new Uchazec("Jan", "Kučera", "Střední škola", "networker", 18));
        fronta.pridatUchazece(new Uchazec("Petr", "Dvořák", "Vysoká škola", "datař", 23));
        fronta.pridatUchazece(new Uchazec("Filip", "Marek", "Střední škola", "bezpečák", 17));
        fronta.pridatUchazece(new Uchazec("David", "Krejčí", "Základní škola", "grafik", 15));
        fronta.pridatUchazece(new Uchazec("Jiří", "Veselý", "Vysoká škola", "vývojář", 24));
        fronta.pridatUchazece(new Uchazec("Anna", "Bílá", "Střední škola", "programátorka", 18));
        fronta.pridatUchazece(new Uchazec("Tereza", "Králová", "Vysoká škola", "markéťačka", 21));
        fronta.pridatUchazece(new Uchazec("Kateřina", "Benešová", "Základní škola", "webařka", 16));
        fronta.pridatUchazece(new Uchazec("Matěj", "Horák", "Střední škola", "junior", 19));
        fronta.pridatUchazece(new Uchazec("Jakub", "Pokorný", "Vysoká škola", "architekt", 25));

        boolean on = true;
        while (on) {
            try {
                System.out.println("\n----------MENU----------");
                System.out.println("1. Příchod nového uchazeče.");
                System.out.println("2. Obsloužení uchazeče.");
                System.out.println("3. Výpis všech uchazečů ve frontě.");
                System.out.println("4. Nakouknutí na dalšího.");
                System.out.println("5. Nakouknutí do fronty.");
                System.out.println("6. Konec.");
                System.out.print("Volba: ");

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Zadejte jméno: ");
                        String jmeno = sc.nextLine();
                        System.out.print("Zadejte příjmení: ");
                        String prijmeni = sc.nextLine();
                        System.out.print("Zadejte školu: ");
                        String skola = sc.nextLine();
                        System.out.print("Zadejte zaměření: ");
                        String zamereni = sc.nextLine();
                        System.out.print("Zadejte věk: ");
                        int vek = sc.nextInt();
                        sc.nextLine();

                        fronta.pridatUchazece(new Uchazec(jmeno, prijmeni, skola, zamereni, vek));
                        System.out.println("Uchazeč byl přidán do fronty.");
                        break;
                    case 2:
                        fronta.obslouzitUchazece();
                        break;
                    case 3:
                        fronta.vypisFrontu();
                        break;
                    case 4:
                        fronta.nakouknoutNaDalsiho();
                        break;
                    case 5:
                        fronta.nakouknoutDoFronty();
                        break;
                    case 6:
                        System.out.println("Konec programu.");
                        on = false;
                        break;
                }
            } catch (Exception e) {
                System.out.println("Nastala chyba při zadávání dat. Zadejte správný formát.");
                sc.nextLine();
            }
        }
        sc.close();
    }
}
