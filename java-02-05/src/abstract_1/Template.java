package abstract_1;

abstract public class Template
{
    public abstract void job();

    //返回job方法运行的时间单位：毫秒
    public long calculateTime()
    {
        long start = System.currentTimeMillis();
        this.job();
        long end = System.currentTimeMillis();
        return end - start;
    }


}
