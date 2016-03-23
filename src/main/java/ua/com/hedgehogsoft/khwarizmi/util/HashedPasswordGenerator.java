package ua.com.hedgehogsoft.khwarizmi.util;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import java.text.MessageFormat;

public class HashedPasswordGenerator
{
   public static String generateHash(String password)
   {
      String hash = Hashing.sha256().hashString(password, Charsets.UTF_8).toString();
      return hash;
   }

   public static void printHash(String password, String hash)
   {
      String output = MessageFormat.format("{0} hashed to: {1}", password, hash);
      System.out.println(output);
   }

   public static void main(String[] args)
   {
      String pwd = "bob";
      printHash(pwd, generateHash(pwd));
      pwd = "ben";
      printHash(pwd, generateHash(pwd));
      pwd = "tom";
      printHash(pwd, generateHash(pwd));
      pwd = "sally";
      printHash(pwd, generateHash(pwd));
      pwd = "lee";
      printHash(pwd, generateHash(pwd));
   }
}
