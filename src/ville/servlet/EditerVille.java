package ville.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.HttpClientBuilder;

import ville.bean.VilleFrance;
import ville.utilitaire.RestResponse;

/**
 * Servlet implementation class EditerVille
 */
@WebServlet("/EditerVille")
public class EditerVille extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final String VUE_FORM = "/editerVille.jsp";
	private static final String VUE_VILLE = "/afficherVille.jsp";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditerVille() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(		request.getParameter("CodeINSEE") != null && 
				request.getParameter("CodePostal") != null &&
				request.getParameter("LibelleAcheminement") != null &&
				request.getParameter("Ligne5") != null &&
				request.getParameter("Nom") != null && 
				request.getParameter("Latitude") != null &&
				request.getParameter("Longitude") != null) {
			String codeINSEE = request.getParameter("CodeINSEE");
			VilleFrance ville = new VilleFrance();
			ville.setCodeINSEE(codeINSEE);
			ArrayList<VilleFrance> villes = RestResponse.getRestResponse("http://localhost:8181/get?Code_commune_INSEE="+ville.getCodeINSEE());
			ville = villes.get(0);
			ville.setCodeINSEE(codeINSEE);
			ville.setLibelleAcheminement("LibelleAcheminement");
			ville.setLigne_5("Ligne5");
			ville.setCodePostal(request.getParameter("CodePostal"));
			ville.setNom(request.getParameter("Nom"));
			ville.setLatitude(request.getParameter("Latitude"));
			ville.setLongitude(request.getParameter("Longitude"));
			
			String url = "http://localhost:8181/put?Code_commune_INSEE="
					+ville.getCodeINSEE()+"&Code_postal="
					+ville.getCodePostal()+"&Nom_commune="
					+ville.getNom()+"&Latitude="
					+ville.getLatitude()+"&Longitude="
					+ville.getLongitude()+"&Libelle_acheminement="
					+ville.getLibelleAcheminement()+"&Ligne_5="
					+ville.getLigne_5();
			
			System.out.println(url);
			
			HttpClient client = HttpClientBuilder.create().build();
			HttpPut httpPut = new HttpPut(url);
			client.execute(httpPut);
			
			response.sendRedirect("AfficherVille");
		}
		else {
			String codeINSEE = request.getParameter("codeINSEE");
			VilleFrance ville = new VilleFrance();
			ville.setCodeINSEE(codeINSEE);
			ArrayList<VilleFrance> villes = RestResponse.getRestResponse("http://localhost:8181/get?Code_commune_INSEE="+ville.getCodeINSEE());
			ville = villes.get(0);
			request.setAttribute("CodeINSEE", ville.getCodeINSEE());
			request.setAttribute("Nom", ville.getNom());
			request.setAttribute("LibelleAcheminement", ville.getLibelleAcheminement());
			request.setAttribute("Ligne5", ville.getLigne_5());
			request.setAttribute("CodePostal", ville.getCodePostal());
			request.setAttribute("Latitude", ville.getLatitude());
			request.setAttribute("Longitude", ville.getLongitude());
			this.getServletContext().getRequestDispatcher(VUE_FORM).forward(request, response);
		}
		
	}

}
