package mineswapper.env;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;


public class Generator{

  private Config configFile;
  private String configPath;

  private void saveEmptyConfig() throws IOException{
    Config.objectMapper.writeValue(new File(this.configPath), new ConfigMap());
  }

  public Generator(String configPath, boolean sync) throws IOException{
    this.configPath = configPath;
    if(!new File(configPath).exists()){
      Files.createFile(Path.of(configPath));
      saveEmptyConfig();
    }
    configFile = new Config(configPath, sync);
  }

  public void setConfigMap(ConfigMap config) throws IOException{ this.configFile.setFileMap(config);}

  public Config getConfigurations(){ return this.configFile; }
}