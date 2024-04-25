import java.util.Comparator;

public class CompararAnimal implements Comparator<Animal> {
    @Override
    public int compare(Animal animal1, Animal animal2) {
        if(animal1.getClass().getName().equals(animal2.getClass().getName())){
            return animal1.getCodigo().compareTo(animal2.getCodigo());
        }
        return animal1.getClass().getName().compareTo(animal2.getClass().getName());
    }
}
