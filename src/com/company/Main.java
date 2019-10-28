package com.company;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

private static void clear(){
    System.out.print("\033[H\033[2J"); // czysci konsole
    System.out.flush();
}
private static void graj(){ //METODA DZIEKI KTOREJ PO PRZEKROCZENIU 21pkt MOZNA GRAC DALEJ:D
    // talia 24 kart (od 9 do asa)
    ArrayList<String> talia = new ArrayList<>(Arrays.asList("9","9","9","9","10","10","10","10","W","W","W","W",
            "D","D","D","D","K","K","K","K","A","A","A","A"));
    // talia pomocnicza do podmiany przy ponownej grze
    ArrayList<String> temp = new ArrayList<>(Arrays.asList("9","9","9","9","10","10","10","10","W","W","W","W",
            "D","D","D","D","K","K","K","K","A","A","A","A"));

    ArrayList<String> kartyKrupiera = new ArrayList<>(); // tu przechowuje karty krupiera
    ArrayList<String> kartyGracza = new ArrayList<>(); // tu przechowuje karty gracza
    Scanner input = new Scanner(System.in);
    String dobranieG; // zmienna do dobierania kart przez gracza
    String ponownaGra;
    int dobranieK = 0; // zmienna do dobrania kart przez krupiera (krupier dopiera 2 karty tylko na poczatku gry)
    int punktyG = 0; // punkty gracza
    int punktyK = 0; // punkty krupiera


        do {
            //*******************Krupier****************
            while (dobranieK<2) {
                int losKrup = (int) (Math.random() * talia.size()); // losowanie kart krupiera

                while (!talia.get(losKrup).equals("")) {
                    switch (losKrup){
                        case 0:case 1: case 2:case 3:
                            kartyKrupiera.add(talia.get(losKrup));
                            talia.set(losKrup,"");
                            punktyK += 9;
                            break;
                        case 4:case 5: case 6:case 7:
                            kartyKrupiera.add(talia.get(losKrup));
                            talia.set(losKrup,"");
                            punktyK += 10;
                            break;
                        case 8:case 9: case 10:case 11:
                            kartyKrupiera.add(talia.get(losKrup));
                            talia.set(losKrup,"");
                            punktyK += 5;
                            break;
                        case 12:case 13: case 14:case 15:
                            kartyKrupiera.add(talia.get(losKrup));
                            talia.set(losKrup,"");
                            punktyK += 6;
                            break;
                        case 16:case 17: case 18:case 19:
                            kartyKrupiera.add(talia.get(losKrup));
                            talia.set(losKrup,"");
                            punktyK += 7;
                            break;
                        default:
                            kartyKrupiera.add(talia.get(losKrup));
                            talia.set(losKrup,"");
                            punktyK += 11;
                    }dobranieK++;
                }


            }
            clear();
            System.out.println("Krupier Kamil dobral dwie karty, jedna z nich to " + kartyKrupiera.get(0)+"\n");

            //********************gracz********************
            do {
                int los = (int) (Math.random() * talia.size());  // losowanie kart gracza

                while (!talia.get(los).equals("")) {
                    switch (los){
                        case 0:case 1: case 2:case 3:
                            kartyGracza.add(talia.get(los));  //dodaje wyciagnieta karte do kart gracza
                            talia.set(los,"");  // podmienia wartosc indeksu na "" zeby punktacja dzialala poprawnie
                            punktyG += 9;
                            break;
                        case 4:case 5: case 6:case 7:
                            kartyGracza.add(talia.get(los));
                            talia.set(los,"");
                            punktyG += 10;
                            break;
                        case 8:case 9: case 10:case 11:
                            kartyGracza.add(talia.get(los));
                            talia.set(los,"");
                            punktyG += 5;
                            break;
                        case 12:case 13: case 14:case 15:
                            kartyGracza.add(talia.get(los));
                            talia.set(los,"");
                            punktyG += 6;
                            break;
                        case 16:case 17: case 18:case 19:
                            kartyGracza.add(talia.get(los));
                            talia.set(los,"");
                            punktyG += 7;
                            break;
                        default:
                            kartyGracza.add(talia.get(los));
                            talia.set(los,"");
                            punktyG += 11;
                    }
                    while (punktyG>21){
                        System.out.println("przegrałes, przekroczyles 21pkt\n");
                        System.out.println("\nKarty krupiera to: "+kartyKrupiera+" punkty: "+punktyK);
                        System.out.println("\n\nTwoje Karty to: "+kartyGracza+" punkty: "+punktyG+"\n\n");
                        System.out.println("Czy chcesz zagrac jeszcze raz? (T/N)");
                        System.out.println("po przekroczeniu 21"+talia);
                        punktyG = 0;
                        punktyK = 0;
                        talia.clear();
                        talia.addAll(temp);                 // zerowanie wszystkiego do nowej gry
                        kartyGracza.clear();
                        kartyKrupiera.clear();
                        ponownaGra = input.next();
                        clear();

                        if (ponownaGra.equalsIgnoreCase("t")){
                            graj();                         // wykonanie super metody w super metodzie!

                        }else{
                            System.out.println("Dzieki za gre");
                            return;
                        }
                    }
                }
                System.out.println("Odkryta karta krupiera Kamila:\t"+kartyKrupiera.get(0));
                System.out.println("\n\ntwoje karty to: "+kartyGracza+" \tTwoja liczba punktow: "+punktyG);
                System.out.println("***********************************************************************");
                System.out.println("dobrac jeszcze jedna? (T/N)");
                dobranieG = input.next();
                clear();


            }while (dobranieG.equalsIgnoreCase("t"));

            if (punktyG<punktyK){
                System.out.println("Przegrales masz mniej punktow niz krupier Kamil");
            }
            else if (punktyG == punktyK){
                System.out.println("Remis");
            }
            else if (punktyG == 21){
                System.out.println("Oczko! Wygrales!");
            }
            else{System.out.println("Wygrales!");}

            System.out.println("\nKarty krupiera to: "+kartyKrupiera+" punkty: "+punktyK);
            System.out.println("\n\nTwoje Karty to: "+kartyGracza+" punkty: "+punktyG+"\n\n");

            System.out.println("Czy chcesz zagrac jeszcze raz? (T/N)\n");
            ponownaGra = input.next();
            dobranieK = 0;
            punktyG = 0;
            punktyK = 0;                    //zerowanie wszystkiego do nowej gry
            talia.clear();
            talia.addAll(temp);
            kartyGracza.clear();
            kartyKrupiera.clear();
            clear();

        } while (ponownaGra.equalsIgnoreCase("t"));
        System.out.println("Dzieki za gre!");
        System.exit(0);             // konczenie programu gdy gracz nie bedzie chcial grac dalej
    }

    public static void main(String[] args) {

        String nowaGra;
        Scanner input = new Scanner(System.in);
        //*************Start**********************
        System.out.println("Witaj w Super BlackJacek Pro! Chcesz zagrac? (T/N)");
        nowaGra = input.next();
        clear();
        if (nowaGra.equalsIgnoreCase("t")) {
            graj();
        }
        else {
            System.out.println("To po kiego wuja to odpalales??");
        }
    }

}
