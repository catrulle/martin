package noyau;

import java.util.List;

public class Somme extends Fonction {
	
	double eval() throws ArgumentsFonctionVide {
		double res=0;
		if (arguments==null)
		{
			throw new ArgumentsFonctionVide();
		}
		for (Case x :arguments)
		{
			res=res + x.getValeur();
		}
		return res;
	}
	
	public Somme(List<Case> arg)
	{
		super (arg);
	}
	
	public String monToString(String langue)
	{
		String res ;
		if (langue=="anglais")
		{
			res = "Sum (";
		}
		else 
		{
			res = "Somme (";
		}
		return res+super.toString()+")";
	}
	
	public String toStringBis(String langue)
	{
		String res ;
		if (langue=="anglais")
		{
			res = "Sum (";
		}
		else 
		{
			res = "Somme (";
		}
		return res+super.toStringBis(langue)+")";
	}
	

	
} 
