import java.util.Scanner;

/**
 * Created by 时光与你 on 2017/7/11.
 */
/*
Java常用算法之——数据结构之——队列
 */
/*
定义队列结点数据
 */
class DATA{
    String name;
    int age;
}
/*
定义队列
 */
class SQType{
    static final int QUEUELEN = 15;
    DATA []data = new DATA[QUEUELEN];
    int head;
    int tail;

    /*
    初始化队列
     */
    SQType SQTypeInit(){
        SQType q;
        if ((q = new SQType()) != null){
            q.head = 0;
            q.tail = 0;
        }else {
            q = null;
        }
        return q;
    }

    /*
    判断空队列
     */
    int SQTypeIsEmpty(SQType q){
        int temp = 0;
        if (q.head == q.tail){
            temp = 1;
        }
        return temp;
    }

    /*
    判断满队列
     */
    int SQTypeIsFull(SQType q){
        int temp = 0;
        if (q.tail == QUEUELEN){
            temp = 1;
        }
        return temp;
    }

    /*
    清空队列
     */
    void SQTypeClear(SQType q){
        q.head = 0;
        q.tail = 0;
    }

    /*
    释放队列
     */
    void SQTyprFree(SQType q){
        if (q != null){
            q = null;
        }
    }

    /*
    入队列
     */
    int InSQType(SQType q, DATA data){
        if (q.tail == QUEUELEN){
            System.out.println("队列已满！操作失败！\n");
            return 0;
        }
        else {
            q.data[q.tail++] = data;
            return 1;
        }
    }

    /*
    出队列
     */
    DATA OutSQType(SQType q){
        if (q.tail == q.head){
            System.out.println("\n队列已空！操作失败！\n");
            System.exit(0);
        }else {
            return q.data[q.head++];
        }
        return null;
    }

    /*
    读结点数据
     */
    DATA PeekSQType(SQType q){
        if (SQTypeIsEmpty(q) == 1){
            System.out.println("\n空队列\n");
            return null;
        }else {
            return q.data[q.head];
        }
    }

    /*
    计算队列长度
     */
    int SQTypeLen(SQType q){
        int temp;
        temp = q.tail - q.head;
        return temp;
    }
}
public class QueueLearn {
    public static void main(String[] args) {
        SQType st = new SQType();
        DATA data1;

        Scanner input = new Scanner(System.in);
        SQType queue = st.SQTypeInit(); // 初始化队列
        System.out.println("输入姓名 年龄进行入队列操作！\n");
        do {
            DATA data = new DATA();
            data.name = input.next();
            data.age = input.nextInt();
            if (data.name.equals("0")){
                break;
            }else {
                st.InSQType(queue,data);
            }
        }while (true);

        String temp = "1";
        System.out.println("出队列操作！按任意非零键进行：");
        temp = input.next();
        while (!temp.equals("0")){
            data1 = st.OutSQType(queue);
            System.out.println("出队列的数据是："+data1.name+","+data1.age);
            temp = input.next();
        }
        System.out.println("测试结束！");
        st.SQTyprFree(queue);
    }
}
