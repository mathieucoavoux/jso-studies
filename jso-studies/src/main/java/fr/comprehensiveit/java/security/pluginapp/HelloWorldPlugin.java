package fr.comprehensiveit.java.security.pluginapp;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HelloWorldPlugin {
	public Map<String,String> autoInstallation(String path) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			File file = new File(path+"/readme.txt");
			if(file.createNewFile()) {
				map.put("code", "OK");
				map.put("msg", "Installation réussie");
			}else{
				map.put("code", "KO");
				map.put("msg", "Installation échouée, le fichier n'a pas pu être créé");
			}
		}catch(IOException e) {
			map.put("code", "KO");
			map.put("msg", "Installation échouée, le dossier "+path+" n'existe pas ou l'utilisateur n'a pas les droits suffisants");
		}catch(Exception e){
			map.put("code", "KO");
			map.put("msg", "Installation échouée. Une erreur inconnue est survenue");
		}
		return map;
	}
}
