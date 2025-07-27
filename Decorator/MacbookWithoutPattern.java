public class MacbookWithoutPattern {

    RAM ram;
    CHIP chip;
    int baseCost = 100_0;

    MacbookWithoutPattern(RAM ram, CHIP chip) {
        this.chip = chip;
        this.ram = ram;
    }

    int getCost() {
        int cost = baseCost;
        switch (ram) {
            case RAM.GB_16:
                cost += 10;
                break;
            case RAM.GB_32:
                cost += 100;
                break;
            case RAM.GB_8:
                cost += 1;
                break;
        }
        switch (chip) {
            case CHIP.M1:
                cost += 10;
                break;
            case CHIP.M2:
                cost += 100;
                break;
            case CHIP.M3:
                cost += 1000;
                break;
            case CHIP.M4:
                cost += 10000;
                break;
            case Intel:
                cost += 0;
                break;
        }
        return cost;
    }

    public static void main(String[] args) {
        MacbookWithoutPattern macbookWithoutPattern = new MacbookWithoutPattern(
            RAM.GB_32,
            CHIP.M1
        );
        System.out.println(macbookWithoutPattern.getCost());
    }
}

enum RAM {
    GB_8,
    GB_16,
    GB_32,
}

enum CHIP {
    M1,
    M2,
    M3,
    M4,
    Intel,
}
