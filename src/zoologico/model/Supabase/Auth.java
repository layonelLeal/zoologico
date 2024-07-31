package zoologico.model.Supabase;
import Api.Api;
import java.util.HashMap;
import org.json.JSONObject;

public class Auth {
    private String authURL;
    
    public Auth (){
        this.authURL =  Supabase.getSupabaseUrl().concat("auth/v1");
    }
    
    public JSONObject LoginWithEmailAndPassword(String email, String password){
        //Body fetch
        HashMap<String, Object> body = new HashMap<>();
        body.put("email", email);
        body.put("password", password);
        
        HashMap<String, Object> params = new HashMap<>();
        params.put("grant_type", "password");
        
        //Header fetch
        HashMap<String, String> header = new HashMap<>();
        header.put("apiKey", Supabase.getAnonKey());
        header.put("Content-Type", "application/json");
        
        //Fetch options
        HashMap<String, Object> options = new HashMap<>();
        
        options.put("method", "POST");
        options.put("body", body);
        options.put("header", header);
        options.put("params", params);

        System.out.println(options.toString());
        
        JSONObject response = Api.fetch(authURL.concat("/token"), options);
        
        System.out.println(response.toString());
        
        Session newSession = new Session(response);
        Supabase.setCurrentSession(newSession);

        return response;
    }
    
    public JSONObject getUser(){
        
        if (Supabase.getCurrentSession().getToken().isEmpty()){
            JSONObject noneUser = new JSONObject();
            return noneUser;
        }
        
        String getUserURL = authURL.concat("/user");
        
        //Header fetch
        HashMap<String, String> header = new HashMap<>();
        header.put("apiKey", Supabase.getAnonKey());
        header.put("Content-Type", "application/json");
        header.put("Authorization", "Bearer " + Supabase.getCurrentSession().getToken());
        
        //Fetch options
        HashMap<String, Object> options = new HashMap<>();
        options.put("method", "POST");
        options.put("header", header);
        
        JSONObject response = Api.fetch(getUserURL, options);

        return response;
    }
    
    public void logOut(){
        Session noneSession = new Session();
        Supabase.setCurrentSession(noneSession);
    }
}
