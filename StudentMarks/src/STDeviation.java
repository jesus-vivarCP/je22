
public class STDeviation {
	private double avg;
	private double squaredSum;
	
	public STDeviation() {
		squaredSum = 0;
	}
	
	public double getSTDev() {
		return avg;
	}
	/*
	public double average() {
        return count > 0 ? ((double) total)/count : 0;
    }
        
    public void accept(int i) { total += i; count++; }
    public void combine(Averager other) {
        total += other.total;
        count += other.count;
    }*/
	
	public double squaredSTDev(double d) {
		squaredSum += (d - avg) * (d - avg);
		return 0;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

}
