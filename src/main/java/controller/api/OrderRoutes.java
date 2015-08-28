package controller.api;

import controller.BaseController;
import model.Order;
import model.Product;
import model.User;

import java.util.Set;

import static spark.Spark.get;
import static spark.Spark.post;

public class OrderRoutes extends BaseController {

    @Override
    public void routes() {

        get("/order/create", (request, response) -> {

//            Set<String> queryParams = request.queryParams();
//            StringBuilder stringBuilder = new StringBuilder();
//            for (String param : queryParams) {
//                stringBuilder.append(param).append(" ").append(request.queryParams(param));
//            }
//
//            return stringBuilder.toString();
            Product product = null;

            em = getEm();
            try {
                em.getTransaction().begin();
                product =  em.createQuery("SELECT p1 FROM model.Product p1 WHERE p1.name=:name", Product.class)
                        .setParameter("name", request.queryParams("name"))
                        .getSingleResult();
            } catch (Exception e) {
                product = new Product(request.queryParams("name"));
                em.persist(product);
                return product.getId().toString();
            } finally {
                em.getTransaction().commit();
                em.close();
            }

            return product.getId().toString();

        });


    }
}
