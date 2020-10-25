package com.atguigu.springboot.test;

public class Hello {
    public static void main(String[] args) {

        System.out.println(3&1); //=1
        System.out.println(3|1);  //=3

        String string = null;
        boolean result = (string+"welcome").equals("welcome");
        System.out.println(result); //false

        String str1 = "welcome";
        String str2 = "welcome";
        System.out.println(str1 == str2); // true

        Integer int1 = 1;
        Integer int2 = 1;
        System.out.println(int1 == int2); //true

        Integer a = 128;
        Integer b = 128;
        /*
        这道题 a==b 结果为false, a.equals(b) 结果为true
        涉及到常量池知识 在-128和127之间的时候integer不会new新对象 a==b为true
        超过127就会自动new一个对象 这时候就为a==b就为false了
        */
        System.out.println(a == b); // false

        //int数据类型能表示的大小范围  -2的31次方到2的31次方-1）  所以int的数据表示范围大概在-21亿到21亿之间

        /*1、HashMap是通过hashcode()对其内容进行快速查找的；HashMap中的元素是没有顺序的；

        TreeMap中所有的元素都是有某一固定顺序的，如果需要得到一个有序的结果，就应该使用TreeMap；

        2、HashMap和TreeMap都不是线程安全的；

        3、HashMap继承AbstractMap类；覆盖了hashcode() 和equals() 方法，以确保两个相等的映射返回相同的哈希值；

        TreeMap继承SortedMap类；他保持键的有序顺序；

        4、HashMap：基于hash表实现的；使用HashMap要求添加的键类明确定义了hashcode() 和equals() （可以重写该方法）；为了优化HashMap的空间使用，可以调优初始容量和负载因子；

        TreeMap：基于红黑树实现的；TreeMap就没有调优选项，因为红黑树总是处于平衡的状态；

        5、HashMap：适用于Map插入，删除，定位元素；

        TreeMap：适用于按自然顺序或自定义顺序遍历键（key）；*/

        /*System.gc();作用是什么？
        System.gc(); //告诉垃圾收集器打算进行垃圾收集，而垃圾收集器进不进行收集是不确定的
        java.lang.System.gc()只是java.lang.Runtime.getRuntime().gc()的简写，两者的行为没有任何不同。
        唯一的区别就是System.gc()写起来比Runtime.getRuntime().gc()简单点. 其实基本没什么机会用得到这个命令,
        因为这个命令只是建议JVM安排GC运行, 还有可能完全被拒绝。 GC本身是会周期性的自动运行的,由JVM决定运行的时机,
        而且现在的版本有多种更智能的模式可以选择,还会根据运行的机器自动去做选择,就算真的有性能上的需求,
        也应该去对GC的运行机制进行微调,而不是通过使用这个命令来实现性能的优化*/

        //查询出平均成绩最高的班级和平均分，新创建表已经验证过了。
        /*SELECT a.classid, a.avgsource
        FROM
                (SELECT classid, avg(score) avgsource
                        FROM student
                        GROUP BY classid) a ORDER BY a.avgsource desc LIMIT 0,1;*/

        /*--查询出每个班级分数最高的学生
        SELECT a.id, a.classid,a.score
        from student a
                JOIN
        (SELECT classid,max(score) maxscore
        FROM student
        GROUP BY classid) b  on a.classid = b.classid and a.score = b.maxscore*/





    }
}
