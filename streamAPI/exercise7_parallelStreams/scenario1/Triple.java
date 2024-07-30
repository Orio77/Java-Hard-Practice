package streamAPI.exercise7_parallelStreams.scenario1;

public class Triple<S1, S2, S3> {
    private S1 one;
    private S2 two;
    private S3 three;


    public Triple(S1 element1, S2 element2, S3 element3) {
        one = element1;
        two = element2;
        three = element3;
    }

    public S1 getOne() {
        return one;
    }
    public S3 getThree() {
        return three;
    }
    public S2 getTwo() {
        return two;
    }

    // AI Copied
    public static <S1, S2, S3> Triple<S1, S2, S3> of(S1 one, S2 two, S3 three) {
        return new Triple<S1,S2,S3>(one, two, three);
    }
}
