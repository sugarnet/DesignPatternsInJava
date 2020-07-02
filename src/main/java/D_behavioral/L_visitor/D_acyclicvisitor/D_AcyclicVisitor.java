package D_behavioral.L_visitor.D_acyclicvisitor;

public class D_AcyclicVisitor {
    public static void main(String[] args) {
        AdditionExpression e = new AdditionExpression(
                new DoubleExpression(1),
                new AdditionExpression(
                        new DoubleExpression(2),
                        new DoubleExpression(3)));

        ExpressionPrinter ep = new ExpressionPrinter();
        ExpressionCalculator ec = new ExpressionCalculator();
        ep.visit(e);
        ec.visit(e);
        System.out.println(ep + " = " + ec.result);

    }
}

interface Visitor {

}

interface ExpressionVisitor extends Visitor {
    void visit(Expression e);
}

interface DoubleExpressionVisitor extends Visitor {
    void visit(DoubleExpression de);
}

interface AdditionExpressionVisitor extends Visitor {
    void visit(AdditionExpression ae);
}

abstract class Expression {
    public void accept(Visitor visitor) {
        if (visitor instanceof ExpressionVisitor) {
            ((ExpressionVisitor)visitor).visit(this);
        }
    }
}

class ExpressionCalculator implements AdditionExpressionVisitor, DoubleExpressionVisitor {

    public double result;

    @Override
    public void visit(DoubleExpression de) {
        result = de.value;
    }

    @Override
    public void visit(AdditionExpression ae) {

        ae.left.accept(this);
        double a = result;
        ae.right.accept(this);
        double b = result;
        result = a + b;
    }
}


class ExpressionPrinter implements DoubleExpressionVisitor, AdditionExpressionVisitor {

    private StringBuilder sb = new StringBuilder();

    @Override
    public void visit(DoubleExpression de) {
        sb.append(de.value);
    }

    @Override
    public void visit(AdditionExpression ae) {
        sb.append("(");
        ae.left.accept(this);
        sb.append("+");
        ae.right.accept(this);
        sb.append(")");
    }

    @Override
    public String toString() {
        return sb.toString();
    }
}

class DoubleExpression extends Expression {
    public double value;

    public DoubleExpression(double value) {
        this.value = value;
    }

    @Override
    public void accept(Visitor visitor) {
        if (visitor instanceof DoubleExpressionVisitor) {
            ((DoubleExpressionVisitor)visitor).visit(this);
        }
    }
}

class AdditionExpression extends Expression {
    public Expression left, right;

    public AdditionExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public void accept(Visitor visitor) {
        if (visitor instanceof AdditionExpressionVisitor) {
            ((AdditionExpressionVisitor)visitor).visit(this);
        }
    }
}