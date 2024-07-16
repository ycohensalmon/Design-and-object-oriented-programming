package sorting_clean;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.HashMap;
import java.util.Map;

public aspect Logging {

    @Pointcut("execution(* *.*.sort(..))")
    private void selectSort(){}

    @Pointcut("execution(* *.*.runAlgorithms(..))")
    private void runAlgorithms(){}

    static Map<String, Integer> counter = new HashMap<String, Integer>(){{
        put("sorting_clean.BubbleSort", 0);
        put("sorting_clean.InsertionSort", 0);
        put("sorting_clean.MergeSort", 0);
        put("sorting_clean.QuickSort", 0);
    }};

    long startTime;
    @Before("selectSort()")
    public void beforeSort(JoinPoint jp){
        // calculate the beginning of the function
        startTime = System.currentTimeMillis();

        String nameClass = jp.getThis().toString().substring(jp.getThis().toString().lastIndexOf('.') + 1, jp.getThis().toString().indexOf('@'));

        // calculate the num of times that the function was running
        counter.put(nameClass ,counter.get(nameClass) + 1);
    }

    // Create a new dictionary
    static Map<String, Long> elapsedTime = new HashMap<String, Long>(){{
        put("sorting_clean.BubbleSort", 0L);
        put("sorting_clean.InsertionSort", 0L);
        put("sorting_clean.MergeSort", 0L);
        put("sorting_clean.QuickSort", 0L);
    }};

    @After("selectSort()")
    public void afterSort(JoinPoint jp){
        String nameClass = jp.getThis().toString().substring(jp.getThis().toString().lastIndexOf('.') + 1, jp.getThis().toString().indexOf('@'));
        elapsedTime.put(nameClass ,elapsedTime.get(nameClass) + System.currentTimeMillis() - startTime);
    }

    @After("runAlgorithms()")
    public void runAlgorithms(JoinPoint jp) {
        // Sum all the values in the dictionary
        long sum = 0;
        for (long value : elapsedTime.values()) {
            sum += value;
        }
        System.out.println("Total time of running all sort functions was " + sum + " ms\n");
        System.out.println("In detail:");

        // Get all the keys in the dictionary
        for (String key : elapsedTime.keySet()) {
            if (elapsedTime.get(key) != 0)
                System.out.println("Function sort in " + key + " ran " + counter.get(key) + " times and took in total " + elapsedTime.get(key) + " ms\n");
        }


    }
}