package sorting;
import utils.Utils;

public class SillySorts {
	
	// ***************************** Silly Sorts *****************************
	// *** the silliest sorts of them all
	public static void bogoSort(Integer[] nums) {
		while (!Utils.isSorted(nums)) {
			Utils.shuffle(nums);
		}
	}

}
