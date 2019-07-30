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

  public Map<String,Param> inParamsToParams(String params,Map<String,Param> maps){
    Map<String,Param> mapParams = new HashMap<>();
    String[] paramAndValues = params.split(" ");
    for (int i = 0; i < paramAndValues.length; i++) {
      if (isStartsWithLine(paramAndValues[i])) {
        String paramKey = substringLine(paramAndValues[i]);
        Param param = maps.get(paramKey);
        if (i == (paramAndValues.length -1)) {
          mapParams.put(paramKey, param);
          break;
        }
        if (null != param && (null == maps.get(substringLine(paramAndValues[i+1])))) {
          param.setValue(paramAndValues[i+1]);
          mapParams.put(paramKey, param);
          ++i;
        } else {
          mapParams.put(paramKey, param);
        }
      }
    }
    return mapParams;
  }
  private boolean isStartsWithLine(String value) {
    return value.startsWith("-");
  }
  private String substringLine(String value) {
    return value.substring(1);
  }
}
