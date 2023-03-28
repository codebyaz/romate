package com.codebyaz.romate.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {

    private final LibraryRepository libraryRepository;

    @Autowired
    LibraryService(LibraryRepository libraryRepository) { this.libraryRepository = libraryRepository; }

    void save(Library library) {
        this.libraryRepository.save(library);
    }

    List<Library> list() {
        return this.libraryRepository.findAll();
    }
}
