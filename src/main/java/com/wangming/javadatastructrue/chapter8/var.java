package com.wangming.javadatastructrue.chapter8;

import java.awt.*;

import javax.swing.*;

class var{
    public static int num=0;											//表示开始时第一塔有5个
    public static int t_one=0,t_two=-1,t_three=-1;					//表示每层塔的个数
    public static int tower_one[]=new int[30],tower_two[]=new int[30],tower_three[]=new int[30];		//表示每个塔有塔的层数
    public static int n=2;
    public static int rectx1,rectx2,recty=440,rectmid,rectmidt=315;			//表示要画的矩形左右坐标
    public static int t=0,t2=0;							//tower为指向要移动的塔的指针
    public static int tower[]=tower_one;
    public static int bool=1;//画图函数，画出a塔移动到b塔
    public static char str[]=new char[20];
}
 class Hanoi2 extends JFrame implements Runnable{
    public Thread thread1=new Thread(this);

    public Hanoi2(){
        init();
        add(new Paints());
        //runs();
        input();
        thread1.start();
    }
    public void init(){
        for(int i=0;i<30;i++)									//分别为每个塔里层数编号
        {
            var.tower_one[i]=i;
        }
        for(int i=0;i<30;i++)
        {
            var.tower_two[i]=i;
        }
        for(int i=0;i<30;i++)
        {
            var.tower_three[i]=i;
        }
    }
    public void input(){
        String str=JOptionPane.showInputDialog("请输入汉诺塔层数不大于13的整数。");
        int x=(int)Float.parseFloat(str);
        if(!(x>=1&&x<=13)){
            JOptionPane.showMessageDialog(null,"请输入汉诺塔层数不大于13的整数。");
            System.exit(0);
        }
        else{
            var.n=x;
            var.t_one=x-1;
        }

    }
    public void moves(int a,int b)
    {
        switch(a)
        {
            case 1:var.rectmid=155;var.tower=var.tower_one;var.t=var.t_one;var.t_one-=1;break;   //t表示要移动的塔中塔数有几个
            case 2:var.rectmid=315;var.tower=var.tower_two;var.t=var.t_two;var.t_two-=1;break;
            case 3:var.rectmid=475;var.tower=var.tower_three;var.t=var.t_three;var.t_three-=1;break;
        }
        switch(b)
        {
            case 1:var.rectmidt=155;var.t2=var.t_one;break;			 //t2表示要移动到的塔有几个
            case 2:var.rectmidt=315;var.t2=var.t_two;break;
            case 3:var.rectmidt=475;var.t2=var.t_three;break;
        }
        if(a>=b) var.bool=1;
        else	var.bool=0;
        var.rectx1=var.rectmid-(14-var.tower[var.t])*5;					//计算要画的矩形左边坐标
        var.rectx2=var.rectmid+(14-var.tower[var.t])*5;
        var.recty=440-var.t*5;
        while(var.recty>=200)
        {
            var.recty-=10;									//塔向上移动到坐标100处
            repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        while(var.rectmid!=var.rectmidt)					//rectmidt表示中间塔中间的位置
        {
            if(1==var.bool)
            {
                var.rectmid-=5;
                var.rectx1=var.rectmid-(14-var.tower[var.t])*5;		//rectx2-rectx1 是变长的
                var.rectx2=var.rectmid+(14-var.tower[var.t])*5;
                repaint();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else
            {
                var.rectmid+=5;
                var.rectx1=var.rectmid-(14-var.tower[var.t])*5;
                var.rectx2=var.rectmid+(14-var.tower[var.t])*5;
                repaint();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        while(var.recty<=(430-(var.t2)*5))
        {
            var.recty+=10;							//塔向下移动
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        }
        switch(b)
        {
            case 1:var.t_one+=1;var.tower_one[var.t_one]=var.tower[var.t];repaint();break;		//选择移动到的塔层数加1，并且把当前塔的大小，传递过去。
            case 2:var.t_two+=1;var.tower_two[var.t_two]=var.tower[var.t];repaint();break;
            case 3:var.t_three+=1;var.tower_three[var.t_three]=var.tower[var.t];repaint();break;
        }


    }
    public void hanoi(int n,int one,int two,int three)
    {
        if(n==1)
        {
            moves(one,three);
            //JOptionPane.showMessageDialog(null,n);
        }
        else
        {
            hanoi(n-1,one,three,two);
            moves(one,three);
            hanoi(n-1,two,one,three);
        }
    }
    public void run(){
        hanoi(var.n,1,2,3);

    }
    public static void main(String[] args){
        Hanoi2  frame= new Hanoi2();


        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(660, 550);
        frame.setTitle("汉诺塔移动动画");
        frame.setVisible(true);
        frame.setResizable(false);

    }

}
class Paints extends JPanel{
    protected void paintComponent(Graphics g){
        int i,j,rectmid1;
        //JOptionPane.showMessageDialog(null, "画图启动");
        g.drawString("南昌大学benmo制作", 270, 50);
        g.drawString("qq号52733#8997(去掉中间的#)", 270, 70);
        g.drawRect(80,450,150,5);
        g.drawRect(240,450,150,5);
        g.drawRect(400,450,150,5);
        rectmid1=155;int recty1=440;
        g.drawRect(var.rectx1,var.recty,var.rectx2-var.rectx1,9);             //画出移动的矩形
        for(i=0;i<=var.t_one;i++)
            g.drawRect(155-(14-var.tower_one[i])*5,recty1-10*i,(14-var.tower_one[i])*10,10);
        for(i=0;i<=var.t_two;i++)
            g.drawRect(315-(14-var.tower_two[i])*5,recty1-10*i,(14-var.tower_two[i])*10,10);
        for(i=0;i<=var.t_three;i++)
            g.drawRect(475-(14-var.tower_three[i])*5,recty1-10*i,(14-var.tower_three[i])*10,10);
    }
}