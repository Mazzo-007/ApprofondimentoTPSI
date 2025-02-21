package CCmanagement;

/**
 * La classe CifraNegativaException rappresenta un'eccezione personalizzata che viene sollevata
 * quando si tenta di eseguire un'operazione (come un prelievo o un deposito) con una cifra negativa.
 * Estende la classe {@link Exception}.
 */
public class CifraNegativaException extends Exception {

    /**
     * Costruttore che crea un'istanza dell'eccezione CifraNegativaException con un messaggio personalizzato.
     *
     * @param message Il messaggio di errore che descrive la causa dell'eccezione.
     */
    public CifraNegativaException(String message) {
        super(message);
    }
}