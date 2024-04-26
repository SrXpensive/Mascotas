import java.util.Date;

public class Loro extends Ave implements Mascota{
    private String tipo;
    private boolean habla;
    private String nombre="";

    public Loro(String codigo, int patas, int edad, Date fecha_nac, boolean pico, boolean vuela, String tipo, boolean habla) throws EdadErronea{
        super(codigo, patas, edad, fecha_nac, pico, vuela);
        this.tipo = tipo;
        this.habla = habla;
    }

    @Override
    public void aniversario() {
        setEdad(1);
        System.out.println("Este loro tiene "+getEdad()+" años, que equivalen a "+getEdad()*10+" años humanos");
    }

    @Override
    public void habla() {
        System.out.println("Siuuuuu");
    }

    @Override
    public void volar() {
        System.out.println("El loro se ha desplazado 3 metros");
    }
    public void saluda(){
        System.out.println("HOLA, HOLA");
    }

    public String getTipo() {
        return tipo;
    }

    public boolean isHabla() {
        return habla;
    }

    public String toString(){
        String habla = isHabla() ? "Si" : "No";
        String n="";
        if(!getNombre().isEmpty()){
            n+="\n Nombre: "+getNombre();
        }
        return super.toString()+"\n Tipo de loro: "+getTipo()+"\n ¿Habla?: "+habla+", "+n;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String jugar(String nombre) {
        return "Saluda a quien pase";
    }
}
