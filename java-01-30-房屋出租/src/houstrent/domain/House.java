package houstrent.domain;


//Hose的对象表示一个房屋信息
public class House
{
    //编号  房主  电话  地址  月租  状态(未出租/已出租)
    private int id;
    private String name;
    private String phone;
    private String address;
    private int rent;
    private String statue;

    public House() {  }

    public House(int id, String name, String phone, String address, int rent, String statue) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.rent = rent;
        this.statue = statue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public String getStatue() {
        return statue;
    }

    public void setStatue(String statue) {
        this.statue = statue;
    }

    //为了方便输出对象信息，我们重写toString方法
    public String toString()
    {
        return this.id +
                "\t\t" + this.name +
                "\t\t" + this.phone +
                "\t" + this.address +
                "\t" + this.rent +
                "\t" + this.statue;
    }


}
