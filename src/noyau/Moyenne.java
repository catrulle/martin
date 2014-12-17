package noyau;

import java.util.List;

public class Moyenne extends Fonction {
	
	double eval() throws ArgumentsFonctionVide {
		double res=0;
		double cpt=0;
		if (arguments==null)
		{
			throw new ArgumentsFonctionVide();
		}
		for (Case x :arguments)
		{
			res=res + x.getValeur();
			cpt=cpt+1;
		}
		return res/cpt;
	}
	
	public Moyenne(List<Case> arg)
	{
		super (arg);
	}
	
	
	public String monToString(String langue)
	{
		String res ;
		if (langue=="anglais")
		{
			res = "Mean (";
		}
		else 
		{
			res = "Moyenne (";
		}
		return res+super.toString()+")";
	}
	
	public String toStringBis(String langue)
	{
		String res ;
		if (langue=="anglais")
		{
			res = "Mean (";
		}
		else 
		{
			res = "Moyenne (";
		}
		return res+super.toStringBis(langue)+")";
	}
	
}
