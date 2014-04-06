import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Created by kapturma@05/04/14.
 */
public class Euler_18 extends EulerRunner {

    public static void main(String[] args) {
        new Euler_18().execute();
    }

    // see Euler_67 for fully functional implementation
    @Override
    protected String run() {
        File file = new File("src/resources/Euler18.txt");
        // File file = new File("src/resources/Euler67.txt");
        ArrayList<Integer[]> list = null;
        try {
            BufferedReader rdr = new BufferedReader(new FileReader(file));
            list = (ArrayList<Integer[]>) rdr.lines()
                    .map(line -> line.split(" "))
                    .map(numberStrings -> {
                        Integer[] numbers = new Integer[numberStrings.length];
                        for (int iter = 0; iter < numbers.length; iter++) {
                            numbers[iter] = Integer.parseInt(numberStrings[iter]);
                        }
                        return numbers;
                    })
                    .collect(Collectors.toCollection((Supplier<Collection<Integer[]>>) ArrayList::new));
            int rowIter = list.size() - 2;
            while (rowIter >= 0) {
                for (int columnIter = 0; columnIter < list.get(rowIter).length; columnIter++) {
                    Integer leftSon = list.get(rowIter + 1)[columnIter];
                    Integer rightSon = list.get(rowIter + 1)[columnIter + 1];
                    if (leftSon > rightSon) {
                        list.get(rowIter)[columnIter] += leftSon;
                    } else {
                        list.get(rowIter)[columnIter] += rightSon;
                    }
                }
                rowIter--;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return String.valueOf(list.get(0)[0]);
    }

}
