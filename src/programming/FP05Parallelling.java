package programming;

import java.util.stream.LongStream;

public class FP05Parallelling {
    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        //499999999500000000
//        System.out.println(LongStream.range(0, 1000000000).sum());
        System.out.println(LongStream.range(0, 1000000000).parallel().sum());

        //820 - 513
        System.out.println(System.currentTimeMillis() - time);
    }
}
