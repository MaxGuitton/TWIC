package ville.servlet;

import java.io.IOException;
import java.net.URLEncoder;
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
 * Servlet implementation class CalculerDistance
 */
@WebServlet("/CalculerDistance")
public class CalculerDistance extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final String ATT_LISTE_VILLES = "listeVilles";
	private static final String DISTANCE = "distance";
	private double distance = 0;
	private static final String VUE_FORM = "/calculerDistance.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculerDistance() {
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
		session.setAttribute(DISTANCE, distance);
		
		this.getServletContext().getRequestDispatcher(VUE_FORM).forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String codeDepart = request.getParameter("nomVilleDepart");
		String codeArrivee = request.getParameter("nomVilleArrivee");
		ArrayList<VilleFrance> villesDeparts = new ArrayList<VilleFrance>();
		ArrayList<VilleFrance> villesArrivees = new ArrayList<VilleFrance>();
	
		villesDeparts = RestResponse.getRestResponse("http://localhost:8181/get?Code_commune_INSEE="+codeDepart);
		villesArrivees = RestResponse.getRestResponse("http://localhost:8181/get?Code_commune_INSEE="+codeArrivee);
		
		VilleFrance villeDepart = villesDeparts.get(0);
		VilleFrance villeArrivee = villesArrivees.get(0);
		request.setAttribute("villeDepart", villeDepart.getNom());
		request.setAttribute("villeArrivee", villeArrivee.getNom());
				
		this.distance = 6372*(Math.acos(Math.sin(Double.parseDouble(villeDepart.getLatitude())*Math.PI/180)*
						Math.sin(Double.parseDouble(villeArrivee.getLatitude())*Math.PI/180) + 
						Math.cos(Double.parseDouble(villeDepart.getLatitude())*Math.PI/180)*
						Math.cos(Double.parseDouble(villeArrivee.getLatitude())*Math.PI/180)*
						Math.cos((Double.parseDouble(villeDepart.getLongitude()) - Double.parseDouble(villeArrivee.getLongitude()))*
						Math.PI/180)));
		
		doGet(request, response);
	}

}
