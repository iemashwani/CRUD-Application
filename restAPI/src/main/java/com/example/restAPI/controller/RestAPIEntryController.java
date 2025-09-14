package com.example.restAPI.controller;

import com.example.restAPI.entity.RestAPIEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/restApi")
public class RestAPIEntryController {

    private Map<Long, RestAPIEntry> restApiEntries = new HashMap<>();

    @GetMapping
    public List<RestAPIEntry> getAll(){
        return new ArrayList<>(restApiEntries.values());
    }

    @PostMapping
    public boolean createEntry(@RequestBody RestAPIEntry myEntry){
        restApiEntries.put(myEntry.getId(), myEntry);
        return true;
    }

    @GetMapping("id/{myId}")
    public RestAPIEntry getEntryById(@PathVariable Long myId){
        return restApiEntries.get(myId);
    }
}
