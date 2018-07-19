package com.greensize.develop.reportgenerator;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.greensize.develop.reportgenerator.util.ReportUtil;
import com.greensize.develop.reportgenerator.util.SchemaUtil;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReportUtilTests {

	String data;
	LinkedHashMap<String, Object> mapData;

	@Before
	public void setup() throws IOException {
		data = "{\"1\":{\"number\":\"1\",\"resource\":\"orlando\",\"client\":\"OPENMOBILE\",\"project\":\"Open api\",\"activity\":\"Soporte\",\"dateBegin\":\"8:00:00\",\"dateEnd\":\"12:00:00\",\"activeHours\":\"4\",\"date\":\"12/05/2018\",\"description\":\"Deploy Open Api\",\"scheduleType\":\"NORMAL\"},\"2\":{\"number\":\"2\",\"resource\":\"orlando\",\"client\":\"SOPORTE\",\"project\":\"Soporte\",\"activity\":\"Soporte\",\"dateBegin\":\"13:00:00\",\"dateEnd\":\"17:00:00\",\"activeHours\":\"3\",\"date\":\"12/05/2018\",\"description\":\"Monitoreo y revision de recuros\",\"scheduleType\":\"NORMAL\"},\"3\":{\"number\":\"1\",\"resource\":\"luis\",\"client\":\"SOPORTE\",\"project\":\"Soporte\",\"activity\":\"Soporte\",\"dateBegin\":\"8:00:00\",\"dateEnd\":\"12:00:00\",\"activeHours\":\"4\",\"date\":\"12/05/2018\",\"description\":\"Monitoreo y revision de recuros\",\"scheduleType\":\"NORMAL\"}}";
		mapData = new ObjectMapper().readValue(data, new TypeReference<LinkedHashMap<String, Object>>(){});
	}

	@Ignore
	@Test
	public void contextLoads() {
	}

	@Test
	public void showData() {
		final String[] headerData = {""};
		for (Map.Entry<String, Object> header : SchemaUtil.getHeaderContext().entrySet()) {
			headerData[0] += ((Map<String, Object>) header.getValue()).get("labelData").toString();
			headerData[0] += "\t\t";
		}
		System.out.println(headerData[0]);

		final String[] rowData = {""};
		for (Map.Entry<String, Object> row : mapData.entrySet()) {
			((Map<String, Object>) row.getValue()).entrySet().forEach(column -> {
				rowData[0] += column.getValue();
				rowData[0] += "\t\t";
			});

			rowData[0] += "\n";
		}
		System.out.println(rowData[0]);
	}

	@Test
	public void writeReport() {
		ReportUtil.writeDefaultreport(mapData);
	}
}
