public class BigDec {
    String exp,frac;
    
    private BigDec(String exp, String frac) {
        this.exp = exp;
        this.frac = frac;
    }

    public static BigDec parse(String str) throws NumberFormatException {
        // Check if numeric
        Double.parseDouble(str);

        // Split exponent and fractional part 
        String[] comp = str.split("\\.", 2);

        // Remove leading zeroes in exponent
        comp[0] = comp[0].replaceAll("^0+","");

        // If there is a fractional part, remove trailing zeroes, otherwise represent it as empty string
        if (comp.length == 2) {
            comp[1] = comp[1].replaceAll("0+$", "");
            return new BigDec(comp[0], comp[1]);
        }
        else {
            return new BigDec(comp[0], "");
        }
    }

    @Override
    public final int hashCode() {
        return (this.exp + "." + this.frac).hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof BigDec)) {
            return false;
        }
        BigDec other = (BigDec) o;

        return this.exp.equals(other.exp) && this.frac.equals(other.frac);
    }
}
