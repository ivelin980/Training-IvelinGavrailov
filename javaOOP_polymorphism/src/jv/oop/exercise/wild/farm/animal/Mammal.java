package jv.oop.exercise.wild.farm.animal;

public abstract class Mammal extends Animal {
	private String livingRegion;

	public Mammal(String animalName, String animalType, double animalWeight, String livingRegion) {
		super(animalName, animalType, animalWeight);
		setLivingRegion(livingRegion);
	}

	public String getLivingRegion() {
		return livingRegion;
	}

	protected void setLivingRegion(String livingRegion) {
		this.livingRegion = livingRegion;
	}

	@Override
	public String toString() {
		return String.format("%s[%s,%.1f,%s,%d]", this.getClass().getSimpleName(), super.getAnimalName(),
				super.getAnimalWeight(), this.getLivingRegion(), super.getFoodEaten());
	}
}
