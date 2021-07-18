package com.stl.dms.commodity;

import javax.inject.Inject;

import com.ozguryazilim.telve.data.RepositoryBase;
import com.ozguryazilim.telve.forms.Browse;
import com.ozguryazilim.telve.forms.BrowseBase;
import com.ozguryazilim.telve.query.QueryDefinition;
import com.ozguryazilim.telve.query.columns.LinkColumn;
import com.ozguryazilim.telve.query.columns.TextColumn;
import com.stl.dms.entities.Supplier;
import com.stl.dms.entities.Supplier_;

/**
 * Brwose Control Class
 * 
 * @author
 */
@Browse(feature = SupplierFeature.class)	
public class SupplierBrowse extends BrowseBase<Supplier, SupplierViewModel> {

	@Inject
	private SupplierRepository repository;

	@Override
	protected void buildQueryDefinition( QueryDefinition<Supplier, SupplierViewModel> queryDefinition) {


		queryDefinition
		.addColumn(new LinkColumn<>(Supplier_.id, "general.label.Code"), true)
		.addColumn(new TextColumn<>(Supplier_.name, "general.label.Name"), true)
		.addColumn(new TextColumn<>(Supplier_.address, "general.label.Name"), true);
		
		
	}

	@Override
	protected RepositoryBase<Supplier, SupplierViewModel> getRepository() {
		return repository;
	}
}