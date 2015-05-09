package autotest;

public class Main {

	public static void main(String[] args) {
		Console console = new Console();
		console.execute(System.out, new String[] {"--datasourse","F:/软件工程与计算3/迭代1/迭代一数据"});
	//	console.execute(System.out, new String[] {"-player","-n","10"});
		console.execute(System.out, new String[] {"-team","-total","-n","10"});
	//	console.execute(System.out, new String[] {"-team","-hot","score","-n","10"});
		

	}

}
