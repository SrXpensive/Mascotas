import java.util.ArrayList;
import java.util.Collections;

public class ListaAnimales {
    private static ArrayList<Animal> animales = new ArrayList<>();
    public static void main(String[] args) {
        int opcion;
        do{
            System.out.println("1 - Mostrar lista de animales");
            System.out.println("2 - Ordenar lista");
            System.out.println("3 - Mostrar todos los datos de un animal");
            System.out.println("4 - Insertar nuevo animal");
            System.out.println("5 - Eliminar animal");
            opcion = Leer.leerEntero("Introduce una opción: ");
            switch(opcion){
                case 1:
                    listaAnimales();
                break;
                case 2:
                    int modo;
                    System.out.println("1 - Ordenar por código");
                    System.out.println("2 - Ordenar por tipo");
                    modo = Leer.leerEntero("¿Cómo quieres ordenar los animales?");
                    switch(modo){
                        case 1:
                            ordenarCodigo();
                        break;
                        case 2:
                            ordenarTipo();
                        break;
                    }
                break;
                case 3:
                    int num;
                    listaAnimales();
                    num = Leer.leerEntero("¿De qué animal quieres ver los datos?: ");
                    System.out.println(animales.get(num-1));
            }
        }while(opcion!=0);
    }
    public static void listaAnimales(){
        for(int i = 0; i<animales.size(); i++){
            System.out.println((i+1)+" "+animales.get(i).getClass().getName()+" "+animales.get(i).getCodigo());
        }
    }
    public static void ordenarCodigo(){
        Collections.sort(animales);
    }
    public static void ordenarTipo(){
        Collections.sort(animales,new CompararAnimal());
    }
    public static void buscarAnimal(String codigo){
        for (Animal ani : animales){
            if(ani.getCodigo().equals(codigo)){
                System.out.println(ani);
            }
        }
    }
}
