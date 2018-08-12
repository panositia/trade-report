package org.panos.engine.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Utilities class.
 * 
 * @author panos
 */
public class Util {

	public static String getEngineVersion() {
		String currentVersion = "X";

		Properties mavenProp = new Properties();
		InputStream is = Util.class.getResourceAsStream("/META-INF/maven/org.panos.tradereport/trade-report-engine/pom.properties");
		try {
			mavenProp.load(is);
			currentVersion = mavenProp.getProperty("version");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return currentVersion;
	}

}
