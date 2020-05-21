package C_structural.F_flyweight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class A_RepeatingUserNames {
    public static void main(String[] args) {
        User user1 = new User("Ben Smith");
        User user2 = new User("Jane Smith");

        UserX user3 = new UserX("Jane Smith");
        UserX user4 = new UserX("Jane Smith");

    }
}

class UserX {
    static List<String> strings = new ArrayList<>();
    private int[] names;

    public UserX(String fullName) {
        Function<String, Integer> getOrAdd = (String s) -> {
            int idx = strings.indexOf(s);

            if (idx != -1) return idx;
            else {
                strings.add(s);
                return strings.size()-1;
            }
        };

        names = Arrays.stream(fullName.split(" "))
                .mapToInt(getOrAdd::apply)
                .toArray();
    }
}

class User {
    private String fullName;

    public User(String fullName) {
        this.fullName = fullName;
    }
}
