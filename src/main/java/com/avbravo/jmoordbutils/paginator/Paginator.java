/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbutils.paginator;

import com.avbravo.jmoordbutils.FacesUtil;
import static com.avbravo.jmoordbutils.FacesUtil.nameOfMethod;
import com.jmoordb.core.model.Search;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.bson.Document;

/**
 *
 * @author avbravo
 */
public class Paginator {

    private String nameOfController;
    private Integer page;
    private Integer rowsForPage;
    private Integer numberOfPage;
    private Integer totalRecords;
    private Document query;
    private Document sort;
    private String title;
    private Integer pageforskip = 1;
    private Search search;
    private Boolean isByQuery;

    public Boolean getIsByQuery() {
        return isByQuery;
    }

    public void setIsByQuery(Boolean isByQuery) {
        this.isByQuery = isByQuery;
    }

    List<Integer> pagesPaginator = new ArrayList<>();

    public Paginator() {
    }

    public Paginator(String nameOfController, Integer page, Integer rowsForPage, Integer numberOfPage, Integer totalRecords, Document query, Document sort, String title, Search search, Boolean isByQuery) {
        this.nameOfController = nameOfController;
        this.page = page;
        this.rowsForPage = rowsForPage;
        this.numberOfPage = numberOfPage;
        this.totalRecords = totalRecords;
        this.query = query;
        this.sort = sort;
        this.title = title;
        this.search = search;
        this.isByQuery = isByQuery;
    }

    
    
    
    public void setSearch(Search search) {
        this.search = search;
    }

    public void setPagesPaginator(List<Integer> pagesPaginator) {
        this.pagesPaginator = pagesPaginator;
    }

   

   


    public Search getSearch() {
        return search;
    }


    public Integer getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Integer totalRecords) {
        this.totalRecords = totalRecords;
    }

    public List<Integer> getPagesPaginator() {

        return arrayListOfNumber(getNumberOfPage());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPageforskip() {
        return pageforskip;
    }

    public void setPageforskip(Integer pageforskip) {
        this.pageforskip = pageforskip;
    }

    public String getNameOfController() {
        return nameOfController;
    }

    public void setNameOfController(String nameOfController) {
        this.nameOfController = nameOfController;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRowsForPage() {
        return rowsForPage;
    }

    public void setRowsForPage(Integer rowsForPage) {
        this.rowsForPage = rowsForPage;
    }

    public Integer getNumberOfPage() {
        return numberOfPage;
    }

    public void setNumberOfPage(Integer numberOfPage) {
        this.numberOfPage = numberOfPage;
    }

    public Document getQuery() {
        return query;
    }

    public void setQuery(Document query) {
        this.query = query;
    }

    public Document getSort() {
        return sort;
    }

    public void setSort(Document sort) {
        this.sort = sort;
    }

    private List<Integer> arrayListOfNumber(Integer numberOfPage) {
        List<Integer> pages = new ArrayList<>();
        try {

            pages = IntStream.range(1, numberOfPage + 1)
                    .boxed()
                    .collect(Collectors.toList());

            return pages;

        } catch (Exception e) {
            System.out.println(
                    "------------------------------------------------------------------------------------------------");
            System.out.println("Class:" + FacesUtil.nameOfClass() + " Metodo:" + FacesUtil.nameOfMethod());
            System.out.println("Error " + e.getLocalizedMessage());
            System.out.println(
                    "------------------------------------------------------------------------------------------------");
            FacesUtil.errorMessage(nameOfMethod() + " " + e.getLocalizedMessage());
        }
        return pages;
    }

    public static class Builder {

        private String nameOfController;
        private Integer page;
        private Integer rowsForPage;
        private Integer numberOfPage;
        private Integer totalRecords;
        private Document query;
        private Document sort;
        private String title;
        private Search search;
        private Boolean isByQuery;
        List<Integer> pagesPaginator = new ArrayList<>();
        Integer pageforskip = 1;

        public Builder nameOfController(String nameOfController) {
            this.nameOfController = nameOfController;
            return this;
        }

        public Builder search(Search search) {
            this.search = search;
            return this;
        }

        public Builder isByQuery(Boolean isByQuery) {
            this.isByQuery= isByQuery;
            return this;
        }
       

        public Builder page(Integer page) {
            this.page = page;
            return this;
        }

        public Builder totalRecords(Integer totalRecords) {
            this.totalRecords = totalRecords;
            return this;
        }

        public Builder pageforskip(Integer pageforskip) {
            this.pageforskip = pageforskip;
            return this;
        }

        public Builder pagesPaginator(List<Integer> pagesPaginator) {
            this.pagesPaginator = this.pagesPaginator;
            return this;
        }

        public Builder rowsForPage(Integer rowsForPage) {
            this.rowsForPage = rowsForPage;
            return this;
        }

        public Builder numberOfPage(Integer numberOfPage) {
            this.numberOfPage = numberOfPage;
            return this;
        }

        public Builder query(Document query) {
            this.query = query;
            return this;
        }

        public Builder sort(Document sort) {
            this.sort = sort;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Paginator build() {
            return new Paginator(nameOfController, page, rowsForPage, numberOfPage, totalRecords, query, sort, title, search, isByQuery);

        }
    }

}
