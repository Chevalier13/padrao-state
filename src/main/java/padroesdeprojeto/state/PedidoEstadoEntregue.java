package padroescomportamentais.state;

public class PedidoEstadoEntregue extends PedidoEstado {

    private PedidoEstadoEntregue() {
    }

    private static final PedidoEstadoEntregue instance =
            new PedidoEstadoEntregue();

    public static PedidoEstadoEntregue getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Entregue";
    }
}