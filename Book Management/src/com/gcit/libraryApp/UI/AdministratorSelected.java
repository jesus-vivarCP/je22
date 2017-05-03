package com.gcit.libraryApp.UI;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;

import com.gcit.libraryApp.Administrator.Admin;
import com.gcit.libraryApp.GenericFunction.GenericFunctions;

public class AdministratorSelected {
	private Connection conn;
	private GenericFunctions gf;
	private Admin admin;

	private enum Menu {
		BOOK_AND_AUTHOR, PUBLISHER, LIBRARY_BRANCHES, BORROWERS
	};

	private Map<String, ArrayList<String>> args;
	private Map<String, ArrayList<String>> values;

	public AdministratorSelected(Connection conn, GenericFunctions gf) {
		this.conn = conn;
		this.gf = gf;

		admin = new Admin(conn, gf);
		args = new HashMap<String, ArrayList<String>>();
		values = new HashMap<String, ArrayList<String>>();
	}

	public int adminMenu() {
		int option = 0;
		while (true) {
			option = menu(option);
			if (option == 5)
				break;
		}
		args.clear();
		values.clear();
		return 0;
	}

	private int menu(int option) {
		switch (option) {
		case 1:
			String table = tableNameOptions("ADD");
			option = toAdd(table);

			gf.println("Adding.... Sucessful");
			values.clear();
			args.clear();
			break;
		case 2:
			String table1 = tableNameOptions("UPDATE");
			String[] to_update = table1.split(" ");
			for (String update : to_update)
				option = requiredInformation(update, "UPDATE");

			gf.println("Updating.... Sucessful");
			values.clear();
			args.clear();
			break;
		case 3:
			String table2 = tableNameOptions("DELETE");
			String[] to_delete = table2.split(" ");
			for (String delete : to_delete)
				option = requiredInformation(delete, "DELETE");

			gf.println("Deleting.... Sucessful");
			values.clear();
			args.clear();
			break;
		case 4:
			String table3 = "tbl_book_loans";
			option = requiredInformation(table3, "OVERRIDE");

			gf.println("Override.... Sucessful");
			values.clear();
			args.clear();
			break;
		default:
			gf.println("Administration options:");
			gf.println("1) Add");
			gf.println("2) Update");
			gf.println("3) Delete");
			gf.println("4) Override book due date");
			gf.println("5) Quit to previous");
			try {
				option = Integer.parseInt(gf.stringCondition());
			} catch (InputMismatchException | NumberFormatException e) {
				gf.println("Invalid input. Quitting to menu");
				option = 5;
			}
			break;
		}

		return option;
	}

	private int toAdd(String table) {
		ArrayList<String> temp, temp2;
		String[] to_add = table.split(" ");

		admin.getColumnNames(table, args, values);
		gf.println("Enter values: n/a to skip");

		for (String add : to_add) {
			temp = args.get(add);
			temp2 = values.get(add);
			for (int idx = 1; idx < temp.size(); idx++) {
				gf.println(temp.get(idx) + ": ");
				String input = gf.stringCondition();
				temp2.add(input);
				if (!input.equals("n/a"))
					temp2.add(null);
			}
		}
		admin.Add(table, values, args);
		return 0;
	}

	private int requiredInformation(String table, String task) {
		ArrayList<String> list = new ArrayList<>();
		int indentification;
		String nameLabel;
		String override;

		gf.println(task + ": Enter table card/id number.");
		indentification = gf.integerCondition();
		if (indentification == 0) {
			gf.println("Invalid card/id number. Quitting to menu.");
			return 0;
		}
		nameLabel = getIndentificationLabel(task);

		gf.println("Records for card/id number:" + indentification);
		gf.println("Options to: " + task);
		admin.getColumnNames(table, args, values);
		if (nameLabel.equals("other"))
			nameLabel = args.get(table).get(0);

		int valid = gf.viewTable(conn, table, indentification, nameLabel);
		if (valid != 0) {
			gf.println("No record found. Quitting to Menu.");
			gf.println("");
			return 0;
		}

		override = gf.stringCondition();

		int success = 0;
		list.add(indentification + "");
		list.add(table);
		list.add(nameLabel);
		list.add(override);
		list = admin.taskAtTableLocation(conn, task, list, args.get(table));
		if (list == null) {
			gf.println("Quitting to Menu");
			return 0;
		}
		values.put(table, list);

		if (task.equals("UPDATE")) {
			getArguments(table);
			success = admin.Update(table, args.get(table), values.get(table));
		}

		return success;
	}

	private String getIndentificationLabel(String task) {
		switch (task) {
		case "OVERRIDE":
			return "cardNo";
		default:
			return "other";
		}
	}

	public void getArguments(String table) {
		ArrayList<String> temp = new ArrayList<String>();
		gf.println("Enter column values for: n/a to skip");

		int size = args.get(table).size();
		temp.add(values.get(table).get(0));

		for (int idx = 1; idx < size; idx++) {
			gf.println(args.get(table).get(idx) + ": ");

			String val = gf.stringCondition();
			temp.add(values.get(table).get(idx));
			if (!val.equals("n/a"))
				temp.add(val);
			
		}
		values.put(table, temp);
	}

	public String tableNameOptions(String tag) {
		int option = 0;
		String table;

		gf.println(tag);
		for (Menu select : Menu.values())
			gf.println((select.ordinal() + 1) + ") " + select);
		gf.println("\n");

		while (true) {
			table = getTableName(option);
			if (!table.equals("Not valid option"))
				break;
			else
				option = gf.integerCondition();
		}

		return table;
	}

	public String getTableName(int option) {
		String table;

		switch (option) {
		case 1:
			table = "tbl_book tbl_author";
			break;
		case 2:
			table = "tbl_publisher";
			break;
		case 3:
			table = "tbl_library_branch";
			break;
		case 4:
			table = "tbl_borrower";
			break;
		case 5:
			table = "tbl_book_loans";
			break;
		default:
			table = "Not valid option";
			break;
		}
		return table;
	}
}
