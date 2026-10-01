package padroescomportamentais.state;

public class PedidoEstadoNovo extends PedidoEstado {

    private PedidoEstadoNovo() {
    }

    private static final PedidoEstadoNovo instance =
            new PedidoEstadoNovo();

    public static PedidoEstadoNovo getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Novo";
    }

    public boolean pagar(Pedido pedido) {
        pedido.setEstado(PedidoEstadoPago.getInstance());
        return true;
    }

    public boolean cancelar(Pedido pedido) {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        return true;
    }
}
