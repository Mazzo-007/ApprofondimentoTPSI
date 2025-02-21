package Main;

import CCmanagement.CCmanagement;
import CCmanagement.SaldoInsufficienteException;
import CCmanagement.CifraNegativaException;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * La classe {@code Main} gestisce l'interazione con l'utente per eseguire operazioni su un conto corrente.
 * Permette di creare un conto, effettuare prelievi, depositi, e visualizzare lo stato del conto.
 * Gestisce anche gli errori legati agli input non validi o alle eccezioni specifiche (come saldo insufficiente o cifra negativa).
 */
public class Main {
    static CCmanagement CC;
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Metodo principale per eseguire il programma.
     * Consente la creazione del conto corrente e la gestione delle operazioni come prelievo, deposito, e visualizzazione dello stato.
     * Gestisce le eccezioni per input non validi e operazioni non consentite.
     *
     * @param args Gli argomenti passati al programma (non utilizzati in questo caso).
     */
    public static void main(String[] args) {
        System.out.println("Creazione conto corrente...");
        String n = "";
        boolean stato = true;

        // Ciclo per ottenere il nome del titolare e creare un conto
        while(stato) {
            try {
                System.out.println("Nome del titolare del conto corrente");
                n = scanner.next();
                CC = new CCmanagement(n);  // Creazione del conto corrente con il nome fornito
                int scelta;
                stato = false;  // Esci dal ciclo se il conto è stato creato con successo
            } catch (InputMismatchException e) {
                System.out.println("Input non valido");
                stato = true;  // Riprova se l'input non è valido
            }
        }

        stato = true;
        int scelta = 0;

        // Ciclo principale per gestire le operazioni sul conto corrente
        while (stato) {
            System.out.println("Conto corrente di " + n + ": ");
            try {
                System.out.println("1. Preleva\n2. Deposita\n3. Visualizza stato del conto\n4. Esci...");
                scelta = scanner.nextInt();  // Scelta dell'operazione
                scanner.nextLine();
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Input non valido");
            }

            switch (scelta) {
                case 1:
                    try {
                        // Prelievo
                        System.out.println("Inserisci cifra da prelevare: ");
                        CC.preleva(scanner.nextDouble());
                        scanner.nextLine();
                    } catch (CifraNegativaException | SaldoInsufficienteException e) {
                        scanner.nextLine();
                        System.out.println(e.getMessage());  // Messaggio di errore in caso di prelievo non valido
                    } catch (InputMismatchException e) {
                        scanner.nextLine();
                        System.out.println("Input non valido");
                    }
                    break;

                case 2:
                    try {
                        // Deposito
                        System.out.println("Inserisci cifra da depositare");
                        CC.deposita(scanner.nextDouble());
                        scanner.nextLine();
                    } catch (CifraNegativaException e) {
                        System.out.println(e.getMessage());  // Messaggio di errore per cifra negativa
                    } catch (InputMismatchException e) {
                        System.out.println("Input non valido");
                    }
                    break;

                case 3:
                    // Visualizza stato del conto corrente
                    System.out.println(CC);
                    break;

                case 4:
                    // Uscita dal programma
                    System.out.println("Esco...");
                    stato = false;
            }
        }
    }
}
