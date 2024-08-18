package com.mtk.poi.Helper;

import java.util.List;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import com.mtk.poi.Model.Category;

public class Helper {
    /*
     * 
     * Apache POI is used to read/write Excel files.
       ByteArrayOutputStream is used to convert the workbook into a byte array.
       ByteArrayInputStream is used to read the byte array as an input stream for further processing.
            */

    public static String[] HEADERS = {
        "id",
        "title",
        "description"
    };

    public static String SHEET_NAME = "category";

    public static ByteArrayInputStream dataToExcel(List<Category> list) throws IOException {

        //create Work Book
        Workbook workbook = new XSSFWorkbook();
        ByteArrayOutputStream out = new ByteArrayOutputStream();


        try{
            //create sheet
            Sheet sheet = workbook.createSheet(SHEET_NAME);

            //create row
            Row row = sheet.createRow(0);

            for(int i=0; i < HEADERS.length;i++){
                Cell cell = row.createCell(i);
                cell.setCellValue(HEADERS[i]);
            }

            //value rows

            int rowIndex = 1;
            for(Category c: list){

                Row dataRow = sheet.createRow(rowIndex);
                rowIndex++;

                dataRow.createCell(0).setCellValue(c.getCategoryId());
                dataRow.createCell(1).setCellValue(c.getTitle());
                dataRow.createCell(2).setCellValue(c.getDescription());


            }
            workbook.write(out);


            return new ByteArrayInputStream(out.toByteArray());
            


        }catch(IOException e){
            e.printStackTrace();
            System.out.println("fail to import data excel");
        } finally {
            workbook.close();
            out.close();
        }



        return null;



    }




    
}
