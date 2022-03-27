package rx.masterdata.company;

import javax.ejb.ApplicationException;

@ApplicationException(rollback=true)
public class MissingAPIKeyException extends Exception {

}
