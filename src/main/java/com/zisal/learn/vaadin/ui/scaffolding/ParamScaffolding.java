package com.zisal.learn.vaadin.ui.scaffolding;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

/**
 * Created by Ladies Man on 5/16/2016.
 * @param <DATA>
 * @param <REPO>
 */
public class ParamScaffolding<DATA extends Serializable, REPO extends PagingAndSortingRepository> {

    private DATA data;
    private REPO repo;

    public DATA getData() {
        return data;
    }

    public void setData(DATA data) {
        this.data = data;
    }

    public REPO getRepo() {
        return repo;
    }

    public void setRepo(REPO repo) {
        this.repo = repo;
    }
}
