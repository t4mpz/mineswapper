package mineswapper.operations;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import mineswapper.env.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Unit test for simple App.
 */
public class SeekerTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SeekerTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( SeekerTest.class );
    }

    // public void testSeeker() throws FileNotFoundException{
    //   Seeker modsSeeker = new Seeker(new Config(".config.test.json", false));
    // }

    public void testFilterString(){
      List<String> filesTest = new ArrayList<String>(Arrays.asList("Testes", "testes.zip", "mod1.jar", "mod2.jar"));
      List<String> filtered = Seeker.filterStringPathFiles(filesTest);
      assertEquals(2, filtered.size());
      assertEquals("mod1.jar", filtered.get(0));
      assertEquals("mod2.jar", filtered.get(1));

    }

    public void testListVersions() throws FileNotFoundException, IOException{
      Seeker modsSeeker = new Seeker(new Config(".config.test.json", false));
      List<File> versions = modsSeeker.getAvailableVersions();
      List<String> versionsNames = new ArrayList<String>(); 
      for(File versionFolder : versions){ versionsNames.add(versionFolder.getName()); }
      assertTrue(versionsNames.contains("1.20.4"));
      assertTrue(versionsNames.contains("1.19.3"));
      assertTrue(versionsNames.contains("1.20.2"));
    }

    public void testListFilterMods() throws FileNotFoundException, IOException{
      Seeker modsSeeker = new Seeker(new Config(".config.test.json", false));
      List<File> mods = modsSeeker.getModsFromVersion("1.20.4");
      mods.forEach(f -> System.out.println(f.getName()));
      List<File> filtered = Seeker.filterJarFiles(mods);
      filtered.forEach(f -> System.out.println(f.getName()));
    }
}
