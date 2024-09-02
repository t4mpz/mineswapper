package mineswapper.env;

public class ConfigMap{
  public String mmods_path;
  public String mmods_pool;
  public String mshaders_pool;
  public String mshaders_path;

  public ConfigMap(){
    this.mmods_path = "";
    this.mmods_pool = "";
    this.mshaders_path = "";
    this.mshaders_pool = "";
  };

  public ConfigMap(String mModsPath, String mShadersPath, String modsPool, String shadersPool){
    this.mmods_path = mModsPath;
    this.mshaders_path = mShadersPath;
    this.mmods_pool = modsPool;
    this.mshaders_pool = shadersPool;
  }
}