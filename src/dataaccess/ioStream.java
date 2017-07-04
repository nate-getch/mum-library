package dataaccess;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class ioStream {
	public static String OUTPUT_DIR = System.getProperty("user.dir") + "\\src\\dataaccess\\storage\\";

	public <T> Boolean write(List<T> list, String fileName) {
		try {
			list.addAll(read(fileName));
			FileOutputStream fileOutputStream = new FileOutputStream(this.OUTPUT_DIR + fileName);
			ObjectOutputStream output = new ObjectOutputStream(fileOutputStream);
			// first read from the file
			output.writeObject(list);
			output.close();
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public <T> List<T> read(String fileName) {
		ObjectInputStream input;
		ArrayList<T> allMembers = new ArrayList<T>();
		try {

			FileInputStream fileInputStream = new FileInputStream(new File(this.OUTPUT_DIR + fileName));
			input = new ObjectInputStream(fileInputStream);
			allMembers = (ArrayList<T>) input.readObject();
			input.close();

		} catch (Exception e) {
			// e.printStackTrace();
		} finally {

		}

		return allMembers;
	}
}
