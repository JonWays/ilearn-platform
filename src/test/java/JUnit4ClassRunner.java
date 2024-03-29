import org.junit.runners.model.InitializationError;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Log4jConfigurer;

import java.io.FileNotFoundException;

/**
 * Creator zhuweijun
 * Date 2017/9/6 0006.
 */
public class JUnit4ClassRunner extends SpringJUnit4ClassRunner
{
    static
    {
        try
        {
            Log4jConfigurer.initLogging("log4j.xml");
        }
        catch (FileNotFoundException ex)
        {
            System.err.println("Cannot Initialize log4j");
        }
    }
    public JUnit4ClassRunner(Class<?> clazz) throws InitializationError
    {
        super(clazz);
    }
}
