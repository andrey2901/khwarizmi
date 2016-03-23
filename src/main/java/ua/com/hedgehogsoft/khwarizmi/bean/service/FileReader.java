package ua.com.hedgehogsoft.khwarizmi.bean.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.servlet.http.Part;

@Stateless
public class FileReader
{
   private Part uploadedFile;
   private static Logger log = Logger.getLogger(FileReader.class.getName());

   public String[] readByLine()
   {
      List<String> lines = new ArrayList<>();
      if (null != uploadedFile)
      {
         try
         {
            InputStream is = uploadedFile.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String currentLine;
            while ((currentLine = br.readLine()) != null)
            {
               lines.add(currentLine);
            }
         }
         catch (IOException e)
         {
            log.log(Level.SEVERE, "File cann't be read", e);
         }
      }
      return lines.toArray(new String[lines.size()]);
   }

   public Part getUploadedFile()
   {
      return uploadedFile;
   }

   public void setUploadedFile(Part uploadedFile)
   {
      this.uploadedFile = uploadedFile;
   }
}
