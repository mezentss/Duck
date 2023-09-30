interface FlyBehavior {
    void fly();
}

interface QuackBehavior {
    void quack();
}

class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("Я летаю на крыльях");
    }
}

class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("Я не летаю");
    }
}

class QuackLoud implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Я крякаю громко");
    }
}

class QuackSilent implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Я не крякаю");
    }
}

class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public Duck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
        this.flyBehavior = flyBehavior;
        this.quackBehavior = quackBehavior;
    }

    void performFly() {
        flyBehavior.fly();
    }

    void performQuack() {
        quackBehavior.quack();
    }
}

class RubberDuck extends Duck {
    public RubberDuck() {
        super(new FlyNoWay(), new QuackSilent());
    }
}

class DecoyDuck extends Duck {
    DecoyDuck() {
        super(new FlyNoWay(), new QuackSilent());
    }

    void flyRemoteControlled() {
        System.out.println("Я летаю на радиоуправлении");
    }
}

class MallardDuck extends Duck {
    MallardDuck() {
        super(new FlyWithWings(), new QuackLoud());
    }
}

class AlbinosDuck extends Duck {
    public AlbinosDuck() {
        super(new FlyWithWings(), new QuackSilent());
    }

    void flyRemoteControlled() {
        System.out.println("Я летаю на радиоуправлении");
    }
}

public class DuckSimulation {
    public static void main(String[] args) {
        System.out.println("Симуляция уток:");

        Duck saxonDuck = new Duck(new FlyWithWings(), new QuackLoud());
        System.out.println("Саксонская утка");
        saxonDuck.performQuack();
        saxonDuck.performFly();

        System.out.println();

        RubberDuck rubberDuck = new RubberDuck();
        System.out.println("Резиновая утка");
        rubberDuck.performQuack();
        rubberDuck.performFly();

        System.out.println();

        DecoyDuck decoyDuck = new DecoyDuck();
        System.out.println("Утка-приманка");
        decoyDuck.performQuack();
        decoyDuck.performFly();
        decoyDuck.flyRemoteControlled();

        System.out.println();

        MallardDuck mallardDuck = new MallardDuck();
        System.out.println("Красноголовая утка");
        mallardDuck.performQuack();
        mallardDuck.performFly();

        System.out.println();

        AlbinosDuck albinosDuck = new AlbinosDuck();
        System.out.println("Утка альбинос");
        albinosDuck.performQuack();
        albinosDuck.performFly();
        albinosDuck.flyRemoteControlled();
    }
}