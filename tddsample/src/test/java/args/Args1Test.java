package args;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import args1.Args1;
import args1.InStringHandle;

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
  }
}
