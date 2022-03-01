package a.tankgame11;


import java.io.*;
import java.util.Vector;

//该类用于记录游戏相关的信息，和文件交互
public class Recorder
{

    //定义变量，记录我方击毁敌人坦克数量
    private static int allEnemys = 0;

    //定义IO对象，用于写数据到文件中
    private static BufferedWriter bw = null;
    private static BufferedReader br = null;
    private static String recordPath = "src\\Record.txt";

    //定义一个Vector，指向MyPanel对象的敌人坦克的Vector
    private static Vector<Enemy> ems = null;

    //定义一个Node的Vector，用于保存敌人的信息
    private static Vector<Node> nodes = new Vector<>();



    //增加一个方法，当游戏退出时，我们将allEnemys保存到recordPath中
    //保存敌人坦克的坐标和方向
    public static void keepRecord()
    {
        try
        {
            bw = new BufferedWriter(new FileWriter(recordPath));
            if (allEnemys == 0)
            {
                bw.write("0");
                bw.newLine();
            }
            else
            {
                bw.write(allEnemys);
                bw.newLine();
            }


            //保存敌人坦克的坐标和方向，遍历敌人坦克的vecEnemy，然后视情况保存
            //定义一个属性，通过set方法得到集合
            for (int i = 0; i < ems.size(); ++i)
            {
                //取出敌人坦克
                Enemy e = Recorder.ems.get(i);

                //保存e的信息
                String record = e.getX() + " " + e.getY() + " " + e.getDirect();
                bw.write(record);
                bw.newLine();
            }

        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            try
            {
                bw.close();
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }

    }

    public static String getRecordPath() {
        return recordPath;
    }

    //增加一个方法，用于读取文件，恢复相关的信息
    //该方法在继续上局游戏时调用
    public static Vector<Node> getNodesAndEnemyRecord()
    {
        try
        {
            br = new BufferedReader(new FileReader(recordPath));

            allEnemys = Integer.parseInt(br.readLine());

            //循环读取文件，生成nodes集合
            String line = " ";
            while ((line = br.readLine()) != null)
            {
                String[] xyd = line.split(" ");
                Node n = new Node(Integer.parseInt(xyd[0]), Integer.parseInt(xyd[1]), Integer.parseInt(xyd[2]));
                nodes.add(n);
            }
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            try
            {
                br.close();
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }

        return nodes;
    }




    public static void setEms(Vector<Enemy> ems)
    {
        Recorder.ems = ems;
    }

    //当我方坦克击毁一个敌人坦克，就应当allEnemys++
    public static void addAllEnemys()
    {
        ++allEnemys;
    }


    public static int getAllEnemys()
    {
        return allEnemys;
    }

    public static void setAllEnemys(int allEnemys)
    {
        Recorder.allEnemys = allEnemys;
    }
}
