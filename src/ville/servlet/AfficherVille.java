package ville.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ville.bean.VilleFrance;
import ville.utilitaire.RestResponse;

/**
 * Servlet implementation class AfficherVille
 */
@WebServlet("/AfficherVille")
public class AfficherVille extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final String ATT_LISTE_VILLES = "listeVilles";
	private static final String VUE_FORM = "/afficherVille.jsp";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AfficherVille() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		ArrayList<VilleFrance> villes = new ArrayList<VilleFrance>();
		villes = RestResponse.getRestResponse("http://localhost:8181/get");
		session.setAttribute(ATT_LISTE_VILLES, villes);
		this.getServletContext().getRequestDispatcher(VUE_FORM).forward(request, response);		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		doGet(request,response);
	}

}
