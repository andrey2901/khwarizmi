package ua.com.hedgehogsoft.khwarizmi.bean.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.ejb.Stateless;

@Stateless
public class BracketChecker
{
   private List<String> results;

   public String check(String... input)
   {
      results = new ArrayList<>();

      for (String in : input)
      {
         checkBrackets(in);
      }
      return getResults();
   }

   private void checkBrackets(String input)
   {
      List<Integer> errors = new ArrayList<>();
      Stack<Character> openBrackets = new Stack<>();
      Stack<Integer> openBracketPosition = new Stack<>();
      Stack<Character> closeBrackets = new Stack<>();
      Stack<Integer> closeBracketPosition = new Stack<>();
      int size = input.length();
      for (int i = 0; i < size; i++)
      {
         char ch = input.charAt(i);
         switch (ch)
         {
            case '{':
            case '[':
            case '(':
               openBrackets.push(ch);
               openBracketPosition.push(i);
               break;
            case '}':
            case ']':
            case ')':
               if (!openBrackets.isEmpty())
               {
                  char chx = openBrackets.pop();
                  int index = openBracketPosition.pop();
                  if ((ch == '}' && chx != '{') || (ch == ']' && chx != '[') || (ch == ')' && chx != '('))
                  {
                     errors.add(index);
                     errors.add(i);
                  }
               }
               else
               {
                  closeBrackets.push(ch);
                  closeBracketPosition.push(i);
               }
               break;
            default:
               break;
         }
      }
      if (!openBrackets.isEmpty())
         while (openBracketPosition.iterator().hasNext())
         {
            errors.add(openBracketPosition.pop());
         }
      if (!closeBrackets.isEmpty())
         while (closeBracketPosition.iterator().hasNext())
         {
            errors.add(closeBracketPosition.pop());
         }
      if (errors.size() > 0)
      {
         errors.sort((Integer o1, Integer o2) -> o1.intValue() - o2.intValue());
         String markers = fixedLengthString(" ", errors.get(errors.size() - 1) + 1);
         StringBuilder builder = new StringBuilder(markers);
         for (int error : errors)
         {
            builder.setCharAt(error, '^');
         }
         results.add(input);
         results.add(builder.toString());
      }
   }

   private String fixedLengthString(String string, int length)
   {
      return String.format("%1$" + length + "s", string);
   }

   private String getResults()
   {
      StringBuilder builder = new StringBuilder();
      for (String result : results)
      {
         builder.append(result);
         builder.append("\r\n");
      }
      return builder.toString();
   }
}