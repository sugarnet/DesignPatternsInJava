package B_creational.C_prototype;

import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;

public class C_CopyThroughSerialization {
    public static void main(String[] args) {
        Foo foo1 = new Foo(32, "Florero");
        Foo foo2 = SerializationUtils.roundtrip(foo1);

        foo2.whatever = "centro de mesa";

        System.out.println(foo1);
        System.out.println(foo2);
    }
}

// some libraries use reflection (no need for Serializable)
class Foo implements Serializable {
    public int stuff;
    public String whatever;

    public Foo(int stuff, String whatever) {
        this.stuff = stuff;
        this.whatever = whatever;
    }

    @Override
    public String toString() {
        return "Foo{" +
                "stuff=" + stuff +
                ", whatever='" + whatever + '\'' +
                '}';
    }
}
