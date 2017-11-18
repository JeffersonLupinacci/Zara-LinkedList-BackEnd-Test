package zaraprueba.doublelinkedlist;

public class ProductoLinkedListBuilder {

	private ProductoLinkedList instance;
	
	public ProductoLinkedListBuilder() {
		this.instance = new ProductoLinkedList();
	}
	
	public ProductoLinkedListBuilder anadirInicio(Producto producto) {
		instance.anadirProductoInicio(producto);
		return this;
	}
	
	public ProductoLinkedListBuilder anadirFin(Producto producto) {
		instance.anadirProductoFin(producto);
		return this;
	}
	
	public ProductoLinkedList getInstance() {
		return instance;
	}
}


