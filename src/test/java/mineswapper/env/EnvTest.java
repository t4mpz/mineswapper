package mineswapper.env;

import java.io.FileNotFoundException;
import java.io.IOException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class EnvTest extends TestCase{

  public EnvTest(String testName)
  {
      super( testName );
  }

  /**
   * @return the suite of tests being tested
   */
  public static Test suite()
  {
      return new TestSuite( EnvTest.class );
  }

  /**
   * Rigourous Test :-)
   */
  public void testConfig(){
    try{
        Config configuration = new Config(".config.test.json", false);
        ConfigMap mapped = configuration.getFileMap();
        assertEquals("/home/giulliano/.minecraft/mods/", mapped.mmods_path);
    }
    catch(FileNotFoundException fnfe){ System.out.println(fnfe.getStackTrace());}
  }

  public void testWriteConfig(){
    try{
        Config configuration = new Config(".config.test.json", false);
        ConfigMap mapped = configuration.getFileMap();
        mapped.mmods_path = "/home/giulliano/.minecraft/writefunciona";
        configuration.setFileMap(mapped);
        configuration.writeDocument();
        mapped.mmods_path = "/home/giulliano/.minecraft/mods/";
        configuration.setFileMap(mapped);
        configuration.writeDocument();
    }
    catch(FileNotFoundException fnfe){ System.out.println(fnfe.getStackTrace());}
    catch(IOException ioe){ System.out.println(ioe.getStackTrace()); }
  }

  public void testWriteSyncConfig() throws FileNotFoundException, IOException{
    Config configuration = new Config(".config.test.json", true);
    ConfigMap mapped = configuration.getFileMap();
    mapped.mmods_path = "/home/giulliano/.minecraft/writefunciona";
    configuration.setFileMap(mapped); // writes the config with the sync when the filemap is changed
    mapped.mmods_path = "/home/giulliano/.minecraft/mods/";
    configuration.setFileMap(mapped); // reseting values for the configurations file
  }
}