package mineswapper.operations;

import java.io.File;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

import mineswapper.env.*;

public class Seeker extends Consultant{

  public Seeker(Config configurations){
    super(configurations);
  }

  public static List<File> filterJarFiles(List<File> pool){
    List<File> poolCp = pool;
    poolCp.removeIf(n -> (!n.getName().contains("jar")));
    return poolCp;
  }

  public static List<String> filterStringPathFiles(List<String> pool){
    List<String> poolCp = pool;
    poolCp.removeIf(n -> (!n.contains("jar")));
    return poolCp;
  }

  public List<File> getMods() throws IOException{
    File[] mods = new File(this.configurations.mmods_path).listFiles();
    return Arrays.asList(mods);
  }

  public List<File> getAvailableVersions() throws IOException{
    File[] versionFolders = new File(this.configurations.mmods_pool).listFiles();
    return Arrays.asList(versionFolders);
  }

  public boolean isVersionAvailable(String version) throws IOException{
    List<File> availableVersions = getAvailableVersions();
    List<String> versionsNames   = new ArrayList<String>();
    for(File aversion : availableVersions){ versionsNames.add(aversion.getName()); }
    return versionsNames.contains(version);
  }

  public List<File> getModsFromVersion(String version) throws IOException{
    File[] mods = new File(this.configurations.mmods_pool + "/" + version).listFiles();
    return Arrays.asList(mods);
  }
}