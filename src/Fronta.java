import java.util.Scanner;

public class Fronta {
    Scanner sc = new Scanner(System.in);

    private int kapacita = 20;
    private Uchazec[] fronta = new Uchazec[kapacita];
    private int front = 0;
    private int rear = -1;
    private int size = 0;


    public void pridatUchazece(Uchazec uchazec) {
        if (size >= kapacita) {
            throw new FullFrontaException("Fronta je plná. Nelze přidat žáka: " + uchazec.getCeleJmeno());
        }
        rear = (rear + 1) % kapacita;
        fronta[rear] = uchazec;
        size++;
        System.out.println("Žák " + uchazec.getCeleJmeno() + " se zařadil do fronty.");
    }

    public Uchazec obslouzitUchazece() {
        if (size == 0) {
            throw new EmptyFrontaException("Fronta je prázdná");
        }
        Uchazec obslouzeny = fronta[front];
        fronta[front] = null;
        front = (front + 1) % kapacita;
        size--;

        System.out.println("Obsloužen uchazeč: " + obslouzeny.getCeleJmeno());
        return obslouzeny;
    }

    public void vypisFrontu() {
        if (size == 0) {
            throw new EmptyFrontaException("Fronta je prázdná");
        }

        System.out.println("Uchazeči ve frontě (" + size + "/" + kapacita + ")");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % kapacita;
            System.out.println((i + 1) + ". " + fronta[index].getCeleJmeno());
        }
    }

    public Uchazec nakouknoutNaDalsiho() {
        if (size == 0) {
            throw new EmptyFrontaException("Fronta je prázdná");
        }
        Uchazec dalsiNaRade = fronta[front];

        System.out.println("Nakouknutí na dalšího: " + dalsiNaRade.getCeleJmeno() + " Pozice: " + dalsiNaRade.getPozice());
        return dalsiNaRade;
    }

    public Uchazec nakouknoutDoFronty() {
        if (size == 0) {
            throw new EmptyFrontaException("Fronta je prázdná");
        }

        System.out.println("Zadejte příjmení žáka.");
        String hledanePrijmeni = sc.nextLine();

        for (int i = 0; i < size; i++) {
            int index = (front + i) % kapacita;

            if (hledanePrijmeni.equalsIgnoreCase(fronta[index].getPrijmeni())) {
                System.out.println("Žák s daným příjmením byl nalezen.");
                System.out.println(fronta[index].getCeleJmeno());
                return fronta[index];
            }
        }

        System.out.println("Žák s daným příjmením nebyl nalezen.");
        return null;
    }

    public int getKapacita() {
        return kapacita;
    }

    public int getSize() {
        return size;
    }
}