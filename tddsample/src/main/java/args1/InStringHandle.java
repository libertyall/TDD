package args1;

import java.util.HashMap;
import java.util.Map;

import args.Param;

public class InStringHandle {
  public Map<String,Param> inTypesToParams(String types) {
    Map<String,Param> maps = new HashMap<>();
    String[] type = types.split(",");
    for (String s : type) {
      String[] typeSplit = s.split(":");
      maps.put(typeSplit[0],new Param(typeSplit[0],typeSplit[1]));
    }
    return maps;
  }
}
