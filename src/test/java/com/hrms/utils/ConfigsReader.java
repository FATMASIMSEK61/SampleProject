package com.hrms.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigsReader {

	/**
	 * 
	 * @param filePath
	 */
	public static Properties prop;

	public static void readProperties(String filePath) {
		try {
			FileInputStream fis=new FileInputStream(filePath);
			//locol oldugu icin asagida ki metodda cagiramadik prop'u o yuzden declare yapiyoruz
			//Properties prop= new Properties();
			prop=new Properties();
			prop.load(fis);//2. siradakini utill ettik yeni try catch blogu acti
			fis.close();

		}catch(FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	/**
	 * this methos will return value of specified key
	 * @param key
	 * @return String value
	 */
	//simdi browser,ilerde url, sonra baska bisey yazabilir o yuzden string key yaptik
	//two properties icindekiler string key 	
	public static String getProperty(String key) {

		//key i getproperti metoduyla cagiriyoruz
		return prop.getProperty(key);
	}

}
