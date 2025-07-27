public class MacbookWithDecoratorPattern {

    int getCost() {
        return 100;
    }

    public static void main(String[] args) {
        MacbookWithDecoratorPattern baseMacbook =
            new MacbookWithDecoratorPattern();
        System.out.println(baseMacbook.getCost());
        MacbookWithDecoratorPattern fireEmojiMacbook = new MacbookWithARam(
            new MacbookWithAStorage(new MacbookWithDecoratorPattern())
        );
        System.out.println(fireEmojiMacbook.getCost());
    }
}

class MacbookDecorator extends MacbookWithDecoratorPattern {

    MacbookWithDecoratorPattern baseMacbook;

    MacbookDecorator(MacbookWithDecoratorPattern baseMacbook) {
        this.baseMacbook = baseMacbook;
    }
}

class MacbookWithARam extends MacbookDecorator {

    MacbookWithARam(MacbookWithDecoratorPattern baseMacbook) {
        super(baseMacbook);
    }

    @Override
    int getCost() {
        return baseMacbook.getCost() + 10;
    }
}

class MacbookWithAStorage extends MacbookDecorator {

    MacbookWithAStorage(MacbookWithDecoratorPattern baseMacbook) {
        super(baseMacbook);
    }

    @Override
    int getCost() {
        return baseMacbook.getCost() + 100;
    }
}
