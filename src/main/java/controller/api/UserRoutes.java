package controller.api;

import com.google.gson.Gson;
import controller.BaseController;
import model.User;
import utils.EMF;


import static spark.Spark.post;

public class UserRoutes extends BaseController {

    @Override
    public void routes() {

        post("/user/registration", (request, response) -> {

            User user = new Gson().fromJson(request.body(), User.class);
            user.setSecretKey();
            em = EMF.getEm();
            try {
                em.getTransaction().begin();
                em.persist(user);
                em.getTransaction().commit();
            }catch (Exception e){
                em.getTransaction().rollback();
                throw new RuntimeException("Error " + e.getMessage());
            }finally {
                em.close();
            }

            return user.getId().toString()+ " " + user.getSecretKey().toString();

        });

    }
}
