
import controller.api.UserRoutes;

import static spark.SparkBase.port;

public class Application {

    public static void main(String[] args){

        int port;

        if (args.equals(null)){
            port = Integer.parseInt(args[0]);
        }else {
            port = 5555;
        }

        port(port);
        new UserRoutes();
    }
}
