package com.gcit.libraryApp.UI;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.InputMismatchException;

import com.gcit.libraryApp.GenericFunction.GenericFunctions;
import com.gcit.libraryApp.Librarian.ManageBranch;

public class LibrarySelected {
	private Connection conn;

	private ManageBranch mb;
	private GenericFunctions gf;

	private int size;
	private int brachId;

	public LibrarySelected(Connection conn, GenericFunctions gf) {
		size = -1;
		brachId = 0;
		mb = new ManageBranch();
		this.conn = conn;
		this.gf = gf;
	}

	public int lib1() {
		int option = 0;
		while (true) {
			option = lib1(option);
			if (option == 2)
				return 0;
		}
	}

	private int lib1(int option) {
		switch (option) {
		case 1:
			option = lib2();
			break;
		default:
			gf.println("");
			gf.println("1) Branch Management");
			gf.println("2) Quit to previous");
			try {
				option = Integer.parseInt(gf.stringCondition());
			} catch (InputMismatchException | NumberFormatException e) {
				gf.println("Invalid input.Quitting to menu.");
				return 2;
			}
			break;
		}
		return option;
	}

	private int lib2() {
		int option = 0;

		while (true) {
			try {
				option = lib2(option);
			} catch (InputMismatchException e) {
				gf.println("Invalid input.Quitting to menu.");
				return 0;
			}
			if (option == size)
				return 0;
		}
	}

	private int lib2(int option) {
		switch (option) {
		case 0:
			gf.println("Pick branch to manage.");
			size = gf.viewTable(conn, "tbl_library_branch");
			if (size == 0)
				return 0;
			gf.println(size + ") Quit to previous.");
			try {
				while (true) {
					option = gf.integerCondition();
					if (option > 0 && option <= size)
						break;
				}
			} catch (InputMismatchException e) {
				gf.println("Invalid input.Quitting to menu.");
				return size;
			}
			brachId = option;
			break;
		default:
			option = lib3();
			break;
		}
		return option;
	}

	private int lib3() {
		int option = 0;

		try {
			while (true) {
				option = lib3(option);
				if (option == 3)
					return 0;
			}
		} catch (InputMismatchException e) {
			gf.println("Invalid input.Quitting to menu.");
			return 0;
		}
	}

	private int lib3(int option) {
		switch (option) {
		case 1:
			option = option1(option);
			break;
		case 2:
			option = option2();
			break;
		default:
			gf.println("1) Update the details of the library.");
			gf.println("2) Add copies of books to the branch.");
			gf.println("3) Quit to previous.");
			while (true) {
				try {
					option = gf.integerCondition();
					if (option > 0 && option <= size)
						break;
				} catch (InputMismatchException e) {
					gf.println("Invalid input.Quitting to menu.");
					return 3;
				}
			}
			break;
		}
		return option;
	}

	private int option1(int option) {
		ArrayList<String> b = new ArrayList<>();

		b = mb.getLibraryBranch(conn, brachId);
		if (b == null) {
			gf.println("No such library.Quitting to menu.");
			return 0;
		}

		gf.print("You have chosen to update the Branch with Branch Id: ");
		gf.println(b.get(0) + " and branchName: " + b.get(1));
		gf.println("Enter 'quit' at any prompt to cancel the operation.");

		gf.println("Please enter new branch name or enter N/A for no change:");
		String name = gf.stringCondition();
		if (name.equals("quit"))
			return 0;

		gf.println("Please enter new branch address or enter N/A for no change:");
		String address = gf.stringCondition();
		if (address.equals("quit"))
			return 0;

		if (!name.equals("N/A"))
			mb.updateBranchName(conn, name, brachId);
		if (!address.equals("N/A"))
			mb.updateBranchAddress(conn, address, brachId);

		gf.println("Updated Successfully.");

		return 0;
	}

	private int option2() {
		int option = 0;
		while (true) {
			option = option2(option);
			if (option == size)
				return 0;
		}
	}

	private int option2(int option) {
		switch (option) {
		case 0:
			gf.println("Choose book you wish to add copies to:");
			size = mb.displayBooks(conn, "tbl_book");
			if (size == 0) {
				gf.println("No books to display. Quitting to menu.");
				return 0;
			}
			gf.println(size + ") Quit to cancel operation.");
			option = gf.integerCondition();
			option = gf.getTableByIndex(conn, "tbl_book", option);
			break;
		default:

			int noOfCopies = mb.numberOfCopies(conn, option, brachId);
		
			gf.println("Existing number of copies: " + noOfCopies);
			gf.println("Enter new number of copies:");
			try {
				noOfCopies += Integer.parseInt(gf.stringCondition());
			} catch (NumberFormatException e) {
				gf.println("Invalid integer input. Quitting to menu.");
				return size;
			}
			mb.updateNoOfCopies(conn, option, brachId, noOfCopies);
			option = size;
			break;
		}
		return option;
	}
}
