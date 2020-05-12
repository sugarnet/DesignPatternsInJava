package C_structural.C_composite;

import java.util.*;
import java.util.function.Consumer;

public class B_NeuralNetworks {
    public static void main(String[] args) {
        Neuron neuron1 = new Neuron();
        Neuron neuron2 = new Neuron();
        NeuronLayer layer1 = new NeuronLayer();
        NeuronLayer layer2 = new NeuronLayer();


        neuron1.connectTo(neuron2);
        neuron1.connectTo(layer1);
        layer1.connectTo(neuron1);
        layer1.connectTo(layer2);
    }
}

interface SomeNeurons extends Iterable<Neuron> {
    default void connectTo(SomeNeurons other) {
        if (this == other) return;

        for (Neuron from : this) {
            for (Neuron to : other) {
                from.out.add(to);
                to.in.add(from);
            }
        }
    }
}

class Neuron implements SomeNeurons {
    public List<Neuron> in, out;

    @Override
    public Iterator<Neuron> iterator() {
        return Collections.singleton(this).iterator();
    }

    @Override
    public void forEach(Consumer<? super Neuron> action) {
        action.accept(this);
    }

    @Override
    public Spliterator<Neuron> spliterator() {
        return Collections.singleton(this).spliterator();
    }

    /*
    public void connectTo(Neuron other) {
        out.add(other);
        other.in.add(this);
    }
    */
}

class NeuronLayer extends ArrayList<Neuron> implements SomeNeurons {

}
