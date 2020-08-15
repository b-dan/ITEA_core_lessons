package FileManagerNIO;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FileManagerNIO {

	public FileManagerNIO() {
		super();
	}

	public void fmanager() {
		Path path1 = Paths.get("");
		Scanner s = new Scanner(System.in);
		String command = null;

		while(true) {
			command = s.nextLine().toLowerCase().trim();
			if(command==null||command=="") {
				System.out.println("Please enter the command");
			}
			else {
				if(command.equals("dir")) {
					System.out.println(path1.toString());
					dir(path1.toAbsolutePath().toString());
				}
				else if(command.equals("cd ..")) {
					Path path2 = path1.toAbsolutePath();
					if(path2.getParent()!=null) {
						path1 = path2.getParent();
						System.out.println(path1);
						dir(path1.toString());
					}
					else {
						System.out.println("error");
					}

				}
				else if(command.startsWith("cd ")) {
					String enteredDirName = command.substring(3);
					String currentDirPath = path1.toAbsolutePath().toString();
					Path p = Paths.get(currentDirPath + "\\" + enteredDirName);
					if(!Files.exists(p)) {
						System.out.println("Wrong folder name!");
					}
					else {
						path1 = p;
						if(Files.isDirectory(path1)) {
							dir(path1.toAbsolutePath().toString());
						}
						else {
							System.out.println(path1.toString()+" is not a Directory");
							path1 = Paths.get(currentDirPath);
						}
					}
				}
				else if(command.startsWith("copy ")) {
					int firstSpace = command.indexOf(" ");
					//System.out.println(firstSpace);
					int secondSpace = command.indexOf(" ",firstSpace+1);
					//System.out.println(secondSpace);
					String 	source = command.substring(firstSpace+1,secondSpace);
					String dest = command.substring(secondSpace+1);
					//System.out.println(source + "\n" + dest);
					Path sourceFile = Paths.get(source);
					Path destFile = Paths.get(dest);
					try {
						Files.copy(sourceFile, destFile);
						System.out.println("File "+source+" was copied to "+dest);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				else if(command.equals("exit")) {
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

	public static void dir(String path) {
		Path path1 = Paths.get(path);
		try(DirectoryStream<Path> stream = Files.newDirectoryStream(path1)){
			List<String> files = new ArrayList<>();
			List<String> directories = new ArrayList<>();
			for(Path path11: stream) {
				if(Files.isDirectory(path11)) {
					directories.add(path11.getFileName().toString());
				}
				else {
					files.add(path11.getFileName().toString());
				}
			}
			Collections.sort(directories);
			Collections.sort(files);
			directories.addAll(files);
			System.out.println(path1.toString());
			for(String s: directories) {
				System.out.println(s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}



}
