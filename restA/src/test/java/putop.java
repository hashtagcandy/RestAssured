import api.put;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.req;
import pojo.response;

public class putop {

    @Test
    public void triggerPut()
    {
        req putRequestPayload=new req();
        putRequestPayload.setJob("zion resident");
        putRequestPayload.setName("morpheus");

        Response putResponse= put.putApiCall(putRequestPayload,"2");
        response putResponseBody= putResponse.as(response.class);

        Assert.assertEquals(putResponseBody.getJob(),putRequestPayload.getJob());
        Assert.assertEquals(putResponseBody.getName(),putRequestPayload.getName());
    }

}