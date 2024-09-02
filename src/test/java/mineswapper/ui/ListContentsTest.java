package mineswapper.ui;
import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class ListContentsTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ListContentsTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( ListContentsTest.class );
    }

    public void test(){
      File pwd = new File("./");
      List<Path> fp = new ArrayList<Path>();
      for (File path : pwd.listFiles()) { fp.add(path.toPath()); }
      ListContents con = new ListContents(fp);
    }
}
