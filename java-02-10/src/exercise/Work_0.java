package exercise;

import java.util.Arrays;
import java.util.Comparator;

public class Work_0
{
    public static void main(String[] args)
    {
        Book[] books = new Book[4];
        books[0] = new Book("人类简史", 100);
        books[1] = new Book("思辨与立场", 90);
        books[2] = new Book("星门", 5);
        books[3] = new Book("三国志", 300);

        System.out.println("排序之前:");
        printBooks(books);

        Arrays.sort(books, new Comparator()
                                {
                                    public int compare(Object v1, Object v2)
                                    {
                                        Book b1 = (Book)v1;
                                        Book b2 = (Book)v2;
                                        return b1.getPrice() - b2.getPrice();
                                    }
                                });

        System.out.println("排序之后:");
        printBooks(books);



    }

    public static void printBooks(Book[] bs)
    {
        for (Book b : bs)
        {
            System.out.println(b.toString());
        }
    }
}


class Book
{
    private String name;
    private int price;

    public Book(String name, int price)
    {
        this.name = name;
        this.price = price;
    }


    public String toString()
    {
        return "name: " + this.name + "   price: " + this.price;
    }


    public String getName()
    {
        return name;
    }

    public int getPrice()
    {
        return price;
    }
}
