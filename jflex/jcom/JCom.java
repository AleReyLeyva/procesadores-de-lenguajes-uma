import java.io.FileReader;
import java.io.IOException;

public class JCom {
    protected static int LINE = 0;
    protected static int BLOCK = 0;
    protected static int DOC = 0;

    public static void addLine(int count) {
        LINE += count;
    }

    public static void addBlock(int count) {
        BLOCK += count;
    }

    public static void addDoc(int count) {
        DOC += count;
    }

    public static void main(String args[]) {
        if (args.length > 0) {
            try {
                Yylex lex = new Yylex(new FileReader(args[0]));
                while (lex.yylex() != Yylex.YYEOF) {
                }

                System.out.println("//  " + LINE);
                System.out.println("/*  " + BLOCK);
                System.out.println("/** " + DOC);
            } catch (IOException e) {
                System.err.println("Error reading the input file");
            }
        } else {
            System.err.println("You have to pass an input file as argument");
        }
    }
}
