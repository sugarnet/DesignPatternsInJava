package D_behavioral.I_state.D_exercise;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise {
    public static void main(String[] args) {
        CombinationLock cl = new CombinationLock(new int[]{1, 2, 3, 4});
        Assert.assertEquals("LOCKED", cl.status);
        cl.enterDigit(1);
        Assert.assertEquals("1", cl.status);
        cl.enterDigit(2);
        Assert.assertEquals("12", cl.status);
        cl.enterDigit(3);
        Assert.assertEquals("123", cl.status);
        cl.enterDigit(4);
        Assert.assertEquals("OPEN", cl.status);
    }
}

class CombinationLock {
    private int [] combination;
    private List<String> buffer;
    public String status;


    public CombinationLock(int[] combination)    {
        this.combination = combination;
        this.buffer = new ArrayList<>();
        status = Status.LOCKED.name();
    }

    public void enterDigit(int digit)
    {
        buffer.add(String.valueOf(digit));
        for (int i = 0; i < buffer.size(); i++) {
            if (Integer.parseInt(buffer.get(i)) != combination[i]) {
                status = Status.ERROR.name();
            } else if (Integer.parseInt(buffer.get(i)) == combination[i]
                    && buffer.size() < combination.length) {
                status = buffer.stream().collect(Collectors.joining());
            } else {
                status = Status.OPEN.name();
            }
        }
    }
}

enum Status {
    OPEN, ERROR, LOCKED
}