package com.example.disasterprepfrontend;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class Repository {

    public void getDisasterList(ExecutorService srv, Handler uiHandler) {

        srv.submit(()->{
                try {
                    URL url = new URL("http://10.0.2.2:8080/disasterprep/disasters");

                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                    String line = "";
                    StringBuilder buffer = new StringBuilder();

                    while((line = reader.readLine()) != null){
                        buffer.append(line);
                    }


                    JSONArray arr = new JSONArray(buffer.toString());
                    List<ModelDisaster> data = new ArrayList<>();

                    for (int i = 0; i < arr.length(); i++) {

                        JSONObject obj = arr.getJSONObject(i);
                        ModelDisaster temp = new ModelDisaster(obj.getString("disasterType"), obj.getString("disasterCause"), obj.getString("disasterPlan"));

                        data.add(temp);

                    }

                    conn.disconnect();

                    Message msg = new Message();
                    msg.obj = data;
                    uiHandler.sendMessage(msg);


                } catch (MalformedURLException e) {
                    Log.e("DEV",e.toString());
                } catch (IOException e) {
                    Log.e("DEV",e.toString());
                } catch (JSONException e) {
                    Log.e("DEV",e.toString());
                }

        });

    }


    public void getCheckList(ExecutorService srv, Handler uiHandler) {

        srv.submit(()->{
            try {

                URL url = new URL("http://10.0.2.2:8080/disasterprep/preparednesschecklists");

                HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                String line = "";
                StringBuilder buffer = new StringBuilder();

                while((line = reader.readLine()) != null){
                    buffer.append(line);
                }

                JSONArray arr = new JSONArray(buffer.toString());
                List<ModelChecklist> data = new ArrayList<>();

                for (int i = 0; i < arr.length(); i++) {

                    JSONObject obj = arr.getJSONObject(i);

                    ModelChecklist temp = new ModelChecklist(obj.getString("disasterType"), obj.getJSONArray("checklistItems"));
                    data.add(temp);

                }

                conn.disconnect();

                Message msg = new Message();
                msg.obj = data;
                uiHandler.sendMessage(msg);


            } catch (MalformedURLException e) {
                Log.e("DEV",e.toString());
            } catch (IOException e) {
                Log.e("DEV",e.toString());
            } catch (JSONException e) {
                Log.e("DEV",e.toString());
            }

        });

    }

    public void getContacts(ExecutorService srv, Handler uiHandler) {


        srv.submit(()->{
            try {

                URL url = new URL("http://10.0.2.2:8080/disasterprep/emergencycontacts");

                HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                String line = "";
                StringBuilder buffer = new StringBuilder();

                while((line = reader.readLine()) != null){
                    buffer.append(line);
                }


                JSONArray arr = new JSONArray(buffer.toString());
                List<ModelContact> data = new ArrayList<>();

                for (int i = 0; i < arr.length(); i++) {

                    JSONObject obj = arr.getJSONObject(i);
                    ModelContact temp = new ModelContact(obj.getString("contactName"), obj.getString("contactPhoneNumber"));
                    data.add(temp);

                }

                conn.disconnect();

                Message msg = new Message();
                msg.obj = data;
                uiHandler.sendMessage(msg);


            } catch (MalformedURLException e) {
                Log.e("DEV",e.toString());
            } catch (IOException e) {
                Log.e("DEV",e.toString());
            } catch (JSONException e) {
                Log.e("DEV",e.toString());
            }

        });

    }

}
