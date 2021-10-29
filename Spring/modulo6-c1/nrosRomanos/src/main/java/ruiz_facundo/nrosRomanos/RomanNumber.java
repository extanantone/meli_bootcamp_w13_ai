package ruiz_facundo.nrosRomanos;

import java.util.HashMap;

public class RomanNumber {
    String roman;

    public RomanNumber(String inRoman) {
        this.roman = inRoman;
    }

    public RomanNumber(Integer inDecimal) {
        this.roman = this.getRomanFromDec(inDecimal);
    }

    public String getRomanFromDec(Integer inDecimal) {
        if (inDecimal > 0 && inDecimal < 4000) {
            String outRoman = "";
            while (inDecimal >= 1000) {
                inDecimal-=1000;
                outRoman+="M";
            }
            outRoman+=getRomanLettersForDecByOrdValues(new String[]{"CM", "D", "CD", "C"},
                    inDecimal, new Integer[]{900, 500, 400, 100});
            inDecimal%=100;
            outRoman+=getRomanLettersForDecByOrdValues(new String[]{"XC", "L", "XL", "X"},
                    inDecimal, new Integer[]{90, 50, 40, 10});
            inDecimal%=10;
            outRoman+=getRomanLettersForDecByOrdValues(new String[]{"IX", "V", "IV", "I"},
                    inDecimal, new Integer[]{9, 5, 4, 1});
            return outRoman;
        } else {
            return "";
        }
    }

    private String getRomanLettersForDecByOrdValues(String[] ordLetters, Integer inDecimal, Integer[] ordValues) {
        String outRoman = "";
        if (inDecimal >= ordValues[0]) {
            inDecimal-=ordValues[0];
            outRoman+=ordLetters[0];
        } else {
            if (inDecimal >= ordValues[1]) {
                inDecimal-=ordValues[1];
                outRoman+=ordLetters[1];
            }
            if (inDecimal >= ordValues[2]) {
                inDecimal-=ordValues[2];
                outRoman+=ordLetters[2];
            } else {
                while (inDecimal >= ordValues[3]) {
                    inDecimal-=ordValues[3];
                    outRoman+=ordLetters[3];
                }
            }
        }
        return outRoman;
    }

    public String getRoman() {
        return this.roman;
    }
}
