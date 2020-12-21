package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static  int [] tableau_circulaire = new int[10];
    private static int index_tete = 0;
    private static int index_queue = 0;
    private static int compteur;


    public static void afficher_tableau(){
        System.out.println("tableau : "+Arrays.toString(tableau_circulaire));
        System.out.println("index de la tête : "+ index_tete);
        System.out.println("index de la queue : "+ index_queue);
    }

    public static void afficher_file(){
        System.out.print("file : ");
        if(index_tete>index_queue) {
            for (int i = index_queue; i < index_tete; i++) {                  //toutes les valeurs à partir de la queue jusqu'à l'index tête
                System.out.print(tableau_circulaire[i] + "  ");
            }
            System.out.println();
        }else if(index_queue>index_tete){
            for(int y = index_queue; y < tableau_circulaire.length; y++){    //toutes valuers à partir de l'index_tête jusqu'à la fin du tableau
                System.out.print(tableau_circulaire[y] + "  ");
            }
            for (int z = 0; z < index_queue; z++){                           //toutes les valeurs à partir du début du tableau jusqu'à l'index_queue
                System.out.print(tableau_circulaire[z] + "  ");
            }
            System.out.println();
        }else if (compteur > 0){
            for(int y = index_tete; y < tableau_circulaire.length; y++){    //toutes valuers à partir de l'index_tête jusqu'à la fin du tableau
                System.out.print(tableau_circulaire[y] + "  ");
            }
            for (int z = 0; z < index_queue; z++){                          //toutes les valeurs à partir du début du tableau jusqu'à l'index_queue
                System.out.print(tableau_circulaire[z] + "  ");
            }
            System.out.println();
        }
    }

    public static void offer(){
        if(compteur <= 10) {
            System.out.print("Entrez une valeur : ");
            Scanner scan = new Scanner(System.in);
            int val = scan.nextInt();

            if (index_tete <= 9) {
                tableau_circulaire[index_tete] = val;
                index_tete++;
                afficher_file();
            } else {
                index_tete = 0;
                tableau_circulaire[index_tete] = val;
                afficher_file();
                index_tete++;
            }
            compteur++;
        }else{
            System.out.println("Opération impossible");
        }

    }

    public static int  poll(){
        if(compteur > 0) {
            int a = tableau_circulaire[index_queue];
            if (index_queue <= 9) {
                //tableau_circulaire[index_queue] = 0;
                index_queue++;
            } else {
                index_queue = 0;
            }
            compteur--;
            afficher_file();
            return a;
        }else {
            System.out.println("Opération impossible");
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println("___________boucle offer____________");
        for(int i = 0; i<10; i++) {
            offer();
            afficher_tableau();
            System.out.println("_________________________________");
        }
        System.out.println("_________ fin boucle poll_________");
        System.out.println("___________boucle poll____________");
        for (int i = 0; i<5; i++) {
            poll();
            afficher_tableau();
            System.out.println("_________________________________");
        }
        System.out.println("_________ fin boucle poll_________");

        System.out.println("___________boucle offer____________");
        for(int i = 0; i<5; i++) {
            offer();
            afficher_tableau();
            System.out.println("_________________________________");
        }
    }
}

