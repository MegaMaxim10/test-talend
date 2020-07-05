package dimsoft.testtalend.app.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;

import javax.ws.rs.core.HttpHeaders;

import org.joda.time.DateTime;

import dimsoft.testtalend.app.dao.TestStagiaire1Dao;

public class Util {
	public static String 
			CLIENT_ID_KEY = "TcWlVp4QhnscuHn182TFXHeX7ph8fqwm8IHNOxyEQtzTRs4udppKpGC7HOXljVek",
			CLIENT_ID = "gMnW0SpOnVgoHC4gtsElPAmEwRnVWehOLcfRU3wTiGVlpFq4hmVQPrBBh1AQrWi-)-N8UfnhnIvBgT8NpCu8SB2h7drGYwiIUY2cOz0Kwye69JGtCU2h0FfT65QgctMLR2h0TTpZtH-)-BYAM2IQHUyWHtt2yAEXkyOZln005AYjqOwb-@",
			TOKEN_KEY = "TestTalendToken";

	public static boolean isRequestValid(HttpHeaders httpHeaders){
		String appId = httpHeaders.getHeaderString(CLIENT_ID_KEY);
		//return appId != null && CLIENT_ID.equals(appId);
		return true;
	}
	
	public static boolean isTokenValid(HttpHeaders httpHeaders, TestStagiaire1Dao userDao, String ... rights){
		String token = httpHeaders.getHeaderString(TOKEN_KEY);
		return token != null;
	}
	
	public static void uploadFile () {
		
	}
	
	/**
	 * Cette méthode permet de créer un dossier s'il n'existe pas encore
	 */
	public static void createFolderIfNotExists(String dirName) throws SecurityException {
		File theDir = new File(dirName);
		if (!theDir.exists()) {
			theDir.mkdirs();
		}
	}
	
	/**
	 * Utility method to save InputStream data to target location/file
	 */
	public static void saveToFile(InputStream inStream, String target) throws IOException {
		OutputStream out = null;
		int read = 0;
		byte[] bytes = new byte[1024];
		out = new FileOutputStream(new File(target));
		while ((read = inStream.read(bytes)) != -1) {
			out.write(bytes, 0, read);
		}
		out.flush();
		out.close();
	}

	public static String generateToken() {
		Random rand = new Random();
		String token = "";
		for (int i=0; i < 50; i++) {
			char c = (char)(rand.nextInt(26) + 97);
			token += c;
		}
		return token + DateTime.now().getMillisOfDay();
	}
	
	/**
	 * Fonction permettant de nettoyer une chaine de caractere
	 */
	public static String linearized (String string) {
		return string;
	}
	
}
