package gestisimal;
/*
 * <p>
 * Crea el programa GESTISIMAL (GESTIón SIMplificada de Almacén) para llevar el
 * control de los artículos de un almacén. De cada artículo se debe saber el
 * código, la descripción, el precio de compra, el precio de venta y el stock
 * (número de unidades).
 * 
 * Como comportamiento: Consideramos que el código va a generarse de forma automática en el constructor,
 *  así no puede haber dos artículos con el mismo código. Esto implica que no puede modificarse el código de un artículo,
 *  sí el resto de las propiedades. Podremos mostrar el artículo, por lo que necesito una representación del artículo en forma de cadena (toString).
 * 
 * 
 * </p>
 * @author Villarroel Molina Jesus David
 */

public class Articulo {

	/* Gerenamos codigos para cada articulo */

	private static int contador = 1;
	private String descripcion;
	private double precioCompra;
	private double precioVenta;
	private int stock;
	/* Identifica al artículo. Será único */
	private int codigo;

	/**
	 * Constructor de la clase artículo
	 * 
	 * @param descripcion
	 * @param precioCompra
	 * @param precioVenta
	 * @param stock
	 * @throws StockNegativoException
	 * @throws PrecioCompraNegativoException
	 * @throws PrecioVentaNegativoException
	 */

	/**
	 * Constructor de la clase artículo unicamente con el código del artículo
	 * 
	 * @param precioVenta2
	 * @param precioCompra2
	 * @param descripcion2
	 * 
	 * @param codigoArticulo
	 */

	Articulo(String descripcion2, double precioCompra2, double precioVenta2, int codigoArticulo) {
		setCodigo(codigoArticulo);
	}

	/**
	 * Setter del código del constructor de articulo que usa unicamente el codigo.
	 */
	private void setCodigo(int codigo) {
		this.codigo = Articulo.contador++;
	}

	/**
	 * Getter del código
	 * 
	 * @return codigo del artículo
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * Getter de la descripción
	 * 
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Setter de la descripción
	 * 
	 * @param descripcion the descripcion to set
	 */
	void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Getter precio de compra
	 * 
	 * @return the precioCompra
	 */
	public double getPrecioCompra() {
		return precioCompra;
	}

	/**
	 * Setter de precio de compra en el que se controla que el precio de compra no
	 * sea negativo
	 * 
	 * @param precioCompra the precioCompra to set
	 * @throws PrecioCompraNegativoException
	 */

	void setPrecioCompra(double precioCompra) throws PrecioCompraNegativoException {
		if (precioCompra >= 0) {
			this.precioCompra = precioCompra;
		} else
			throw new PrecioCompraNegativoException("El precio de compra no puede ser negativo.");
	}

	/**
	 * Getter precio de venta
	 * 
	 * @return the precioVenta
	 */
	public double getPrecioVenta() {
		return precioVenta;
	}

	/**
	 * Setter precio de venta en el que se controla que el precio de venta no sea
	 * negativo
	 * 
	 * @param precioVenta the precioVenta to set
	 * @return
	 * @throws PrecioVentaNegativoException
	 */
	int setPrecioVenta(double precioVenta) throws PrecioVentaNegativoException {
		if (precioVenta >= 0) {
			this.precioVenta = precioVenta;
		} else
			throw new PrecioVentaNegativoException("El precio de venta no puede ser negativo.");
		return codigo;
	}

	/**
	 * Getter del stock
	 * 
	 * @return the stock
	 */
	int getstock() {
		return stock;
	}

	/**
	 * Setter de stock en el que se controla que el stock no sea negativo
	 * 
	 * @param stock the stock to set
	 * @throws StockNegativoException
	 */
	private void setStock(int stock) throws StockNegativoException {
		if (stock >= 0) {
			this.stock = stock;
		} else
			throw new StockNegativoException("El stock no puede ser negativo.");
	}

	/**
	 * Método para aumentar el stock
	 * 
	 * @param cantidad
	 * @throws StockNegativoException
	 * @throws CantidadNegativaException
	 */
	public void incrementaStock(int cantidad) throws StockNegativoException, CantidadNegativaException {
		if (cantidad > 0)
			setStock(getstock() + cantidad);
		else
			throw new CantidadNegativaException("No se puede añadir una cantidad de stock negativo.");
	}

	/**
	 * Método para aumentar el stock
	 * 
	 * @param cantidad
	 * @throws CantidadNegativaException
	 * @throws StockNegativoException
	 */
	public void decrementaStock(int cantidad) throws CantidadNegativaException, StockNegativoException {
		if (cantidad > 0)
			setStock(getstock() - cantidad);
		else
			throw new CantidadNegativaException("No se puede añadir una cantidad de stock negativo.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */

	public String toString() {
		return "\nCodigo: " + getCodigo() + "\nDescripcion: " + getDescripcion() + "\nPrecioCompra: "
				+ getPrecioCompra() + "\nPrecioVenta: " + getPrecioVenta() + "\nStock: " + getstock()
				+ "\n'''''''''''''''''''''''''''''''''''''''";
	}

	public void set(String descripcion, double precioCompra, double precioVenta, int stock)
			throws StockNegativoException, PrecioCompraNegativoException, PrecioVentaNegativoException {
		setDescripcion(descripcion);
		setPrecioCompra(precioCompra);
		setPrecioVenta(precioVenta);
		setStock(stock);
	}

}
