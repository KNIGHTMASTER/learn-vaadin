package com.zisal.learn.vaadin.ui.panel;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.ViewScope;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.themes.ValoTheme;
import com.zisal.learn.vaadin.component.IComponentInitalizer;
import com.zisal.learn.vaadin.ui.label.LabelRowPerPage;
import com.zisal.learn.vaadin.ui.lov.LOVDisplayDataRowTable;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * Created by Ladies Man on 5/16/2016.
 */
@SpringComponent
@ViewScope
public class PanelRowPage extends HorizontalLayout implements IComponentInitalizer {

    private static final long serialVersionUID = 5628498843370259467L;

    @Autowired
    LabelRowPerPage labelRowPerPage;

    @Autowired
    LOVDisplayDataRowTable lovDisplayDataRowTable;

    @PostConstruct
    @Override
    public void initComponents() throws Exception {
        this.addComponents(lovDisplayDataRowTable, labelRowPerPage);
        this.setSpacing(true);
        this.setStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);
    }
}
