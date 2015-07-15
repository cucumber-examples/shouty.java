package shouty.web;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.Map;

public class QueryString {

    /**
     * Utility that converts a query string into a map.
     */
    static Map<String, String> toMap(String queryString) throws UnsupportedEncodingException {
        Map<String, String> queryPairs = new LinkedHashMap<>();
        if (queryString == null) return queryPairs;
        String[] pairs = queryString.split("&");
        for (String pair : pairs) {
            int idx = pair.indexOf("=");
            String key = URLDecoder.decode(pair.substring(0, idx), "UTF-8");
            String value = URLDecoder.decode(pair.substring(idx + 1), "UTF-8");
            queryPairs.put(key, value);
        }
        return queryPairs;
    }
}
