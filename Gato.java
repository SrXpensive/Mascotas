import java.util.Date;

public class Gato extends Animal implements Mascota{
    private String raza;
    private boolean pelo_largo;
    private String nombre;
    public Gato(String codigo, int patas, int edad, Date fecha_nac, String raza, boolean pelo_largo) throws EdadErronea{
        super(codigo,patas,edad,fecha_nac);
        this.raza = raza;
        this.pelo_largo = pelo_largo;
    }
    @Override
    public void aniversario() {
        setEdad(1);
        System.out.println("Este gato tiene "+getEdad()+" años, que equivale a "+getEdad()*5+" años humanos");
    }

    @Override
    public void habla() {
        System.out.println("MIAU, MIAU");
    }

    public void cortarPelo(){
        setPelo_largo(false);
    }

    public void setPelo_largo(boolean pelo_largo) {
        this.pelo_largo = pelo_largo;
    }
    public String toString(){
        String pelo = isPelo_largo() ? "Si" : "No";
        String n = "";
        if(!getNombre().isEmpty()){
            n += "\n Nombre: "+getNombre();
        }
        return super.toString()+"\n Gato\n Raza :" +getRaza()+" \n Pelo largo: "+pelo+"\n Edad: "+getEdad()+" "+n;
    }

    public boolean isPelo_largo() {
        return pelo_largo;
    }

    public String getRaza() {
        return raza;
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
        return "Rasca la cuerda";
    }
}
