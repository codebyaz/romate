package com.codebyaz.romate.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/library")
public class LibraryController {

    private final LibraryService libraryService;

    @Autowired
    LibraryController(LibraryService libraryService) { this.libraryService = libraryService; }

    @GetMapping
    List<Library> list() {
        return this.libraryService.list();
    }

    @PostMapping
    void save(@RequestBody Library library) {
        this.libraryService.save(library);
    }
}
