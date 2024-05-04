package edu.mum.cs.cs525.labs.skeleton.repository.factory;

import edu.mum.cs.cs525.labs.skeleton.repository.AccountDAO;
import edu.mum.cs.cs525.labs.skeleton.repository.ProdAccountDAOImpl;

public class ProdAccountDAOFactory implements AccountDAOFactory {
    @Override
    public AccountDAO createAccountDAO() {
        return new ProdAccountDAOImpl();
    }
}
