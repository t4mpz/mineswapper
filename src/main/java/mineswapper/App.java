package mineswapper;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import mineswapper.ui.*;

/**
 * Hello world!
 *
 */
public class App 
{
  public static void main( String[] args )
  {
    System.out.println( "Hello World!" );
    File pwd = new File("./");
    List<Path> fp = new ArrayList<Path>();
    for (File path : pwd.listFiles()) { fp.add(path.toPath()); }
    ListContents con = new ListContents(fp);
  }

  
}
