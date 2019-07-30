package args1;

public class TransferBooleanImpl implements Transfer{

  @Override public Object transfer(String value){
    return Boolean.valueOf(value);
  }
}
