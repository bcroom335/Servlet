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



@WebServlet("/UpLoadOneFile")
@MultipartConfig
public class UpLoadOneFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public UpLoadOneFile() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Part part=request.getPart("photo");
		InputStream in=part.getInputStream();
		String header=part.getHeader("Content-Disposition");
		System.out.println(header);
		//form-data; name="photo"; filename="C:\Users\User\Pictures\17215.jpg"//		
		String filename_header=header.split(";")[2];
		String filename;
		if(filename_header.lastIndexOf("\\")!=-1) {
			filename=filename_header.substring(filename_header.lastIndexOf("\\")+1,filename_header.lastIndexOf("\""));
		}else {
			filename=filename_header.substring(filename_header.lastIndexOf("filename=\"")+10,
					filename_header.lastIndexOf("\""));
		}	
		OutputStream out=new FileOutputStream("D:/servlets/uploadFiles/"+filename);
		byte[] buf=new byte[1024];
		int length;
		while((length=in.read(buf))!=-1) {
			out.write(buf, 0, length);
		}
		in.close();
		out.close();		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
