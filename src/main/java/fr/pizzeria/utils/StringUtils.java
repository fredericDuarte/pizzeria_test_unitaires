package fr.pizzeria.utils;

public class StringUtils {
	
	private String chaine;
	
	StringBuilder builder;
	
	public StringUtils() {
		this.chaine = "";
		this.builder = new StringBuilder();
	}
	
	public StringBuilder concate (String chaine)
	{
		return builder.append(chaine);
	}



}
