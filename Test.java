public class Test {
    private static String[] sides = new String[3];
    public static void main(String[] args) {
        setSides("1", "2", "3");
        assertTriangle(Triangle.triangle(sides), Type.SCALENE);

        setSides("1", "1", "3");
        assertTriangle(Triangle.triangle(sides), Type.ISOSCELES);

        setSides("1", "1", "1");
        assertTriangle(Triangle.triangle(sides), Type.EQUILATERAL);

        setSides("1.0", "0.1", "1");
        assertTriangle(Triangle.triangle(sides), Type.ISOSCELES);

        setSides(".100", "0.1", "0");
        assertTriangle(Triangle.triangle(sides), Type.ISOSCELES);

        setSides("001", "1", "1.0000");
        assertTriangle(Triangle.triangle(sides), Type.EQUILATERAL);

        setSides("0.1", "0.10000000000000000000000000000000000000000001", "0.1000000000000000001");
        assertTriangle(Triangle.triangle(sides), Type.SCALENE);

        setSides("0.001", ".001", "0000.001");
        assertTriangle(Triangle.triangle(sides), Type.EQUILATERAL);
    }

    private static void assertTriangle(Type t1, Type t2) {
        if (t1 == t2) {
            System.out.println("Test OK");
        } else {
            System.out.println("Test FAIL");
        }
    }

    public static void setSides(String s1, String s2, String s3) {
        Test.sides[0] = s1;
        Test.sides[1] = s2;
        Test.sides[2] = s3;
    }
}