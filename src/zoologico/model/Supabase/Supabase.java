package zoologico.model.Supabase;

public class Supabase {
    static private final String SUPABASEURL = "";
    static private final String ANONKEY = "";
    static private Session currentSession;
    static public Auth auth = new Auth();;
    
                
    public Supabase(){
    }

    static public String getSupabaseUrl() {
        return SUPABASEURL;
    }
    static public String getAnonKey(){
        return ANONKEY;
    }
    
    static public void setCurrentSession(Session new_session){
        currentSession = new_session;
    }
    
    static public Session getCurrentSession (){
        return currentSession;
    }
    
    /**
     *
     * @param tabla
     * @return
     */
    public static Rest from(String tabla){
        String tablaURL = SUPABASEURL.concat("rest/v1/" + tabla);
        return new Rest(tablaURL); 
    }
    
}
