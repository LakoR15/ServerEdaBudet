
import controller.api.OrderRoutes;
import controller.api.UserRoutes;

import static spark.SparkBase.port;

public class Application {

    public static void main(String[] args){

        int port;
        port = Integer.parseInt(args[0]);
//        port = 5555;

        port(port);
        new UserRoutes();
        new OrderRoutes();
    }
}
