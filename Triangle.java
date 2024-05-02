import java.util.Set;
import java.util.HashSet;

enum Type {
    EQUILATERAL,
    ISOSCELES,
    SCALENE,
    UNDEFINED
}

public class Triangle {

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("usage: <side 1> <side 2> <side 3>");
            return;
        }
        
        switch (triangle(args)) {
            case EQUILATERAL:
                System.out.println("Triangle is equilateral!");
                break;
            case ISOSCELES:
                System.out.println("Triangle is isoceles!");
                break;
            case SCALENE:
                System.out.println("Triangle is scalene!");
                break;
            default:
                System.out.println("Could not detect triangle type");
                break;
        }
    }

    public static Type triangle(String[] sides) {

        Set<BigDec> unique = new HashSet<>();
        // Parse the sides, and check for parsing errors.
        for (String side : sides) {
            try {
                unique.add(BigDec.parse(side));
            } catch (NumberFormatException e) {
                System.out.println("Side " + side + " is not a number!");
                return Type.UNDEFINED;
            }
        }
        
        // The length of the set will be unique sides
        switch (unique.size()) {
            case 1:
                return Type.EQUILATERAL;
            case 2:
                return Type.ISOSCELES;
            case 3:
                return Type.SCALENE;
            default:
                return Type.UNDEFINED;
        }
    }
}
