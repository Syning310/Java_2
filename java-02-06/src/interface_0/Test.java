package interface_0;

public class Test
{
    public static void main(String[] args)
    {
        Phone_ p1 = new Phone_();
        Camera_ c1 = new Camera_();
        Phone_ p2 = new Phone_();
        Phone_ p3 = new Phone_();
        Camera_ c2 = new Camera_();

        USB[] usbs = {p1, c1, p2, p3, c2};

        for (int i = 0; i < usbs.length; ++i)
        {
            if (usbs[i] instanceof Phone_)
            {
                ((Phone_)usbs[i]).cal();
            }
            else if (usbs[i] instanceof Camera_)
            {
                ((Camera_)usbs[i]).pic();
            }
        }



    }
}
