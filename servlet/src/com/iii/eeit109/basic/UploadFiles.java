package com.iii.eeit109.basic;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/UploadFiles")
@MultipartConfig
public class UploadFiles extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UploadFiles() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String header=null;
		String filename=null;
		InputStream in=null;
		OutputStream out=null;
		
		for(Part part:request.getParts()) {
		
		in=part.getInputStream();
		header=part.getHeader("Content-Disposition");
		System.out.println(header);
		//form-data; name="photo"; filename="C:\Users\User\Pictures\17215.jpg"//

		if(header.lastIndexOf("\\")!=-1) {
			filename=header.substring(header.lastIndexOf("\\"),header.lastIndexOf("\""));
		}
		else {
			filename=header.substring(header.lastIndexOf("filename=\"")+10,
					header.lastIndexOf("\""));
		}			
		if(filename.length()!=0) {
			out=new FileOutputStream("D:/servlets/uploadFiles/"+filename);
			byte[] buf=new byte[1024];
			int length;
			while((length=in.read(buf))!=-1) {
				out.write(buf, 0, length);
				}
			}else {
				continue;
				}
		in.close();
		out.close();
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
