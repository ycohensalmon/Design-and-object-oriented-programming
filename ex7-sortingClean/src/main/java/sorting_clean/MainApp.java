package sorting_clean;

import jakarta.enterprise.inject.Produces;
import jakarta.inject.Named;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import java.util.Random;

public class MainApp {

    // not in the main for using in the producer
    private static WeldContainer container = new Weld().initialize();

    public static void main(String[] args) {

        AlgorithmRunner algorithmRunner = container.select(AlgorithmRunner.class).get();

        algorithmRunner.runAlgorithms();
    }

    @Produces
    public static @Named("sorting_clean.BubbleSort") BubbleSort getBubbleSort() {
        return container.select(BubbleSort.class).get();
    }

    @Produces
    public static @Named("sorting_clean.InsertionSort") InsertionSort getInsertionSort() {
        return container.select(InsertionSort.class).get();
    }

    @Produces
    public static @Named("sorting_clean.QuickSort") QuickSort getQuickSort() {
        return container.select(QuickSort.class).get();
    }

    @Produces
    public static @Named("sorting_clean.MergeSort") MergeSort getMergeSort() {
        return container.select(MergeSort.class).get();
    }

    @Produces
    public @Named("Size") int getSize() {
        return 10_000;
    }


    // SRP principle
    @Produces
    private @Named("Random")
    static SortingAlgorithm<Integer> makeRandomSortingAlgorithm() {
        Random random = new Random(System.currentTimeMillis());
        SortingAlgorithm<Integer> sortAlg = null;
        switch (random.nextInt(4)) {
            case 0:
                sortAlg = getQuickSort();
                break;
            case 1:
                sortAlg = getMergeSort();
                break;
            case 2:
                sortAlg = getBubbleSort();
                break;
            case 3:
                sortAlg = getInsertionSort();
        }
        return sortAlg;
    }
}