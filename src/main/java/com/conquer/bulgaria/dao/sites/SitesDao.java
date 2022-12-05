package com.conquer.bulgaria.dao.sites;

import com.conquer.bulgaria.model.Site;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SitesDao {

    int insertSite(UUID uuid, Site site);

    List<Site> getSites();

    int deleteSiteById(UUID uuid);

    int updateSiteById(UUID uuid, Site site);

    Optional<Site> getSiteById(UUID uuid);

    default int insertSite(Site site) {
        final UUID uuid = UUID.randomUUID();
        return insertSite(uuid, site);
    }
}
