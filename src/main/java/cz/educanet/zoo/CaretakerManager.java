package cz.educanet.zoo;

import javax.enterprise.context.ApplicationScoped;
import javax.swing.text.Caret;
import java.util.ArrayList;

@ApplicationScoped
public class CaretakerManager {
    ArrayList<Caretaker> caretakers = new ArrayList<>();

    public ArrayList<Caretaker> getCaretakers() {
        return caretakers;
    }
    public void addCaretaker(Caretaker newCaretaker) {
        caretakers.add(newCaretaker);
    }

    public boolean editCaretaker(int id, Caretaker edited) {
        if(existsById(id)) {
            Caretaker caretaker = getCaretakerById(id);
            caretaker.setFirstName(edited.getFirstName());
            caretaker.setLastName(edited.getLastName());
            caretaker.setGender(edited.getGender());
            return true;
        }
        else return false;
    }
    public boolean deleteCaretaker(int id) {
        return caretakers.remove(getCaretakerById(id));
    }

    public boolean existsById(int id) {
        for (Caretaker caretaker : caretakers) {
            if (caretaker.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public Caretaker getCaretakerById(int id) {
        for (Caretaker caretaker : caretakers) {
            if(caretaker.getId() == id) {
                return caretaker;
            }
        }
        return null;
    }
}
