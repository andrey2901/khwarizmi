package ua.com.hedgehogsoft.khwarizmi.bean.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileWriter
{
   private static Logger log = Logger.getLogger(FileWriter.class.getName());

   public void writer(OutputStream output, byte[] exportContent)
   {
      try (InputStream input = new ByteArrayInputStream(exportContent); OutputStream _output = output)
      {
         byte[] buffer = new byte[1024];
         while (input.read(buffer) != -1)
         {
            _output.write(buffer);
            _output.flush();
         }
         _output.flush();
      }
      catch (IOException e)
      {
         log.log(Level.SEVERE, "File wasn't be write", e);
      }
   }
}
