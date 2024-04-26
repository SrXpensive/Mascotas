import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class ListaAnimales {
    private static ArrayList<Animal> animales = new ArrayList<>();
    public static void main(String[] args) {
        int opcion;
        do{
            System.out.println("--------------------");
            System.out.println("1 - Mostrar lista de animales");
            System.out.println("2 - Ordenar lista");
            System.out.println("3 - Mostrar todos los datos de un animal");
            System.out.println("4 - Insertar nuevo animal");
            System.out.println("5 - Eliminar animal");
            System.out.println("6 - Modificar animal");
            System.out.println("--------------------");
            opcion = Leer.leerEntero("Introduce una opción: ");
            switch(opcion){
                case 1:
                    listaAnimales();
                break;
                case 2:
                    int modo;
                    if(animales.isEmpty()){
                        System.out.println("La lista está vacía");
                    }
                    else{
                        System.out.println("--------------------");
                        System.out.println("1 - Ordenar por código");
                        System.out.println("2 - Ordenar por tipo");
                        System.out.println("--------------------");
                        modo = Leer.leerEntero("¿Cómo quieres ordenar los animales?");
                        switch(modo){
                            case 1:
                                ordenarCodigo();
                            break;
                            case 2:
                                ordenarTipo();
                            break;
                        }
                    }
                    break;
                case 3:
                    String num;
                    listaAnimales();
                    num = Leer.leerTexto("¿De qué animal quieres ver los datos? (introduce su código): ");
                    System.out.println(buscarAnimal(num));
                    break;
                case 4:
                    insertarAnimal();
                    break;
                case 5:
                    if(animales.isEmpty()){
                        System.out.println("La lista está vacía");
                    }else{
                        listaAnimales();
                        String n = Leer.leerTexto("¿Qué animal quieres eliminar? (introduce su código): ");
                        System.out.println("El siguiente animal será eliminado: ");
                        System.out.println(buscarAnimal(n));
                        String op = Leer.leerTexto("¿Estás seguro de querer eliminarlo? (s/n)");
                            if(op.equals("s")){
                            animales.remove(buscarAnimal(n));
                            System.out.println("Animal borrado");
                        }else{
                            System.out.println("Proceso de eliminación abortado");
                        }
                    }
                    break;
                case 6:
                    int mod;
                    if(animales.isEmpty()){
                        System.out.println("La lista está vacía");
                    }else{
                        listaAnimales();
                        String m = Leer.leerTexto("¿Qué animal quieres modificar? (introduce su código): ");
                            if(buscarAnimal(m) instanceof Perro){
                            System.out.println("--------------------");
                            System.out.println("1 - Vacunar");
                            System.out.println("2 - Aniversario");
                            System.out.println("3 - Poner nombre");
                            mod = Leer.leerEntero("Introduce una opción: ");
                            try {
                                switch(mod) {
                                    case 1:
                                        ((Perro) buscarAnimal(m)).vacunar();
                                        break;
                                    case 2:
                                        buscarAnimal(m).aniversario();
                                        break;
                                    case 3:
                                        String nom = Leer.leerTexto("Introduce el nombre que quieres poner al perro: ");
                                        ((Perro) buscarAnimal(m)).setNombre(nom);
                                }
                                }catch (NullPointerException e) {
                                        System.out.println(e.getMessage());
                                }
                            }else if(buscarAnimal(m) instanceof Gato){
                                System.out.println("--------------------");
                                System.out.println("1 - Cortar Pelo");
                                System.out.println("2 - Aniversario");
                                System.out.println("3 - Poner nombre");
                                mod = Leer.leerEntero("Introduce una opcion: ");
                                switch(mod){
                                    case 1:
                                        ((Gato)buscarAnimal(m)).cortarPelo();
                                        break;
                                    case 2:
                                        buscarAnimal(m).aniversario();
                                        break;
                                    case 3:
                                        String nom = Leer.leerTexto("Introduce el nombre que quieres poner al gato: ");
                                        ((Gato) buscarAnimal(m)).setNombre(nom);
                                        break;
                                }
                            }else if(buscarAnimal(m) instanceof Loro) {
                                System.out.println("--------------------");
                                System.out.println("1 - Aniversario");
                                System.out.println("2 - Poner nombre");
                                mod = Leer.leerEntero("Introduce una opcion: ");
                                switch (mod) {
                                    case 1:
                                        buscarAnimal(m).aniversario();
                                        break;
                                    case 2:
                                        String nom = Leer.leerTexto("Introduce el nombre del loro");
                                        ((Loro) buscarAnimal(m)).setNombre(nom);
                                        break;
                                }
                                break;
                            }
                    }
            }
        }while(opcion!=0);
    }
    public static void listaAnimales(){
        if(animales.isEmpty()){
            System.out.println("La lista está vacía");
        }else{
            for(int i = 0; i<animales.size(); i++){
                System.out.println((i+1)+" "+animales.get(i).getClass().getName()+" "+animales.get(i).getCodigo());
            }
        }
    }
    public static void ordenarCodigo(){
        Collections.sort(animales);
    }
    public static void ordenarTipo(){
        Collections.sort(animales,new CompararAnimal());
    }
    public static Animal buscarAnimal(String codigo){
        for (Animal ani : animales){
            if(ani.getCodigo().equals(codigo)){
                return ani;
            }
        }
        return null;
    }
    public static void insertarAnimal(){
        Animal a = new Perro();
        int tipo;
        String raza;
        String cod = Leer.leerTexto("Introduce el código del animal: ");
        int patas = Leer.leerEntero("Introduce el número de patas del animal: ");
        int edad = Leer.leerEntero("Introduce la edad del animal: ");
        int dia = Leer.leerEntero("Introduce su dia de nacimiento(dd): ");
        int mes = Leer.leerEntero("Introduce su mes de nacimiento(mm): ");
        int ano = Leer.leerEntero("Introduce su año de nacimiento(yyyy): ");
        Date fecha = new Date((ano-1900),(mes-1),dia);
        System.out.println("1 - Perro");
        System.out.println("2 - Gato");
        System.out.println("3 - Gallina");
        System.out.println("4 - Loro");
        tipo = Leer.leerEntero("¿Qué tipo de animal quieres añadir?: ");
        switch(tipo){
            case 1:
                boolean d;
                raza = Leer.leerTexto("Introduce la raza del perro: ");
                String desp = Leer.leerTexto("¿Está desparasitado?(s/n): ");
                d = desp.equals("s");
                int vac = Leer.leerEntero("¿Cuantas vacunas tiene el perro?: ");
                try {
                    a = new Perro(cod, patas, edad, fecha, raza, d, vac);
                }catch(EdadErronea e){
                    System.out.println(e.getMessage());
                }
            break;
            case 2:
                boolean p;
                raza = Leer.leerTexto("Introduce la raza del gato: ");
                String pelo = Leer.leerTexto("¿Tiene el pelo largo? (s/n): ");
                p = pelo.equals("s");
                try{
                    a = new Gato(cod,patas,edad,fecha,raza,p);
                }catch(EdadErronea e){
                    System.out.println(e.getMessage());
                }
            break;
            case 3:
                String ponedora = Leer.leerTexto("¿Es una gallina ponedora? (s/n): ");
                boolean pon = ponedora.equals("s");
                try{
                    a = new Gallina(cod,patas,edad,fecha,true,false,pon);
                }catch(EdadErronea e){
                    System.out.println(e.getMessage());
                }
                break;
            case 4:
                String t = Leer.leerTexto("¿De qué tipo es el loro?: ");
                String habla = Leer.leerTexto("¿Habla? (s/n): ");
                boolean h = habla.equals("s");
                try{
                    a = new Loro(cod,patas,edad,fecha,true,true,t,h);
                }catch(EdadErronea e){
                    System.out.println(e.getMessage());
                }
                break;
        }
        animales.add(a);
    }
}
