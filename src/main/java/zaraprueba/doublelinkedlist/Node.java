package zaraprueba.doublelinkedlist;

public class Node {
	private Node anterior;
	private Node proximo;
	private Producto producto;

	public Node(Producto producto) {
		this(null, producto, null);
	}

	public Node(Node anterior, Producto producto, Node proximo) {
		this.anterior = anterior;
		this.proximo = proximo;
		this.producto = producto;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Node getAnterior() {
		return this.anterior;
	}

	public void setAnterior(Node anterior) {
		this.anterior = anterior;
	}

	public Node getProximo() {
		return this.proximo;
	}

	public void setProximo(Node proximo) {
		this.proximo = proximo;
	}

}