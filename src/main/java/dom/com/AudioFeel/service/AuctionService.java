package dom.com.AudioFeel.service;


import dom.com.AudioFeel.Repo.AppAucionRepo;
import dom.com.AudioFeel.model.AppAuction;
import dom.com.AudioFeel.model.AppUser;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public class AuctionService {

    private AppAucionRepo appAucionRepo;

    public AuctionService(AppAucionRepo appAucionRepo) {
        this.appAucionRepo = appAucionRepo;
    }

    public void addAuction(AppAuction appAuction, AppUser appUser){

        appAucionRepo.save(appAuction);

    }
    public void changePrice(AppAuction appAuction , int a){

        appAuction.setPrice(a);
        appAucionRepo.save(appAuction);

    }
}
