package automation.utility;


public class ApiEndpoint {

    public static final String Base_url = "https://dummyapi.io/data/v1/"; // Endpoint main url

    public static final String Get_user = Base_url + "user/"; // Endpoint for user

    public static final String create = Base_url + "user/create/"; // Endpoint for creating user

    public static final String user_by_id = Base_url + "user/{id}"; // Endpoint getting user specific ID

    public static final String GET_TAG = Base_url + "tag/"; // Endpoint for tag

}
