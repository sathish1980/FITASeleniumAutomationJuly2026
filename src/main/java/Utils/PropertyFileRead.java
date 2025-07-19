package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileRead {

	String filepath=System.getProperty("user.dir")+"\\Env\\envProperties.properties";
	
	public Properties GetEnvPropertyData() throws IOException
	{
		File F = new File(filepath);
		FileInputStream Fs = new FileInputStream(F);
		Properties P = new Properties();
		P.load(Fs);
		return P;
	}
}
