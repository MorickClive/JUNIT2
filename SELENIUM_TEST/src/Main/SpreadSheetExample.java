package Main;

import org.junit.Test;
import Main.SpreadSheetReader;

import java.util.List;

public class SpreadSheetExample {

    @Test
    public void spreadSheet(){
    	System.out.println("Test");
    	System.out.println(System.getProperty("user.dir") + "\\res\\testDetails.xlsx");
    	
        SpreadSheetReader sheetReader = new SpreadSheetReader(System.getProperty("user.dir") + "\\res\\testDetails.xlsx");
        List<String> row = sheetReader.readRow(1, "Inputs");
        
	    for(String cell : row){
	        System.out.println(cell);
	    }
    	System.out.println("end");
    }


}
