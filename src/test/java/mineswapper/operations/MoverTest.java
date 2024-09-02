package mineswapper.operations;


import java.io.IOException;
import java.nio.file.Files;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.nio.file.Path;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import mineswapper.env.*;
import mineswapper.utils.Utils;
/**
 * Unit test for simple App.
 */
public class   MoverTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public   MoverTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite(MoverTest.class );
    }

    public void test(){
        assert true;
    }

    public void testMoveFiles() throws IOException{
      Utils.deleteDirectoryIfExists(Path.of("./fakemodspath"));
      Utils.deleteDirectoryIfExists(Path.of("./fakemodspool"));
      Config conf = new Config("./.config.test.json", false);
      ConfigMap cm = conf.getFileMap();
      cm.mmods_path = "./fakemodspath";
      cm.mmods_pool = "./fakemodspool";
      conf.setFileMap(cm);
      Mover mover = new Mover(conf);
      Path fakemods = Files.createDirectory(Path.of("./fakemodspath"));
      Path fakepool = Files.createDirectory(Path.of("./fakemodspool"));
      Path fakemod = Files.createFile(Path.of("./fakemodspool/mods1.jar"));
      List<File> mods = new ArrayList<>();
      mods.add(new File(fakemod.toString()));
      mover.updateMods(mods);
      // assertEquals(Files.list(fakepool).toArray(), Files.list(fakemods).toArray());

      Utils.deleteDirectoryIfExists(fakemods);
      Utils.deleteDirectoryIfExists(fakepool);
    }
}
