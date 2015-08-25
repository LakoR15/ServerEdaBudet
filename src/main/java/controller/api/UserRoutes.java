package controller.api;

import com.google.gson.Gson;
import controller.BaseController;
import model.User;


import static spark.Spark.post;
import static spark.Spark.get;

public class UserRoutes extends BaseController {

    @Override
    public void routes() {

        post("/user/registration", (request, response) -> {

            User user = new Gson().fromJson(request.body(), User.class);
            User user1 = null;
            //Тут должно быть хеширование пароля

            em = getEm();
            try {
                em.getTransaction().begin();
                user1 = em.createQuery("SELECT user FROM model.User user WHERE user.name=:name", User.class)
                        .setParameter("name", user.getName())
                        .getSingleResult();
                em.getTransaction().commit();
            } catch (Exception e) {
                em.getTransaction().rollback();
            } finally {
                em.close();
            }

            if(user1 == null){
                em = getEm();
                try {
                    em.getTransaction().begin();
                    em.persist(user);
                    em.getTransaction().commit();
                } catch (Exception e) {
                    em.getTransaction().rollback();
                    throw new RuntimeException("Error " + e.getMessage());
                } finally {
                    em.close();
                }

                return user.getId().toString() + " " + user.getSecretKey();
            }else {
                return "Error 1";
            }
        });

        post("/user/login", (request, response) -> {

            User user = new Gson().fromJson(request.body(), User.class);
            User user1;

            em = getEm();
            try {
                em.getTransaction().begin();
                user1 = em.createQuery("SELECT user FROM model.User user WHERE user.name=:name and user.password=:password", User.class)
                        .setParameter("name", user.getName())
                        .setParameter("password", user.getPassword())
                        .getSingleResult();
                em.getTransaction().commit();
            } catch (Exception e) {
                em.getTransaction().rollback();
                throw new RuntimeException("Error " + e.getMessage());
            } finally {
                em.close();
            }

            return user1.getId().toString() + " " + user1.getSecretKey();
        });

        get("/test", (request, response) -> {
            em = getEm();
            return  "test_is_ok";
        });

    }
}
