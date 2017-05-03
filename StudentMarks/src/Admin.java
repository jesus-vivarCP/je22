import java.io.File;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.Scanner;

public class Admin {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Map<String, Records> StudentsRecords = new HashMap<>();
		
		String textfile = "Student_Records.txt";
		OptionalDouble avg, std;
		int size;
		File file = new File(textfile);
		
		try {
			Scanner readFile = new Scanner(file);
			
			while (readFile.hasNextLine()) {
				String info = readFile.nextLine();
				System.out.println(info);
				
				String[] student = info.split(" ");
				
				if (StudentsRecords.containsKey(student[0])) {
					Records record = StudentsRecords.get(student[0]);
					record.setNumMarks();
					record.setSumMarks(student[1]);
				} else {
					Records record = new Records(info);
					StudentsRecords.put(student[0], record);
				}
			}
			
			ArrayList<Records> Students = new ArrayList<>(StudentsRecords.values());
			Collections.sort(Students);
			
			System.out.println("\nAlpha Order");
			for(Records student : Students)
				System.out.println(student);
			
			Collections.sort(Students, Records.StudentAvg);
			
			System.out.println("\nMerit Order");
			for(Records student : Students) {
				System.out.println(student);
			}
			
			size = (int) Students.stream().count();
			avg = Students.stream().mapToDouble(Records::getAvg).average();
			//std = Students.stream().mapToDouble(Records::getAvg);
			
			Collections.enumeration(Students);
			
			NumberFormat nf = new DecimalFormat("#.0");
			System.out.print("\nNumber of student: " + size + "\n");
			System.out.println("Average student mark: "+ nf.format(avg.getAsDouble()));
			System.out.println("Standard deviation: ");
			
			readFile.close();
		}catch (Exception e) {
			System.out.println("Bad file.");
		}
	}

}
