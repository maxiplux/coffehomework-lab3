package edu.mum.data;

import edu.mum.data.impl.DataFacadeImpl;

/**
 * Returns an implementation of a DataFacade.
 * Could be TestDataImpl or ProdDataImpl, depending on
 * input argument.
 * <p>
 * Input argument can be "dev" or "prod"
 */
public class DataFacadeFactory {
    public DataFacade getDataFacadeInstance(String type) {
        if (type.equals("dev")) {
            return DataFacadeImpl.INSTANCE;
        }
//		if(type.equals("prod")){
//			return ProdDataImpl.INSTANCE
//		}
        return null;
    }
}
