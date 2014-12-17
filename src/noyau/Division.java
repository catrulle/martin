package noyau;

public class Division extends OperationBinaire{

	@Override
	double eval() throws CaseNonAttribue
	{
		if (gauche==null || droite==null)
		{
			throw new CaseNonAttribue();
		}
		else
		{
			double res;
			if (droite.getValeur()==0.0)
			{
				res=Double.NaN;
			}
			else
			{
				res= gauche.getValeur()/droite.getValeur();
			}
			return res;
		}
	}
	
	public Division(Case g, Case d) 
	{
		super (g,d);
	}
	
	public String monToString(String langue)
	{
		return gauche.getNom()+" / "+droite.getNom();
	}

	public String toStringBis(String langue)
	{
		String res="";
		res="("+gauche.getContentDev2(langue)+" / "+droite.getContentDev2(langue)+")";
		return res;
	}

}
