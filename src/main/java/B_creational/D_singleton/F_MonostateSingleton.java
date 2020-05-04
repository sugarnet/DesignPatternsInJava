package B_creational.D_singleton;

/**
 * In this approach, in no moment we are communicating to user that is a singleton
 */
public class F_MonostateSingleton {
    public static void main(String[] args) {
        ChiefExecutiveOfficer ceo = new ChiefExecutiveOfficer();
        ceo.setName("Diego");
        ceo.setAge(37);

        ChiefExecutiveOfficer ceo2 = new ChiefExecutiveOfficer();
        System.out.println(ceo2);
    }
}

class ChiefExecutiveOfficer {
    private static String name;
    private static int age;

    public static String getName() {
        return name;
    }

    public void setName(String name) {
        ChiefExecutiveOfficer.name = name;
    }

    public static int getAge() {
        return age;
    }

    public void setAge(int age) {
        ChiefExecutiveOfficer.age = age;
    }

    @Override
    public String toString() {
        return "ChiefExecutiveOfficer{" +
                "name = " + name + "," +
                "age = " + age + "}";
    }
}
