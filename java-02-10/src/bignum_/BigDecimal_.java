package bignum_;

import java.math.BigDecimal;

public class BigDecimal_
{
    public static void main(String[] args)
    {

        BigDecimal bd = new BigDecimal("0.99999999999999999999999999999999999999999999");

        System.out.println("bd = " + bd);
        System.out.println(bd.add(new BigDecimal("0.00000000000000000000000000000000000000000001")));
        System.out.println(bd);

        //当会出现无限循环的情况，在后面多加上一个参数，即可
        System.out.println(bd.divide(new BigDecimal("13"), BigDecimal.ROUND_DOWN));


    }
}
