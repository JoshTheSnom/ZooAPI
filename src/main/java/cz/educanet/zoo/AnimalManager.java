package cz.educanet.zoo;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;

@ApplicationScoped
public class AnimalManager {
        ArrayList<Animal> animals = new ArrayList<>();

        public ArrayList<Animal> getAnimals() {
            return animals;
        }
        public void addAnimal(Animal newAnimal) {
            animals.add(newAnimal);
        }

        public boolean editAnimal(int id, Animal edited) {
            if(existsById(id)) {
                Animal animal = getAnimalById(id);
                animal.setName(edited.getName());
                animal.setAge(edited.getAge());
                animal.setWeight(edited.getWeight());
                animal.setGender(edited.getGender());
                return true;
            }
            else return false;
        }
        public boolean deleteAnimal(int id) {
            return animals.remove(getAnimalById(id));
        }

        public boolean existsById(int id) {
            for (Animal animal : animals) {
                if (animal.getId() == id) {
                    return true;
                }
            }
            return false;
        }

        public Animal getAnimalById(int id) {
            for (Animal animal : animals) {
                if(animal.getId() == id) {
                    return animal;
                }
            }
            return null;
        }
}
