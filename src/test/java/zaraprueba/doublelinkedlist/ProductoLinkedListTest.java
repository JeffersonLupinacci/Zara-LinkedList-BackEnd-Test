package zaraprueba.doublelinkedlist;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ProductoLinkedListTest {

	ProductoLinkedListBuilder builder;
	Producto p_1;
	Producto p_2;
	Producto p_3;

	@Before
	public void setup() {
		builder = new ProductoLinkedListBuilder();
		p_1 = new Producto(1);
		p_2 = new Producto(2);
		p_3 = new Producto(3);
	}

	@Test
	public void listaNoPuedeEstarVacio() {
		ProductoLinkedList lista = builder.anadirFin(p_1).getInstance();

		assertEquals(lista.estaVacio(), false);
		assertEquals(lista.total(), 1);
	}

	@Test
	public void anadirTresProductosAlFinal() {
		ProductoLinkedList lista = builder.anadirFin(p_1).anadirFin(p_2).anadirFin(p_3).getInstance();

		assertEquals(lista.primeroNode().getProducto(), p_3);
		assertEquals(lista.ultimoNode().getProducto(), p_1);
	}

	@Test
	public void anadirTresProductosAlInicio() {
		ProductoLinkedList lista = builder.anadirInicio(p_1).anadirInicio(p_2).anadirInicio(p_3).getInstance();

		assertEquals(lista.primeroNode().getProducto(), p_1);
		assertEquals(lista.ultimoNode().getProducto(), p_3);
	}

	@Test(expected = IllegalArgumentException.class)
	public void exceptionAoQuitarProductoNull() {
		boolean result = new ProductoLinkedList().quitarProducto(null);

		assertEquals(result, false);
	}

	@Test
	public void quitarProducto() {
		ProductoLinkedList lista = builder.anadirInicio(p_1).anadirInicio(p_2).getInstance();
		boolean result = lista.quitarProducto(p_1);

		assertEquals(result, true);
		assertEquals(lista.estaVacio(), false);
	}

	@Test
	public void quitarPrimeiroProducto() {
		ProductoLinkedList lista = builder.anadirFin(p_1).anadirFin(p_2).getInstance();
		Producto proximo = lista.quitarPrimeroProducto();

		assertEquals(proximo, p_2);
	}

	@Test
	public void quitarUltimoProducto() {
		ProductoLinkedList lista = builder.anadirFin(p_1).anadirFin(p_2).getInstance();
		Producto anterior = lista.quitarUltimoProducto();

		assertEquals(anterior, p_1);
	}

	@Test
	public void validarProductoAnterior() {
		ProductoLinkedList lista = builder.anadirInicio(p_1).anadirInicio(p_2).anadirInicio(p_3).getInstance();
		boolean exito = lista.quitarProducto(p_2);

		assertEquals(exito, true);
		assertEquals(lista.ultimoNode().getAnterior().getProducto(), p_1);
	}

	@Test
	public void validarProximoProducto() {
		ProductoLinkedList lista = builder.anadirInicio(p_1).anadirInicio(p_2).anadirInicio(p_3).getInstance();
		boolean exito = lista.quitarProducto(p_2);

		assertEquals(exito, true);
		assertEquals(lista.primeroNode().getProximo().getProducto(), p_3);
	}

}
