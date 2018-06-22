package at.technikumwien;

import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;
import com.meterware.servletunit.ServletRunner;
import com.meterware.servletunit.ServletUnitClient;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(IntegrationTest.class)
public class CalculatorServletTest {
    private ServletRunner runner;
    private ServletUnitClient client;

    @Before
    public void setUp() {
        runner = new ServletRunner();
        runner.registerServlet("calculator", CalculatorServlet.class.getName());
        client = runner.newClient();
    }

    @After
    public void tearDown() {
        runner.shutDown();
    }

    @Test
    public void testWith2Params() throws Exception {
        WebRequest request = new GetMethodWebRequest("http://test.meterware.com/calculator");
        request.setParameter("operand1", "1");
        request.setParameter("operand2","2");

        WebResponse response = client.getResponse(request);
        Assert.assertEquals("Summe: 3", response.getText());
    }

    @Test (expected = NumberFormatException.class)
    public void testNoParams() throws Exception{
        WebRequest request = new GetMethodWebRequest("http://test.meterware.com/calculator");
        WebResponse response = client.getResponse(request);
    }

    @Test (expected = NumberFormatException.class)
    public void testWithNonIntegers() throws Exception{
        WebRequest request = new GetMethodWebRequest("http://test.meterware.com/calculator");
        request.setParameter("operand1", "abc");
        request.setParameter("operand2","abc");
        client.getResponse(request);
    }
}
