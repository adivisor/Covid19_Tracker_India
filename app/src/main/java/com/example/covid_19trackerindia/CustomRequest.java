//package com.example.covid_19trackerindia;
//
//import android.app.VoiceInteractor;
//
//import com.android.volley.NetworkResponse;
//import com.android.volley.ParseError;
//import com.android.volley.Request;
//import com.android.volley.Response;
//import com.android.volley.toolbox.HttpHeaderParser;
//
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.io.UnsupportedEncodingException;
//
//public class CustomRequest extends Request<JSONObject> {
//    private Response.Listener<JSONObject> listener;
//
//    public CustomRequest(String url,
//                         Response.Listener<JSONObject> responseListener, Response.ErrorListener errorListener) {
//        super(Method.GET, url, errorListener);
//        this.listener = responseListener;
//    }
//
//    public CustomRequest(int method, String url,
//                         Response.Listener<JSONObject> responseListener, Response.ErrorListener errorListener) {
//        super(method, url, errorListener);
//        this.listener = responseListener;
//    }
//
//    @Override
//    protected Response<JSONObject> parseNetworkResponse(NetworkResponse response) {
//        try {
//            String jsonString = new String(response.data,
//                    HttpHeaderParser.parseCharset(response.headers));
//            return Response.success(new JSONObject(jsonString),
//                    HttpHeaderParser.parseCacheHeaders(response));
//        } catch (UnsupportedEncodingException e) {
//            return Response.error(new ParseError(e));
//        } catch (JSONException je) {
//            return Response.error(new ParseError(je));
//        }
//    }
//
//    @Override
//    protected void deliverResponse(JSONObject response) {
//
//        listener.onResponse(response);
//    }
//}
