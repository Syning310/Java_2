package bignum_;

import java.math.BigInteger;

public class BigInteger_
{

    public static void main(String[] args)
    {

        BigInteger big = new BigInteger("239999999999999999999999999999999999999");

        System.out.println("big = " + big);

        BigInteger big2 = new BigInteger("1");

        System.out.println(big.add(big2));
        System.out.println(big);




    }

}
