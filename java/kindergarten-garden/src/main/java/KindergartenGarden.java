import java.text.StringCharacterIterator;
import java.util.LinkedList;
import java.util.List;

class KindergartenGarden {

    private List<List> childPlants = new LinkedList<>();
    
    KindergartenGarden(String garden) {
        if(garden.isEmpty()) {
          return;  
        }
        String[] rows = garden.split("\n");
        StringCharacterIterator topRow = new StringCharacterIterator(rows[0]);
        StringCharacterIterator bottomRow = new StringCharacterIterator(rows[1]);
        List<Plant> currentList;
        do {
            currentList = new LinkedList<>();
            currentList.add(Plant.getPlant(topRow.current()));
            currentList.add(Plant.getPlant(topRow.next()));
            currentList.add(Plant.getPlant(bottomRow.current()));
            currentList.add(Plant.getPlant(bottomRow.next()));
            childPlants.add(currentList);
        } while(topRow.next() != StringCharacterIterator.DONE && bottomRow.next() != StringCharacterIterator.DONE);
    }

    List<Plant> getPlantsOfStudent(String student) {
        return childPlants.get(student.charAt(0) - 'A');
    }

}
