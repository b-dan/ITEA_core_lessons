package FileManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FileManager {
	
	public FileManager() {
		super();
	}


	public static void dir(String path) {
		File path1 = new File(path);
		File[] filess = path1.listFiles();
		if(path1.exists()&&path1.isDirectory()) {
			List<String> files = new ArrayList<>();
			List<String> directories = new ArrayList<>();
			for(File f: filess) {
				if(f.isDirectory()){
					directories.add(f.getName().toString());
				}
				else {
					files.add(f.getName().toString());
				}


			}
			Collections.sort(directories);
			Collections.sort(files);
			directories.addAll(files);
			for(String s: directories){
				System.out.println(s);
			}
		}

		else {
			System.out.println("Wrong path entered in dir");

		}
	}
	public void fmanager() {
		File path = new File(".");
		Scanner s = new Scanner(System.in);
		String command = null;

		while(true) {
			command = s.nextLine().toLowerCase().trim();
			System.out.println(command);
			if(command==null||command=="") {
				System.out.println("Please enter the command.");
			}
			else {
				if ("dir".equals(command)) {
					dir(path.getAbsolutePath().toString());
				}

				else if("cd ..".equals(command)) {
					if(path.getAbsoluteFile().getParentFile()!=null) {
						path = path.getAbsoluteFile().getParentFile();
						System.out.println(path);
						dir(path.getAbsolutePath().toString());
					}
				}
				else if(command.startsWith("cd ")) {
					String enteredDirName = command.substring(3);
					String currentDirPath = path.getAbsolutePath();
					if(!new File(currentDirPath +"\\"+enteredDirName).exists()) {
						System.out.println("Wrong folder name!");
					}
					else {
						path = new File(currentDirPath +"\\"+enteredDirName);
						if(path.isDirectory()) {
							dir(path.getAbsolutePath().toString());
						}
						else {
							System.out.println(enteredDirName + "is not a Directory!");
							path = new File(currentDirPath);
						}

					}
				}
				else if(command.startsWith("copy")) {
					int firstSpace = command.indexOf(" ");
					System.out.println(firstSpace);
					int secondSpace = command.indexOf(" ",firstSpace+1);
					System.out.println(secondSpace);
					String 	source = command.substring(firstSpace+1,secondSpace);
					String dest = command.substring(secondSpace+1);
					System.out.println(source + "\n" + dest);
					File sourceFile = new File(source);
					File destFile = new File(dest);
					InputStream is = null;
					OutputStream os = null;
					
					try {
						is = new FileInputStream(sourceFile);
						os = new FileOutputStream(destFile);
						byte [] buffer = new byte[1024];
						int length;
						while((length = is.read(buffer))>0){
							os.write(buffer, 0 , length);
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
					finally {
						try {
							is.close();
							os.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
						
					}
					/*try {
						Files.copy(sourceFile.toPath(), destFile.toPath());
					} catch (IOException e) {
						e.printStackTrace();
					}*/
				}

			else if(command.equals("exit")) {
				s.close();
				System.out.println("Program completed");
				break;
			}
			else {
				System.out.println("Ñommand not recognized!");
				System.out.println("Try again)");
			}
		}
	}
}
}
