public class NumberRepresent{
    private int num;
    private String roman;
    private static final string[] ROMAN_SYMBOLS = {"I","V","X,"L","C","D","M"};
    public NumberRepresent(NumberSystem system, String repr){
    switch(system){
        case NumberSystem.ROMAN -> {
            this.roman = repr;
            this.initArabic();
        }
        case NumberSystem.HINDU_ARABIC -> {
            this.num = Integer.parseInt(repr);
            this.initRoman();
        }
    }
    }
}