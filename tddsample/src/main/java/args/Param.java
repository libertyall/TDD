package args;

public class Param {

  String key;

  String type;

  String value;

  public Param(String key,String type){
    this.key = key;
    this.type = type;
  }

  public String getKey(){
    return key;
  }

  public void setKey(String key){
    this.key = key;
  }

  public String getType(){
    return type;
  }

  public void setType(String type){
    this.type = type;
  }

  public String getValue(){
    return value;
  }

  public void setValue(String value){
    this.value = value;
  }
}
