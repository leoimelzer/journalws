package com.journal.journalws.controller;

import com.journal.journalws.dto.entry.EntryListRequest;
import com.journal.journalws.dto.entry.EntrySaveRequest;
import com.journal.journalws.model.Entry;
import com.journal.journalws.service.EntryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/entry")
public class EntryController {

    private final EntryService entryService;

    public EntryController(EntryService entryService) {
        this.entryService = entryService;
    }

    @GetMapping
    public ResponseEntity<List<Entry>> list(@ModelAttribute EntryListRequest request) {
        List<Entry> entries = entryService.list(request);
        return ResponseEntity.ok(entries);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entry> get(@PathVariable String id) {
        Entry entry = entryService.get(id);
        return ResponseEntity.ok(entry);
    }

    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody EntrySaveRequest request) {
        String id = entryService.create(request);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @Valid @RequestBody EntrySaveRequest request) {
        entryService.update(id, request);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        entryService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
