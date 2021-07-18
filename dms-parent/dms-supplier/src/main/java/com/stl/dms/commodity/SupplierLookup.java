package com.stl.dms.commodity;

import javax.inject.Inject;

import com.ozguryazilim.telve.data.RepositoryBase;
import com.ozguryazilim.telve.lookup.Lookup;
import com.ozguryazilim.telve.lookup.LookupTableControllerBase;
import com.ozguryazilim.telve.lookup.LookupTableModel;
import com.stl.dms.commodity.config.SupplierPages;
import com.stl.dms.entities.Supplier;
import com.stl.dms.entities.Supplier_;

/**
 * Lookup View Control Class
 * 
 * @author
 */
@Lookup(dialogPage = SupplierPages.SupplierLookup.class)
public class SupplierLookup
		extends
			LookupTableControllerBase<Supplier, SupplierViewModel> {

	@Inject
	private SupplierRepository repository;

	@Override
	public void buildModel(LookupTableModel<SupplierViewModel> model) {
		model.addColumn("code", "general.label.Code");
                model.addColumn("name", "general.label.Name");
	}

	@Override
	protected RepositoryBase<Supplier, SupplierViewModel> getRepository() {
		return repository;
	}

	@Override
	public String getCaptionFieldName() {
		return Supplier_.name.getName();
	}
}