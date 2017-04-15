package ohtu.intjoukkosovellus;

import java.util.Scanner;

public class Sovellus {

    private static IntJoukko A, B, C;
    private static Scanner lukija;

    private static String luku() {
        String luettu = lukija.nextLine();
        return luettu;
    }
    
    private static int luettuLuku(String kehote) {
        System.out.println(kehote);
        return lukija.nextInt();
    }

    private static IntJoukko mikaJoukko() {
        String luettu;
        luettu = luku();
        while (true) {
            if (luettu.equals("A") || luettu.equals("a")) {
                return A;
            } else if (luettu.equals("B") || luettu.equals("b")) {
                return B;
            } else if (luettu.equals("C") || luettu.equals("c")) {
                return C;
            } else {
                System.out.println("Virheellinen joukko! " + luettu);
                System.out.print("Yritä uudelleen!");
                luettu = luku();
            }
        }
    }

    private static void lisaa() {
        IntJoukko joukko = joukonValinta("Mihin joukkoon? ");
        System.out.println("");
        int lisattavaLuku = luettuLuku("Mikä luku lisätään? ");
        joukko.lisaa(lisattavaLuku);
    }

    private static void yhdiste() {
        IntJoukko aJoukko = joukonValinta("1. joukko? ");
        IntJoukko bJoukko = joukonValinta("2. joukko? ");
        IntJoukko c = IntJoukko.yhdiste(aJoukko, bJoukko);
        System.out.println("A yhdiste B = " + c);
    }

    private static void leikkaus() {
        IntJoukko aJoukko = joukonValinta("1. joukko? ");
        IntJoukko bJoukko = joukonValinta("2. joukko? ");
        IntJoukko c = IntJoukko.leikkaus(aJoukko, bJoukko);
        System.out.println("A leikkaus B = " + c);
    }

    private static void erotus() {
        IntJoukko aJoukko = joukonValinta("1. joukko? ");
        IntJoukko bJoukko = joukonValinta("2. joukko? ");
        IntJoukko c = IntJoukko.erotus(aJoukko, bJoukko);
        System.out.println("A erotus B = " + c);
    }

    private static void poista() {
        IntJoukko joukko = joukonValinta("Mistä joukosta? ");
        int poistettavaLuku = luettuLuku("Mikä luku poistetaan? ");
        joukko.poista(poistettavaLuku);
    }

    private static void kuuluu() {
        IntJoukko joukko = joukonValinta("Mihin joukkoon? ");
        int kysyttyLuku = luettuLuku("Mikä luku? ");
        boolean kuuluuko = joukko.kuuluu(kysyttyLuku);
        if (kuuluuko) {
            System.out.println(kysyttyLuku + " kuuluu joukkoon ");
        } else {
            System.out.println(kysyttyLuku + " ei kuulu joukkoon ");
        }
    }
    
    private static IntJoukko joukonValinta(String kysymys) {
        System.out.println(kysymys);
        return mikaJoukko();
    }

    public static void main(String[] args) {
        lukija = new Scanner(System.in);
        A = new IntJoukko();
        B = new IntJoukko();
        C = new IntJoukko();
        String luettu;

        System.out.println("Tervetuloa joukkolaboratorioon!");
        System.out.println("Käytössäsi ovat joukot A, B ja C.");
        System.out.println("Komennot ovat lisää(li), poista(p), kuuluu(k), yhdiste(y), erotus(e), leikkaus(le) ja lopetus(quit)(q).");
        System.out.println("Joukon nimi komentona tarkoittaa pyyntöä tulostaa joukko.");

        Scanner lukija = new Scanner(System.in);
        while (true) {
            luettu = lukija.nextLine();
            if (luettu.equals("lisää") || luettu.equals("li")) {
                lisaa();
            } else if (luettu.equalsIgnoreCase("poista") || luettu.equalsIgnoreCase("p")) {
                poista();
            } else if (luettu.equalsIgnoreCase("kuuluu") || luettu.equalsIgnoreCase("k")) {
                kuuluu();
            } else if (luettu.equalsIgnoreCase("yhdiste") || luettu.equalsIgnoreCase("y")) {
                yhdiste();
            } else if (luettu.equalsIgnoreCase("leikkaus") || luettu.equalsIgnoreCase("le")) {
                leikkaus();
            } else if (luettu.equalsIgnoreCase("erotus") || luettu.equalsIgnoreCase("e")) {
                erotus();
            } else if (luettu.equalsIgnoreCase("A")) {
                System.out.println(A);
            } else if (luettu.equalsIgnoreCase("B")) {
                System.out.println(B);
            } else if (luettu.equalsIgnoreCase("C")) {
                System.out.println(C);
            } else if (luettu.equalsIgnoreCase("lopeta") || luettu.equalsIgnoreCase("quit") || luettu.equalsIgnoreCase("q")) {
                System.out.println("Lopetetaan, moikka!");
                break;
            } else {
                System.out.println("Virheellinen komento! " + luettu);
                System.out.println("Komennot ovat lisää(li), poista(p), kuuluu(k), yhdiste(y), erotus(e) ja leikkaus(le).");
            }
            System.out.println("Komennot ovat lisää(li), poista(p), kuuluu(k), yhdiste(y), erotus(e) ja leikkaus(le).");
        }
    }
}
