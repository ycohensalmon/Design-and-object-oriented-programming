package sorting_clean;

import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.Random;

public class AlgorithmRunner {
    // OCP principle - no dependency with changing
    // DIP principle - dependency just in interface
    @Inject
    private @Named("sorting_clean.QuickSort") SortingAlgorithm<Integer> quadraticAlgorithm;

    @Inject
    private @Named("sorting_clean.InsertionSort") SortingAlgorithm<Integer> nlognAlgorithm;

    @Inject
    private @Named("Random") SortingAlgorithm<Integer> randomAlgorithm1;

    @Inject
    private @Named("Random") SortingAlgorithm<Integer> randomAlgorithm2;
    @Inject
    private @Named("Size") int numberOfElements;

    public void runAlgorithms(){
        Random rand = new Random();
        Integer[] ints = rand.ints(1,Integer.MAX_VALUE)
                .distinct()
                .limit(numberOfElements)
                .boxed()
                .toArray(Integer[]::new);
        Integer[] intsClone = ints.clone();
        quadraticAlgorithm.sort(intsClone);
        intsClone = ints.clone();
        nlognAlgorithm.sort(intsClone);
        intsClone = ints.clone();
        randomAlgorithm1.sort(intsClone);
        intsClone = ints.clone();
        randomAlgorithm2.sort(intsClone);
    }
}
