import java.util.*;

public class Species {
	private double population;

	public Species (double pop) {
		if (pop >= 0) {
			population = pop;
		}
		else {
			population = 0;
		}
	}

	/**get the population
 * 	@return double, the population*/
	public double getPop() {
		return population;
	}

	/**add population by a certain amount
 * 	@param dPop double, the added amount, can be positive or negative */
	public void addPop(double dPop) {
		population = Math.max(population + dPop, 0);
	}
}
