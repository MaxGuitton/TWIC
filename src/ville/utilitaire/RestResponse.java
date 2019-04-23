package ville.utilitaire;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import ville.bean.VilleFrance;


public class RestResponse {
	public static ArrayList<VilleFrance> getRestResponse(String url) throws IOException{
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet httpGet = new HttpGet(url);
		HttpResponse httpResponse = client.execute(httpGet);
		
		BufferedReader rd = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
	
		StringBuffer result = new StringBuffer();
		
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		return resultToList(result);
	}
	
	public static ArrayList<VilleFrance> resultToList(StringBuffer result){
		ArrayList<VilleFrance> villes = new ArrayList<VilleFrance>();
		Gson gson = new Gson();
		Type villeFranceListType = new TypeToken<ArrayList<VilleFrance>>(){}.getType();
		villes = gson.fromJson(result.toString(), villeFranceListType);
		
		return villes;
	}
}