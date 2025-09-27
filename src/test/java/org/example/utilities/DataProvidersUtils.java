package org.example.utilities;

import org.testng.annotations.DataProvider;
import java.io.IOException;

public class DataProvidersUtils {

    // DataProvider 1
    @DataProvider(name = "LoginData")
    public String[][] getData() throws IOException {
        String path = "testData/Opecart_LoginData.xlsx"; // taking xl file from testData

        ExcelUtil xlutil = new ExcelUtil(path); // creating an object for XLUtility

        int totalRows = xlutil.getRowCount("Sheet1");
        int totalCols = xlutil.getCellCount("Sheet1", 1);

        // created 2D array to store Excel data
        String[][] loginData = new String[totalRows][totalCols];

        // read data from Excel and store in 2D array
        for (int i = 1; i <= totalRows; i++) { // starting from row 1 (row 0 is header usually)
            for (int j = 0; j < totalCols; j++) {
                loginData[i - 1][j] = xlutil.getCellData("Sheet1", i, j);
            }
        }
        return loginData; // returning 2D array
    }
}

