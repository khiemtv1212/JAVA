package solekia.dvdrental.service;
import java.util.List;

import org.springframework.stereotype.Service;

import solekia.dvdrental.entities.CustomerFilm;
import solekia.dvdrental.repository.CustomerMapperFilm;

@Service

public class ServicePaging {
    private final CustomerMapperFilm customerFilm;

    public ServicePaging(CustomerMapperFilm customerMapperFilm) {
        this.customerFilm = customerMapperFilm;
    }

    public List<CustomerFilm> getFilmsWithPagination(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return customerFilm.getFilmsWithPagination(pageSize, offset);
    }

    public int getTotalPages(int pageSize) {
        int totalFilms = customerFilm.getTotalFilms(); // Lấy tổng số bản ghi trong bảng "film" từ mapper
        return (int) Math.ceil((double) totalFilms / pageSize);
    }
}