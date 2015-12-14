package de.morphyum.speedruncomapiwrapper;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import de.morphyum.speedruncomapiwrapper.entity.Game;
import de.morphyum.speedruncomapiwrapper.entity.Name;
import de.morphyum.speedruncomapiwrapper.http.NetClient;

public class ApiWrapper {
	
	public static void main(String[] args) throws Exception {
		getAllGames();
	}

	private static List<Game> getAllGames() throws JSONException, URISyntaxException {
		JSONObject body = new JSONObject(NetClient.restGET("http://www.speedrun.com/api/v1/games"));
		JSONArray data = body.getJSONArray("data");
		List<Game> games = new ArrayList<Game>();
		for(int i = 0; i < data.length(); i++){
			String id = data.getJSONObject(i).getString("id");
			List<Name> names = getNames(data.getJSONObject(i).getJSONObject("names"));
			String abbreviation = data.getJSONObject(i).getString("abbreviation");
			URI weblink = new URI(data.getJSONObject(i).getString("weblink"));
			String released = data.getJSONObject(i).getString("released");		
					
					
			Game game = new Game(id, names, abbreviation, weblink, released, null, null, null, null, null, null, null, null);
			games.add(game);
		}
		
		//System.out.println(games.get(0).getId());

		return null;
	}

	private static List<Name> getNames(JSONObject jsonObject) {
		List<Name> names = new ArrayList<Name>();
	    Iterator iter = jsonObject.keys();
	    while(jsonObject.keys().hasNext()){
	        String key = (String)iter.next();
	        String value = jsonObject.getString(key);
	        names.add(new Name(key,value));
	    }
		return names;
	}

}
