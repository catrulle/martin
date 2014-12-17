package noyau;

import java.util.Comparator;

public class ComparateurCase implements Comparator<Case> {

	@Override
	public int compare(Case c1, Case c2) {
		// TODO Auto-generated method stub
	    if (c1.compareTo(c2) < 0)
	    {
	    	return c1.compareTo(c2);
	    }
	    else
	    {
	    	return c2.compareTo(c1);
	    }
	}

}
