import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Optional;

/**
 * Created by kapturma@05/04/14.
 */
public class Euler_67 extends EulerRunner {

    public static void main(String[] args) {
        new Euler_67().execute();
    }

    @Override
    protected String run() {
        //File file = new File("src/resources/Euler18.txt");
        File file = new File("src/resources/Euler67.txt");
        Optional<Integer[]> list = null;
        try {
            list = new BufferedReader(new FileReader(file))
                    .lines()
                    .map(line -> line.split(" "))
                    .map(numberStrings -> {
                        Integer[] numbers = new Integer[numberStrings.length];
                        for (int iter = 0; iter < numbers.length; iter++) {
                            numbers[iter] = Integer.parseInt(numberStrings[iter]);
                        }
                        return numbers;
                    })
                    .sorted((row, anotherRow) -> -Integer.valueOf(row.length).compareTo(anotherRow.length)) // reverse order for easier reduction
                    .reduce((currRow, nextRow) -> {
                        for (int iter = 0; iter < nextRow.length; iter++) {
                            if (currRow[iter] > currRow[iter + 1])
                                nextRow[iter] += currRow[iter];
                            else
                                nextRow[iter] += currRow[iter + 1];
                        }
                        return nextRow;
                    });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return String.valueOf(list.get()[0]);
    }

}
