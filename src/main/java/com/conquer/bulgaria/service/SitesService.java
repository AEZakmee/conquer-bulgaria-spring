package com.conquer.bulgaria.service;

import com.conquer.bulgaria.dao.sites.SitesDao;
import com.conquer.bulgaria.model.Site;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SitesService {

    private final SitesDao sitesDao;

    @Autowired
    public SitesService(@Qualifier("sitesPostgres") SitesDao sitesDao) {
        this.sitesDao = sitesDao;
    }

    public int insertSite(Site site) {
        return sitesDao.insertSite(site);
    }

    public List<Site> getSites() {
        return sitesDao.getSites();
    }

    public int deleteSiteById(UUID uuid) {
        return  sitesDao.deleteSiteById(uuid);
    }

    public int updateSiteById(UUID uuid, Site site) {
        return  sitesDao.updateSiteById(uuid, site);
    }

    public Optional<Site> getSiteById(UUID uuid) {
        return sitesDao.getSiteById(uuid);
    }
}
