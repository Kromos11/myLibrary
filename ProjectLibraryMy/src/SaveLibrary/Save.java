package SaveLibrary;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import Main.Application;

public class Save {

	
	
	
	private static void saveApplication() {
		
	}
	

	public static void saveApplication(Application application) {
		File file = new File("D:/Library");
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(application);
			oos.flush();
			fos.flush();
			oos.close();
			fos.close();
		} catch(IOException e) {
			e.printStackTrace();
		}finally {
			if(fos!=null) 
				try{
					fos.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static Application getApplication() {
		File file = new File("D:/Library");
		Application application = null;
		FileInputStream fis = null;
		if(file.exists()) {
			try {
				fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				application = (Application)ois.readObject();
			}catch(IOException|ClassNotFoundException e) {
				e.printStackTrace();
			}finally {
				if(fis!=null) {
					try {
						fis.close();
					}catch(IOException e) {
						e.printStackTrace();
					}
				}
					
			}
		}
		return application;
	}

}
