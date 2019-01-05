package application;


import javafx.beans.NamedArg;

public class Bus {
	private final String nrInmatriculare;
	private final String value;
	private final int nrLocuri;
	
	public Bus(@NamedArg("value") String value, @NamedArg("nrinmatriculare") String nrInmatriculare, @NamedArg("nrlocuri") String nrLocuri)
	{
		this.nrInmatriculare = nrInmatriculare;
		this.nrLocuri = Integer.parseInt(nrLocuri);
		this.value = value;
	}
	
	public String[] getNrInmatriculare()
	{
		String [] arrOfStr = this.nrInmatriculare.split("-");
		return arrOfStr;
	}
	
	public int getNrLocuri()
	{
		return this.nrLocuri;
	}
	
	public String getValue() 
	{
        return this.value;
    }
}
