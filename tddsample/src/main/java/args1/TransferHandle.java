package args1;

import java.util.HashMap;
import java.util.Map;

public class TransferHandle {

  private final String type;

  private final String value;

  private final Map<String,Transfer> transferMap = new HashMap() {{
    put("bool",new TransferBooleanImpl());
    put("int",new TransferIntImpl());
    put("string",new TransferStringImpl());
  }};

  public TransferHandle(String type,String value){
    this.type = type;
    this.value = value;
  }

  public Object getValue(){
    Transfer transfer =  transferMap.get(type);
    return transfer.transfer(value);
  }
}
