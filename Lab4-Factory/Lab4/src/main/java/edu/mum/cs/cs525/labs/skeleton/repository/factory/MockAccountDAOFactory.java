package edu.mum.cs.cs525.labs.skeleton.repository.factory;

import edu.mum.cs.cs525.labs.skeleton.repository.AccountDAO;
import edu.mum.cs.cs525.labs.skeleton.repository.MockAccountDAOImpl;

public class MockAccountDAOFactory implements AccountDAOFactory {

    @Override
    public AccountDAO createAccountDAO() {
        return new MockAccountDAOImpl();
    }
}
