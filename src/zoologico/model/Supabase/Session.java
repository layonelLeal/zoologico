package zoologico.model.Supabase;

import org.json.JSONObject;

/**
 *
 * @author layonel
 */
public class Session {
    private String token;
    private final String role;
    
    public Session (JSONObject session_data){
        this.token = (String) session_data.get("access_token");
        this.role = (String) session_data.getJSONObject("user").getString("role");
    }
    
    public Session (){
        this.token = "";
        this.role = "";
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public String getRole() {
        return role;
    }
    
}
