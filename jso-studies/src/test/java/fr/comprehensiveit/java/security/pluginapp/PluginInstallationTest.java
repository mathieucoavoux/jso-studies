package fr.comprehensiveit.java.security.pluginapp;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import java.util.Map;

import fr.comprehensiveit.java.security.pluginapp.PluginInstallation;

public class PluginInstallationTest {
	@Test
	public void testInstallOnePlugin() {
		PluginInstallation plu = new PluginInstallation();
		//Expected result : OK
		Map<String,String> mapOK1 = plu.installOnePlugin("fr.comprehensiveit.java.security.pluginapp.HelloWorldPlugin","/tmp/");
		if(mapOK1.get("code") == "OK") {
			org.junit.Assert.assertTrue("Message :"+mapOK1.get("msg"),true);
		}else{
			fail("Message :"+mapOK1.get("msg"));
		}
		
	}
}
