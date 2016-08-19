/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package av.online_exampaper.servlet;

import av.online_exampaper.dao.LoadFileDao;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author KLINGON
 */
@WebServlet("/f1")
@MultipartConfig
public class FileUploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
   

            HttpSession session=request.getSession();
            String path=session.getAttribute("path").toString();
            String enrollid=session.getAttribute("enrollid").toString();
            String pprid=session.getAttribute("pprid").toString();
            
            File dir=new File(request.getRealPath("/")+"image"+"/"+path);
            dir.mkdirs();
        
            String UPLOAD_DIRECTORY = request.getRealPath("/")+"image"+"/"+path;
            
            System.out.println(UPLOAD_DIRECTORY);  
            int flag=0;
            if (ServletFileUpload.isMultipartContent(request)) {


               System.out.println("Check this path when file is uploaded....."+UPLOAD_DIRECTORY);

                try {
                    List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest((RequestContext) request);
                   
                    System.out.println("multi ple parts...."+multiparts.size());
                    int fileid=1;
                    for (FileItem item : multiparts) {
                        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+item.getName());
                        if (!item.isFormField()) {
                            //String name = new File(item.getName()).getName();
                            
                            //String name =(String)i.toString();
                            if(new File(UPLOAD_DIRECTORY +File.separator + fileid).isFile()) {
                                flag=1;

                            } 
                            else {
                                item.write(new File(UPLOAD_DIRECTORY + File.separator + fileid+".jpg"));
                                
                                fileid++;
                            }
                        }
                       
                    }

                    //File uploaded successfully
                    if(flag==1)
                    {
                        request.setAttribute("mk","File already Exist");
                    }
                    else
                    {
                        
                       int i=LoadFileDao.saveAnswerSheet(enrollid,path,pprid);
                        
                        System.out.println(i);
                        request.setAttribute("mk", "File Uploaded Successfully");
                    }
                } catch (Exception ex) {
                    System.out.println(ex);
                    request.setAttribute("mk", "File Upload Failed due to " + ex);
                }

            } else {
                request.setAttribute("message", "Sorry this Servlet only handles file upload request");
            }

            request.getRequestDispatcher("/index_1.jsp").forward(request, response);


        }
        
    }

    

