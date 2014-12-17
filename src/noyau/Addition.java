package noyau;

import java.io.Serializable;

public class Addition extends OperationBinaire {


	@Override
	double eval() throws CaseNonAttribue
	{
		if (gauche==null || droite==null)
		{
			throw new CaseNonAttribue();
		}
		else
		{
			return gauche.getValeur()+droite.getValeur();
		}

	}

	public Addition(Case g, Case d) 
	{
		super (g,d);
	}

	public String monToString(String langue)
	{
		return gauche.getNom()+" + "+droite.getNom();
	}
	
	public String toStringBis(String langue)
	{
		String res="";
		res="("+gauche.getContentDev2(langue)+" + "+droite.getContentDev2(langue)+")";
		return res;
	}
	
}
