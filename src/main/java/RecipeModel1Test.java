import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.io.*;

public class RecipeModel1Test extends Mockito{
	
	@Test
	public void testServlet() throws Exception {
		HttpServletRequest request = mock(HttpServletRequest.class);       
		HttpServletResponse response = mock(HttpServletResponse.class); 

		when(request.getParameter("query")).thenReturn("chicken");

		StringWriter stringWriter = new StringWriter();
		PrintWriter writer = new PrintWriter(stringWriter);
		when(response.getWriter()).thenReturn(writer); //returns writer (aka the json from the RecipeModel1)

		new RecipeModel1().service(request, response);
		
		//verify(request, atLeast(1)).getParameter("username"); // only if you want to verify username was called...
		writer.flush(); // it may not have been flushed yet...
		assertTrue(stringWriter.toString().contains(request.getParameter("query")));
	}
}