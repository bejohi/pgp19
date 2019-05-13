/**
 * What have i done?
 * 1. Removed all methods which were dependend to non-local context.
 * 2. Moved setter to local fields in the main-method.
 * 3. Changend the signatur of printNumber to work with a parameter codec
 *    insteadt of a local instant codec.
 * 4. copied the BIN, OCT, DEC, HEX infomration.
 * 
 * Not the nicest way, but it works, xD
 */

public class NonFunctional { 
    private static void printNumber(int printNumber,int codec){
        final int BIN = 0;
        final int OCT = 1;
        final int DEC = 2;
        final int HEX = 3;
        switch(codec){
            case BIN:
                System.out.format("0b%s\n", Integer.toBinaryString(printNumber));
                return;
            case OCT:
                System.out.format("0o%s\n",Integer.toOctalString(printNumber));
                return;
            case DEC:
                System.out.format("%d\n",printNumber);
                return;
            case HEX:
                System.out.format("0x%s\n",Integer.toHexString(printNumber));
                return;
            default:
                System.err.format("unknown codec '%d'\n",codec);
        }
    }
 
    public static void main(String[] args){
        int number = 0;
        final int BIN = 0;
        final int OCT = 1;
        final int DEC = 2;
        final int HEX = 3;
        int codec = DEC;
        printNumber(number,codec);
        number = 1337;
        codec = BIN;
        printNumber(number,codec);
        codec = OCT;
        printNumber(number,codec);
        codec = DEC;
        printNumber(number,codec);
        codec = HEX;
        printNumber(number,codec);
    }
}