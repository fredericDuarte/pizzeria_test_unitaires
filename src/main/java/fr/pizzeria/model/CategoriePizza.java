package fr.pizzeria.model;

public enum CategoriePizza {

	VIANDE("Viande"), POISSON("Poisson"), SANS_VIANDE("Sans Viande");

	private String catName;

	private CategoriePizza(String catName) {
		this.catName = catName;
	}

	@Override
	public String toString() {
		return catName;
	}

}
