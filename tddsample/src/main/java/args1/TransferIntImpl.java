package args1;

public class TransferIntImpl implements Transfer{

  @Override public Object transfer(String value){
    return Integer.valueOf(value);
  }
}
