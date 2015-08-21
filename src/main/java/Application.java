
import controller.api.UserRoutes;

import static spark.SparkBase.port;

public class Application {

    public static void main(String[] args){

        port(5555);
        new UserRoutes();
    }
}
