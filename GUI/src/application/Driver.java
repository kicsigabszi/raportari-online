package application;

import javafx.beans.NamedArg;

public class Driver {
	private final String cnp;
	private final String value;
	
	public Driver(@NamedArg("value") String value, @NamedArg("cnp") String cnp)
	{
		this.cnp = cnp;
		this.value = value;
	}
	
	public String getCnp()
	{
		return this.cnp;
	}
	
	public String getValue() 
	{
        return this.value;
    }
}
