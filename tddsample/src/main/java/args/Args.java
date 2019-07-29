package args;

import java.util.HashMap;
import java.util.Map;

public class Args {

  private final String paramTypes;

  private final String params;

  public Args(String paramTypes,String params){
    this.paramTypes = paramTypes;
    this.params = params;
  }

  public Object getValue(String l){
    Map<String,Param> mapTypes = splitParamTypes(paramTypes);
    Map<String,Param> mapParams = splitParamsAndSetParamMapValue(params,mapTypes);
    Param param = mapParams.get(l);
    return getValueByType(param);
  }

  private Object getValueByType(Param param){
    if ("bool".equals(param.getType())) {
      return Boolean.valueOf(param.getValue());
    }
    if ("int".equals(param.getType())) {
      return Integer.valueOf(param.getValue());
    }
    if ("string".equals(param.getType())) {
      if (null != param.getValue()) {
        return param.getValue();
      }
    }
    return null;
  }

  private Map<String,Param> splitParamsAndSetParamMapValue(String params,Map<String,Param> types){
    String[] paramAll = params.split(" ");
    for (int i = 0; i < paramAll.length; i++) {
      String paramKey = paramAll[i].substring(1);
      String paramValue = null;
      if (i < (paramAll.length - 1)) {
        paramValue = paramAll[i + 1];
        if (paramValue.startsWith("-") && (null != types.get(paramValue.substring(1)))) {
          paramValue = null;
        } else {
          ++i;
        }
      }
      Param param = types.get(paramKey);
      if (null != param) {
        param.setValue(paramValue);
      }
    }
    return types;
  }

  private Map<String,Param> splitParamTypes(String paramTypes){
    String[] paramTypeAll = paramTypes.split(",");
    Map<String,Param> map = new HashMap<>();
    for (String paramType : paramTypeAll) {
      String[] typeValue = paramType.split(":");
      Param param = new Param(typeValue[0],typeValue[1]);
      map.put(typeValue[0],param);
    }
    return map;
  }
}
