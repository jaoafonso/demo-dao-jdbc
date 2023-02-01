package model.dao;

import model.dao.impl.SellerDaoJDBC;

public class DaoFactory {

    public static SellerDao createSellerDAO() {
        return new SellerDaoJDBC();
    }
}
