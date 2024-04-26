import java.util.Date;

public abstract class Animal implements Comparable<Animal>{
    private String codigo;
    private int patas;
    private int edad;
    private Date fecha_nacimiento = new Date();
    public Animal(String codigo, int patas, int edad, Date fecha_nacimiento) throws EdadErronea{
        if(edad<0){
            throw new EdadErronea("La edad no puede ser negativa");
        }
        this.codigo = codigo;
        this.patas = patas;
        this.edad = edad;
        this.fecha_nacimiento = fecha_nacimiento;
    }
    public Animal(String codigo, int patas, int edad)throws EdadErronea{
        if(edad<0){
            throw new EdadErronea("La edad no puede ser negativa");
        }
        this.codigo = codigo;
        this.patas = patas;
        this.edad = edad;
    }
    public Animal(){}
    public abstract void aniversario();
    public abstract void habla();
    public String toString(){
        String fecha = String.format("%td-%<tb-%<tY",getFecha_nacimiento());
        return "Codigo: "+codigo+", Patas: "+patas+", Edad: "+edad+", Fecha de nacimiento: "+fecha;
    }
    public String getCodigo() {
        return codigo;
    }

    public int getPatas() {
        return patas;
    }

    public int getEdad() {
        return edad;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setEdad(int edad) {
        this.edad += edad;
    }

    public int compareTo(Animal animal){
        return this.codigo.compareTo(animal.getCodigo());
    }

}
