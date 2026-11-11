public class Caja {
    private double totalVendido;
    private int numeroVentas;

    public Caja() {
        this.totalVendido = 0.0;
        this.numeroVentas = 0;
    }

    public double getTotalVendido() {
        return totalVendido;
    }

    public int getNumeroVentas() {
        return numeroVentas;
    }

    //No se puede vender productos si existe stock es insuficiente o es una cantidad inválida
    public boolean cobrar(Producto producto, int cantidad) {
        if (!producto.vender(cantidad)) {
            return false; 
        }
        double subtotal = producto.getPrecio() * cantidad;
        double descuento = 0.0;

        if (subtotal >= 300) {
            descuento = subtotal * 0.10;
        }

        // Calculamos el IVA directo: 15% de (subtotal - descuento)
        double iva = Math.round((subtotal - descuento) * 0.15 * 100.0) / 100.0; 
        
        // Calculamos el total directo: (subtotal - descuento) + IVA
        double total = Math.round(((subtotal - descuento) + iva) * 100.0) / 100.0;1

        // Imprimir ticket
        System.out.println("\nTICKET");
        System.out.println(producto.getNombre() + " x " + cantidad);
        System.out.println("Subtotal: C$" + subtotal);
        System.out.println("Descuento: C$" + descuento);
        System.out.println("IVA (15%): C$" + iva);
        System.out.println("TOTAL: C$" + total);

        // Actualización de ventas
        totalVendido += total;
        numeroVentas++;

        return true;
    }

    public void mostrarReporte() {
        System.out.println("\n===== REPORTE DEL DÍA =====");
        System.out.println("Cantidad de ventas: " + numeroVentas);
        System.out.println("Total vendido: C$" + totalVendido);
    }
}













    
