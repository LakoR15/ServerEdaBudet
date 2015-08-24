package controller;

import javax.persistence.EntityManager;

public abstract class BaseController {

    protected EntityManager em;

    public BaseController() {
        routes();
    }

    abstract public void routes();
}
