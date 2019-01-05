package automationFramework;

public class Document {
	private String id;
	private static String codFiscal = "RO3494286";
	private String nrDocControl;
	private String nrFoaie;
	private String nrCirculatie;
	private String dataTransport;
	private static Document instance;
	
	public Document(){
		
	}
	
	public static Document getInstance(){
        if(instance == null){
            instance = new Document();
        }
        return instance;
    }
	
	public Document(String nrDoc, String nrFoaie, String nrCirc, String dataTransport) {
		instance = Document.getInstance();  
		instance.nrDocControl = nrDoc;
		instance.nrFoaie = nrFoaie;
		instance.nrCirculatie = nrCirc;
		instance.dataTransport = dataTransport;
	}
	
	public Document(String id, String nrDoc, String nrFoaie, String nrCirc, String dataTransport) {
		instance = Document.getInstance();
		instance.id = id;
		instance.nrDocControl = nrDoc;
		instance.nrFoaie = nrFoaie;
		instance.nrCirculatie = nrCirc;
		instance.dataTransport = dataTransport;
	}
	
	public String getId() {
		return instance.nrDocControl;
	}
	
	public void setId(String id) {
		instance.id = id;
	}
	
	public String getNrDocControl() {
		return instance.nrDocControl;
	}
	
	public String getNrFoaie() {
		return instance.nrFoaie;
	}
	
	public String getNrCirculatie() {
		return instance.nrCirculatie;
	}
	
	public String getDataTransport() {
		return instance.dataTransport;
	}
	
	public static String getCodFiscal() {
		return Document.codFiscal;
	}

}

