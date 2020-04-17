import java.io.*;

abstract class Problem{
	public int testNumber;
	public String testName;
	abstract void test();
	public String toString(){
		return "problem_"+testNumber+":"+testName;
	}
}

public class WKExam{
	//这里是对翁恺老师自学期末考试题目的一些测试
	//经过测试我们发现这些题目中有一些答案是错的...
	//当然也可能有JDK版本，上下文等其他因素导致，不过实践是检验真理的唯一标准嘛
	public static void main(String args[]){
		test(new CompileTest());
		test(new ValueTest());
	}
	static void test(Problem p){
		System.out.println();
		System.out.print("Start testing:");
		System.out.println(p);
		p.test();
		System.out.println("Test ended");
	}
}

class CompileTest extends Problem{
	//用于测试一些代码是否能过编译
	CompileTest(){
		testNumber = 1;
		testName = "Compile test";
	}
	void test(){
		int j=0;

		//2.C，实践证明无法通过编译（与答案不符）
		//for();
		
		//2.D，实践证明无法通过编译（与答案不符）
		//for(i=0;i<10,j<10;i++);

		//6.C & 6.D，可以通过编译[与答案相符]
		int $a=666;
		System.out.println("变量名为$a，输出："+$a);
		int 变量=666;
		System.out.println("变量名为变量，输出："+变量);
		
		//6.F，实践证明无法通过编译（与答案不符）
		//翻阅Java关键词表中有double
		//int double=666;
		//System.out.println("变量名为变量，输出："+double);

		//24.A & 24.C，实践证明可以作为变量名，则不是关键词（与答案不符）
		//而且翻阅Java关键词表中也没有
		PrintWriter pw = new PrintWriter(System.out,true);
		int System = 666;
		pw.println("变量名为System，输出："+System);
		int Scanner = 666;
		pw.println("变量名为Scanner，输出："+Scanner);
	}
	//26.A & 26.E 无法通过编译（与答案不符）
	/*
	void f(int i){
		return i;//error: incompatible types: unexpected return value
	}
	int f(void){//error: <identifier> expected
		return 0;
	}
	*/
}

class ValueTest extends Problem{
	//用于测试一些代码的输出是什么
	ValueTest(){
		testNumber = 2;
		testName = "Value test";
	}
	void test(){

		{
			//8.A 实践证明A与题干要求相符（与答案不符）
			boolean x,y;
			for(int i=0;i<4;i++){
				x = i%2==0;
				y = i/2==0;
				System.out.println("x="+x+",y="+y+",题干中(!x&&!y)="
					+(!x&&!y)+",A选项中(!(x!=false||y!=false))="+(!(x!=false||y!=false)));
			}
		}
		{
			//12 [与答案相符]
			String s1 = "hello";
			String s2 = "hello";
			System.out.println("s1==s2:"+(s1==s2));
		}
		{
			//16（与答案不符）
			int x=0,y=4;
			System.out.print("-10<x&&y<0=");
			System.out.println(-10<x&&y<0);
		}
		{
			//23 [与答案相符]
			System.out.println("-17%4="+(-17%4));
		}
		{
			//31.B 要求表示x在[-10,0]的范围内，个人感觉这选项没问题
			for(int x=-15;x<=5;x++){
				System.out.println("x="+x+"，x>=-10&&x<=0为"+(x>=-10&&x<=0));
			}
		}

	}
}
