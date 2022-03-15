package exercise;

import java.math.BigInteger;

public class Calc
{
    public static void main(String[] args)
    {

        BigInteger bi = new BigInteger("9223372036854775807");

        BigInteger bp = bi.divide(new BigInteger("1024"));
        System.out.println(bi + "byte = " + bp + " kb");

        BigInteger ba = bp.divide(new BigInteger("1024"));
        System.out.println(bp + "kb = " + ba + " mb");

        BigInteger bb = ba.divide(new BigInteger("1024"));
        System.out.println(ba + "mb = " + bb + " gb");


        BigInteger bc = bb.divide(new BigInteger("1024"));
        System.out.println(bb + "gb = " + bc + " tb");


    }
}
