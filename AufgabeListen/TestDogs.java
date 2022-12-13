import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class TestDogs {

    static String[] names = {
            "Shakespeare",
            "Shaki",
            "Shakira",
            "Shakka",
            "Shakur",
            "Shaky",
            "Shakyra",
            "Shalimar",
            "Shally",
            "Shaman",
            "Shamira",
            "Shan",
            "Shana",
            "Shandor",
            "Shandra",
            "Shandy",
            "Shane",
            "Shani",
            "Shania",
            "Shanna",
            "Shannah",
            "Shannen",
            "Shannon",
            "Shanny",
            "Shanon",
            "Shanti",
            "Shanty",
            "Shany",
            "Shara",
            "Sharan",
            "Sharek",
            "Shari",
            "Sharie",
            "Sharif"
    };

    public static void main(String[] args) {
        ArrayList<Dog> dogList = generateDogList();
        //Aufgabe1
        System.out.print(dogList);
        System.out.println("\n--------------------");

        //Aufgabe2
        ArrayList<Dog> olderDogs = filterYoungDogs(dogList);
        System.out.print(olderDogs.toString());
        System.out.println("\n--------------------");

        //Aufgabe3
        ArrayList<Dog> youngDogs = collectYoungDogs(dogList);
        System.out.print(youngDogs);
        System.out.println("\n--------------------");

        //Aufgabe4
        ArrayList<Dog> allDogs = combineLists(olderDogs, youngDogs);
        System.out.print(countBarkingDogs(allDogs));
        System.out.println("\n--------------------");

    }

    public static ArrayList<Dog> generateDogList() {
        ArrayList<Dog> result = new ArrayList<Dog>();

        for (int i = 0; i < ThreadLocalRandom.current().nextInt(20, 30); i++) {
            Dog tmp = new Dog(TestDogs.names[ThreadLocalRandom.current().nextInt(0, names.length)], i % 2 == 0, ThreadLocalRandom.current().nextInt(0, 12), Math.random() > 0.5);
            result.add(tmp);
        }

        return result;
    }

    public static ArrayList<Dog> filterYoungDogs(ArrayList<Dog> inputList) {
        ArrayList<Dog> result = inputList;

        for (int i = 0; i < result.size(); i++) {
            if (result.get(i).age < 1) {
                result.remove(i);
                i--;
            }
        }

        return result;
    }

    public static ArrayList<Dog> collectYoungDogs(ArrayList<Dog> inputList) {
        ArrayList<Dog> result = new ArrayList<Dog>();

        for (Dog dog : inputList) {
            if (dog.age < 2) {
                result.add(dog);
            }
        }

        return result;
    }

    public static int countBarkingDogs(ArrayList<Dog> inputList) {
        int result = 0;

        for (Dog dog : inputList) {
            if (dog.isBarking) {
                result++;
            }
        }
        return result;
    }

    public static ArrayList<Dog> combineLists(ArrayList<Dog> inputListOne, ArrayList<Dog> inputListTwo) {
        ArrayList<Dog> result = new ArrayList<Dog>();

        result.addAll(inputListOne);
        result.addAll(inputListTwo);

        return result;
    }

    public static String[] getNames() {
        return names;
    }
}