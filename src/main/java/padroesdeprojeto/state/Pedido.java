package padroescomportamentais.state;

public class Pedido {

    private int numero;
    private PedidoEstado estado;

    public Pedido() {
        this.estado = PedidoEstadoNovo.getInstance();
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public PedidoEstado getEstado() {
        return estado;
    }

    public void setEstado(PedidoEstado estado) {
        this.estado = estado;
    }

    public String getNomeEstado() {
        return estado.getEstado();
    }

    public boolean pagar() {
        return estado.pagar(this);
    }

    public boolean enviar() {
        return estado.enviar(this);
    }

    public boolean entregar() {
        return estado.entregar(this);
    }

    public boolean cancelar() {
        return estado.cancelar(this);
    }
}