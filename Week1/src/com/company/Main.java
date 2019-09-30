package com.company;

import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static final void main(String... args) throws Exception{
        Main prng = new Main();
        prng.zeroToUpperBound(5000);
        Thread.sleep(4000);
        log("Done.");
    }

    /** The upper bound is excluded. */
    void zeroToUpperBound(long upper){
        log("Generating " + MAX + " random integers in the range 0.." + (upper-1));
        //a single object is reused here
        ThreadLocalRandom generator = ThreadLocalRandom.current();
        for (int idx = 1; idx <= MAX; ++idx){
            long random = generator.nextLong(upper);
            log(INDENT + random);
        }
    }

    /** The lower bound is included, but the upper bound is excluded. */
    void range(long lower, long upper){
        log(
                "Generating " + MAX + " random integers in the range " +
                        lower + ".." + (upper-1)
        );
        //note the static factory method for getting an object; there's no constructor,
        //and there's no need to pass a seed
        ThreadLocalRandom generator = ThreadLocalRandom.current();
        for (int idx = 1; idx <= MAX; ++idx){
            long random = generator.nextLong(lower, upper);
            log(INDENT + random);
        }
    }

    void gaussian(double mean, double variance){
        log("Generating " + MAX + " random doubles in a gaussian distribution.");
        log("Mean: " + mean + " Variance:" + variance);
        ThreadLocalRandom generator = ThreadLocalRandom.current();
        for (int idx = 1; idx <= MAX; ++idx){
            double random = mean + generator.nextGaussian() * variance;
            log(INDENT + random);
        }
    }

    //PRIVATE
    private static final int MAX = 10;
    private static final String INDENT = "  ";

    private static void log(String aMessage){
        System.out.println(aMessage);
    }
}
