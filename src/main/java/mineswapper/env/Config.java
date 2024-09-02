package mineswapper.env;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Config{

  private String configurationFile;
  private ConfigMap fileMap;
  public static final ObjectMapper objectMapper = new ObjectMapper();
  private boolean sync;

  public Config(String configFile, boolean sync) throws FileNotFoundException{
    objectMapper.enable(SerializationFeature.INDENT_OUTPUT); // creates indent
    this.configurationFile = configFile;
    this.sync = sync;
    try{ loadDocument(); }
    catch(IOException ioe){System.out.println(ioe.getStackTrace());}
  }

  public Config(){}

  private void loadDocument() throws FileNotFoundException, IOException{
    try{
      this.fileMap = objectMapper.readValue(new File(this.configurationFile), ConfigMap.class);
    }
    catch(DatabindException dbe){ System.out.println(dbe.getStackTrace()); }
  }

  public void writeDocument() throws IOException{ objectMapper.writeValue(new File(this.configurationFile), this.fileMap); }

  public ConfigMap getFileMap(){ return this.fileMap; }
  
  public void setFileMap(ConfigMap cm) throws IOException{
    this.fileMap = cm;
    if(this.sync) this.writeDocument();
  }

  public boolean isSync(){ return sync;}
}