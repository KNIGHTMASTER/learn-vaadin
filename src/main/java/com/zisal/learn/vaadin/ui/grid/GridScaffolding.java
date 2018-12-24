package com.zisal.learn.vaadin.ui.grid;

import com.vaadin.ui.Grid;
import com.zisal.learn.vaadin.component.IComponentInitalizer;
import com.zisal.learn.vaadin.component.IComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by Ladies Man on 5/16/2016.
 */
public abstract class GridScaffolding extends Grid
        implements IComponent<GridScaffoldingParam, Grid>, IComponentInitalizer, IGridScaffoldingListener {

    private static final long serialVersionUID = -4217895641357329655L;

    protected Logger logger = LoggerFactory.getLogger(GridScaffolding.class);

    private GridScaffoldingParam gridScaffoldingParam;

    @Override
    public void initComponents() throws Exception {
        this.setColumns(gridScaffoldingParam.getColumns());
        this.setHeight(gridScaffoldingParam.getHeight(),Unit.PIXELS);
        this.addSelectionListener(se -> onSelection());
        //loadDataSource();
    }

    @Override
    public void setParamComponent(GridScaffoldingParam p_Component) {
        this.gridScaffoldingParam = p_Component;
    }

    @Override
    public GridScaffoldingParam getParamComponent() {
        return gridScaffoldingParam;
    }

    @Override
    public Grid getResultComponent() {
        return this;
    }
}
