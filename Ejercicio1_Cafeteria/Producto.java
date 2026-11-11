public class Producto {

    private String nombre;
    private Double precio;
    private int stock;

    public Producto(String nombre, Double precio, int stock){

        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }


    public String getNombre(){
       
    
        return nombre;

    }

    public Double getPrecio(){
        return precio;
    }

    public int getStock(){
        return stock;
    }


        // Un buen setter no solo asigna: VALIDA
    public void setPrecio(double precio) {
        if (precio  > 0) {
            this.precio = precio;
        }

        else{

            System.out.println("El precio debe ser mayor que 0");
        }
    
    }


    public boolean vender(int cantidad){
        if(cantidad <= 0 ){
            System.out.println("La cantidad debe ser mayor que 0");
        }


         if(cantidad > stock)
    {
        System.out.println("No hay stock suficiente");
        return false;
        
    }

    stock -= cantidad;
    return true;

    }

    //Cantidades solo positivas
    public void reabastecer(int cantidad){
        if(cantidad > 0)
        {
            stock += cantidad;
        }

        else{
            System.out.println("La cantidad a reabastecer debe ser positiva.");
        }

    }

   

     

   
}