package com.zisal.learn.vaadin.ui.scaffolding;

import com.zisal.learn.vaadin.ui.dialog.ConfirmationDialogDeleteSingleRecord;
import com.zisal.learn.vaadin.ui.localization.SimpleMessageSource;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

/**
 * Created by Ladies Man on 5/16/2016.
 * @param <DATA>
 */
public class ScaffoldingParam<DATA extends Serializable> implements Serializable{

    private static final long serialVersionUID = 397513183305654924L;

    private PagingAndSortingRepository pagingAndSortingRepository;
    private DATA data;
    private SimpleMessageSource simpleMessageSource;
    private ConfirmationDialogDeleteSingleRecord confirmationDialogDeleteSingleRecord;

    public PagingAndSortingRepository getPagingAndSortingRepository() {
        return pagingAndSortingRepository;
    }

    public void setPagingAndSortingRepository(PagingAndSortingRepository pagingAndSortingRepository) {
        this.pagingAndSortingRepository = pagingAndSortingRepository;
    }

    public DATA getData() {
        return data;
    }

    public void setData(DATA data) {
        this.data = data;
    }

    public SimpleMessageSource getSimpleMessageSource() {
        return simpleMessageSource;
    }

    public void setSimpleMessageSource(SimpleMessageSource simpleMessageSource) {
        this.simpleMessageSource = simpleMessageSource;
    }

    public ConfirmationDialogDeleteSingleRecord getConfirmationDialogDeleteSingleRecord() {
        return confirmationDialogDeleteSingleRecord;
    }

    public void setConfirmationDialogDeleteSingleRecord(ConfirmationDialogDeleteSingleRecord confirmationDialogDeleteSingleRecord) {
        this.confirmationDialogDeleteSingleRecord = confirmationDialogDeleteSingleRecord;
    }
}
