package api.app;

import lombok.Data;

import java.util.ArrayList;

@Data
public class BooksResponse {
    public ArrayList<String> author_alternative_name;
    public ArrayList<String> author_key;
    public ArrayList<String> author_name;
    public ArrayList<String> contributor;
    public int cover_i;
    public ArrayList<String> ddc;
    public String ebook_access;
    public int ebook_count_i;
    public int edition_count;
    public ArrayList<String> edition_key;
    public Integer first_publish_year;
    public ArrayList<String> first_sentence;
    public ArrayList<String> format;
    public boolean has_fulltext;
    public ArrayList<String> ia;
    public ArrayList<String> ia_collection;
    public String ia_collection_s;
    public ArrayList<String> isbn;
    public String key;
    public ArrayList<String> language;
    public int last_modified_i;
    public ArrayList<String> lcc;
    public ArrayList<String> lccn;
    public String lending_edition_s;
    public String lending_identifier_s;
    public int number_of_pages_median;
    public ArrayList<String> oclc;
    public int osp_count;
    public String printdisabled_s;
    public boolean public_scan_b;
    public ArrayList<String> publish_date;
    public ArrayList<String> publish_place;
    @CompareFlag("publish_year")
    public ArrayList<Integer> publish_year;
    public ArrayList<String> publisher;
    public ArrayList<String> seed;
    @CompareFlag("title")
    public String title;
    public String title_suggest;
    public String title_sort;
    public String type;
    public ArrayList<String> id_goodreads;
    public ArrayList<String> id_librarything;
    public ArrayList<String> id_amazon;
    public ArrayList<String> id_better_world_books;
    public ArrayList<String> id_wikidata;
    public ArrayList<String> id_depósito_legal;
    public ArrayList<String> id_google;
    public ArrayList<String> id_bcid;
    public ArrayList<String> id_alibris_id;
    public ArrayList<String> id_overdrive;
    public ArrayList<String> id_libris;
    public ArrayList<String> id_dnb;
    public ArrayList<String> subject;
    public ArrayList<String> place;
    public ArrayList<String> time;
    public ArrayList<String> person;
    public ArrayList<String> ia_loaded_id;
    public ArrayList<String> ia_box_id;
    public double ratings_average;
    public double ratings_sortable;
    public int ratings_count;
    public int ratings_count_1;
    public int ratings_count_2;
    public int ratings_count_3;
    public int ratings_count_4;
    public int ratings_count_5;
    public int readinglog_count;
    public int want_to_read_count;
    public int currently_reading_count;
    public int already_read_count;
    public ArrayList<String> publisher_facet;
    public ArrayList<String> person_key;
    public ArrayList<String> time_facet;
    public ArrayList<String> place_key;
    public ArrayList<String> person_facet;
    public ArrayList<String> subject_facet;
    public Object _version_;
    public ArrayList<String> place_facet;
    public String lcc_sort;
    public ArrayList<String> author_facet;
    public ArrayList<String> subject_key;
    public String ddc_sort;
    public ArrayList<String> time_key;
    public String cover_edition_key;
    public String subtitle;
}

