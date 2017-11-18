package zaraprueba.doublelinkedlist;

/***
 * Implementación académica de una java.util.LinkedList
 * @author Jefferson Lupinacci Pereira Evangelista
 *
 */
public class ProductoLinkedList {

		
	private Node inicio;
	private Node fin;

	public ProductoLinkedList() {
		inicio = null;
		fin = null;
	}

	public boolean estaVacio() {
		// no hay nada, entonces está vacío
		return null == fin;
	}

	public void anadirProductoInicio(Producto producto) {
		Node node = new Node(inicio, producto, null);
		if (estaVacio())
			fin = inicio = node;
		else {
			inicio.setProximo(node);
			inicio = node;
		}
	}

	public void anadirProductoFin(Producto producto) {
		Node node = new Node(null, producto, fin);
		if (estaVacio())
			fin = inicio = node;
		else {
			fin.setAnterior(node);
			fin = node;
		}
	}

	public int total() {
		Node node = fin;
		int t = 0;
		while (null != node) {
			t++;
			node = node.getProximo();
		}
		return t;
	}

	public Producto quitarPrimeroProducto() {
		Producto producto = fin.getProducto();
		if (!estaVacio()) {
			if (fin == inicio)
				fin = inicio = null;
			else {
				fin = fin.getProximo();
				fin.setProximo(null);
			}
		}
		return producto;
	}

	public Producto quitarUltimoProducto() {
		Producto producto = inicio.getProducto();
		if (!estaVacio()) {
			if (fin == inicio)
				fin = inicio = null;
			else {
				inicio = inicio.getAnterior();
				inicio.setAnterior(null);
			}
		}

		return producto;
	}

	public boolean quitarProducto(Producto producto) {

		if (null == producto)
			throw new IllegalArgumentException();
		
		Node node = fin;

		// compare equals
		while (producto != node.getProducto())
			node = node.getProximo();

		if (null != node) {
			if (null == node.getAnterior()) {
				fin = node.getProximo();
				if (!estaVacio()) {
					fin.setAnterior(null);
				}
			} else if (null == node.getProximo()) {
				inicio = node.getAnterior();
				if (!estaVacio()) {
					inicio.setProximo(null);
				}
			} else {
				node.getAnterior().setProximo(node.getProximo());
				node.getProximo().setAnterior(node.getAnterior());
			}
		}
		return null != node;
	}

	public Node primeroNode() {
		return fin;
	}

	public Node ultimoNode() {
		return inicio;
	}

		
	
}