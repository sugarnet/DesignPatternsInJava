/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solid;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class OpenClosedPrinciple {
    public static void main(String[] args) {
        Product apple = new Product("Apple", Color.RED, Size.SMALL);
        Product house = new Product("House", Color.GREEN, Size.LARGE);
        Product tree = new Product("Tree", Color.GREEN, Size.LARGE);
        Product warm = new Product("Warm", Color.GREEN, Size.SMALL);
        
        List<Product> products = Arrays.asList(apple, house, tree, warm);
        
        System.out.println("FilterProduct (old):");
        ProductFilter pf = new ProductFilter();
        
        pf.filterByColor(products, Color.GREEN)
                .forEach(p -> System.out.println(p.name + " is green"));
        
        System.out.println("");
        System.out.println("FilterProduct (new):");
        BetterFilter bf = new BetterFilter();
        
        bf.filter(products, new ColorSpecification(Color.GREEN))
                .forEach(p -> System.out.println(p.name + " is green"));
        
        System.out.println("");
        System.out.println("FilterProduct by color and size (new):");
        bf.filter(products, new AndSpecification<>(
                new ColorSpecification(Color.GREEN), 
                new SizeSpecification(Size.SMALL)))
                .forEach(p -> System.out.println(p.name + " is green and small"));
    }
}

enum Color {
    RED, BLUE, GREEN
}

enum Size {
    SMALL, MEDIUM, LARGE, YUGE
}

class Product {
    public String name;
    public Color color;
    public Size size;

    public Product(String name, Color color, Size size) {
        this.name = name;
        this.color = color;
        this.size = size;
    }
    
    
}

interface Specification<T> {
    boolean isSatisfied(T item);
}

interface Filter<T> {
    Stream<T> filter(List<T> items, Specification<T> spec);
}

class AndSpecification<T> implements Specification<T> {
    
    Specification<T> left, right;

    public AndSpecification(Specification<T> left, Specification<T> right) {
        this.left = left;
        this.right = right;
    }
    
    @Override
    public boolean isSatisfied(T item) {
        return left.isSatisfied(item) && right.isSatisfied(item);
    }
    
}

class ColorSpecification implements Specification<Product> {
    
    private final Color color;

    public ColorSpecification(Color color) {
        this.color = color;
    }
    
    @Override
    public boolean isSatisfied(Product item) {
        return this.color == item.color;
    }
    
}

class SizeSpecification implements Specification<Product> {
    
    private final Size size;

    public SizeSpecification(Size size) {
        this.size = size;
    }
    
    @Override
    public boolean isSatisfied(Product item) {
        return this.size == item.size;
    }
    
}

class BetterFilter implements Filter<Product> {

    @Override
    public Stream<Product> filter(List<Product> items, 
            Specification<Product> spec) {
        return items.stream().filter(p -> spec.isSatisfied(p));
    }
    
}

class ProductFilter {
    public Stream<Product> filterByColor(List<Product> products, Color color) {
        return products.stream().filter(p -> p.color == color);
    }
    
    public Stream<Product> filterBySize(List<Product> products, Size size) {
        return products.stream().filter(p -> p.size == size);
    }
    
    public Stream<Product> filterByColorAndSize(List<Product> products,
            Color color, Size size) {
        return products.stream()
                .filter(p -> p.color == color && p.size == size);
    }
}
