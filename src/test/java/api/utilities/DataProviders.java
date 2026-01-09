package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviders {
	@DataProvider(name = "Data")
	public String[][] getAllData() throws IOException {
		String path = System.getProperty("user.dir") + "//TestData//TestData.xlsx";
		ExcelUtility xlutility = new ExcelUtility(path);
		int rownum = xlutility.getRowCount("Sheet1");
		int colCount = xlutility.getCellCount("Sheet1", 1);
		String apiData[][] = new String[rownum][colCount];

		for (int i = 1; i <=rownum; i++) {
			for (int j = 0; j < colCount; j++) {
				apiData[i - 1][j] = xlutility.getCellData("Sheet1", i, j);

			}
		}
		return apiData;
	}
	@DataProvider(name="Usernames")
	public String[] getUserNames() throws IOException {
		String path = System.getProperty("user.dir") + "//TestData//TestData.xlsx";
		ExcelUtility xlutility = new ExcelUtility(path);
		int rownum = xlutility.getRowCount("Sheet1");
		String apiData[] = new String[rownum];

		for (int i = 1; i <= rownum; i++) {
			apiData[i - 1] = xlutility.getCellData("Sheet1", i, 1);
		}

		return apiData;

	}

}
