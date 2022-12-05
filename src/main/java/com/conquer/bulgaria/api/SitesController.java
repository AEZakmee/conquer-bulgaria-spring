package com.conquer.bulgaria.api;

import com.conquer.bulgaria.model.Site;
import com.conquer.bulgaria.service.SitesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/sites")
@RestController
public class SitesController {

    private final SitesService sitesService;

    @Autowired
    public SitesController(SitesService sitesService) {
        this.sitesService = sitesService;
    }

    @PostMapping
    public void addSite(@Valid @NotNull @RequestBody Site site) {
        sitesService.insertSite(site);
    }

    @GetMapping
    public List<Site> getSites() {
        return sitesService.getSites();
    }

    @DeleteMapping(path = "{id}")
    public int deleteSiteById(@PathVariable("id") UUID uuid) {
        return sitesService.deleteSiteById(uuid);
    }

    @PutMapping(path = "{id}")
    public int updateSiteById(@PathVariable("id") UUID uuid, @Valid @NonNull @RequestBody Site site) {
        return sitesService.updateSiteById(uuid, site);
    }

    @GetMapping(path = "{id}")
    public Site getSiteById(@PathVariable("id") UUID uuid) {
        return sitesService.getSiteById(uuid).orElse(null);
    }
}
