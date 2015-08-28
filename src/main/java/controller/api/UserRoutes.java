package controller.api;

import controller.BaseController;
import controller.logic.UserController;
import model.User;

import static spark.Spark.post;
import static spark.Spark.get;

public class UserRoutes extends BaseController {

    @Override
    public void routes() {

        post("/user/registration", (request, response) -> {

            User user = new User(request.queryParams("name"), request.queryParams("password"));

            UserController userController = new UserController(user);
            userController.setHashPassword();
            return userController.userRegistration();
        });

        post("/user/login", (request, response) -> {

            User user = new User(request.queryParams("name"), request.queryParams("password"));

            UserController userController = new UserController(user);
            userController.setHashPassword();
            return userController.userLogin();
        });

        get("/test", (request, response) -> {
            em = getEm();
            return  "test_is_ok";
        });

    }
}
