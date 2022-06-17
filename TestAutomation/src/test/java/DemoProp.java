import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DemoProp {
	public static void main(String[] args) throws IOException {

		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\config.properties");
		prop.load(fis);
		String u_Name = prop.getProperty("username");
		System.out.println(u_Name);
		System.out.println(prop.getProperty("url"));
		System.out.println(prop.getProperty("pssword"));
	}
}
