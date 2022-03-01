package generic;

import java.util.*;

public class Work1
{
    public static void main(String[] args)
    {
        PPD<User> ppd = new PPD<>();
        ppd.save("No1", new User("宁", 1, 4000));
        ppd.save("No2", new User("尘", 2, 28));
        ppd.save("No3", new User("颜", 3, 16));
        ppd.save("No4", new User("月", 4, 15000));

        List<User> lst = ppd.list();
        for (User u : lst)
        {
            System.out.println(u);
        }



    }
}
class User
{
    private String name;
    private int id;
    private int age;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }
}


class PPD<T>
{
    private Map<String, T> map;
    public PPD() {   map = new HashMap<>();  }

    public void save(String id, T entity)
    {
        map.put(id, entity);
    }

    public T get(String id)
    {
        return map.get(id);
    }

    public void update(String id, T entity)
    {
        map.put(id, entity);
    }

    public void delete(String id)
    {
        map.remove(id);
    }

    public List<T> list()
    {
        List<T> lst = new ArrayList<>();

        Collection<T> cet = map.values();
        for (T t : cet)
        {
            lst.add(t);
        }

//        Set<String> k = map.keySet();
//        for (String s : k)
//        {
//            lst.add(map.get(s));
//        }

        return lst;
    }



}

