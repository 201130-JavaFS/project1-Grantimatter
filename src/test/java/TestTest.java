import org.junit.jupiter.api.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class TestTest {

    static Logger log = LogManager.getLogger(TestTest.class);

    @Test
    public void runThis(){
        log.info("I'm working!");
        assert(true);
    }
}
