package com.stl.dms.commodity.config;

import javax.enterprise.context.ApplicationScoped;

import org.apache.deltaspike.jsf.api.config.view.Folder;
import org.apache.deltaspike.jsf.api.config.view.View;

import com.ozguryazilim.telve.auth.SecuredPage;
import com.ozguryazilim.telve.nav.Navigation;
import com.ozguryazilim.telve.nav.SideNavigationSection;
import com.ozguryazilim.telve.view.PageTitle;
import com.ozguryazilim.telve.view.Pages;

/**
 * @author oyas
 */
@ApplicationScoped
@Folder(name = "./supplier")
public interface SupplierPages extends Pages {

    @View
    @SecuredPage("supplier")
    @PageTitle("module.caption.SupplierBrowse")
    @Navigation(label = "module.caption.SupplierBrowse",
            icon = "flaticon-package",
            section = SideNavigationSection.class)
    class SupplierBrowse implements SupplierPages {
    }

    @View
    @SecuredPage("supplier")
    @PageTitle("module.caption.Supplier")
    class Supplier implements SupplierPages {
    }

    @View
    @SecuredPage("supplier")
    @PageTitle("module.caption.Supplier")
    class SupplierView implements SupplierPages {
    }

    @View
    @SecuredPage("supplier")
    @PageTitle("module.caption.SupplierView")
    class SupplierMasterView implements SupplierPages {
    }

    @View
    @SecuredPage
    class SupplierLookup implements SupplierPages {
    }

  /*  @View
    @SecuredPage("commodityCategory")
    @PageTitle("module.caption.CommodityCategory")
    @Navigation(label = "module.caption.CommodityCategory",
            icon = "fa fa-sitemap",
            section = ParamNavigationSection.class)
    class CommodityNewCategory implements SupplierPages {
    }

    @View
    @SecuredPage
    class CommodityNewCategoryLookup implements SupplierPages {
    }*/
}
