package utilities;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.DataProvider;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReadXLSData {
    public static Properties properties = new Properties();

    @DataProvider(name="openg2pdata")
    public String[][] getData(Method m) throws IOException {
        String excelSheetName = m.getName();
        FileInputStream propertyFileInput = new FileInputStream("testconfig/configfile/config.properties");
        properties.load(propertyFileInput);
        propertyFileInput.close();


        String testDataFilePath = properties.getProperty("testdatafilepath");
        File file = new File(testDataFilePath);

        FileInputStream fileinputstream = new FileInputStream(file);
         Workbook wb = WorkbookFactory.create(fileinputstream);
        Sheet sheetName = wb.getSheet(excelSheetName);


        int totalRows = sheetName.getLastRowNum();
        System.out.println(totalRows);
        Row rowCells = sheetName.getRow(0);
        int totalCols = rowCells.getLastCellNum();
        System.out.println(totalCols);


        DataFormatter format = new DataFormatter();

        String[][] testData = new String[totalRows][totalCols];
        for(int i=1; i<=totalRows; i++) {
            for(int j=0; j<totalCols;j++) {
                testData[i-1][j] = format.formatCellValue(sheetName.getRow(i).getCell(j));
                System.out.println(testData[i-1][j]);
            }
        }
        return testData;
    }
}
