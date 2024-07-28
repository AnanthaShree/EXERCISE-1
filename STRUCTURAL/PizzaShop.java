// PizzaShop.java
public interface Pizza {
    String getDescription();
    double getCost();
}

class PlainPizza implements Pizza {

    @Override
    public String getDescription() {
        return "Plain Pizza";
    }

    @Override
    public double getCost() {
        return 4.0;
    }
}

abstract class PizzaDecorator implements Pizza {
    protected Pizza decoratedPizza;

    public PizzaDecorator(Pizza pizza) {
        this.decoratedPizza = pizza;
    }

    @Override
    public String getDescription() {
        return decoratedPizza.getDescription();
    }

    @Override
    public double getCost() {
        return decoratedPizza.getCost();
    }
}

class CheeseDecorator extends PizzaDecorator {

    public CheeseDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return decoratedPizza.getDescription() + ", Cheese";
    }

    @Override
    public double getCost() {
        return decoratedPizza.getCost() + 1.0;
    }
}

class PepperoniDecorator extends PizzaDecorator {

    public PepperoniDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return decoratedPizza.getDescription() + ", Pepperoni";
    }

    @Override
    public double getCost() {
        return decoratedPizza.getCost() + 1.5;
    }
}

class OlivesDecorator extends PizzaDecorator {

    public OlivesDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return decoratedPizza.getDescription() + ", Olives";
    }

    @Override
    public double getCost() {
        return decoratedPizza.getCost() + 0.75;
    }
}

public class PizzaShop {
    public static void main(String[] args) {
        Pizza plainPizza = new PlainPizza();
        System.out.println(plainPizza.getDescription() + " $" + plainPizza.getCost());

        Pizza cheesePizza = new CheeseDecorator(new PlainPizza());
        System.out.println(cheesePizza.getDescription() + " $" + cheesePizza.getCost());

        Pizza pepperoniPizza = new PepperoniDecorator(new PlainPizza());
        System.out.println(pepperoniPizza.getDescription() + " $" + pepperoniPizza.getCost());

        Pizza fullyLoadedPizza = new OlivesDecorator(new PepperoniDecorator(new CheeseDecorator(new PlainPizza())));
        System.out.println(fullyLoadedPizza.getDescription() + " $" + fullyLoadedPizza.getCost());
    }
}

