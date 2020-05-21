package C_structural.G_proxy;

public class B_PropertyProxy {
    public static void main(String[] args) {
        Creature creature = new Creature();
        creature.setAgility(23);
    }
}

/*
We use Property Proxy when we need to do something like logging in the setter of a class.
SSo, we implement a class that allows us to do it but without dirtying the POJO class.
 */
class Property<T> {
    private T value;

    public Property(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        // do some logging here
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Property<?> property = (Property<?>) o;

        return value != null ? value.equals(property.value) : property.value == null;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }
}

class Creature {
    private Property<Integer> agility = new Property<>(10);

    public Integer getAgility() {
        return agility.getValue();
    }

    public void setAgility(Integer agility) {
        this.agility.setValue(agility);
    }
}
