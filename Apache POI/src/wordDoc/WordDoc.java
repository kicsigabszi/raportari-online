package wordDoc;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.OLE2NotOfficeXmlFileException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;   
import org.apache.poi.xwpf.usermodel.XWPFParagraph;   
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.poi.hwpf.usermodel.TableCell;
import org.apache.poi.hwpf.usermodel.Table;
import org.apache.poi.hwpf.usermodel.TableRow;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.Range;

import org.apache.xmlbeans.impl.piccolo.io.FileFormatException;   
  public class WordDoc {   
   
    public ArrayList<ArrayList> readTables(String fileName) { 
    	
    	ArrayList<ArrayList> tableList = new ArrayList<ArrayList>(); 
        try { 
                if(!(fileName.endsWith(".doc") || fileName.endsWith(".docx"))) { 
                        throw new FileFormatException(); 
                } else { 
                		                	 	              
                		try {
                			XWPFDocument doc = new XWPFDocument(new
                				    FileInputStream(fileName));
                			List<XWPFTable> table = doc.getTables();        
                            for (XWPFTable xwpfTable : table) {
                            		ArrayList<ArrayList<String>> tableInstance = new ArrayList<ArrayList<String>>(); 
        							List<XWPFTableRow> row = xwpfTable.getRows();
        							int i = 0;
        							for (XWPFTableRow xwpfTableRow : row) 
        							{
        								List<XWPFTableCell> cell = xwpfTableRow.getTableCells();
        								tableInstance.add(new ArrayList<String>());
        								for (XWPFTableCell xwpfTableCell : cell) 
        								{
        									
        									if(xwpfTableCell!=null)
        									{
        										tableInstance.get(i).add(xwpfTableCell.getText());
        										System.out.println(xwpfTableCell.getText());        										
        									}        								
        								}
        								i++;
        							}
        							tableList.add(tableInstance);
                            	}
                                                        
                		}
                		catch(OLE2NotOfficeXmlFileException e)
                		{
                			HWPFDocument doc = new HWPFDocument(new
                				    FileInputStream(fileName));
                			Range range = doc.getRange(); 
                		    for (int i=0; i<range.numParagraphs(); i++)
                		    { 
                		    	try
                		    	{
                		    		Paragraph tablePar = range.getParagraph(i);
                		    		if (tablePar.isInTable()) {  
                    		            Table table = range.getTable(tablePar);
                    		            
                    		            ArrayList<ArrayList<String>> tableInstance = new ArrayList<ArrayList<String>>();
                    		            for (int rowIdx=0; rowIdx<table.numRows(); rowIdx++) 
                    		            {  
                    		            	TableRow row = table.getRow(rowIdx);
                    		            	tableInstance.add(new ArrayList<String>());
                    		                for (int colIdx=0; colIdx<row.numCells(); colIdx++) {  
                    		                    TableCell cell = row.getCell(colIdx);  
                    		                    tableInstance.get(rowIdx).add(cell.getParagraph(0).text());
                    		                    //System.out.println("column="+cell.getParagraph(0).text());  
                    		                }  
                    		            }
                    		            tableList.add(tableInstance);
                    		        }
                		    	}
                		    	catch(java.lang.IllegalArgumentException ie){}
                		    } 
                		}                		                                                           
                	}
        } catch(FileFormatException e) { 
                e.printStackTrace(); 
        } catch (FileNotFoundException e) { 
                e.printStackTrace(); 
        } catch (IOException e) { 
                e.printStackTrace(); 
                
        } catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
        } 
       
        return tableList;	
      }	
    
    public ArrayList<String> readParagraphs(File file) { 
    	
    	String fileName = file.getPath();
    	
    	ArrayList<String> pgpList = new ArrayList<String>(); 
    	try { 
            if(!(fileName.endsWith(".doc") || fileName.endsWith(".docx"))) { 
                    throw new FileFormatException(); 
            } 
            else { 
            	
	            try {
	        		XWPFDocument doc = new XWPFDocument(new
				    FileInputStream(fileName));
	        		List<XWPFParagraph> paragraphList =  doc.getParagraphs();
	        		
	        		for (XWPFParagraph paragraph: paragraphList){
	        			String text = paragraph.getText().trim();
	        			if(text.length() > 0) pgpList.add(text);
	            	}
	                                        
				}
				catch(OLE2NotOfficeXmlFileException e)
				{
		                if(!(fileName.endsWith(".doc") || fileName.endsWith(".docx"))) { 
		                        throw new FileFormatException(); 
		                } 
		                else { 
		
		        			HWPFDocument doc = new HWPFDocument(new
		        				    FileInputStream(fileName));
		        			Range range = doc.getRange(); 
		        		    for (int i=0; i<range.numParagraphs(); i++)
		        		    { 
		        		    	try
		        		    	{
		        		    		Paragraph par = range.getParagraph(i);
		        		    		
		        		    		String text = par.text().trim();
		        		    		
		            		        if(text.length() > 0) pgpList.add(text);
		            		        
		        		    	}
		        		    	catch(java.lang.IllegalArgumentException ie){}
		        		    } 
		        		}  
				}
            }
        } catch(FileFormatException e) { 
                e.printStackTrace(); 
        } catch (FileNotFoundException e) { 
                e.printStackTrace(); 
        } catch (IOException e) { 
                e.printStackTrace(); 
                
        } catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
        } 
       
        return pgpList;	
      }	
    
    public ArrayList<String> getTableImplodedRows(File file)
    {
    	   
		ArrayList<ArrayList> tableList = this.readTables(file.getPath());
		 //TODO
		 int a = 1;
		 String rowText = "";
		 ArrayList<String> rows = new ArrayList<String>();
		 
		for(ArrayList<ArrayList> tableInstance : tableList){
			for(ArrayList<String> tableRow : tableInstance){
				for(String str : tableRow) {
					str = str.trim();
					if(str.length() > 0) rowText += " "+str;
				}
				
				rowText = rowText.trim();
				
				if(rowText.length() > 0) rows.add(rowText);
				rowText = "";
			}
			
		}
		
		return rows;
    }
  } 