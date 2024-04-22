import java.util.Date;

public class Gato extends Animal{
    private String raza;
    private boolean pelo_largo;
    public Gato(String codigo, int edad, int patas, Date fecha_nac, String raza, boolean pelo_largo){
        super(codigo,edad,patas,fecha_nac);
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
        return "Gato\n Raza :" +getRaza()+" \n Pelo largo: "+pelo+"\n Edad: "+getEdad();
    }

    public boolean isPelo_largo() {
        return pelo_largo;
    }

    public String getRaza() {
        return raza;
    }
}
