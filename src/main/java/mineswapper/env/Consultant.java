package mineswapper.env;

public abstract class Consultant{
  protected Config configFile;
  protected ConfigMap configurations;

  public Consultant(Config config){
    this.configFile = config;
    this.configurations = this.configFile.getFileMap();
  }

  public Config getEnv(){ return this.configFile; }
}