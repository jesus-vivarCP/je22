import java.util.ArrayList;
import java.util.Comparator;

public class Records implements Comparable {
	private String name;
	private int numMarks;
	private double sumMarks;
	private double avg;

	public Records (String info) {
		String[] student = info.split(" ");
		name = student[0];
		sumMarks = Integer.parseInt(student[1]);
		numMarks = 1;
		avg = 0;
	}

	public double getSumMarks() {
		return sumMarks;
	}

	public void setSumMarks(String sumMarks) {
		this.sumMarks += Integer.parseInt(sumMarks);
	}
	
	public String getName() {
		return name;
	}
	
	public int getNumMarks() {
		return numMarks;
	}
	public void setNumMarks() {
		this.numMarks += 1;
	}
	public double getAvg() {
		return getSumMarks()/getNumMarks();
	}

	@Override
	public int compareTo(Object o) {
		if (this.name.compareTo(((Records) o).getName())==0)
			return 0;
		else if (this.name.compareTo(((Records) o).getName()) < 0)
			return -1;
		
		return 1;
	}
	
	public static Comparator<Records> StudentAvg = new Comparator<Records>() {
		@Override
		public int compare(Records o1, Records o2) {
			return (int) (o2.getAvg() - o1.getAvg());
		}};
	
	@Override 
	public String toString() {
		return name + " " + getNumMarks() + " " + getAvg();
	}
	
	/*public static Frequency<Records> sum = new Frequency<Records>() {
	    int sum = 0;
	    for (int i: list) {
	        sum += i;
	    }
	    return sum;
	}
	 */
}
