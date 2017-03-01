package fr.comprehensiveit.java.security.pluginapp;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.TransformerUtils;

public class PluginInstallation{
	static String PLUGIN_METHOD="autoInstallation";
	@SuppressWarnings("rawtypes")
	static Class[] PARAM_TYPES = { String.class };
	@SuppressWarnings("unchecked")
	public Map<String, String> installOnePlugin(String name,String path) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			Class<?> pluginClass = Class.forName(name);
			Object pluginInstance = pluginClass.newInstance();
			Method pluginMethod = pluginClass.getMethod(PLUGIN_METHOD, PARAM_TYPES);
			Transformer transformer = TransformerUtils.invokerTransformer(PLUGIN_METHOD, PARAM_TYPES, new Object[]{path});
			if (pluginMethod.getReturnType() == Map.class) {
				map = (Map<String,String>) transformer.transform(pluginInstance);
			}else{
				map.put("msg","Le plugin a retourne une erreur inconnue");
				map.put("code", "KO");
			}
		}catch (ClassNotFoundException notFoundEx) {
			map.put("msg","La classe n'a pas ete trouvee");
			map.put("code", "KO");
		}catch (Exception e) {
			map.put("msg","Erreur non connue");
			e.printStackTrace();
			e.getCause();
			map.put("code", "KO");
		}
		return map;
	}
}
