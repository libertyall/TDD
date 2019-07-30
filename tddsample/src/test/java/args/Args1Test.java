package args;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import args1.Args1;

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
}
