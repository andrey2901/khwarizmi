package ua.com.hedgehogsoft.khwarizmi.bean;

import javax.inject.Inject;
import javax.inject.Named;

import ua.com.hedgehogsoft.khwarizmi.bean.service.BracketChecker;
import ua.com.hedgehogsoft.khwarizmi.bean.service.Downloader;
import ua.com.hedgehogsoft.khwarizmi.bean.service.FileReader;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;

@Named(value = "khwarizmiBean")
@SessionScoped
@Stateful
public class KhwarizmiBean
{
   private String text;
   private String user;
   @Inject
   private BracketChecker checker;
   @Inject
   private FileReader reader;
   @Inject
   private Downloader downloader;
   private static Logger log = Logger.getLogger(KhwarizmiBean.class.getName());

   public void checkFormulas()
   {
      log.log(Level.INFO, "User [" + user + "] begin to check him formulas...");
      String[] fileContent = reader.readByLine();
      text = checker.check(fileContent);
      log.log(Level.INFO, "User [" + user + "] finished to check formulas successfully. Output:\n" + text);
   }

   public void download()
   {
      log.log(Level.INFO, "User [" + user + "] begin to dowload file with checked formulas...");
      downloader.download(text);
      FacesContext.getCurrentInstance().getResponseComplete();
      log.log(Level.INFO, "User [" + user + "] dowload file successfully");
   }

   public String getText()
   {
      return text;
   }

   public void setText(String text)
   {
      this.text = text;
   }

   public String getUser()
   {
      return user;
   }

   public void setUser(String user)
   {
      this.user = user;
   }

   public BracketChecker getChecker()
   {
      return checker;
   }

   public void setChecker(BracketChecker checker)
   {
      this.checker = checker;
   }

   public FileReader getReader()
   {
      return reader;
   }

   public void setReader(FileReader reader)
   {
      this.reader = reader;
   }
}
