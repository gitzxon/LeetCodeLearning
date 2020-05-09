package study.DesignPattern.visitior;

interface Visitor {
    void visit(Wheel wheel);

    void visit(Engine engine);

    void visit(Body body);

    void visit(Car car);
}

class Wheel {
    private String name;

    Wheel(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }

    void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class Engine {
    void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class Body {
    void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class Car {
    private Engine engine = new Engine();
    private Body body = new Body();
    private Wheel[] wheels
            = {new Wheel("front left"), new Wheel("front right"),
            new Wheel("back left"), new Wheel("back right")};

    void accept(Visitor visitor) {
        visitor.visit(this);
        visitor.visit(engine);
        visitor.visit(body);
//        engine.accept(visitor);
//        body.accept(visitor);
        for (Wheel wheel : wheels) {
//            wheel.accept(visitor);
            visitor.visit(wheel);
        }
    }
}

class PrintVisitor implements Visitor {
    public void visit(Wheel wheel) {
        System.out.println("Visiting " + wheel.getName()
                + " wheel");
    }

    public void visit(Engine engine) {
        System.out.println("Visiting engine");
    }

    public void visit(Body body) {
        System.out.println("Visiting body");
    }

    public void visit(Car car) {
        System.out.println("Visiting car");
    }
}

public class VisitorDemo {
    static public void main(String[] args) {
        Car car = new Car();
        Visitor visitor = new PrintVisitor();
        car.accept(visitor);
    }
}