import java.util.*;
import java.nio.file.*;
import java.io.*;

public class Volterra {
	static double iniPopPrey, iniPopPred, alpha, beta, gamma, delta;
	static double dt = 0.01;
	static double totalTime = 30;

	public static void main(String[] args) throws IOException {
		iniPopPrey = Double.parseDouble(args[0]);
		iniPopPred = Double.parseDouble(args[1]);
		alpha = Double.parseDouble(args[2]);
		beta = Double.parseDouble(args[3]);
		gamma = Double.parseDouble(args[4]);
		delta = Double.parseDouble(args[5]);

		Species prey = new Species(iniPopPrey); 
		Species pred = new Species(iniPopPred);
		String path = "";
		for (int i = 0; i < 6 ; i++) {
			path = path + args[i] + " ";
		}
		FileWriter f = new FileWriter(path);
		f.write("t	prey	predator\n");
		for (double t = 0; t < totalTime; t = t + dt) {
			double x = prey.getPop();
			double y = pred.getPop();
			double dPrey = (alpha*x-beta*x*y)*dt;
			double dPred = (-gamma*y+delta*x*y)*dt;
			prey.addPop(dPrey);
			pred.addPop(dPred);
			f.write(t+"	"+prey.getPop()+"	"+pred.getPop()+"\n");
		}
		f.close();
		/**the following only for competitive model: gamma < 0, delta < 0*/
		if (prey.getPop()==0) {
			System.out.println("Competitor 2 wins");
		}
		else if (pred.getPop()==0) {
			System.out.println("Competitor 1 wins");
		}
	}
}
