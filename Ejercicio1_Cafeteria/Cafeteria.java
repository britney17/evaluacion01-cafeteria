import java.util.Scanner;

public class Cafeteria {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Producto cafe = new Producto("Café americano", 45.0, 20);
        Producto cappuccino = new Producto("Cappuccino", 70.0, 15);
        Producto sandwich = new Producto("Sandwich", 95.0, 10);
        Producto galleta = new Producto("Galleta de avena", 30.0, 25);

        Caja caja = new Caja();

        int opcion;
        do {
            System.out.println("\n==== CAFETERIA CI ====");
            System.out.println("1. Ver productos");
            System.out.println("2. Vender");
            System.out.println("3. Reabastecer");
            System.out.println("4. Cambiar precio");
            System.out.println("5. Reporte del día");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
                case 1:
                    verProductos(cafe, cappuccino, sandwich, galleta);
                    break;
                case 2:
                    System.out.print("Numero de producto (1-4): ");
                    int numV = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Cantidad: ");
                    int cantV = sc.nextInt();
                    sc.nextLine();
                    Producto prodVender = obtenerProducto(numV, cafe, cappuccino, sandwich, galleta);
                    if (prodVender != null) {
                        caja.cobrar(prodVender, cantV);
                    } else {
                        System.out.println("Producto invalido.");
                    }
                    break;
                case 3:
                    System.out.print("Numero de producto (1-4): ");
                    int numR = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Cantidad a reabastecer: ");
                    int cantR = sc.nextInt();
                    sc.nextLine();
                    Producto prodReab = obtenerProducto(numR, cafe, cappuccino, sandwich, galleta);
                    if (prodReab != null) {
                        prodReab.reabastecer(cantR);
                    } else {
                        System.out.println("Producto invalido.");
                    }
                    break;
                case 4:
                    System.out.print("Numero de producto (1-4): ");
                    int numP = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nuevo precio: ");
                    double nuevoP = sc.nextDouble();
                    sc.nextLine();
                    Producto prodPrecio = obtenerProducto(numP, cafe, cappuccino, sandwich, galleta);
                    if (prodPrecio != null) {
                        prodPrecio.setPrecio(nuevoP);
                    } else {
                        System.out.println("Producto invalido.");
                    }
                    break;
                case 5:
                    caja.mostrarReporte();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion invalida. Intente de nuevo.");
            }
        } while (opcion != 0);

        sc.close();
    }

    // Mostrar los productos
    private static void verProductos(Producto p1, Producto p2, Producto p3, Producto p4) {
        System.out.println("\n--- LISTA DE PRODUCTOS ---");
        System.out.println("1. " + p1.getNombre() + " - C$" + p1.getPrecio() + " - Stock: " + p1.getStock() + (p1.getStock() < 5 ? " (stock bajo)" : ""));
        System.out.println("2. " + p2.getNombre() + " - C$" + p2.getPrecio() + " - Stock: " + p2.getStock() + (p2.getStock() < 5 ? " (stock bajo)" : ""));
        System.out.println("3. " + p3.getNombre() + " - C$" + p3.getPrecio() + " - Stock: " + p3.getStock() + (p3.getStock() < 5 ? " (stock bajo)" : ""));
        System.out.println("4. " + p4.getNombre() + " - C$" + p4.getPrecio() + " - Stock: " + p4.getStock() + (p4.getStock() < 5 ? " (stock bajo)" : ""));
    }

    // Permite seleccionar producto x número 
    private static Producto obtenerProducto(int num, Producto p1, Producto p2, Producto p3, Producto p4) {
        if (num == 1) return p1;
        if (num == 2) return p2;
        if (num == 3) return p3;
        if (num == 4) return p4;
        return null;
    }
}