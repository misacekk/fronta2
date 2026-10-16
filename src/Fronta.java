import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Fronta {
    private Scanner sc = new Scanner(System.in);

    private int pocetObslouzenych;

    private Node front;
    private Node rear;
    private int size;

    public Fronta() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public void pridatUchazece(Uchazec uchazec) {
        Node newNode = new Node(uchazec);
        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.setNext(newNode);
            rear = newNode;
        }
        size++;
        System.out.println("Žák " + uchazec.getCeleJmeno() + " se zařadil do fronty.");
    }

    public Uchazec obslouzitUchazece() {
        if (front == null) {
            throw new EmptyFrontaException("Fronta je prázdná");
        }
        Uchazec obslouzeny = front.getData();
        front = front.getNext();
        if (front == null) {
            rear = null;
        }
        size--;
        pocetObslouzenych++;
        System.out.println("Obsloužen uchazeč: " + obslouzeny.getCeleJmeno() + " | " + obslouzeny.getPozice() + " | Celkový počet obsloužených je: " + pocetObslouzenych);
        return obslouzeny;
    }

    public void vypisFrontu() {
        if (front == null) {
            throw new EmptyFrontaException("Fronta je prázdná");
        }

        System.out.println("Uchazeči ve frontě (počet: " + size + ")");
        Node current = front;
        int i = 1;
        while (current != null) {
            Uchazec uchazec = current.getData();
            System.out.println(i + ". " + uchazec.getCeleJmeno() + " | " + uchazec.getVzdělání()
                    + " | " + uchazec.getPozice() + " | " + uchazec.getVek());
            current = current.getNext();
            i++;
        }
    }

    public Uchazec nakouknoutNaDalsiho() {
        if (front == null) {
            throw new EmptyFrontaException("Fronta je prázdná");
        }
        Uchazec dalsiNaRade = front.getData();

        System.out.println("Nakouknutí na dalšího: " + dalsiNaRade.getCeleJmeno() + " Pozice: " + dalsiNaRade.getPozice());
        return dalsiNaRade;
    }

    public Uchazec nakouknoutDoFronty() {
        if (front == null) {
            throw new EmptyFrontaException("Fronta je prázdná");
        }

        System.out.println("Zadejte příjmení žáka.");
        String hledanePrijmeni = sc.nextLine();

        Node current = front;
        while (current != null) {
            Uchazec uchazec = current.getData();
            if (hledanePrijmeni.equalsIgnoreCase(uchazec.getPrijmeni())) {
                System.out.println("Uchazeč s daným příjmením byl nalezen.");
                System.out.println(uchazec.getCeleJmeno());
                return uchazec;
            }
            current = current.getNext();
        }

        System.out.println("Uchazeč s daným příjmením nebyl nalezen.");
        return null;
    }

    // 7. Filtrování podle pozice
    public void vypisPodlePozice(String hledanaPozice) {
        if (front == null) {
            throw new EmptyFrontaException("Fronta je prázdná");
        }

        System.out.println("Uchazeči na pozici '" + hledanaPozice + "':");
        Node current = front;
        int i = 1;
        boolean nalezen = false;
        while (current != null) {
            Uchazec uchazec = current.getData();
            if (uchazec.getPozice().equalsIgnoreCase(hledanaPozice)) {
                System.out.println(i + ". " + uchazec.getCeleJmeno() + " | " + uchazec.getVzdělání()
                        + " | " + uchazec.getPozice() + " | " + uchazec.getVek());
                nalezen = true;
                i++;
            }
            current = current.getNext();
        }

        if (!nalezen) {
            System.out.println("Žádný uchazeč hlásící se na pozici '" + hledanaPozice + "' nebyl nalezen.");
        }
    }

    public Uchazec vymazatCelouFrontu() {
        if (front == null) {
            throw new EmptyFrontaException("Fronta je prázdná");
        }

        Uchazec posledniObslouzeny = null;

        while (front != null) {
            posledniObslouzeny = front.getData();
            front = front.getNext();
            size--;
        }

        rear = null;

        System.out.println("Fronta byla vymazána.");
        return posledniObslouzeny;
    }

    // 9. Uložení fronty do souboru
    public void ulozitDoSouboru(String nazevSouboru) {
        if (front == null) {
            throw new EmptyFrontaException("Fronta je prázdná");
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(nazevSouboru))) {
            Node current = front;
            while (current != null) {
                Uchazec uchazec = current.getData();
                writer.println(uchazec.getJmeno() + ";" + uchazec.getPrijmeni() + ";"
                        + uchazec.getVzdělání() + ";" + uchazec.getPozice() + ";" + uchazec.getVek());
                current = current.getNext();
            }
            System.out.println("Fronta byla úspěšně uložena do souboru: " + nazevSouboru);
        } catch (IOException e) {
            System.out.println("Chyba při zápisu do souboru: " + e.getMessage());
        }
    }

    public boolean jePrazdna() {
        return front == null;
    }

    public int getSize() {
        return size;
    }
}