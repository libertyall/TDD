package args;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import args1.Args1;
import args1.InStringHandle;
import args1.TransferHandle;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class Args1Test {

  @Test
  public void test1(){
  }

  @Test
  public void test_2(){
    Args1 args1 = new Args1("l:bool,d:int,f:string,s:string","-l true -d -9 -f /usr/local -s");
    assertEquals(args1.getValue("l"),Boolean.TRUE);
  }

  @Test
  public void test_2_tools(){
    InStringHandle handle = new InStringHandle();
    Map<String, Param> maps = handle.inTypesToParams("l:bool,d:int,f:string,s:string");
    assertEquals(maps.size(),4);
    assertEquals(maps.get("l").getKey(),"l");
    assertEquals(maps.get("l").getType(),"bool");
    assertEquals(maps.get("d").getType(),"int");
    assertEquals(maps.get("f").getType(),"string");

    Map<String, Param> mapParams = handle.inParamsToParams("-l true -d -9 -f /usr/local -s", maps);
    assertEquals(mapParams.size(),4);
    assertEquals(mapParams.get("l").getType(),"bool");
    assertEquals(Boolean.valueOf(mapParams.get("l").getValue()),Boolean.TRUE);
    assertEquals(mapParams.get("d").getType(),"int");
    assertEquals(Integer.valueOf(mapParams.get("d").getValue()),Integer.valueOf("-9"));
    assertEquals(mapParams.get("f").getType(),"string");
    assertEquals(mapParams.get("f").getValue(),"/usr/local");
    assertEquals(mapParams.get("s").getType(),"string");
    assertEquals(mapParams.get("s").getValue(),null);
  }

  @Test
  public void test_2_transfer_tools(){
    TransferHandle handle = new TransferHandle("bool", null);
    assertEquals(handle.getValue(),Boolean.FALSE);
  }
}
