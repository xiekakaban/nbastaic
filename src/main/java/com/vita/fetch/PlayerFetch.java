package com.vita.fetch;

import java.util.List;

/**
 * Created by bobo on 2018/5/8.
 *
 * @email ruantianbo@163.com
 */
public class PlayerFetch {
    private List<String> fetchUrls;

    public PlayerFetch() {
    }

    public List<String> getFetchUrls() {
        return fetchUrls;
    }

    public void setFetchUrls(List<String> fetchUrls) {
        this.fetchUrls = fetchUrls;
    }
}
