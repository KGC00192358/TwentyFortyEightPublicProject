package gameLogic;

import java.util.Comparator;

public class CompareIntAscending implements Comparator<Integer> {
        @Override
        public int compare(Integer a, Integer b) {
           return a - b;
        }

}
