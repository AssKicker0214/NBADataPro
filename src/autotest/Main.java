package autotest;

public class Main {

	public static void main(String[] args) {
		Console console = new Console();
	//	console.execute(System.out, new String[] {"--datasourse","----"});
	//	console.execute(System.out, new String[] {"-player","-n","10"});
		console.execute(System.out, new String[] {"-team","-n","10"});
		console.execute(System.out, new String[] {"-team","-hot","score","-n","10"});
		

	}

}
