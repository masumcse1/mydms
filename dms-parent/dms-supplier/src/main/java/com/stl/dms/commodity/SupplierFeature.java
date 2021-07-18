package com.stl.dms.commodity;

import com.ozguryazilim.tekir.core.code.AutoCode;
import com.ozguryazilim.telve.feature.AbstractFeatureHandler;
import com.ozguryazilim.telve.feature.Feature;
import com.ozguryazilim.telve.feature.Page;
import com.ozguryazilim.telve.feature.PageType;
import com.stl.dms.commodity.config.SupplierPages;
import com.stl.dms.entities.Supplier;

/**
 *
 * @author oyas
 */
@Feature(permission = "commodity", forEntity = Supplier.class)
@Page(type = PageType.BROWSE, page = SupplierPages.SupplierBrowse.class)
@Page(type = PageType.EDIT, page = SupplierPages.Supplier.class)
@Page(type = PageType.VIEW, page = SupplierPages.SupplierView.class)
@Page(type = PageType.MASTER_VIEW, page = SupplierPages.SupplierMasterView.class)
@AutoCode(cosumer = "Commodity", caption = "feature.caption.CommodityFeature", serial = "COMM" )
public class SupplierFeature extends AbstractFeatureHandler{
    
}
