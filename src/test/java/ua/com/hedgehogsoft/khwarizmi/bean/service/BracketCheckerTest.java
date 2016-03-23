package ua.com.hedgehogsoft.khwarizmi.bean.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BracketCheckerTest
{
   @Test
   public void check()
   {
      BracketChecker checker = new BracketChecker();
      String actual = checker.check("(a+b) — (a-b)", "a*(a+b", "d — 5*(s/((s+5) +5)+(5+f");
      String expected = "a*(a+b\r\n  ^\r\nd — 5*(s/((s+5) +5)+(5+f\r\n      ^             ^\r\n";
      assertEquals(expected, actual);
   }
}