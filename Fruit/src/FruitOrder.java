import java.util.*;

public class FruitOrder {

	public static void main(String[] args) {


		Set mySet = new HashSet();

		// Ensure that this set contains an interesting selection of fruit

		String fruit1 = "pear", fruit2 = "banana", fruit3 = "tangerine",

		fruit4 = "strawberry", fruit5 = "blackberry";

		mySet.add( fruit1 );
		mySet.add( fruit2 );
		mySet.add( fruit3 );
		mySet.add( fruit2 );
		mySet.add( fruit4 );
		mySet.add( fruit5 );

		// Display contents of mySet

		System.out.println( "mySet now contains:" );

		System.out.println( mySet );
		System.out.println( "Number of elements in myset: " + mySet.size());
		
		System.out.println("Removing element: blackberry...");
		mySet.remove("blackberry");
		System.out.println( mySet );
		
		System.out.println("Removing element: strawberry...");
		mySet.remove("strawberry");
		System.out.println( mySet );
		
		System.out.println("Removing all element from my set...");
		mySet.clear();
		System.out.println( mySet );
		
		System.out.println("mySet is empty: " + mySet.isEmpty());
		
		
		System.out.println("Myset with iterator...");
		ArrayList<String> myIter = new ArrayList<>();
		
		myIter.add( "pear" );
		myIter.add( "bananna" );
		myIter.add( "tangerine" );
		myIter.add( "strawberry" );
		myIter.add( "blackberry" );
		
		Iterator itr = myIter.iterator();
		
		while ( itr.hasNext() ) {
			System.out.print(itr.next() + " ");
		}
		
		ListIterator litr =  myIter.listIterator();
		
		System.out.println("\n");
		
		while ( litr.hasNext() ) {
			litr.next();
		}
		
		while( litr.hasPrevious() ) {
			System.out.print(litr.previous() + " ");
		}
		System.out.println("\n");
		
		while ( litr.hasNext() ) {
			Object element = litr.next();
			
			if ( element.equals("tangerine")) 
				litr.add("bananna");
		}
		
		while ( litr.hasPrevious())
			litr.previous();
		
		while( litr.hasNext() ) {
			System.out.print(litr.next() + " ");
		}
		
	
	}

}
