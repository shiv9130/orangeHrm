package GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class propertyUtilityHrm {
	
	public String propUtil(String key) throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\Nis\\automation\\HrmAutomationTesting\\src\\main\\resources\\Browseredgehrm.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String data = prop.getProperty(key);
		return data ;
	}

}
