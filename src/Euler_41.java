import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.common.collect.Collections2;
import com.google.common.collect.Sets;
import org.apache.commons.math3.util.ArithmeticUtils;

/**
 * Created by kapturma@25/03/14.
 */
public class Euler_41 extends EulerRunner {

    private static boolean[] primes = new boolean[7654322];
    // to inefficient !!!
    public static void main(String[] args) {
        new Euler_41().execute();
    }

    @Override
    protected String run() {
        List<String> numbersWithNoDuplicatedDigits = (List<String>) words(asList("7654321")); // too many elements to check !!!
        fillSieve();
        return numbersWithNoDuplicatedDigits.stream()
                .filter(Euler_41::isPandigital)
                .map(Integer::valueOf)
                .filter(n -> isPrime((int) n))
                .max((o1, o2) -> ((Integer)o1).compareTo((Integer)o2)).toString();
    }

    //set up the primesieve
    public static void fillSieve() {
        Arrays.fill(primes, true);        // assume all integers are prime.
        primes[0] = primes[1] = false;       // we know 0 and 1 are not prime.
        for (int i = 2; i < primes.length; i++) {
            //if the number is prime,
            //then go through all its multiples and make their values false.
            if (primes[i]) {
                for (int j = 2; i * j < primes.length; j++) {
                    primes[i * j] = false;
                }
            }
        }
    }

    public static boolean isPandigital(String n) {
        for (int k = 1; k <= n.length(); k++) {
            if (!n.contains(Integer.toString(k))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrime(int n) {
        return primes[n]; //simple, huh?
    }

    public static Collection<String> words(final List<Character> tiles) {
        if ((tiles == null) || (tiles.size() > 10))
            return Collections.emptyList();
        final List<String> allWords = new ArrayList<String>(getExpectedMaximumOutputSize(tiles.size()));
        final Set<Integer> checkedSubsets = new HashSet<Integer>();
        for (Set<Tile> subset : Sets.powerSet(getDistinguishableTiles(tiles))) {
            final List<Tile> subsetRepresentation = new ArrayList<Tile>();
            subsetRepresentation.addAll(subset);
            Collections.sort(subsetRepresentation);
            if (checkedSubsets.add(subsetRepresentation.hashCode())) {
                final Set<Integer> checkedPermutations = new HashSet<Integer>();
                for (List<Tile> permutation : Collections2.permutations(subset)) {
                    if (checkedPermutations.add(permutation.hashCode())) {
                        final StringBuilder wordBuilder = new StringBuilder(subset.size());
                        for (Tile tile : permutation) {
                            wordBuilder.append(tile.character);
                        }
                        allWords.add(wordBuilder.toString());
                    }
                }
            }
        }
        allWords.remove("");
        return allWords;
    }

    /**
     * Helper method to obtain the maximal output list size that is needed to avoid copying when dynamically resizing
     *
     * @param n input set size
     * @return maximal output size needed
     */
    public static int getExpectedMaximumOutputSize(int n) {
        int expectedOutputSize = 0;
        // number of elements = \sum_{k=0}^n (n over k)*k!
        for (int k = 0; k <= n; k++) {
            expectedOutputSize += ArithmeticUtils.binomialCoefficient(n, k) * ArithmeticUtils.factorial(k);
        }
        return expectedOutputSize;
    }

    private static Set<Tile> getDistinguishableTiles(List<Character> tiles) {
        final Set<Tile> distinguishableTiles = new HashSet<Tile>();
        int id = 0;
        for (Character tile : tiles) {
            distinguishableTiles.add(new Tile(tile, id++));
        }
        return distinguishableTiles;
    }

    private static class Tile implements Comparable<Tile> {
        private final Character character;
        private final int id;

        private Tile(Character character, int id) {
            this.character = character;
            this.id = id;
        }

        @Override
        public int hashCode() {
            return this.character.hashCode();
        }

        @Override
        public boolean equals(Object o) {
            return (o instanceof Tile) && (this.id == ((Tile) o).id);
        }

        @Override
        public int compareTo(Tile o) {
            return this.character.compareTo(o.character);
        }

    }

    private static List<Character> asList(String input) {
        List<Character> inputList = new ArrayList<Character>();
        for (char c : input.toCharArray()) {
            inputList.add(c);
        }
        return inputList;
    }


}
