package autotest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Console console = new Console();
//		console.execute(System.out, args);

		console.execute(System.out, new String[] {"--datasourse","/Users/chenghao/Desktop/迭代一数据"});
//		console.execute(System.out, new String[] {"-player","-sort","numOfGame.desc"});
//		console.execute(System.out, new String[] {"-player","-all","-n","10"});
//		console.execute(System.out, new String[] {"-player","-high","-n","10","-sort","frequency.desc"});
//		console.execute(System.out, new String[] {"-player","-hot","assist","-n","5"});
//		console.execute(System.out, new String[] {"-player","-king","score","-season"});
//		console.execute(System.out, new String[] {"-player","-avg","-n","5","-filter","position.F"});
//		console.execute(System.out, new String[] {"-player","-total","-all","-n","10","-filter","position.F,league.west","-sort","shot.desc"});
//		console.execute(System.out, new String[] {"-team"});
		console.execute(System.out, new String[] {"-team","-all","-total"});
//		console.execute(System.out, new String[] {"-team","-all","-n","10"});
//		console.execute(System.out, new String[] {"-team","-hot","assist","-n","5"});
//		console.execute(System.out, new String[] {"-team","-avg","-n","5","-sort","shot.asc"});
//		console.execute(System.out, new String[] {"-team","-total","-all","-n","10","-sort","shot.desc"});
//		console.execute(System.out, new String[] {"-team","-high","-n","5","-sort","stealEfficient.asc"});

	}

}
