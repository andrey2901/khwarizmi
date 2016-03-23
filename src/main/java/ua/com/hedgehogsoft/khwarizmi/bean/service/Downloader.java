package ua.com.hedgehogsoft.khwarizmi.bean.service;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

@Stateless
public class Downloader
{
   private static Logger log = Logger.getLogger(Downloader.class.getName());
   private String attachmentName = "attachment; filename=\"out.txt\"";
   private String user;

   public void download(String content)
   {
      user = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
      log.log(Level.INFO, "start download for [" + user + "] the content:\n" + content);
      byte[] exportContent = content.getBytes();
      ServletOutputStream servletOutputStream = getPareperedStreamForDownloding(exportContent.length);
      new FileWriter().writer(servletOutputStream, exportContent);
      log.log(Level.INFO, "finish download for [" + user + "]");
   }

   private ServletOutputStream getPareperedStreamForDownloding(int contentLength)
   {
      log.log(Level.INFO, "start getPareperedStreamForDownloding");
      FacesContext facesContext = FacesContext.getCurrentInstance();
      HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
      ServletOutputStream servletOutputStream = null;
      try
      {
         servletOutputStream = response.getOutputStream();
      }
      catch (IOException e)
      {
         log.log(Level.SEVERE, "Stream for downloding was not prepared", e);
      }
      response.setContentType("text/plain");
      response.setHeader("Content-Disposition", attachmentName);
      response.setContentLength(contentLength);
      facesContext.responseComplete();
      log.log(Level.INFO, "finish getPareperedStreamForDownloding");
      return servletOutputStream;
   }
}
