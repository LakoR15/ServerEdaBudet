package controller.logic;

import com.google.gson.Gson;
import model.User;
import utils.EMF;
import utils.HashWithSalt;

import javax.persistence.NoResultException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Map;

public class UserController extends EMF {

    private User user = null;
    private HashWithSalt hash = null;

    public UserController(User user) throws InvalidKeySpecException, NoSuchAlgorithmException {
        this.user = user;
        this.hash = new HashWithSalt(user.getPassword(), user.getName());
    }

    public void setHashPassword(){
        user.setPassword(hash.getHash());
    }

    public String userRegistration(){
        Map<String, Object> result = new HashMap<>();

        if (em == null){
            em = getEm();
        }
        try {
            em.getTransaction().begin();

            try {
                em.createQuery("SELECT user FROM model.User user WHERE user.name=:name")
                        .setParameter("name", user.getName())
                        .getSingleResult();
            }catch (NoResultException e){
                em.persist(user);
                result.put("userId", user.getId());
                result.put("secretKey", user.getSecretKey());
            }

            em.getTransaction().commit();

            return new Gson().toJson(result);

        } catch (Exception e) {
            if (em.getTransaction() != null){
                em.getTransaction().rollback();
            }
            return "Error1";
        } finally {
            em.close();
        }
    }

    public String userLogin(){

        Map<String, Object> result = new HashMap<>();

        if (em ==null){
            em = getEm();
        }
        try {
            em.getTransaction().begin();

            User u = em.createQuery("SELECT user FROM model.User user WHERE user.name=:name and user.password=:password", User.class)
                    .setParameter("name", user.getName())
                    .setParameter("password", user.getPassword())
                    .getSingleResult();

            result.put("userId", u.getId());
            result.put("secretKey", u.getSecretKey());

            em.getTransaction().commit();

            return new Gson().toJson(result);
        }catch (NoResultException e){
            if (em.getTransaction() != null){
                em.getTransaction().rollback();
            }
            return "Error2";
        }catch (Exception e){
            if (em.getTransaction() != null){
                em.getTransaction().rollback();
            }
            return "Error3";
        }finally {
            em.close();
        }
    }

}
