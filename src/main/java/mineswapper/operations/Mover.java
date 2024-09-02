package mineswapper.operations;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.io.IOException;
import java.io.File;

import mineswapper.env.*;

public class Mover extends Consultant{
  private Path mModsPath;
  private Path mShadersPath;

  public Mover(Config config){ 
    super(config); 
    this.mModsPath = Path.of(configurations.mmods_path);
    this.mShadersPath = Path.of(configurations.mshaders_path);
  }

  public void updateMods(List<File> mods) throws IOException{
    for (File mod : mods) { 
      System.out.println("Moving " + mod.toString() + " to " + this.mModsPath.toString());
      Files.copy(mod.toPath(), Path.of(mModsPath.toString() + "/" + mod.getName()), StandardCopyOption.REPLACE_EXISTING); 
    }
  }

  public void updateShaders(List<File> shaders) throws IOException{
    for( File shader: shaders){ Files.copy(shader.toPath(), mShadersPath); }
  }

  public Path getModsPath(){ return this.mModsPath; }
  public Path getShadersPath(){ return this.mShadersPath; }

  // gonna create some setters just to do some tests
  public void setShadersPath(Path shadersPath){ this.mShadersPath = shadersPath; }
  public void setModsPath(Path modsPath){ this.mModsPath = modsPath; }
  
}