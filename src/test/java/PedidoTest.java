package padroescomportamentais.state;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {

    Pedido pedido;

    @BeforeEach
    void setUp() {
        pedido = new Pedido();
    }

    @Test
    void deveArmazenarEstadoNovo() {
        assertEquals("Novo", pedido.getNomeEstado());
    }

    @Test
    void devePagarPedidoNovo() {
        pedido.setEstado(PedidoEstadoNovo.getInstance());

        assertTrue(pedido.pagar());
        assertEquals("Pago", pedido.getNomeEstado());
    }

    @Test
    void deveCancelarPedidoNovo() {
        pedido.setEstado(PedidoEstadoNovo.getInstance());

        assertTrue(pedido.cancelar());
        assertEquals("Cancelado", pedido.getNomeEstado());
    }

    @Test
    void naoDeveEnviarPedidoNovo() {
        pedido.setEstado(PedidoEstadoNovo.getInstance());

        assertFalse(pedido.enviar());
    }

    @Test
    void deveEnviarPedidoPago() {
        pedido.setEstado(PedidoEstadoPago.getInstance());

        assertTrue(pedido.enviar());
        assertEquals("Enviado", pedido.getNomeEstado());
    }

    @Test
    void deveCancelarPedidoPago() {
        pedido.setEstado(PedidoEstadoPago.getInstance());

        assertTrue(pedido.cancelar());
        assertEquals("Cancelado", pedido.getNomeEstado());
    }

    @Test
    void naoDevePagarPedidoPago() {
        pedido.setEstado(PedidoEstadoPago.getInstance());

        assertFalse(pedido.pagar());
    }

    @Test
    void deveEntregarPedidoEnviado() {
        pedido.setEstado(PedidoEstadoEnviado.getInstance());

        assertTrue(pedido.entregar());
        assertEquals("Entregue", pedido.getNomeEstado());
    }

    @Test
    void naoDeveCancelarPedidoEntregue() {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());

        assertFalse(pedido.cancelar());
    }

    @Test
    void naoDeveAlterarPedidoCancelado() {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());

        assertFalse(pedido.pagar());
        assertFalse(pedido.enviar());
        assertFalse(pedido.entregar());
    }
}