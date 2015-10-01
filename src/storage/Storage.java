package storage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import com.google.gson.Gson;

public class Storage {
	
	private static Gson gson = new Gson();
	private static File todo = new File("saveFile.txt");

	public Storage() {
	}
	static File file;
	static Path path;

	public boolean newEntry(String taskName) {
		return true;
	}

	/* this method writes to plain text file
	public static void write(String stuff)  {

		String toAdd = stuff + System.getProperty("line.separator");
		byte data[] = toAdd.getBytes();
		try {
			Files.write(path, data, StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	*/
	
	public static void write(ArrayList<Task> tasks){
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(saveFile));
			for(Task task: tasks) {
				String json = gson.toJson(task) + "\n";
				bw.write(json);
			}
			bw.close();
		}
		
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}


	public static boolean createFile(String fileName) {
		file = new File(fileName);
		setPath(Paths.get(fileName));
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}

	public static void setPath(Path path) {
		Storage.path = path;
	}
	/*
	private static void readFromFile(File file){
		BufferedReader br = null;
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			br = new BufferedReader(new FileReader(file));
			String newLine;
			while ((newLine = br.readLine()) != null) {
				texts.add(newLine);
			}
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
			System.exit(-1);
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException ex) {
				System.exit(-1);
			}
		}

	}
	 */
	 
	 public static ArrayList<Task> read() {
		ArrayList<Task> tasks = new ArrayList<Task>();
		String line = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(saveFile));
			while((line = br.readLine()) != null) {
				tasks.add(gson.fromJson(line, Task.class));
			}
			br.close();
		}
		catch (FileNotFoundException e){
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return tasks;
	}
}
