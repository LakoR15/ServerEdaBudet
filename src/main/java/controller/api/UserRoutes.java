package controller.api;

import controller.BaseController;


import static spark.Spark.post;

public class UserRoutes extends BaseController {

    @Override
    public void routes() {

        post("/user/registration", (request, response) -> {

            return true;

        });

    }
}
