import java.util.List;
import java.util.ArrayList;
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

        List<Double> sides = new ArrayList<>();
        
        for (String s : args) {
            try {
                sides.add(Double.parseDouble(s));
            } catch (Exception e) {
                System.out.println("Could not parse side " + s);
                return;
            }
        }
        
        switch (triangle(sides)) {
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

    public static Type triangle(List<Double> sides) {

        Set<Double> unique = new HashSet<>(sides);

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
