package automationFramework;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Person {
	private SimpleStringProperty name ;
	private SimpleIntegerProperty numb ;
	
	public Person() {
		this(0,null);
	}
	
	public Person(int i, String s) {
		name = new SimpleStringProperty(s);
		numb = new SimpleIntegerProperty(i);
	}
	
	
	public String getName() {
		return name.get();
	}
	
	public SimpleStringProperty getPropertyName() {
		return name;
	}
	
    public void setName(String s) {
    	name.set(s);
    }
    
    public Integer getNumb() {
		return numb.get();
	}
    
    public SimpleIntegerProperty getPropertyNumb() {
		return numb;
	}
	
    public void setNumb(int s) {
    	numb.set(s);
    }

    @Override
    public String toString() {
    	return name.get();
    }

}
