import java.util.Random;
import java.util.Scanner;
public class Roulette {
    static Scanner sc = new Scanner(System.in);
    public static int solde = 1000;
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static String[][] roulette = {
        {"1","rouge"},{"2","noir"},{"3","rouge"},{"4","noir"},{"5","rouge"},
    {"6","noir"},{"7","rouge"},{"8","noir"},{"9","rouge"},{"10","noir"},
    {"11","noir"},{"12","rouge"},{"13","noir"},{"14","rouge"},
    {"15","noir"},{"16","rouge"},{"17","noir"},{"18","rouge"},
    {"19","rouge"},{"20","noir"},{"21","rouge"},{"22","noir"},
    {"23","rouge"},{"24","noir"},{"25","rouge"},{"26","noir"},
    {"27","rouge"},{"28","noir"},{"29","noir"},{"30","rouge"},
    {"31","noir"},{"32","rouge"},{"33","noir"},{"34","rouge"},
    {"35","noir"},{"36","rouge"}
    }; 
    public static int mise = sc.nextInt();

    public static String valeurColor = roulette[1][1];
    public static void main(String[] args) throws Exception {
        welcome();
        start();
        mise();
        game();
    }

    public static void welcome() {
        System.out.print("Votre nom: ");
        String nom = sc.nextLine();
        System.out.println("Bonjour " + nom + ", Bienvenu sur le jeu de la Roulette ! \n Règles du jeu : \n - Au départ vous devez miser une partie de votre argent \n - Il y a 6 mises possible : \n " + ANSI_BLUE + "o Couleur \n o Pair \n o Impair \n o Manque (nombres de 1 à 18) \n o Passe (nombres de 19 à 36) "+ ANSI_RESET + "\n " + ANSI_GREEN + "o Numéro Simple" + ANSI_RESET + "\n \n ("+ ANSI_BLUE + "Gain *2" + ANSI_RESET + " / "+ ANSI_GREEN + " Gain * 36" + ANSI_RESET + ") \n");
    }

    public static int start() {
        System.out.print("Souhaitez vous essayer: (1- oui / 2- non) :");
        int game = sc.nextInt();
        if(game == 2) {
            System.out.print("Aurevoir");
            System.exit(0);
        }
        else {
            System.out.print("Je suis heureux de vous voir tenter votre chance ! \n");
        } 
        return game;         
  }  


    public static void mise() {
        System.out.print("Combiens voulez vous miser ? (votre solde actuelle est de :"+ solde + "\n");

        System.out.print("Vous avez décider de miser " + mise + "\n");
    }

    public static void game() {
        System.out.print("  - Pour commencer taper 1 \n");
        System.out.print("  - Pour annuler taper 2 \n");
        int start = sc.nextInt();
        if(start == 1) {
            System.out.print("Génial ! \n");
            System.out.print("Voici le plateau de jeu ! \n");
            System.out.print("Sur quoi voulez vous pariez ? \n");
            System.out.println(
            "1 - Couleur \n"
            + "2 - Pair \n"
            + "3 - Impair \n"
            + "4 - Manque (numero de 0 à 18) \n"
            + "5 - Passe (numero de 10 à 36) \n"
            + "6 - Numéro Simple \n");
            int key = sc.nextInt();
            switch (key) {
                case 1: 
                    System.out.print("Choisissez votre couleur : (1- noir /2- rouge) \n");
                    int couleur = sc.nextInt();
                    Random randColor = new Random();
                    int colors = randColor.nextInt(roulette.length);
                    System.out.print(roulette[colors][1]);
                    if(couleur == colors) {
                        int total1 = mise * 2;
                        solde = solde + total1;
                        System.out.print("Bien joué \n");
                        System.out.print("Vous veneez d'empocher" + total1 + "\n");
                        System.out.print("Votre solde est maintenant de" + solde + "\n");
                    }else{
                        System.out.print("Perdu, nulos ! \n");
                    }
                break;
                case 2: 
                    Random randPair = new Random();
                    int pair = randPair.nextInt(roulette.length);
                    System.out.print(roulette[pair][0]);
                    if (pair % 2 == 1){
                        int total2 = mise * 2;
                        solde = solde + total2;
                        System.out.print("Vous avez choisi \n pair! \n");
                        System.out.print("Les jeux sont fait !! \n");
                        System.out.print("VOUS AVEZ GAGNE \n");
                        System.out.print("Vous veneez d'empocher" + total2 + "\n");
                        System.out.print("Votre solde est maintenant de" + solde + "\n");
                    }else{
                        System.out.print("Perdu, nulos ! \n");
                    }
                break;
                case 3: 
                Random randImpair = new Random();
                int impair = randImpair.nextInt(roulette.length);
                System.out.print(roulette[impair][0]);

                if (impair % 2 == 0){
                    int total3 = mise * 2;
                    solde = solde + total3;
                    System.out.print("Vous avez choisi \n impair! \n");
                    System.out.print("Les jeux sont fait !! \n");
                    System.out.print("Bien joué \n");
                    System.out.print("Vous veneez d'empocher" + total3 + "\n");
                    System.out.print("Votre solde est maintenant de" + solde + "\n");
                }else{
                    System.out.print("Perdu, nulos ! \n");
                }
                break;
                case 4: 
                    Random RandomManque = new Random();
                    int Manque = RandomManque.nextInt(roulette.length);
                    System.out.print(roulette[Manque][0]);
                    if (Manque <= 18){
                        int total4 = mise * 2;
                        solde = solde + total4;
                        System.out.print("Vous avez choisi \n manque \n");
                        System.out.print("Les jeux sont fait !! \n");
                        System.out.print("Bien joué \n");
                        System.out.print("Vous veneez d'empocher" + total4 + "\n");
                        System.out.print("Votre solde est maintenant de" + solde + "\n");
                    }else{
                        System.out.print("Perdu, nulos ! \n");
                    }
                break;
                case 5: 
                Random RandomPasse = new Random();
                int Passe = RandomPasse.nextInt(roulette.length);
                System.out.print(roulette[Passe][0]);
                if (Passe >= 19){
                    int total5 = mise * 2;
                    solde = solde + total5;
                    System.out.print("Vous avez choisi \n Passe \n");
                    System.out.print("Les jeux sont fait !! \n");
                    System.out.print("Bien joué \n");
                    System.out.print("Vous veneez d'empocher" + total5 + "\n");
                    System.out.print("Votre solde est maintenant de" + solde + "\n");
                }else{
                    System.out.print("Perdu, nulos ! \n");
                }
                break;
                case 6: 
                    System.out.print("Choisissez un nombre entre 1 et 36 : \n");
                    int choixSimple = sc.nextInt();
                    Random RandomSimple = new Random();
                    int Simple = RandomSimple.nextInt(roulette.length);
                    if(choixSimple == Simple){
                        int total6 = mise * 2;
                        solde = solde + total6;
                        System.out.print("Vous avez choisi \n" + choixSimple + "\n");
                        System.out.print("Les jeux sont fait !! \n");
                        System.out.print("Bien joué \n");
                        System.out.print("Vous veneez d'empocher" + total6 + "\n");
                        System.out.print("Votre solde est maintenant de" + solde + "\n");
                    }else{
                        System.out.print("Perdu, nulos ! Le chiffre a trouver était " + Simple + "! \n");
                    }
                break;
                default:
                    break;
            }

        }else{
            System.out.print(":(");
            System.exit(0);
        }
    }

}
