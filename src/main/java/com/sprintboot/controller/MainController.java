package com.sprintboot.controller;

import com.sprintboot.ftp.CamelExecutor;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.*;
import java.nio.charset.StandardCharsets;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String hello(){

		CamelExecutor executor = new CamelExecutor();

		try {
			executor.init();
		} catch (Exception e) {
			e.printStackTrace();
		}

		String server = "127.0.0.1";
		int port = 21;
		String user = "sabrina.cis";
		String pass = "Recicla7980";

		FTPClient ftpClient = new FTPClient();
		try {

			ftpClient.connect(server, port);
			ftpClient.login(user, pass);
			ftpClient.enterLocalPassiveMode();
			ftpClient.setFileType(FTP.ASCII_FILE_TYPE);

			// APPROACH #1: using retrieveFile(String, OutputStream)
/*			String remoteFile1 = "pagos.txt";
			File downloadFile1 = new File("C:\\Galicia\\FTP");
			OutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(downloadFile1));
			boolean success = ftpClient.retrieveFile(remoteFile1, outputStream1);
			outputStream1.close();

			if (success) {
				System.out.println("File #1 has been downloaded successfully.");
			}
*/
			// APPROACH #2: using InputStream retrieveFileStream(String)
			String remoteFile2 = "pagos.txt";
			//File downloadFile2 = new File("C:\\Galicia\\FTP");
			//OutputStream outputStream2 = new BufferedOutputStream(new FileOutputStream(downloadFile2));
			InputStream inputStream = ftpClient.retrieveFileStream(remoteFile2);
			//byte[] bytesArray = new byte[4096];
			//int bytesRead = -1;
			//while ((bytesRead = inputStream.read(bytesArray)) != -1) {
				//outputStream2.write(bytesArray, 0, bytesRead);
			//	System.out.println(bytesRead);
			//}
			String line;
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));

			readAllLines( bufferedReader);


			boolean success = ftpClient.completePendingCommand();
			if (success) {
				System.out.println("File #2 has been downloaded successfully.");
			}
			//outputStream2.close();
			inputStream.close();

		} catch (IOException ex) {
			System.out.println("Error: " + ex.getMessage());
			ex.printStackTrace();
		} finally {
			try {
				if (ftpClient.isConnected()) {
					ftpClient.logout();
					ftpClient.disconnect();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}



		return "hello";
	}

	public String readAllLines(BufferedReader reader) throws IOException {
		StringBuilder content = new StringBuilder();
		String line;

		while ((line = reader.readLine()) != null) {
			String[] arrayLinea = line.split(" ");
			System.out.println("arrayLinea: "+arrayLinea);

		//	JsonObject obj = elemento.getAsJsonObject();
		//	String arregloJson = JSON.stringify(arrayLinea);
		//	System.out.println("arregloJson: "+arregloJson);

		}

		return content.toString();
	}



}
