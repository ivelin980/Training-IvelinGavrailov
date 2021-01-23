package arraycreator;

import java.lang.reflect.Array;

public class ArrayCreator {
	@SuppressWarnings("unchecked")
	public static<T> T[] create(int length, T item) {
		return (T[])Array.newInstance(item.getClass(), length);
	}
	
	@SuppressWarnings("unchecked")
	public static<T> T[] create(Class<T> clazz, int length, T item) {
		return (T[])Array.newInstance(clazz, length);
	}
}
