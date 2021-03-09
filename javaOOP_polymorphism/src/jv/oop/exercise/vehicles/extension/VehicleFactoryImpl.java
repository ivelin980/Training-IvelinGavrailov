package jv.oop.exercise.vehicles.extension;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class VehicleFactoryImpl implements VehicleFactory{

	@Override
	public Vehicle createVehicle(String type, double fuelQuantity, double fuelConsumption, double tankCapacity) {
				try {
					Class<?> clazz = Class.forName("jv.oop.exercise.vehicles.extension" + "." + type);
					Constructor<?> constructor = clazz.getConstructor(double.class,double.class,double.class);
					return (Vehicle) constructor.newInstance(fuelQuantity,fuelConsumption,tankCapacity);
				} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
						| InvocationTargetException | NoSuchMethodException | SecurityException | ClassNotFoundException e) {
					e.printStackTrace();
				}
		return null;
	}

}
