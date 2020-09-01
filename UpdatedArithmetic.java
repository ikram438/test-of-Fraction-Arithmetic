package fractionarithmetic;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import fractionarithmetic.Fraction;
import fractionarithmetic.Training;

public class UpdatedArithmetic {

  public static void main(String[] args) {
  
  Scanner sc= new Scanner(System.in);
  String repeat="yes";
  
  
  while(repeat=="yes")
  {
  int i=0;
  i++;
  Training session=new Training();
  System.out.println("session "+i+"\n");
  System.out.println("total points in the following manner:\n"+"Time limit(30s)  Under         Over\n"+"Correct Ans      4(10)         3(6)\n"+"Wrong Ans        2(3)          1(0)\n"+"TOTAL POINTS: 64 (40 + 18 + 6 + 0)\n");
  session.test();
  System.out.println("you got "+session.getTotalPoint()+" points out of 100 ");
  System.out.println("if you want an other session enter yes or enter something else to terminate:  ");
  repeat=sc.next();
  
  
  }//end while loop
  }
}

  class Fraction {
    private int num;
    private int denom;
   public Fraction()
   
   {
     this(0,1);
   }
   public Fraction(int num)
   
   {
     this(num,1);
   }
   public Fraction(int num,int denom)
                
   {
     this.num=num;
     this.denom=denom;
     
    }
   
   public int getNum()
   {
     return num;
   }
   
    public int getdenom()
   {
     return denom;
   }
   
    public void setNum(int num)
   {
     this.num=num;
   }
   
    public void setdenom(int denom)
   {
     this.denom=denom;
   }
   
   public Fraction add(Fraction f)
   {
     Fraction temp;
     temp = new Fraction();      temp.num=this.num*f.denom+
                         f.num*this.denom;
     temp.denom=this.denom*f.denom;
     return temp;
   }
   public Fraction sub(Fraction f)
   {
   Fraction temp;
   temp = new Fraction();
      temp.num=this.num*f.denom-f.num*this.denom;
     temp.denom=this.denom*f.denom;
     return temp;
   }
   public Fraction mul(Fraction f)
   {
      Fraction temp;
      temp = new Fraction();
      temp.num=this.num*f.num;
     temp.denom=this.denom*f.denom;
     return temp;
   }
   public Fraction div(Fraction f)
   {
      Fraction temp;
      temp = new Fraction();
      temp.num=this.num*f.denom;
     temp.denom=this.denom*f.num;
     return temp;
   }
   
   
   public int limit()
   {
     int n=0,dn=0;
     
     if (num<0)
     n=-num;
     else
     n=num;
     
     if(denom<0)
     dn=-denom;
     else
     dn=denom;
     
     if (n>dn)
     return n;
     else
     return dn;
   }
   
 public String getFraction()
   { 
   
   int dn=0,n=0;

     for(int i=1;i<=limit();i++)
     {
       if (num%i==0&&denom%i==0)
      {
       n=num/i;
       dn=denom/i;
       }  
       
     }
 
    if(dn==0)
     return "error! zero can't be denom";
    else if(dn==1)
     return Integer.toString(n);
    else
     return n+"/"+dn;
     
   }
   }
   
   
   
class Training {
Random rn;
Fraction f1, f2,f;
Date start,stop;
Scanner sc;
private int time;
private int point;
private boolean check;
  public Training ()
  {
  sc =new Scanner(System.in); 
  f1= new Fraction(); 
  f2= new Fraction();
  f = new Fraction(); 
  }
  
  public void answer(Fraction f)
  {
  System.out.print("Ans = ");
   String ans=""; 
   startTiming();
   ans=sc.next();
   stopTiming();
   if (checkAns(ans,f))
   System.out.println("right answer");
   else
  System.out.println("wrong answer\n   right answer is "+f.getFraction());
  System.out.println("you got "+getTotalPoint()+" points");
 
  }
  
  public void test ()
  { 
   int op;
   
  for(int i=1;i<=10;i++)
   {
   System.out.print("q"+i+" = ");
   Random rn = new Random();
   f1.setNum(rn.nextInt(10)+1);
   f1.setdenom(rn.nextInt(10)+1);
   f2.setNum(rn.nextInt(10)+1);
   f2.setdenom(rn.nextInt(10)+1);
   op=rn.nextInt(4)+1;
    
  switch (op)
   {
   case 1:
   f=f1.add(f2);
   System.out.println(f1.getNum()+"/"+f1.getdenom()+" + "+f2.getNum()+"/"+f2.getdenom()+" = ?");
  answer(f);
  break;
  
  
 case 2:
 f=f1.sub(f2);
   System.out.println(f1.getNum()+"/"+f1.getdenom()+" - "+f2.getNum()+"/"+f2.getdenom()+" = ?");
   answer(f);
  break;
  
   
  case 3:
  f=f1.mul(f2);
   System.out.println(f1.getNum()+"/"+f1.getdenom()+" * "+f2.getNum()+"/"+f2.getdenom()+" = ?");
    answer(f);
  break;
  
  case 4 :
  f=f1.div(f2);
   System.out.println(f1.getNum()+"/"+f1.getdenom()+" / "+f2.getNum()+"/"+f2.getdenom()+" = ?");
  answer(f);
  break;
  default :
  System.out.println("error in switch");
   }//end switch
   
    }//end for loop    
    
  }// emd test()
   
  
  public void startTiming()
  {
  start = new Date();
  }
  
  public void stopTiming()
 {
  stop = new Date();
this.time=(int)(stop.getTime()-start.getTime())/1000;
  }
  
  public boolean checkAns(String       
                          ans,Fraction f) 
  {

    if(ans.equals(f.getFraction()))
    this.check= true;
    else
    this.check= false;
    return this.check;
  }
  
  public int getTotalPoint()
  {
    if(check&& time<=30)
    point+=10;
    else if(check&& time>30)
    point+=6;
    else if(!check&& time<=30)
    point+=3;
    else
    point+=0;
    return point;
  }
}