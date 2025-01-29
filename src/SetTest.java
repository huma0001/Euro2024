import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTest {

    public static void main(String[] args) {
        Set<String> mySet = new HashSet<>();

        mySet.add("Charlie");
        mySet.add("Peter");
        mySet.add("Hussain");

        //Setting up the iterator?
        Iterator<String> iterator = mySet.iterator();


        //Iterating through my set
        while (iterator.hasNext()){
            String element = iterator.next();
            System.out.println(element);

        }


        Set<Integer> integersSet = new HashSet<>();

        integersSet.add(4);
        integersSet.add(1);
        integersSet.add(94);
        integersSet.add(55);

        Iterator<Integer> iterator1 = integersSet.iterator();


        while(iterator1.hasNext()){
            int currentNumber = iterator1.next();
            System.out.println(currentNumber);
        }

    }
}
