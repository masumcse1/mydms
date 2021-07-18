package com.stl.dms.commodity;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.Dependent;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.data.api.criteria.CriteriaSupport;

import com.google.common.base.Strings;
import com.ozguryazilim.telve.data.RepositoryBase;
import com.ozguryazilim.telve.query.QueryDefinition;
import com.ozguryazilim.telve.query.filters.Filter;
import com.stl.dms.entities.Supplier;
import com.stl.dms.entities.Supplier_;

/**
 * Repository Class
 *
 * @author
 */
@Repository
@Dependent
public abstract class SupplierRepository extends RepositoryBase<Supplier, SupplierViewModel>
		implements CriteriaSupport<Supplier> {

	@Override
	public List<SupplierViewModel> browseQuery(QueryDefinition queryDefinition) {
		List<Filter<Supplier, ?, ?>> filters = queryDefinition.getFilters();

		CriteriaBuilder criteriaBuilder = entityManager().getCriteriaBuilder();
		// Geriye PersonViewModel dönecek cq'yu ona göre oluşturuyoruz.
		CriteriaQuery<SupplierViewModel> criteriaQuery = criteriaBuilder.createQuery(SupplierViewModel.class);

		// From Tabii ki User
		Root<Supplier> from = criteriaQuery.from(Supplier.class);

		// Sonuç filtremiz
		buildVieModelSelect(criteriaQuery, from);
		/*
		 * Join<Supplier, CommodityCategory> cc = from.join(Supplier_.category,
		 * JoinType.LEFT); Join<Supplier, UnitSetDefinition> us =
		 * from.join(Supplier_.unitSet, JoinType.LEFT); Join<Supplier, TaxDefinition> t1
		 * = from.join(Supplier_.tax1, JoinType.LEFT); Join<Supplier, TaxDefinition> t2
		 * = from.join(Supplier_.tax2, JoinType.LEFT); Join<Supplier, TaxDefinition> t3
		 * = from.join(Supplier_.tax3, JoinType.LEFT);
		 */
		// Filtreleri ekleyelim.
		List<Predicate> predicates = new ArrayList<>();

		decorateFilters(filters, predicates, criteriaBuilder, from);

		buildSearchTextControl(queryDefinition.getSearchText(), criteriaBuilder, predicates, from);

		// Oluşan filtreleri sorgumuza ekliyoruz
		criteriaQuery.where(predicates.toArray(new Predicate[] {}));

		// Öncelikle default sıralama verelim eğer kullanıcı tarafından tanımlı sıralama
		// var ise onu setleyelim
		if (queryDefinition.getSorters().isEmpty()) {
			criteriaQuery.orderBy(criteriaBuilder.asc(from.get(Supplier_.name)));
		} else {
			criteriaQuery.orderBy(decorateSorts(queryDefinition.getSorters(), criteriaBuilder, from));
		}

		// Haydi bakalım sonuçları alalım
		TypedQuery<SupplierViewModel> typedQuery = entityManager().createQuery(criteriaQuery);
		typedQuery.setMaxResults(queryDefinition.getResultLimit());
		List<SupplierViewModel> resultList = typedQuery.getResultList();

		return resultList;
	}

	@Override
	public List<Supplier> suggestion(String searchText) {
		return criteria().or(criteria().like(Supplier_.address, "%" + searchText + "%"),
				criteria().like(Supplier_.name, "%" + searchText + "%")).getResultList();
	}

	private void buildVieModelSelect(CriteriaQuery<SupplierViewModel> criteriaQuery, Root<Supplier> from) {
		criteriaQuery.multiselect(from.get(Supplier_.id), from.get(Supplier_.id), from.get(Supplier_.name),
				from.get(Supplier_.address));
	}

	private void buildSearchTextControl(String searchText, CriteriaBuilder criteriaBuilder, List<Predicate> predicates,
			Root<Supplier> from) {
		if (!Strings.isNullOrEmpty(searchText)) {
			predicates.add(criteriaBuilder.or(criteriaBuilder.like(from.get(Supplier_.address), "%" + searchText + "%"),
					criteriaBuilder.like(from.get(Supplier_.name), "%" + searchText + "%")));
		}
	}

	@Override
	public List<SupplierViewModel> lookupQuery(String searchText) {
		CriteriaBuilder criteriaBuilder = entityManager().getCriteriaBuilder();
		// Geriye PersonViewModel dönecek cq'yu ona göre oluşturuyoruz.
		CriteriaQuery<SupplierViewModel> criteriaQuery = criteriaBuilder.createQuery(SupplierViewModel.class);

		// From Tabii ki User
		Root<Supplier> from = criteriaQuery.from(Supplier.class);
		/*
		 * Join<Supplier, CommodityCategory> cc = from.join(Supplier_.category,
		 * JoinType.LEFT); Join<Supplier, UnitSetDefinition> us =
		 * from.join(Supplier_.unitSet, JoinType.LEFT); Join<Supplier, TaxDefinition> t1
		 * = from.join(Supplier_.tax1, JoinType.LEFT); Join<Supplier, TaxDefinition> t2
		 * = from.join(Supplier_.tax2, JoinType.LEFT); Join<Supplier, TaxDefinition> t3
		 * = from.join(Supplier_.tax3, JoinType.LEFT);
		 */
		// Sonuç filtremiz
		buildVieModelSelect(criteriaQuery, from);

		// Filtreleri ekleyelim.
		List<Predicate> predicates = new ArrayList<>();

		// Sadece aktif olanlar
		// predicates.add(criteriaBuilder.equal(from.get(Supplier_.active), true));

		buildSearchTextControl(searchText, criteriaBuilder, predicates, from);

		// Oluşan filtreleri sorgumuza ekliyoruz
		criteriaQuery.where(predicates.toArray(new Predicate[] {}));

		// Öncelikle default sıralama verelim eğer kullanıcı tarafından tanımlı sıralama
		// var ise onu setleyelim
		criteriaQuery.orderBy(criteriaBuilder.asc(from.get(Supplier_.name)));

		// Haydi bakalım sonuçları alalım
		TypedQuery<SupplierViewModel> typedQuery = entityManager().createQuery(criteriaQuery);
		// Lookuplarda daha fazla sonuç gelmesin
		typedQuery.setMaxResults(50);
		List<SupplierViewModel> resultList = typedQuery.getResultList();

		return resultList;
	}

}
