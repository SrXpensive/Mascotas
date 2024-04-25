import java.util.Date;

public class Gallina extends Ave{
    private boolean ponedora;

    public Gallina(String codigo, int patas, int edad, Date fecha_nac, boolean pico, boolean vuela, boolean ponedora) throws EdadErronea{
        super(codigo, patas, edad, fecha_nac, pico, vuela);
        this.ponedora = ponedora;
    }

    @Override
    public void aniversario() {
        setEdad(1);
        System.out.println("Esta gallina tiene "+getEdad()+" años, que equivalen a "+getEdad()*8+" años humanos");
    }

    @Override
    public void habla() {
        System.out.println("Coc, Coc");
    }

    @Override
    public void volar() {
        System.out.println("La gallina ha saltado un metro y medio");
    }

    public boolean isPonedora() {
        return ponedora;
    }

    public String toString(){
        String pon = isPonedora() ? "Si" : "No";
        return super.toString()+"\n ¿Gallina ponedora?: "+pon;
    }
}
