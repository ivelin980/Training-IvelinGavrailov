package jar;

/**
 * @author Ivelin Gavrailov
 * @since 27.10.2020
 * 
 *        Create a class Jar<> that can store anything. It should have two
 *        public methods: • void add(element) • element remove() Adding should
 *        add on top of its contents. Remove should get the topmost element.
 * 
 */
public class Main {

	public static void main(String[] args) {
		Jar<Integer> jar = new Jar<>();
		jar.add(11);
		jar.add(21);
		jar.add(31);
		jar.add(41);
		System.out.println(jar.remove());
	}
}
