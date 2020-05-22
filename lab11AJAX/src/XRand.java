import java.util.Random;
import java.util.stream.IntStream;

public class XRand {
    private int n;
    private Random random;

    public XRand(int n) {
        random = new Random();
        this.n = n;
    }

    public IntStream get() {
        return IntStream.range(0, n)
                .map(x -> random.nextInt(n));
    }
}
