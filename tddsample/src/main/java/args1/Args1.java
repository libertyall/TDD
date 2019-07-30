package args1;

import java.util.Map;

import args.Param;

public class Args1 {

  private final String types;
  private final String params;

  public Args1(String types,String params){
    this.types = types;
    this.params = params;
  }

  public Object getValue(String l){
    InStringHandle handle = new InStringHandle();
    Map<String,Param> maps = handle.inTypesToParams(types);
    Map<String, Param> mapParams = handle.inParamsToParams(params, maps);
    TransferHandle transferHandle = new TransferHandle(mapParams.get(l).getType(),mapParams.get(l).getValue());
    return transferHandle.getValue();
  }
}
