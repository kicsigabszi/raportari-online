package Sheet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.xmlbeans.impl.piccolo.io.FileFormatException;

public class Excel {
	
	public ArrayList<String> readSheet(File file) throws IOException, EncryptedDocumentException, InvalidFormatException{
		
		ArrayList<String> rows = new ArrayList<String>();
		
			String fileName = file.getPath();
		
			if(!(fileName.endsWith(".xls") || fileName.endsWith(".xlsx"))) { 
	            throw new FileFormatException(); 
			} else {
				
				Workbook workbook = WorkbookFactory.create(file);
				Sheet sheet = workbook.getSheetAt(0);
				DataFormatter dataFormatter = new DataFormatter();
				
				String rowText;
				//Iterate the Sheet
				for (Row row: sheet) {
				
					rowText = "";
				
		            for(Cell cell: row) {
		            
		                String cellValue = dataFormatter.formatCellValue(cell);
		                rowText += cellValue.trim();
		            }
		            
		            rowText = rowText.trim();
		            if(rowText.length() > 0) rows.add(rowText);
		        }
				
				workbook.close();
				return rows;
			}
		
	}

}
