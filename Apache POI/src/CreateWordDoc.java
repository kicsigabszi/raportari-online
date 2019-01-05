//package org.poi.images;

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
  public class CreateWordDoc {   
    public void newWordDoc(String filename, String fileContent)   
         throws Exception {   
       XWPFDocument document = new XWPFDocument();   
       XWPFParagraph tmpParagraph = document.createParagraph();   
       XWPFRun tmpRun = tmpParagraph.createRun();   
       tmpRun.setText(fileContent);   
       tmpRun.setFontSize(18);   
       
       XWPFParagraph tmpParagraph2 = document.createParagraph();   
       XWPFRun tmpRun2 = tmpParagraph2.createRun();   
       tmpRun2.setText("Alma a fa alatt, nyari piros alma!!!");   
       tmpRun2.setFontSize(30);  
       tmpRun2.setColor("ff0000");
       
       FileOutputStream fos = new FileOutputStream(new File("E:\\Java\\"+filename + ".doc"));   
       document.write(fos);   
       fos.close();   
       document.close();
    }
    
    public void readTables(String fileName) { 
    	
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
                		    int j = 0;
                            j++;
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
       
      }	    
  } 