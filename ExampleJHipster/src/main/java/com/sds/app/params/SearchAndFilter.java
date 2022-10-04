package com.sds.app.params;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class SearchAndFilter {

    private String search;

    private int minId;

    private int maxId;

    public SearchAndFilter(String search, int minId, int maxId) {
        this.search = search;
        this.minId = minId;
        this.maxId = maxId;
    }

    public SearchAndFilter() {}

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public int getMinId() {
        return minId;
    }

    public void setMinId(int minId) {
        this.minId = minId;
    }

    public int getMaxId() {
        return maxId;
    }

    public void setMaxId(int maxId) {
        this.maxId = maxId;
    }
}
