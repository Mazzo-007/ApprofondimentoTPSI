package CCmanagement;

/**
 * La classe CCmanagement rappresenta un conto corrente bancario, che contiene informazioni
 * come il nome del titolare e il saldo disponibile. Permette di effettuare operazioni di deposito
 * e prelievo, con la gestione delle eccezioni relative a cifre negative e saldo insufficiente.
 */
public class CCmanagement {
    private String nome;
    private double saldo;

    /**
     * Costruttore per inizializzare un conto corrente con il nome del titolare.
     * Inizializza il saldo a 0.
     *
     * @param nome Il nome del titolare del conto corrente.
     */
    public CCmanagement(String nome) {
        this.nome = nome;
        saldo = 0;
    }

    /**
     * Rappresentazione in formato stringa del conto corrente.
     *
     * @return Una stringa contenente le informazioni relative al conto corrente,
     *         inclusi il nome del titolare e il saldo attuale.
     */
    @Override
    public String toString() {
        return "informazioni conto corrente{" +
                "nome='" + nome + '\'' +
                ", saldo=" + saldo +
                '}';
    }

    /**
     * Restituisce il nome del titolare del conto corrente.
     *
     * @return Il nome del titolare del conto corrente.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Imposta il nome del titolare del conto corrente.
     *
     * @param nome Il nuovo nome del titolare.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Restituisce l'importo attuale del saldo del conto corrente.
     *
     * @return Il saldo attuale del conto corrente.
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Imposta un nuovo saldo per il conto corrente.
     *
     * @param saldo Il nuovo saldo da impostare.
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * Esegue un prelievo dal conto corrente, riducendo il saldo.
     * L'operazione di prelievo è soggetta a due eccezioni:
     * 1. Se la quantità da prelevare è negativa.
     * 2. Se il saldo è insufficiente.
     *
     * @param qta La quantità da prelevare.
     * @throws CifraNegativaException Se la quantità da prelevare è negativa.
     * @throws SaldoInsufficienteException Se il saldo è insufficiente per effettuare il prelievo.
     */
    public void preleva(double qta) throws CifraNegativaException, SaldoInsufficienteException {
        if (qta < 0) {
            throw new CifraNegativaException("Impossibile prelevare una cifra negativa");
        }
        if (qta > saldo) {
            throw new SaldoInsufficienteException("Impossibile prelevare, saldo insufficiente");
        }
        saldo = saldo - qta;
    }

    /**
     * Esegue un deposito nel conto corrente, incrementando il saldo.
     * L'operazione di deposito è soggetta a una eccezione se la quantità da depositare è negativa.
     *
     * @param qta La quantità da depositare.
     * @throws CifraNegativaException Se la quantità da depositare è negativa.
     */
    public void deposita(double qta) throws CifraNegativaException {
        if (qta < 0) {
            throw new CifraNegativaException("Impossibile depositare una cifra negativa");
        }
        saldo = saldo + qta;
    }
}

