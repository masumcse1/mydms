package com.stl.dms.commodity;

import javax.inject.Inject;

import com.ozguryazilim.tekir.core.code.AutoCodeService;
import com.ozguryazilim.telve.data.RepositoryBase;
import com.ozguryazilim.telve.entities.FeaturePointer;
import com.ozguryazilim.telve.forms.FormBase;
import com.ozguryazilim.telve.forms.FormEdit;
import com.stl.dms.entities.Supplier;

/**
 * Home Control Class
 * 
 * @author
 */
@FormEdit(feature = SupplierFeature.class)
public class SupplierHome extends FormBase<Supplier, Long> {

	@Inject
	private SupplierRepository repository;

	@Inject
	private AutoCodeService codeService;

	@Override
	public void createNew() {
		super.createNew();
		//getEntity().setDefaultCurrency(currencyService.getDefaultCurrency());
		//getEntity().setCode(codeService.getNewSerialNumber(Supplier.class.getSimpleName()));
	}

	@Override
	protected RepositoryBase<Supplier, SupplierViewModel> getRepository() {
		return repository;
	}

	

	public FeaturePointer getFeaturePointer() {
		FeaturePointer result = new FeaturePointer();
		result.setBusinessKey(getEntity().getName());
		result.setFeature(getFeatureClass().getSimpleName());
		result.setPrimaryKey(getEntity().getId());
		return result;
	}

}