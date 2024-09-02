package mineswapper.env;


import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


/**
 * Unit test for simple App.
 */
public class GeneratorTest 
    extends TestCase
{

    // this method to validate empty static file contents is fucking stupid and cringe 
    // but I'm not creating a template file for this shit nuh uh 
    // I could use some makefile to create this, maybe, maybe
    public static final  String EMPTYCONF_STRING = String.join("\n", "{",
    "  \"mmods_path\" : \"\",",
    "  \"mmods_pool\" : \"\",",
    "  \"mshaders_pool\" : \"\",",
    "  \"mshaders_path\" : \"\"",
    "}");
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public GeneratorTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( GeneratorTest.class );
    }

    public void test(){
        assert true;
    }

    public void testGeneratorCreatesFile() throws IOException{
        String path = "./.config.generated.test.json";
        Generator gen = new Generator(path, false);  // not used garbage collector must work
        // checking if the file is created and is an empty configurations
        File generatedConfig = new File(path);
        String content = Files.readString(Path.of(path));
        assertTrue(generatedConfig.exists());
        assertEquals(EMPTYCONF_STRING, content);
        generatedConfig.delete(); // no more fortine
        System.gc(); // because of gen object 
    }
}
