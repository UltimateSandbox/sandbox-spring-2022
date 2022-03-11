package org.example.facade;

import javax.naming.OperationNotSupportedException;
import java.util.List;

public abstract class ListFacade implements List<String> {

    @Override
    public int lastIndexOf(Object o) {
        try {
            throw new OperationNotSupportedException();
        } catch (OperationNotSupportedException e) {
            System.out.println("This operation is not supported.");
        }
        return 0;
    }
}
