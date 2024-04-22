import java.util.Date;

public class Perro extends Animal{
    private String raza;
    private boolean desparasitado;
    private int num_vacunas;
    public Perro(String codigo, int patas, int edad, Date fecha_nac, String raza, boolean desparasitado, int num_vacunas){
        super(codigo,patas,edad,fecha_nac);
        this.raza = raza;
        this.desparasitado = desparasitado;
        this.num_vacunas = num_vacunas;
    }
    @Override
    public void aniversario() {
        setEdad(1);
        System.out.println("Este perro tiene "+getEdad()+" que equivale a "+getEdad()*7+" años humanos");
    }
    @Override
    public void habla() {
        System.out.println("GUAU, GUAU");
    }
    public String toString(){
        String desp = isDesparasitado() ? "Si" : "No";
        return "Perro\n Raza :" +getRaza()+" \n Desparasitado: "+desp+"\n Num. vacunas: "+getNum_vacunas();
    }

    public String getRaza() {
        return raza;
    }

    public boolean isDesparasitado() {
        return desparasitado;
    }

    public int getNum_vacunas() {
        return num_vacunas;
    }
    public void setNum_vacunas(int num_vacunas) {
        this.num_vacunas += num_vacunas;
    }
    public void vacunar(){
        setNum_vacunas(1);
        desparasitado = true;
    }

}
