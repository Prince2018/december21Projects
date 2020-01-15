package keyworddriventokbird;import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;import org.apache.poi.xssf.usermodel.XSSFWorkbook;import org.apache.poi.xssf.usermodel.XSSFCell;
public class ReadExcelData{
 private static XSSFSheet ExcelWSheet;private static XSSFWorkbook ExcelWBook; private static XSSFCell Cell; 
 public static void setExcelFile(String Path,String SheetName) throws Exception  //This method is to set the File path and to open the Excel file,Pass Excel Path and SheetName as Arguments to this method
 {FileInputStream ExcelFile = new FileInputStream(Path);ExcelWBook = new XSSFWorkbook(ExcelFile);
 ExcelWSheet = ExcelWBook.getSheet(SheetName);}
 public static String getCellData(int RowNum, int ColNum) throws Exception////This method is to read the test data from the Excel cell.In this we are passing parameters/arguments as Row Num and Col Num
 {Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);String CellData = Cell.getStringCellValue();return CellData;}}
 //https://dzone.com/articles/building-a-data-driven-keyword-driven-and-hybrid-s