package org.camokatuk.amazingbrocessor.broc;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;
import org.camokatuk.amazingbrocessor.broc.command.AbstractBrocessorHttpCommand;

import java.io.IOException;

public class BrocessorHttpTransport implements BrocessorTransport<AbstractBrocessorHttpCommand>
{
    private static final Logger LOGGER = Logger.getLogger(BrocessorHttpTransport.class);

    private static final String BROC_URL = "http://localhost:17994";

    private HttpClient brocClient = HttpClientBuilder.create().build();
    private Gson gson = new GsonBuilder().create();

    public void pushCommand(final AbstractBrocessorHttpCommand brocessorCommand)
    {
        //        new Thread(new Runnable()
        //        {
        //            public void run()
        //            {
        try
        {
            pushCommandUnsafe(brocessorCommand);
        }
        catch (IOException e)
        {
            LOGGER.error("Pffff bro", e);
        }
        //        }).start();
    }

    private void pushCommandUnsafe(final AbstractBrocessorHttpCommand brocessorCommand) throws IOException
    {
        HttpPost request = new HttpPost(BROC_URL);
        request.addHeader("Content-Type", "application/json");

        String requestBody = gson.toJson(brocessorCommand);

        LOGGER.info("Sending " + requestBody);
        HttpEntity requestBody11 = new ByteArrayEntity(requestBody.getBytes("UTF-8"));

        request.setEntity(requestBody11);

        HttpResponse response = brocClient.execute(request);
        request.releaseConnection();
    }
}
