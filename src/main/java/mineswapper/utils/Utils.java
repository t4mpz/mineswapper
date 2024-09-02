package mineswapper.utils;
// works just like a tool box for the files functions primarily 

import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.io.File;
import java.nio.file.Path;


public final class Utils{

  private Utils(){ System.out.println("Do absolutly nuffin"); }

  public static void deleteDirectoryIfExists(Path directory) throws IOException{
    try{ Files.deleteIfExists(directory); }
    catch(DirectoryNotEmptyException dnee){
      File files = new File(directory.toString());
      for(File f : files.listFiles()) f.delete(); // delete the files inside the folder
      Files.delete(directory);
    }
  }

}