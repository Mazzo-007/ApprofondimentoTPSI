package CCmanagement;

/**
 * La classe SaldoInsufficienteException rappresenta un'eccezione personalizzata che viene sollevata
 * quando si tenta di effettuare un prelievo con un saldo insufficiente.
 * Estende la classe {@link Exception}.
 */
public class SaldoInsufficienteException extends Exception {

    /**
     * Costruttore che crea un'istanza dell'eccezione SaldoInsufficienteException con un messaggio personalizzato.
     *
     * @param message Il messaggio di errore che descrive la causa dell'eccezione.
     */
    public SaldoInsufficienteException(String message) {
        super(message);
    }
}
