import java.util.Date;

public abstract class Ave extends Animal{
    private boolean pico;
    private boolean vuela;
    public Ave(String codigo, int edad, int patas, Date fecha_nac, boolean pico, boolean vuela) throws EdadErronea{
        super(codigo, edad, patas, fecha_nac);
        this.pico = pico;
        this.vuela = vuela;
    }
    public abstract void volar();
}
