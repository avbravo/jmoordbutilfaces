/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbutils.paginator;

import com.avbravo.jmoordbutils.DateUtil;
import com.avbravo.jmoordbutils.FacesUtil;
import static com.avbravo.jmoordbutils.FacesUtil.nameOfMethod;
import com.jmoordb.core.model.Pagination;
import com.jmoordb.core.model.Search;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.bson.Document;
import org.primefaces.model.SortMeta;
import org.primefaces.model.SortOrder;
import com.jmoordb.core.model.Sorted;

/**
 * @author avbravo
 */
public interface IPaginatorSearch {

    // <editor-fold defaultstate="collapsed" desc="String last(Paginator paginator)">
    public default String last(Search search) {
        try {

            search.getPagination().setPage(search.getPagination().getSize());

            move(search.getPagination());
        } catch (Exception e) {
            System.out.println(
                    "------------------------------------------------------------------------------------------------");
            System.out.println("Class:" + FacesUtil.nameOfClass() + " Metodo:" + FacesUtil.nameOfMethod());
            System.out.println("Error " + e.getLocalizedMessage());
            System.out.println(
                    "------------------------------------------------------------------------------------------------");
            FacesUtil.errorMessage(nameOfMethod() + " " + e.getLocalizedMessage());
        }
        return "";
    } // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String first(Search search)">
    public default String first(Search search) {
        try {

            search.getPagination().setPage(1);

            move(search.getPagination());
        } catch (Exception e) {
            System.out.println(
                    "------------------------------------------------------------------------------------------------");
            System.out.println("Class:" + FacesUtil.nameOfClass() + " Metodo:" + FacesUtil.nameOfMethod());
            System.out.println("Error " + e.getLocalizedMessage());
            System.out.println(
                    "------------------------------------------------------------------------------------------------");
            FacesUtil.errorMessage(nameOfMethod() + " " + e.getLocalizedMessage());
        }
        return "";
    } // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String next(Search search)">
    public default String next(Search search) {
        try {

            if (search.getPagination().getPage() < search.getPagination().getSize()) {
                search.getPagination().setPage(search.getPagination().getPage() + 1);
            }

            move(search.getPagination());
        } catch (Exception e) {
            System.out.println(
                    "------------------------------------------------------------------------------------------------");
            System.out.println("Class:" + FacesUtil.nameOfClass() + " Metodo:" + FacesUtil.nameOfMethod());
            System.out.println("Error " + e.getLocalizedMessage());
            System.out.println(
                    "------------------------------------------------------------------------------------------------");
            FacesUtil.errorMessage(nameOfMethod() + " " + e.getLocalizedMessage());
        }
        return "";
    } // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String back(Search search)">
    public default String back(Search search) {
        try {

            if (search.getPagination().getPage() > 1) {

                search.getPagination().setPage(search.getPagination().getPage() - 1);

            }

            move(search.getPagination());
        } catch (Exception e) {
            System.out.println(
                    "------------------------------------------------------------------------------------------------");
            System.out.println("Class:" + FacesUtil.nameOfClass() + " Metodo:" + FacesUtil.nameOfMethod());
            System.out.println("Error " + e.getLocalizedMessage());
            System.out.println(
                    "------------------------------------------------------------------------------------------------");
            FacesUtil.errorMessage(nameOfMethod() + " " + e.getLocalizedMessage());
        }
        return "";
    } // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String skip(Search search)">
    /**
     * componentes <jmoordbjsf:paginator> toma el numero de pagina y lo mueve
     *
     * @param field
     * @param value
     * @return
     */
    public default String skip(Search search) {
        try {

            search.getPagination().setPage(search.getPagination().getPageforskip());

            move(search.getPagination());

        } catch (Exception e) {
            System.out.println(
                    "------------------------------------------------------------------------------------------------");
            System.out.println("Class:" + FacesUtil.nameOfClass() + " Metodo:" + FacesUtil.nameOfMethod());
            System.out.println("Error " + e.getLocalizedMessage());
            System.out.println(
                    "------------------------------------------------------------------------------------------------");
            FacesUtil.errorMessage(nameOfMethod() + " " + e.getLocalizedMessage());
        }
        return "";
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="move(Pagination pagination)">
    public default void move(Pagination pagination) {
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Integer numberOfPages(Integer rows,Integer rowForPage)">
    default Integer numberOfPages(Integer rows, Integer rowForPage) {
        Integer numberOfPage = 1;
        try {

            if (rows > 0) {
                numberOfPage = rows / rowForPage;
                if ((rows % rowForPage) > 0) {
                    numberOfPage++;
                }
            }
        } catch (Exception e) {
            System.out.println(
                    "------------------------------------------------------------------------------------------------");
            System.out.println("Class:" + FacesUtil.nameOfClass() + " Metodo:" + FacesUtil.nameOfMethod());
            System.out.println("Error " + e.getLocalizedMessage());
            System.out.println(
                    "------------------------------------------------------------------------------------------------");
            FacesUtil.errorMessage(nameOfMethod() + " " + e.getLocalizedMessage());
        }
        return numberOfPage;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="List<Integer> arrayListOfPage(Integer numberOfPage) ">
    /**
     * Devuele un array list en base al numero de paginas pasadaas
     *
     * @param rowsForPage
     * @param doc
     * @return
     */
    default public List<Integer> arrayListOfNumber(Integer numberOfPage) {
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
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Boolean sizeExceeds(String text,Integer largo) ">
    default public Boolean sizeExceeds(String text, Integer largo) {

        try {
            if (text.length() > largo) {
                return true;
            }

        } catch (Exception e) {
            System.out.println("amanoExcede(() " + e.getLocalizedMessage());
        }
        return false;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String shortTextObservacio(Boletas boletas,Integer largo)">
    default public String shortTextObservacion(String text, Integer largo) {

        try {

            if (text.length() > largo) {
                text = text.substring(0, largo);
            }

        } catch (Exception e) {
            System.out.println("shortTextObservacion() " + e.getLocalizedMessage());

        }
        return text;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String showDialogoObservacion()">
    default public String showDialogoObservacion() {
        return "";
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Pagination loadPagination(Search search)">
    default public Pagination loadPaginator(Search search) {
        return search.getPagination();
    }

    // </editor-fold>
// <editor-fold defaultstate="collapsed" desc="move(Pagination pagination, Object s)">
    public default void move(Pagination pagination, Object s) {

    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="List<Pagination> processLazyDataModel(Search search, Search searchOld, int offset, Integer rowPage, Integer totalRecords, Map<String, SortMeta> sortBy)  ">
    public default List<Paginator> processLazyDataModel(Search search, Search searchOld, int offset, Integer rowPage, Integer totalRecords, Map<String, SortMeta> sortBy) {
        List<Paginator> list = new ArrayList<>();
        try {
            String field;
            SortOrder sortOder;
            paginator.setTotalRecords(totalRecords);
            for (Map.Entry<String, SortMeta> e : sortBy.entrySet()) {

                field = e.getValue().getField();
                sortOder = e.getValue().getOrder();
                if (sortOder.isAscending()) {
                    Sorted sorted = new Sorted();
                    sorted.setSort(new Document(field, 1));
                    // aqui falta el objeto sorted del search

                    search.setSorted(sorted);
                } else {
                    if (sortOder.isDescending()) {
                        Sorted sorted = new Sorted();
                        sorted.setSort(new Document(field, -1));
                        search.setSorted(sorted);
                    } else {
                        if (sortOder.isUnsorted()) {
                            Sorted sorted = new Sorted();
                            sorted.setSort(new Document());
                            search.setSorted(sorted);
                        }
                    }
                }
            }

            if (searchOld.getFilter()== null || searchOld.getFilter().equals("")) {
             searchOld= search;
            }
            if (offset == 0) {
                paginator.setPage(1);
            } else {
                if (searchOld.getFilter().equals(paginator.getQuery())) {
                    paginator.setPage((offset / rowPage) + 1);

                } else {
                    paginatorOld = paginator;
                    paginator.setPage(1);
                }

            }
        } catch (Exception e) {
            System.out.println("processLazyDataModel() " + e.getLocalizedMessage());
        }
        list.add(paginator);
        list.add(paginatorOld);
        return list;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String showDate(Date date)">
    default public String showDate(Date date) {
        String h = "";
        try {

            h = DateUtil.dateFormatToString(date, "dd/MM/yyyy");
        } catch (Exception e) {
            System.out.println("showDate() " + e.getLocalizedMessage());
        }
        return h;
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="String showHour(Date date)">
    default public String showHour(Date date) {
        String h = "";
        try {
            h = DateUtil.hourFromDateToString(date);
        } catch (Exception e) {
            System.out.println("showHour() " + e.getLocalizedMessage());
        }
        return h;
    }// </editor-fold>
}
