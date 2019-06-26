package test.hwj.a1b9;

import test.hwj.utils.Debug;

import java.io.FileOutputStream;
import java.net.URL;

/**
 * @author hwj
 * @date 2019/4/21 19:56
 */
public class FileDownloader implements Runnable {
	private final String fileURL;

	public FileDownloader(String fileURL) {
		this.fileURL = fileURL;
	}

	@Override
	public void run() {
		Debug.info("Downloading from " + fileURL);
		String fileBaseName = fileURL.substring(fileURL.lastIndexOf('/') + 1);
		try {
			URL url = new URL(fileURL);
			String localFileName = System.getProperty("java.io.tmpdir") + "viscent-" + fileBaseName;
			Debug.info("Saving to: " + localFileName);
			downloadFile(url, new FileOutputStream(localFileName), 1024);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Debug.info("Down downloading from " + fileURL);
	}

	private void downloadFile(URL url, FileOutputStream fileOutputStream, int i) {

	}
}
